package com.cineflix.android

import android.content.Context
import android.util.Log
import java.io.*
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import java.nio.channels.FileChannel
import java.nio.ByteBuffer
import java.nio.file.StandardOpenOption
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

/**
 * LocalStreamProxy — Réplica del sistema de Tevegram (g7.e / LocalStreamProxy)
 *
 * ServerSocket nativo en 127.0.0.1 que sirve el archivo de vídeo
 * progresivamente mientras GramJS lo descarga desde Telegram.
 *
 * Flujo:
 *   GramJS (JS) → Base64 chunks → Capacitor Bridge → appendData() → tempFile (disco)
 *   ExoPlayer → HTTP Range Request → StreamProxy → lee tempFile → responde bytes
 */
class StreamProxy(private val context: Context) {

    companion object {
        private const val TAG = "StreamProxy"
    }

    private var serverSocket: ServerSocket? = null
    private var tempFile: File? = null
    private var writeStream: FileOutputStream? = null

    private var totalSize: Long = 0
    private var mimeType: String = "video/mp4"

    private val bytesWritten = AtomicLong(0)
    private val running = AtomicBoolean(false)
    private val downloadComplete = AtomicBoolean(false)
    private val lock = Object()

    private val executor = Executors.newCachedThreadPool()

    /**
     * Arranca el ServerSocket en un puerto aleatorio de 127.0.0.1
     * @return puerto local asignado
     */
    fun start(): Int {
        serverSocket = ServerSocket(0, 20, InetAddress.getByName("127.0.0.1"))
        val port = serverSocket!!.localPort
        running.set(true)

        Thread({
            Log.i(TAG, "🚀 StreamProxy escuchando en http://127.0.0.1:$port")
            while (running.get()) {
                try {
                    val client = serverSocket?.accept() ?: break
                    executor.submit { handleClient(client) }
                } catch (e: Exception) {
                    if (running.get()) Log.e(TAG, "Accept error: ${e.message}")
                }
            }
        }, "StreamProxy-Acceptor").start()

        return port
    }

    /**
     * Prepara un nuevo stream. Crea el archivo temporal en disco.
     */
    fun initStream(fileSize: Long, mime: String) {
        // Limpiar anterior
        writeStream?.close()
        tempFile?.delete()

        totalSize = fileSize
        mimeType = mime
        bytesWritten.set(0)
        downloadComplete.set(false)

        tempFile = File(context.cacheDir, "cineflix_stream_${System.currentTimeMillis()}.tmp")
        writeStream = FileOutputStream(tempFile!!, true) // append mode

        Log.i(TAG, "📁 Stream iniciado: size=$fileSize mime=$mime file=${tempFile?.name}")
    }

    /**
     * Añade datos al archivo temporal. Llamado desde JS vía plugin.
     * Thread-safe: actualiza bytesWritten atómicamente y notifica a lectores bloqueados.
     */
    fun appendData(data: ByteArray) {
        synchronized(lock) {
            writeStream?.write(data)
            writeStream?.flush()
            bytesWritten.addAndGet(data.size.toLong())
            lock.notifyAll() // Despertar a cualquier lector esperando datos
        }
    }

    /**
     * Marca la descarga como completa.
     */
    fun markComplete() {
        downloadComplete.set(true)
        synchronized(lock) { lock.notifyAll() }
        Log.i(TAG, "✅ Descarga completa: ${bytesWritten.get()} bytes")
    }

    fun getUrl(): String = "http://127.0.0.1:${serverSocket?.localPort}/stream"

