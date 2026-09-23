package com.cineflix.android

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest

class OtaUpdateManager(private val activity: ComponentActivity) {

    companion object {
        private const val TAG = "CineflixOTA"
        private const val OTA_JSON_URL =
            "https://raw.githubusercontent.com/Crono2021/crono-apps/ota-update/ota.json"
        private const val PREFS_NAME = "cineflix_ota"
        private const val KEY_SKIP_VERSION = "skip_version_code_long"
        private const val KEY_REMIND_AFTER = "remind_after_timestamp"
        private const val REMIND_INTERVAL_MS = 24 * 60 * 60 * 1000L // 24 horas
        private const val MAX_APK_SIZE = 200L * 1024 * 1024 // 200 MB
    }

    /** Thrown when the downloaded APK exceeds [MAX_APK_SIZE]. */
    private class ApkTooLargeException : Exception("APK exceeds maximum allowed size")

    private val client = OkHttpClient()
    private val mainHandler = Handler(Looper.getMainLooper())
    private val prefs = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    /**
     * Entry point — called from MainActivity.onCreate().
     * Uses lifecycleScope so the coroutine dies with the Activity.
     */
    fun checkForUpdate() {
        activity.lifecycleScope.launch(Dispatchers.IO) {
            try {
                doCheck()
            } catch (e: Exception) {
                Log.e(TAG, "OTA check error", e)
            }
        }
    }

    private fun doCheck() {
        // ¿El usuario pulsó "Más tarde" y aún no han pasado 24h?
        val remindAfter = prefs.getLong(KEY_REMIND_AFTER, 0)
        if (remindAfter > 0 && System.currentTimeMillis() < remindAfter) {
            Log.d(TAG, "Skipping OTA — user snoozed until ${java.util.Date(remindAfter)}")
            return
        }

        // Descargar ota.json
        val request = Request.Builder().url(OTA_JSON_URL).build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                Log.w(TAG, "OTA check failed: HTTP ${response.code}")
                return
            }

            val jsonStr = response.body?.string() ?: return
            val json = JSONObject(jsonStr)

            val remoteVersionCode = json.getLong("versionCode")
            val remoteVersionName = json.getString("versionName")
            val apkUrl = json.getString("apkUrl")
            val sha256 = json.getString("sha256")
            val changelog = json.optString("changelog", "")
            val mandatory = json.optBoolean("mandatory", false)
            val minVersionCode = json.optLong("minVersionCode", 1L)

            // Validar formato SHA-256 antes de continuar
            if (!sha256.matches(Regex("^[A-Fa-f0-9]{64}$"))) {
                Log.e(TAG, "Invalid SHA-256 format in OTA metadata: $sha256")
                return
            }

            // Validar que la URL del APK usa HTTPS
            val apkUri = Uri.parse(apkUrl)
            if (apkUri.scheme != "https") {
                Log.e(TAG, "OTA APK URL must use HTTPS, got: ${apkUri.scheme}")
                return
            }

