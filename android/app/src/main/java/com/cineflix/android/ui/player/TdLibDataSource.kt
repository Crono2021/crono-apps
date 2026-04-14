package com.cineflix.android.ui.player

import android.net.Uri
import android.util.Log
import androidx.media3.common.C
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.BaseDataSource
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DataSpec
import com.cineflix.android.TelegramEngine
import kotlinx.coroutines.*
import java.io.File
import java.io.IOException
import java.io.RandomAccessFile

/**
 * Custom ExoPlayer DataSource that reads from a TDLib-managed local file
 * while it's still being downloaded.
 *
 * Approach (same as Telegram-FOSS / Nekogram / TVGram):
 *   1. TDLib downloads the file to a local path: /data/.../files/videos/file_XXX
 *   2. This DataSource reads from that path using RandomAccessFile
 *   3. If ExoPlayer requests bytes that haven't been downloaded yet,
 *      we hint TDLib to prioritise that offset and poll until available
 *   4. No HTTP proxy, no NanoHTTPD, no cleartext issues
 */
@UnstableApi
class TdLibDataSource(
    private val engine: TelegramEngine,
    private val fileId: Int,
    private val totalSize: Long,
) : BaseDataSource(/* isNetwork= */ true) {

    companion object {
        private const val TAG = "TdLibDataSource"
        private const val POLL_INTERVAL_MS = 100L
        private const val READ_TIMEOUT_MS  = 60_000L
    }

    private var raf: RandomAccessFile? = null
    private var file: File? = null
    private var bytesRemaining: Long = 0L
    private var opened = false
    private var uri: Uri? = null

    override fun open(dataSpec: DataSpec): Long {
        uri = dataSpec.uri
        val position = dataSpec.position
        val length   = dataSpec.length

        Log.d(TAG, "open() position=$position length=$length fileId=$fileId totalSize=$totalSize")

        // 1. Get the local file path from TDLib (blocks until TDLib assigns it)
        val localPath = runBlocking {
            engine.startDownloadReturnPath(fileId, priority = 32)
        } ?: throw IOException("TDLib did not provide a local path for fileId=$fileId")

        val localFile = File(localPath)
        file = localFile

        // 2. Hint TDLib to prioritise downloading from the requested position
        engine.hintDownloadOffset(fileId, position)

        // 3. Wait until enough bytes are available at the requested position
        waitForBytes(localFile, position + 1)  // at least 1 byte at position

        // 4. Open the file for random access reading
        val accessFile = RandomAccessFile(localFile, "r")
        accessFile.seek(position)
        raf = accessFile

        // 5. Calculate how many bytes we can serve
        bytesRemaining = if (length != C.LENGTH_UNSET.toLong()) {
            length
        } else {
            totalSize - position
        }

        opened = true
        transferStarted(dataSpec)
        return bytesRemaining
    }

    override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
        if (bytesRemaining <= 0L) return C.RESULT_END_OF_INPUT

        val localFile = file ?: return C.RESULT_END_OF_INPUT
        val accessFile = raf ?: return C.RESULT_END_OF_INPUT

        val toRead = minOf(length.toLong(), bytesRemaining).toInt()

        // Wait for the file to have enough bytes at current position
        val neededPos = accessFile.filePointer + toRead
        waitForBytes(localFile, neededPos)

        val bytesRead = accessFile.read(buffer, offset, toRead)
        if (bytesRead == -1) {
            // File might still be growing — wait and retry once
            waitForBytes(localFile, neededPos)
            val retry = accessFile.read(buffer, offset, toRead)
            if (retry == -1) return C.RESULT_END_OF_INPUT
            bytesRemaining -= retry
            bytesTransferred(retry)
            return retry
        }

        bytesRemaining -= bytesRead
        bytesTransferred(bytesRead)
        return bytesRead
    }

    override fun getUri(): Uri? = uri

    override fun close() {
        try {
            raf?.close()
        } catch (_: Exception) {}
        raf = null
        file = null
        if (opened) {
            opened = false
            transferEnded()
        }
    }

    /**
     * Block until [file] has at least [neededBytes] on disk.
     * Also hints TDLib if we're waiting for bytes ahead of current download progress.
     */
    private fun waitForBytes(file: File, neededBytes: Long) {
        val deadline = System.currentTimeMillis() + READ_TIMEOUT_MS
        var hinted = false
        while (System.currentTimeMillis() < deadline) {
            val available = file.length()
            if (available >= neededBytes) return

            // Hint TDLib to download from where we need
            if (!hinted) {
                engine.hintDownloadOffset(fileId, neededBytes - 1)
                hinted = true
            }
            Thread.sleep(POLL_INTERVAL_MS)
        }
        Log.w(TAG, "Timeout waiting for $neededBytes bytes (have ${file.length()})")
    }

    // Factory ---

    class Factory(
        private val engine: TelegramEngine,
        private val fileId: Int,
        private val totalSize: Long,
    ) : DataSource.Factory {
        override fun createDataSource(): DataSource =
            TdLibDataSource(engine, fileId, totalSize)
    }
}
