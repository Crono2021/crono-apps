package com.cineflix.android

/** One disk window shared by all HTTP readers, including seeks and multipart reads.
 * Bytes returned to callers are owned RAM copies; deleting the TDLib cache cannot
 * invalidate them. Never allow another download after an unconfirmed purge.
 */
internal class BoundedVideoCache(
    private val backend: Backend,
    private val limitBytes: Long = 32L * 1024 * 1024
) {
    interface Backend {
        fun purge(fileId: Int): Boolean
        fun cached(fileId: Int, offset: Long, count: Long): ByteArray?
        fun download(fileId: Int, offset: Long, count: Long): ByteArray?
    }

    private var currentFile: Int? = null
    private var reservedBytes = 0L
    private var needsPurge = true

    @Synchronized
    fun release(fileId: Int): Boolean {
        val ok = backend.purge(fileId)
        if (currentFile == fileId) {
            needsPurge = true
            if (ok) {
                currentFile = null
                reservedBytes = 0
            }
        }
        return ok
    }

    @Synchronized
    fun read(fileId: Int, offset: Long, count: Long): ByteArray? {
        require(fileId > 0 && offset >= 0 && count in 1..limitBytes)
        if (currentFile != fileId) {
            // Release the previous part before allowing a new part to occupy disk.
            currentFile?.let { if (!backend.purge(it)) return null }
            currentFile = fileId
            needsPurge = true // Also discard files left by an earlier playback.
        }
        if (needsPurge || reservedBytes + count > limitBytes) {
            needsPurge = true
            if (!backend.purge(fileId)) return null
            reservedBytes = 0
            needsPurge = false
        }
        backend.cached(fileId, offset, count)?.let { if (it.size.toLong() == count) return it }
        // Reserve before the request: a failed/timed-out download can still write bytes.
        reservedBytes += count
        val bytes = backend.download(fileId, offset, count)
        if (bytes == null || bytes.size.toLong() != count) {
            needsPurge = true
            return null
        }
        return bytes
    }
}
