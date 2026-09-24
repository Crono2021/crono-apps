package com.cineflix.android

import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class BoundedVideoCacheTest {
    private class FakeBackend : BoundedVideoCache.Backend {
        val disk = mutableMapOf<Int, MutableMap<Long, ByteArray>>()
        var peak = 0
        var downloads = 0
        var purges = 0
        var failPurge = false
        var failDownload = false
        override fun purge(fileId: Int): Boolean {
            purges++
            if (failPurge) return false
            disk.remove(fileId)
            return true
        }
        override fun cached(fileId: Int, offset: Long, count: Long) = disk[fileId]?.get(offset)
        override fun download(fileId: Int, offset: Long, count: Long): ByteArray? {
            downloads++
            val data = ByteArray(count.toInt()) { ((offset + it) % 251).toByte() }
            disk.getOrPut(fileId) { mutableMapOf() }[offset] = data
            peak = maxOf(peak, disk.values.sumOf { chunks -> chunks.values.sumOf { it.size } })
            return if (failDownload) null else data.copyOf()
        }
    }

    @Test fun longPlaybackIsBoundedAndReturnedBytesSurvivePurges() {
        val backend = FakeBackend()
        val cache = BoundedVideoCache(backend, 32)
        val first = cache.read(1, 0, 8)!!
        repeat(200) { assertNotNull(cache.read(1, (it + 1) * 8L, 8)) }
        assertTrue(backend.peak <= 32)
        assertArrayEquals(ByteArray(8) { it.toByte() }, first)
    }

    @Test fun multipartAndBackwardSeeksReleasePreviousFile() {
        val backend = FakeBackend()
        val cache = BoundedVideoCache(backend, 32)
        for (id in listOf(1, 2, 3, 1, 3, 2)) {
            assertNotNull(cache.read(id, 1_000_000, 16))
            assertEquals(setOf(id), backend.disk.keys)
        }
        assertTrue(backend.peak <= 32)
    }

    @Test fun purgeFailureBlocksDownloadUntilConfirmed() {
        val backend = FakeBackend()
        val cache = BoundedVideoCache(backend, 32)
        assertNotNull(cache.read(1, 0, 32))
        backend.failPurge = true
        assertNull(cache.read(1, 32, 8))
        assertNull(cache.read(2, 0, 8))
        assertEquals(1, backend.downloads)
        backend.failPurge = false
        assertNotNull(cache.read(2, 0, 8))
        assertEquals(setOf(2), backend.disk.keys)
    }

    @Test fun failedDownloadsArePurgedBeforeRetry() {
        val backend = FakeBackend()
        val cache = BoundedVideoCache(backend, 32)
        backend.failDownload = true
        assertNull(cache.read(1, 0, 8))
        val before = backend.purges
        backend.failDownload = false
        assertNotNull(cache.read(1, 0, 8))
        assertEquals(before + 1, backend.purges)
    }

    @Test fun cachedReadsDoNotTriggerAnotherDownload() {
        val backend = FakeBackend()
        val cache = BoundedVideoCache(backend, 32)
        repeat(3) { assertNotNull(cache.read(1, 0, 8)) }
        assertEquals(1, backend.downloads)
    }

    @Test fun releaseClearsWindowAndCanReplaySameFile() {
        val backend = FakeBackend()
        val cache = BoundedVideoCache(backend, 32)
        assertNotNull(cache.read(1, 0, 8))
        assertTrue(cache.release(1))
        assertTrue(backend.disk.isEmpty())
        assertNotNull(cache.read(1, 0, 8))
        assertEquals(2, backend.downloads)
    }

    @Test fun concurrentReadersCannotRacePurgeAndDownload() {
        val backend = FakeBackend()
        val cache = BoundedVideoCache(backend, 32)
        val workers = Executors.newFixedThreadPool(4)
        try {
            val futures = (0 until 80).map { i -> workers.submit<Boolean> {
                val offset = i * 8L
                val result = cache.read(i % 3 + 1, offset, 8)
                result != null && result.contentEquals(ByteArray(8) { ((offset + it) % 251).toByte() })
            } }
            futures.forEach { assertTrue(it.get(5, TimeUnit.SECONDS)) }
            assertTrue(backend.peak <= 32)
        } finally { workers.shutdownNow() }
    }
}
