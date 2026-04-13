package com.cineflix.android

import android.content.Context
import android.util.Log
import fi.iki.elonen.NanoHTTPD
import java.io.File
import java.io.FileInputStream
import java.io.RandomAccessFile
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

/**
 * HlsProxy — Servidor HLS local basado en NanoHTTPD.
 *
 * Reemplaza al StreamProxy basado en raw ServerSocket.
 * NanoHTTPD gestiona correctamente el parsing HTTP y los hilos de cliente.
 *
 * Endpoints:
 *   GET /stream.m3u8  → Playlist HLS dinámica (segmentos disponibles)
 *   GET /segment/{n}  → Bytes del segmento n del archivo temporal
 *
 * Flujo:
 *   JS: initStream() → Kotlin prepara NanoHTTPD + temp file
 *   JS: play()       → Kotlin lanza ExoPlayer apuntando a /stream.m3u8
 *   JS: pushChunk()  → Kotlin escribe bytes → NanoHTTPD sirve segmentos
 *   JS: downloadComplete() → NanoHTTPD añade #EXT-X-ENDLIST al M3U8
 */
class HlsProxy(private val context: Context) : NanoHTTPD("127.0.0.1", 0) {

    companion object {
        private const val TAG = "HlsProxy"
        const val SEGMENT_SIZE = 512 * 1024L  // 512KB por segmento HLS
    }

    private var tempFile: File? = null
    private var writeStream: java.io.FileOutputStream? = null

    private var totalSize: Long = 0
    private var mimeType: String = "video/mp4"

    private val bytesWritten = AtomicLong(0)
    private val downloadComplete = AtomicBoolean(false)
    private val lock = Object()

    /**
     * Prepara un nuevo stream: crea el archivo temporal y resetea estado.
     * Llamado desde initStream() en ExoPlayerPlugin.
     */
    fun initStream(fileSize: Long, mime: String) {
        writeStream?.close()
        tempFile?.delete()

        totalSize = fileSize
        mimeType = mime
        bytesWritten.set(0)
        downloadComplete.set(false)

        tempFile = File(context.cacheDir, "cineflix_hls_${System.currentTimeMillis()}.tmp")
        writeStream = java.io.FileOutputStream(tempFile!!, false)

        val segmentCount = Math.ceil(fileSize.toDouble() / SEGMENT_SIZE).toInt()
        Log.i(TAG, "📁 HLS stream: ${fileSize/1024/1024}MB, $segmentCount segmentos, mime=$mime")
    }

    /**
     * Añade bytes al archivo temporal. Thread-safe.
     */
    fun appendData(data: ByteArray) {
        synchronized(lock) {
            writeStream?.write(data)
            writeStream?.flush()
            bytesWritten.addAndGet(data.size.toLong())
            lock.notifyAll()
        }
    }

    /**
     * Marca la descarga como completa → M3U8 incluirá #EXT-X-ENDLIST.
     */
    fun markComplete() {
        downloadComplete.set(true)
        synchronized(lock) { lock.notifyAll() }
        Log.i(TAG, "✅ Download complete: ${bytesWritten.get()} bytes")
    }

    fun getM3u8Url(): String {
        return "http://127.0.0.1:${listeningPort}/stream.m3u8"
    }

    fun getPort(): Int = listeningPort

    /**
     * Espera hasta que `needed` bytes estén disponibles (o descarga completa).
     * Timeout de 120 segundos.
     */
    private fun waitForBytes(needed: Long): Boolean {
        val deadline = System.currentTimeMillis() + 120_000L
        synchronized(lock) {
            while (bytesWritten.get() < needed && !downloadComplete.get()) {
                val remaining = deadline - System.currentTimeMillis()
                if (remaining <= 0) return false
                lock.wait(minOf(remaining, 1000L))
            }
        }
        return bytesWritten.get() >= needed || downloadComplete.get()
    }

    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
    // NanoHTTPD — serve() se llama en un hilo por conexión automáticamente
    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    override fun serve(session: IHTTPSession): Response {
        val uri = session.uri
        Log.d(TAG, "↘ ${session.method} $uri")

        return when {
            uri == "/stream.m3u8" -> serveM3u8()
            uri.startsWith("/segment/") -> serveSegment(uri)
            else -> newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not found")
        }
    }