    fun stop() {
        running.set(false)
        try { serverSocket?.close() } catch (_: Exception) {}
        try { writeStream?.close() } catch (_: Exception) {}
        tempFile?.delete()
        Log.i(TAG, "🛑 StreamProxy detenido")
    }

    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
    // HTTP Handler — réplica simplificada de Tevegram para servir bytes progresivos
    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    private fun handleClient(socket: Socket) {
        try {
            val input = BufferedReader(InputStreamReader(socket.getInputStream()))
            val output = socket.getOutputStream()

            // Leer primera línea HTTP
            val requestLine = input.readLine() ?: return
            
            // Leer headers
            var rangeHeader: String? = null
            var line: String?
            do {
                line = input.readLine()
                if (line != null && line.startsWith("Range:", ignoreCase = true)) {
                    rangeHeader = line.substringAfter(":").trim()
                }
            } while (line != null && line.isNotEmpty())

            if (!requestLine.contains("/stream")) {
                send404(output)
                return
            }

            serveStream(output, rangeHeader)

        } catch (e: Exception) {
            if (running.get()) Log.w(TAG, "Client error: ${e.message}")
        } finally {
            try { socket.close() } catch (_: Exception) {}
        }
    }

    private fun serveStream(output: OutputStream, rangeHeader: String?) {
        val file = tempFile ?: return send404(output)
        
        if (rangeHeader == null) {
            // Sin Range → enviar cabeceras indicando tamaño y soporte de Range
            // ExoPlayer hará un probe inicial sin Range, luego con Range
            val headers = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: $mimeType\r\n" +
                "Content-Length: $totalSize\r\n" +
                "Accept-Ranges: bytes\r\n" +
                "Connection: close\r\n" +
                "\r\n"
            output.write(headers.toByteArray())
            output.flush()
            return
        }

        // Parse Range: bytes=START-END
        val match = Regex("bytes=(\\d+)-(\\d*)").find(rangeHeader) ?: return send404(output)
        val start = match.groupValues[1].toLong()
        val end = if (match.groupValues[2].isNotEmpty()) {
            match.groupValues[2].toLong()
        } else {
            // ExoPlayer a veces no envía end — devolvemos un chunk de 512KB
            minOf(start + 512 * 1024 - 1, totalSize - 1)
        }

        val chunkSize = end - start + 1

        Log.d(TAG, "📥 Range: $start-$end (${chunkSize / 1024}KB) | disponible: ${bytesWritten.get()}")

        // Esperar a que los datos estén disponibles (bloqueo inteligente como Tevegram)
        if (!waitForData(end + 1)) {
            Log.w(TAG, "⏰ Timeout esperando datos para offset $start")
            send404(output)
            return
        }

        // Servir los bytes desde el archivo temporal
        try {
            val raf = RandomAccessFile(file, "r")
            raf.seek(start)

            val headers = "HTTP/1.1 206 Partial Content\r\n" +
                "Content-Type: $mimeType\r\n" +
                "Content-Range: bytes $start-$end/$totalSize\r\n" +
                "Content-Length: $chunkSize\r\n" +
                "Accept-Ranges: bytes\r\n" +
                "Connection: close\r\n" +
                "\r\n"
            output.write(headers.toByteArray())

            // Leer y enviar por bloques de 64KB
            val buf = ByteArray(64 * 1024)
            var remaining = chunkSize
            while (remaining > 0) {
                val toRead = minOf(remaining.toInt(), buf.size)
                val read = raf.read(buf, 0, toRead)
                if (read <= 0) break
                output.write(buf, 0, read)
                remaining -= read
            }

            output.flush()
            raf.close()

        } catch (e: Exception) {
            Log.e(TAG, "Error sirviendo stream: ${e.message}")
        }
    }

    /**
     * Espera hasta que `needed` bytes estén disponibles en el archivo temporal,
     * o hasta un timeout de 60 segundos.
     * Réplica del patrón de espera de Tevegram (segment wait loop).
     */
    private fun waitForData(needed: Long): Boolean {
        val deadline = System.currentTimeMillis() + 60_000 // 60s timeout
        synchronized(lock) {
            while (bytesWritten.get() < needed && !downloadComplete.get()) {
                val remaining = deadline - System.currentTimeMillis()
                if (remaining <= 0) return false
                lock.wait(minOf(remaining, 500)) // Check cada 500ms
            }
        }
        return bytesWritten.get() >= needed || downloadComplete.get()
    }

    private fun send404(output: OutputStream) {
        try {
            output.write("HTTP/1.1 404 Not Found\r\nConnection: close\r\n\r\n".toByteArray())
            output.flush()
        } catch (_: Exception) {}
    }
}
