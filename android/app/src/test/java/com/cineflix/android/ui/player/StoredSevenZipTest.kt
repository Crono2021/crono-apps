package com.cineflix.android.ui.player

import org.junit.Assert.*
import org.junit.Assume.assumeTrue
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.io.RandomAccessFile
import java.util.zip.CRC32

class StoredSevenZipTest {
    private fun crc(b: ByteArray) = CRC32().apply { update(b) }.value
    private fun le(n: Long, size: Int) = ByteArray(size) { (n ushr (it * 8)).toByte() }
    private fun fixture(method: Int = 0, name: String = "film.mkv", packPos: Int = 0): ByteArray {
        val h = ByteArrayOutputStream()
        h.write(byteArrayOf(1,4,6,packPos.toByte(),1,9,16,0,7,11,1,0,1,1,method.toByte(),12,16,0,8,0,0,5,1,17))
        val filename = (name + "\u0000").toByteArray(Charsets.UTF_16LE)
        h.write(filename.size + 1); h.write(0); h.write(filename); h.write(byteArrayOf(0,0))
        val header = h.toByteArray()
        val start = le((packPos + 16).toLong(),8) + le(header.size.toLong(),8) + le(crc(header),4)
        return byteArrayOf(0x37,0x7a,0xbc.toByte(),0xaf.toByte(),0x27,0x1c,0,4) + le(crc(start),4) +
            start + ByteArray(packPos) + ByteArray(16) { it.toByte() } + header
    }
    private fun inspect(b: ByteArray) = StoredSevenZip.inspect(b.size.toLong()) { at, n ->
        b.copyOfRange(at.toInt(), at.toInt() + n)
    }
    private fun rejected(b: ByteArray) {
        try { inspect(b); fail("Archive should have been rejected") } catch (_: IOException) { }
    }
    @Test fun copyMapsOnlyPayload() {
        val video = inspect(fixture())
        assertEquals(32L, video.offset); assertEquals(16L, video.size); assertEquals("film.mkv", video.name)
    }
    @Test fun packPositionIsNotHardcoded() { assertEquals(39L, inspect(fixture(packPos = 7)).offset) }
    @Test fun rejectsCompressionAndNonVideo() { rejected(fixture(method = 3)); rejected(fixture(name = "file.exe")) }
    @Test fun rejectsDamagedHeadersAndMissingLastPart() {
        val a = fixture(); a[12] = 99; rejected(a)
        val b = fixture(); b[b.lastIndex] = 7; rejected(b)
        rejected(fixture().dropLast(1).toByteArray())
    }
    @Test fun rejectsEncodedHeaderWithValidCrc() {
        val a = fixture(); a[48] = 23
        le(crc(a.copyOfRange(48, a.size)),4).copyInto(a,28)
        le(crc(a.copyOfRange(12,32)),4).copyInto(a,8)
        rejected(a)
    }
    @Test fun rejectsOversizedHeaderWithoutReadingIt() {
        val a = fixture(); le(2L * 1024 * 1024,8).copyInto(a,20)
        le(crc(a.copyOfRange(12,32)),4).copyInto(a,8)
        rejected(a)
    }

    @Test fun rejectsMultipleFilesStreamsEncryptionAndMismatchedCopySizes() {
        // Mutate otherwise-valid indexes and repair both CRCs so structure validation is exercised.
        for ((index, value) in listOf(4 to 2, 10 to 2, 11 to 1, 12 to 2, 13 to 0x24,
            14 to 6, 16 to 15, 22 to 2)) {
            val a = fixture()
            a[48 + index] = value.toByte()
            le(crc(a.copyOfRange(48,a.size)),4).copyInto(a,28)
            le(crc(a.copyOfRange(12,32)),4).copyInto(a,8)
            rejected(a)
        }
    }

    // Optional local integration fixture. Reads headers and boundary samples only, never extracts.
    @Test fun realSixVolumeArchive() {
        verifyRealArchive("CINEFLIX_7Z_FIXTURE", 6, 20766579571L, 178L)
    }

    @Test fun realBackroomsArchive() {
        verifyRealArchive("CINEFLIX_BACKROOMS_FIXTURE", 3, 11994816889L, 162L)
    }

    private fun verifyRealArchive(variable: String, volumes: Int, videoSize: Long, overhead: Long) {
        val folder = System.getenv(variable)
        assumeTrue("Set $variable for local integration", folder != null)
        val files = File(folder!!).listFiles()!!.filter { it.name.matches(Regex(".*\\.7z\\.00[1-6]")) }.sortedBy { it.name }
        assertEquals(volumes, files.size)
        val sizes = files.map { it.length() }
        val total = sizes.sum()
        var bytesRead = 0L
        fun read(at: Long, count: Int): ByteArray {
            var offset = at
            var remaining = count
            val out = ByteArrayOutputStream()
            for ((i, file) in files.withIndex()) {
                if (offset >= sizes[i]) { offset -= sizes[i]; continue }
                val take = minOf(remaining.toLong(), sizes[i] - offset).toInt()
                RandomAccessFile(file, "r").use { f ->
                    f.seek(offset); val b = ByteArray(take); f.readFully(b); out.write(b)
                }
                bytesRead += take; remaining -= take; offset = 0
                if (remaining == 0) break
            }
            assertEquals(0, remaining)
            return out.toByteArray()
        }
        val video = StoredSevenZip.inspect(total, ::read)
        assertEquals(32L, video.offset)
        assertEquals(videoSize, video.size)
        assertEquals(overhead, total - video.size)
        assertArrayEquals(byteArrayOf(0x1a,0x45,0xdf.toByte(),0xa3.toByte()), read(video.offset,4))
        assertTrue(bytesRead < 1024)
        // A virtual video range crossing a 4 GB volume boundary must preserve every byte.
        val boundary = sizes[0]
        val spanning = read(video.offset + (boundary - video.offset - 8),16)
        val expected = RandomAccessFile(files[0], "r").use { f -> f.seek(boundary - 8); ByteArray(8).also { f.readFully(it) } } +
            RandomAccessFile(files[1], "r").use { f -> ByteArray(8).also { f.readFully(it) } }
        assertArrayEquals(expected, spanning)
        assertEquals(16, read(video.offset + video.size - 16,16).size)
    }
}
