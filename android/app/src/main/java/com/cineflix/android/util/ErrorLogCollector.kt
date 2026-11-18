package com.cineflix.android.util

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.os.Environment
import android.os.StatFs
import android.util.Log
import com.cineflix.android.TelegramEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.ConcurrentLinkedQueue

/**
 * ErrorLogCollector — Recopila datos de hardware, logcat, estado del reproductor y excepciones,
 * genera un archivo .txt y lo envía directamente al chat de @videoclubpacobot vía TDLib.
 */
object ErrorLogCollector {
    private const val TAG = "ErrorLogCollector"
    private val memoryLogRing = ConcurrentLinkedQueue<String>()
    private const val MAX_RING_SIZE = 300

    fun log(tag: String, message: String) {
        val timestamp = SimpleDateFormat("HH:mm:ss.SSS", Locale.US).format(Date())
        val line = "[$timestamp][$tag] $message"
        memoryLogRing.add(line)
        while (memoryLogRing.size > MAX_RING_SIZE) {
            memoryLogRing.poll()
        }
    }

    /**
     * Genera un reporte detallado en un archivo .txt en el almacenamiento de la app.
     */
    fun generateReportFile(
        context: Context,
        reason: String,
        extraInfo: Map<String, Any?> = emptyMap(),
        throwable: Throwable? = null
    ): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val logsDir = File(context.cacheDir, "crash_reports").apply { mkdirs() }
        // Purge stale crash reports older than 10 minutes without deleting active TDLib uploads in flight
        runCatching {
            val cutoffMs = System.currentTimeMillis() - 10L * 60L * 1000L
            logsDir.listFiles()?.forEach { old ->
                if (old.isFile && old.lastModified() < cutoffMs) {
                    runCatching { old.delete() }
                }
            }
        }
        val logFile = File(logsDir, "cineflix_error_${timeStamp}.txt")

        val sb = StringBuilder()
        sb.appendLine("=======================================================")
        sb.appendLine(" CINEFLIX - INFORME DE DIAGNÓSTICO Y ERROR")
        sb.appendLine("=======================================================")
        sb.appendLine("Fecha y hora: ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date())}")
        sb.appendLine("Motivo: $reason")
        sb.appendLine()

        // 1. Hardware & SO
        sb.appendLine("--- DISPOSITIVO Y SISTEMA ---")
        sb.appendLine("Fabricante: ${Build.MANUFACTURER}")
        sb.appendLine("Modelo: ${Build.MODEL} (${Build.PRODUCT})")
        sb.appendLine("Dispositivo: ${Build.DEVICE}")
        sb.appendLine("Android: ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})")
        sb.appendLine("ABIs soportadas: ${Build.SUPPORTED_ABIS.joinToString(", ")}")
        val pkgInfo = try { context.packageManager.getPackageInfo(context.packageName, 0) } catch (_: Exception) { null }
        val vName = pkgInfo?.versionName ?: "1.4.4e"
        @Suppress("DEPRECATION")
        val vCode = pkgInfo?.versionCode ?: 55
        sb.appendLine("App Version: $vName (versionCode $vCode)")
        sb.appendLine()

        // 2. Memoria y Almacenamiento
        sb.appendLine("--- MEMORIA Y ALMACENAMIENTO ---")
        try {
            val actManager = context.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
            val memInfo = ActivityManager.MemoryInfo()
            actManager?.getMemoryInfo(memInfo)
            val availRamMb = memInfo.availMem / (1024 * 1024)
            val totalRamMb = memInfo.totalMem / (1024 * 1024)
            sb.appendLine("RAM: ${availRamMb}MB libres / ${totalRamMb}MB totales (LowMemory: ${memInfo.lowMemory})")
        } catch (e: Exception) {
            sb.appendLine("Error leyendo RAM: ${e.message}")
        }

        try {
            val stat = StatFs(context.cacheDir.path)
            val availBytes = stat.availableBytes
            val totalBytes = stat.totalBytes
            sb.appendLine("ROM (Cache): ${availBytes / (1024 * 1024)}MB libres / ${totalBytes / (1024 * 1024)}MB totales")
        } catch (e: Exception) {
            sb.appendLine("Error leyendo almacenamiento: ${e.message}")
        }
        sb.appendLine()

        // 3. Metadatos de Reproducción
        if (extraInfo.isNotEmpty()) {
            sb.appendLine("--- CONTEXTO DE REPRODUCCIÓN ---")
            for ((key, value) in extraInfo) {
                sb.appendLine("$key: $value")
            }
            sb.appendLine()
        }

        // 4. Excepción (si existe)
        if (throwable != null) {
            sb.appendLine("--- EXCEPCIÓN / STACKTRACE ---")
            sb.appendLine(Log.getStackTraceString(throwable))
            sb.appendLine()
        }

        // 5. Historial en memoria (Ring Buffer)
        sb.appendLine("--- EVENTOS INTERNOS DE CINEFLIX (${memoryLogRing.size} eventos) ---")
        for (line in memoryLogRing) {
            sb.appendLine(line)
        }
        sb.appendLine()