    /**
     * Genera la playlist HLS M3U8 dinámicamente.
     * Incluye solo los segmentos cuya data ya está disponible en disco.
     * Añade #EXT-X-ENDLIST solo cuando la descarga está completada.
     */
    private fun serveM3u8(): Response {
        val available = bytesWritten.get()
        val complete = downloadComplete.get()
        val totalSegments = Math.ceil(totalSize.toDouble() / SEGMENT_SIZE).toInt()

        // Cuántos segmentos están completamente disponibles
        val availableSegments = if (complete) {
            totalSegments
        } else {
            (available / SEGMENT_SIZE).toInt()   // segmentos ENTEROS disponibles
        }

        // Construir M3U8
        val sb = StringBuilder()
        sb.appendLine("#EXTM3U")
        sb.appendLine("#EXT-X-VERSION:3")
        sb.appendLine("#EXT-X-TARGETDURATION:30")
        sb.appendLine("#EXT-X-PLAYLIST-TYPE:EVENT")
        sb.appendLine("#EXT-X-MEDIA-SEQUENCE:0")

        for (i in 0 until availableSegments) {
            val segSize = if (i == totalSegments - 1) {
                totalSize - (i * SEGMENT_SIZE)
            } else {
                SEGMENT_SIZE
            }
            val durationSec = segSize.toDouble() / (1024 * 1024) * 8 // rough estimate
            sb.appendLine("#EXTINF:${String.format("%.3f", durationSec)},")
            sb.appendLine("/segment/$i")
        }

        if (complete) {
            sb.appendLine("#EXT-X-ENDLIST")
        }

        val m3u8 = sb.toString()
        Log.d(TAG, "📋 M3U8: $availableSegments/${totalSegments} segmentos, complete=$complete")

        val response = newFixedLengthResponse(
            Response.Status.OK,
            "application/vnd.apple.mpegurl",
            m3u8
        )
        response.addHeader("Cache-Control", "no-cache")
        response.addHeader("Access-Control-Allow-Origin", "*")
        return response
    }

    /**
     * Sirve el segmento n del archivo temporal.
     * Bloquea hasta que los bytes del segmento estén disponibles.
     */
    private fun serveSegment(uri: String): Response {
        val segIndex = uri.removePrefix("/segment/").toLongOrNull()
            ?: return newFixedLengthResponse(Response.Status.BAD_REQUEST, MIME_PLAINTEXT, "Bad segment index")

        val byteStart = segIndex * SEGMENT_SIZE
        val byteEnd = minOf(byteStart + SEGMENT_SIZE, totalSize)
        val segSize = byteEnd - byteStart

        if (byteStart >= totalSize) {
            return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Segment out of range")
        }

        Log.d(TAG, "📦 Segmento $segIndex: bytes $byteStart-$byteEnd (${segSize/1024}KB)")

        // Esperar hasta que los bytes del segmento estén disponibles
        if (!waitForBytes(byteEnd)) {
            Log.w(TAG, "⏰ Timeout esperando segmento $segIndex")
            return newFixedLengthResponse(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, "Timeout waiting for segment")
        }

        val file = tempFile ?: return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "No stream active")

        return try {
            val raf = RandomAccessFile(file, "r")
            raf.seek(byteStart)
            val buf = ByteArray(segSize.toInt())
            raf.readFully(buf)
            raf.close()

            newFixedLengthResponse(Response.Status.OK, "video/MP2T", buf.inputStream(), segSize)
        } catch (e: Exception) {
            Log.e(TAG, "Error sirviendo segmento $segIndex: ${e.message}")
            newFixedLengthResponse(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, "Read error: ${e.message}")
        }
    }

    fun cleanup() {
        try { writeStream?.close() } catch (_: Exception) {}
        tempFile?.delete()
        Log.i(TAG, "🧹 HlsProxy cleanup")
    }
}
