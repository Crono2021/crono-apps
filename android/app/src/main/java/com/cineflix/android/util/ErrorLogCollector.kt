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
     * Envía el reporte automáticamente al bot de Telegram (@videoclubpacobot).
     */
    fun sendReportToBot(
        context: Context,
        reason: String,
        extraInfo: Map<String, Any?> = emptyMap(),
        throwable: Throwable? = null,
        onComplete: ((Boolean, String?) -> Unit)? = null
    ) {
        val file = generateReportFile(context, reason, extraInfo, throwable)
        val title = extraInfo["title"] ?: "Desconocido"
        val position = extraInfo["position"] ?: "N/A"
        val model = "${Build.MANUFACTURER} ${Build.MODEL}"

        val caption = "🚨 Reporte de Error Cineflix\n" +
                "📱 Dispositivo: $model\n" +
                "🎬 Título: $title\n" +
                "⏱ Minuto: $position\n" +
                "⚠️ Error: $reason"

        val engine = TelegramEngine.getInstance(context)
        engine.sendLogDocumentToBot(file, caption) { success, errorMsg ->
            if (success) {
                Log.i(TAG, "Reporte de error enviado con éxito al bot")
            } else {
                Log.e(TAG, "Fallo al enviar reporte al bot: $errorMsg")
            }
            onComplete?.invoke(success, errorMsg)
        }
    }
}