            // Obtener versión local (compatible con API 21+ y 28+)
            val packageInfo = activity.packageManager.getPackageInfo(activity.packageName, 0)
            val localVersionCode: Long = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageInfo.longVersionCode
            } else {
                @Suppress("DEPRECATION")
                packageInfo.versionCode.toLong()
            }

            Log.i(TAG, "OTA: local=$localVersionCode, remote=$remoteVersionCode")

            // ¿Hay actualización?
            if (remoteVersionCode <= localVersionCode) {
                Log.d(TAG, "App is up to date")
                return
            }

            // ¿El usuario eligió "Omitir esta versión"?
            val isMandatory = mandatory || localVersionCode < minVersionCode
            val skippedVersion = prefs.getLong(KEY_SKIP_VERSION, -1L)
            if (skippedVersion == remoteVersionCode && !isMandatory) {
                Log.d(TAG, "User permanently skipped v$remoteVersionCode")
                return
            }

            // Mostrar diálogo en el hilo principal (solo si la Activity sigue viva)
            mainHandler.post {
                if (!activity.isFinishing && !activity.isDestroyed) {
                    showUpdateDialog(
                        remoteVersionName, changelog, apkUrl, sha256,
                        remoteVersionCode, isMandatory
                    )
                }
            }
        }
    }

    private fun showUpdateDialog(
        versionName: String, changelog: String, apkUrl: String,
        sha256: String, remoteVersionCode: Long, mandatory: Boolean
    ) {
        val builder = AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog)
            .setTitle("🔄 Actualización disponible")
            .setMessage("Nueva versión: $versionName\n\n$changelog")
            .setCancelable(!mandatory)
            .setPositiveButton("Actualizar") { _, _ ->
                downloadAndInstall(apkUrl, sha256)
            }

        if (!mandatory) {
            // "Más tarde" → vuelve a preguntar en 24h
            builder.setNeutralButton("Más tarde") { dialog, _ ->
                prefs.edit()
                    .putLong(KEY_REMIND_AFTER, System.currentTimeMillis() + REMIND_INTERVAL_MS)
                    .apply()
                dialog.dismiss()
            }
            // "Omitir" → no vuelve a preguntar por ESTA versión (sí por futuras)
            builder.setNegativeButton("Omitir versión") { dialog, _ ->
                prefs.edit()
                    .putLong(KEY_SKIP_VERSION, remoteVersionCode)
                    .remove(KEY_REMIND_AFTER)
                    .apply()
                dialog.dismiss()
            }
        }

        builder.show()
    }

    private fun downloadAndInstall(apkUrl: String, expectedSha256: String) {
        // Comprobar permiso de instalación ANTES de descargar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!activity.packageManager.canRequestPackageInstalls()) {
                Toast.makeText(
                    activity,
                    "Permite instalar apps de Cineflix en Ajustes",
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(
                    Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                    Uri.parse("package:${activity.packageName}")
                )
                activity.startActivity(intent)
                return
            }
        }

        val progressDialog = AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog)
            .setTitle("Descargando actualización...")
            .setView(ProgressBar(activity).apply {
                isIndeterminate = true
                setPadding(50, 50, 50, 50)
            })
            .setCancelable(false)
            .show()

        activity.lifecycleScope.launch(Dispatchers.IO) {
            val apkFile = File(activity.cacheDir, "cineflix_update.apk")

            try {
                // Borrar APK anterior si existe
                if (apkFile.exists()) apkFile.delete()

                val request = Request.Builder().url(apkUrl).build()
                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        showError(progressDialog, "Error de descarga: HTTP ${response.code}")
                        return@launch
                    }

                    val body = response.body ?: run {
                        showError(progressDialog, "Respuesta vacía del servidor")
                        return@launch
                    }

                    // Validar Content-Length si el servidor lo proporciona
                    val contentLength = body.contentLength()
                    if (contentLength > MAX_APK_SIZE) {
                        showError(progressDialog, "El archivo es demasiado grande")
                        return@launch
                    }

                    // Descargar con hash incremental
                    val digest = MessageDigest.getInstance("SHA-256")
                    var totalBytesRead = 0L

                    FileOutputStream(apkFile).use { fos ->
                        body.byteStream().use { input ->
                            val buffer = ByteArray(8192)
                            var bytesRead: Int
                            while (input.read(buffer).also { bytesRead = it } != -1) {
                                totalBytesRead += bytesRead
                                if (totalBytesRead > MAX_APK_SIZE) {
                                    throw ApkTooLargeException()
                                }
                                fos.write(buffer, 0, bytesRead)
                                digest.update(buffer, 0, bytesRead)
                            }
                        }
                    }

                    // Comprobar que el archivo no está vacío
                    if (apkFile.length() == 0L) {
                        apkFile.delete()
                        showError(progressDialog, "El archivo descargado está vacío")
                        return@launch
                    }

                    // Verificar SHA-256
                    val actualHash = digest.digest()
                        .joinToString("") { "%02x".format(it) }

                    if (!actualHash.equals(expectedSha256, ignoreCase = true)) {
                        Log.e(TAG, "SHA-256 MISMATCH! expected=$expectedSha256 actual=$actualHash")
                        apkFile.delete()
                        showError(progressDialog, "Error de integridad: el archivo está corrupto")
                        return@launch
                    }

                    Log.i(TAG, "APK verified: ${apkFile.length()} bytes, SHA-256 OK")

                    mainHandler.post {
                        progressDialog.dismiss()
                        if (!activity.isFinishing && !activity.isDestroyed) {
                            installApk(apkFile)
                        }
                    }
                }
            } catch (e: ApkTooLargeException) {
                apkFile.delete()
                showError(progressDialog, "Descarga excede el límite de seguridad")
            } catch (e: Exception) {
                Log.e(TAG, "Download failed", e)
                apkFile.delete()
                showError(progressDialog, "Error: ${e.message}")
            }
        }
    }

    private fun showError(dialog: AlertDialog, message: String) {
        mainHandler.post {
            dialog.dismiss()
            if (!activity.isFinishing && !activity.isDestroyed) {
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun installApk(apkFile: File) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val uri = FileProvider.getUriForFile(
                    activity,
                    "${activity.packageName}.fileprovider",
                    apkFile
                )
                intent.setDataAndType(uri, "application/vnd.android.package-archive")
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            } else {
                @Suppress("DEPRECATION")
                intent.setDataAndType(
                    Uri.fromFile(apkFile),
                    "application/vnd.android.package-archive"
                )
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivity(intent)
        } catch (e: Exception) {
            Log.e(TAG, "Install failed", e)
            Toast.makeText(activity, "No se pudo abrir el instalador", Toast.LENGTH_LONG).show()
        }
    }
}