        // 6. Logcat del proceso (últimas 350 líneas)
        sb.appendLine("--- LOGCAT DEL PROCESO ---")
        try {
            val pid = android.os.Process.myPid()
            val process = Runtime.getRuntime().exec(arrayOf("logcat", "-d", "-v", "time", "-t", "350"))
            BufferedReader(InputStreamReader(process.inputStream)).use { reader ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    if (line!!.contains("$pid") || line!!.contains("Tdlib") || line!!.contains("Telegram") || 
                        line!!.contains("ExoPlayer") || line!!.contains("Cineflix") || line!!.contains("StreamProxy") ||
                        line!!.contains("LocalStreamServer") || line!!.contains("CCodec") || line!!.contains("MediaCodec")) {
                        sb.appendLine(line)
                    }
                }
            }
        } catch (e: Exception) {
            sb.appendLine("No se pudo capturar logcat: ${e.message}")
        }
        sb.appendLine()
        sb.appendLine("================ FIN DEL INFORME ================")

        logFile.writeText(sb.toString())
        Log.i(TAG, "Reporte generado en: ${logFile.absolutePath} (${logFile.length()} bytes)")
        return logFile
    }

    /**
     * Envía el reporte automáticamente al bot de Telegram (@videoclubpacobot)
     * y en paralelo al endpoint de diagnóstico HTTPS del servidor como respaldo garantizado.
     */
    fun sendReportToBot(
        context: Context,
        reason: String,
        extraInfo: Map<String, Any?> = emptyMap(),
        throwable: Throwable? = null,
        onComplete: ((Boolean, String?) -> Unit)? = null
    ) {
        val file = generateReportFile(context, reason, extraInfo, throwable)
        val reportContent = runCatching { file.readText() }.getOrDefault("")
        val title = extraInfo["title"] ?: "Desconocido"
        val position = extraInfo["position"] ?: "N/A"
        val model = "${Build.MANUFACTURER} ${Build.MODEL}"
        val pkgInfo = runCatching { context.packageManager.getPackageInfo(context.packageName, 0) }.getOrNull()
        val vName = pkgInfo?.versionName ?: "1.5.0"
        val vCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            (pkgInfo?.longVersionCode ?: 69L).toInt()
        } else {
            @Suppress("DEPRECATION")
            pkgInfo?.versionCode ?: 69
        }

        val caption = "🚨 Reporte de Error Cineflix ($vName b$vCode)\n" +
                "📱 Dispositivo: $model\n" +
                "🎬 Título: $title\n" +
                "⏱ Minuto: $position\n" +
                "⚠️ Error: $reason"

        // 1. Guaranteed HTTPS backup upload directly to Cineflix backend
        StorageAndRamHygiene.launchBackgroundHygiene {
            uploadReportToBackendHttps(
                reason = reason,
                device = model,
                appVersion = vName,
                versionCode = vCode,
                extraInfo = extraInfo,
                reportText = reportContent
            )
        }

        // 2. Send to user's @videoclubpacobot chat via TDLib (do NOT delete `file` immediately:
        //    TdApi.SendMessage queues InputFileLocal asynchronously on TDLib's upload worker!)
        val engine = TelegramEngine.getInstance(context)
        engine.sendLogDocumentToBot(file, caption) { success, errorMsg ->
            if (success) {
                Log.i(TAG, "Reporte de error enviado con éxito al bot")
            } else {
                Log.e(TAG, "Fallo al enviar reporte al bot: $errorMsg")
            }
            StorageAndRamHygiene.launchBackgroundHygiene {
                kotlinx.coroutines.delay(180_000L)
                runCatching { if (file.exists()) file.delete() }
            }
            onComplete?.invoke(success, errorMsg)
        }
    }

    private fun uploadReportToBackendHttps(
        reason: String,
        device: String,
        appVersion: String,
        versionCode: Int,
        extraInfo: Map<String, Any?>,
        reportText: String
    ): Boolean {
        var conn: java.net.HttpURLConnection? = null
        return try {
            conn = StorageAndRamHygiene.openCompatUrlConnection("https://cineflixapp.duckdns.org/api/client-error-log").apply {
                requestMethod = "POST"
                connectTimeout = 6000
                readTimeout = 6000
                doOutput = true
                setRequestProperty("Content-Type", "application/json; charset=UTF-8")
            }
            val extraObj = org.json.JSONObject()
            for ((k, v) in extraInfo) {
                extraObj.put(k, v?.toString() ?: "")
            }
            val trimmedReport = if (reportText.length > 58_000) {
                reportText.take(18_000) + "\n...[TRUNCATED MIDDLE]...\n" + reportText.takeLast(38_000)
            } else {
                reportText
            }
            val payload = org.json.JSONObject().apply {
                put("reason", reason)
                put("device", device)
                put("appVersion", appVersion)
                put("versionCode", versionCode)
                put("extraInfo", extraObj)
                put("reportText", trimmedReport)
            }.toString()
            java.io.OutputStreamWriter(conn.outputStream, Charsets.UTF_8).use { it.write(payload) }
            conn.responseCode in 200..299
        } catch (e: Throwable) {
            Log.w(TAG, "HTTPS diagnostic upload fallback note: ${e.message}")
            false
        } finally {
            runCatching { conn?.disconnect() }
        }
    }
}
