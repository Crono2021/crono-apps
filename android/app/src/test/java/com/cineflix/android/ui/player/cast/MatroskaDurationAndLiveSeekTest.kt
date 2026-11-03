package com.cineflix.android.ui.player.cast

import com.cineflix.android.ui.player.LocalStreamServer
import com.cineflix.android.ui.player.cast.transcode.LiveTranscodeManager
import com.cineflix.android.ui.player.cast.transcode.MpegTsMuxer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

class MatroskaDurationAndLiveSeekTest {

    @Test
    fun parseHeaderExtractsInfoDurationAndClusterTimecode() {
        val out = ByteArrayOutputStream()
        // EBML Header (0x1A45DFA3) with 4 bytes payload
        out.write(byteArrayOf(0x1A, 0x45, 0xDF.toByte(), 0xA3.toByte(), 0x84.toByte(), 0x42, 0x86.toByte(), 0x81.toByte(), 0x01))

        // Segment (0x18538067) with unknown length (0x01FFFFFFFFFFFFFF)
        out.write(
            byteArrayOf(
                0x18, 0x53, 0x80.toByte(), 0x67,
                0x01, 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
            )
        )

        // Info (0x1549A966): TimestampScale (0x2AD7B1) = 1_000_000 (0x0F4240) + Duration (0x4489) = 6852000.0 (1h 54m 12s)
        val infoPayload = ByteArrayOutputStream()
        // TimestampScale: ID 0x2AD7B1, size 3 (0x83), value 1_000_000 (0x0F, 0x42, 0x40)
        infoPayload.write(byteArrayOf(0x2A, 0xD7.toByte(), 0xB1.toByte(), 0x83.toByte(), 0x0F, 0x42, 0x40))
        // Duration: ID 0x4489, size 8 (0x88), IEEE-754 double 6852000.0
        infoPayload.write(byteArrayOf(0x44, 0x89.toByte(), 0x88.toByte()))
        val durBytes = ByteBuffer.allocate(8).putDouble(6_852_000.0).array()
        infoPayload.write(durBytes)
        val infoArr = infoPayload.toByteArray()
        out.write(byteArrayOf(0x15, 0x49, 0xA9.toByte(), 0x66, (0x80 or infoArr.size).toByte()))
        out.write(infoArr)

        // Tracks (0x1654AE6B) with 1 video TrackEntry (0xAE)
        val trackEntryPayload = byteArrayOf(
            0xD7.toByte(), 0x81.toByte(), 0x01, // TrackNumber = 1
            0x83.toByte(), 0x81.toByte(), 0x01, // TrackType = 1 (Video)
            0x86.toByte(), 0x85.toByte(), 'V'.code.toByte(), '_'.code.toByte(), 'A'.code.toByte(), 'V'.code.toByte(), 'C'.code.toByte()
        )
        val tracksPayload = ByteArrayOutputStream()
        tracksPayload.write(byteArrayOf(0xAE.toByte(), (0x80 or trackEntryPayload.size).toByte()))
        tracksPayload.write(trackEntryPayload)
        val tracksArr = tracksPayload.toByteArray()
        out.write(byteArrayOf(0x16, 0x54, 0xAE.toByte(), 0x6B, (0x80 or tracksArr.size).toByte()))
        out.write(tracksArr)

        // Cluster (0x1F43B675) at end of header with Timecode (0xE7) = 1_800_000 (30 min)
        val clusterOffset = out.size()
        out.write(
            byteArrayOf(
                0x1F, 0x43, 0xB6.toByte(), 0x75,
                0x86.toByte(), // size 6
                0xE7.toByte(), 0x83.toByte(), 0x1B, 0x77, 0x40, // Timecode = 1_800_000 (0x1B7740)
                0xA3.toByte() // dummy byte
            )
        )

        val mkvBytes = out.toByteArray()
        val parsed = MatroskaEbmlTrackPatcher.parseHeader(mkvBytes)
        assertNotNull(parsed)
        assertEquals(1_000_000L, parsed!!.timestampScaleNs)
        assertEquals(6_852_000L, parsed.durationMs)
        assertEquals(clusterOffset.toLong(), parsed.firstClusterOffset)

        val clusterTicks = MatroskaEbmlTrackPatcher.readClusterTimecodeTicks(
            mkvBytes,
            clusterOffset,
            mkvBytes.size
        )
        assertEquals(1_800_000L, clusterTicks)
    }

    @Test
    fun extractMp4MvhdDurationReadsExactMovieDuration() {
        val buf = ByteBuffer.allocate(64)
        // ftyp box (16 bytes)
        buf.putInt(16)
        buf.put("ftyp".toByteArray())
        buf.putInt(0)
        buf.putInt(0)

        // moov box (48 bytes)
        buf.putInt(48)
        buf.put("moov".toByteArray())

        // mvhd box (40 bytes, version 0)
        buf.putInt(40)
        buf.put("mvhd".toByteArray())
        buf.putInt(0) // version 0 + flags
        buf.putInt(0) // creation_time
        buf.putInt(0) // modification_time
        buf.putInt(1000) // timescale = 1000 ticks/sec
        buf.putInt(5_400_000) // duration = 5,400,000 ticks (1h 30m)
        buf.putInt(0)
        buf.putInt(0)

        val durMs = LocalStreamServer.extractMp4MvhdDurationMs(buf.array())
        assertEquals(5_400_000L, durMs)
    }

    @Test
    fun computeVirtualLiveTsSizeNeverOverflowsSigned32BitAndAlignsTo188() {
        val size90Min = LiveTranscodeManager.computeVirtualLiveTsSizeBytes(90L * 60_000L, is1080p = true)
        assertEquals(0L, size90Min % 188L)
        assertTrue(size90Min <= Int.MAX_VALUE.toLong())

        val size4Hours = LiveTranscodeManager.computeVirtualLiveTsSizeBytes(240L * 60_000L, is1080p = true)
        assertEquals(0L, size4Hours % 188L)
        assertTrue(size4Hours <= LiveTranscodeManager.MAX_SAFE_32BIT_TS_SIZE_BYTES)
        assertTrue(size4Hours <= Int.MAX_VALUE.toLong())
    }

    @Test
    fun mpegTsMuxerEmitsDiscontinuityAndOffsetsPtsOnTvLiveSeek() {
        val out = ByteArrayOutputStream()
        val muxer = MpegTsMuxer(
            initialMediaOffsetUs = 1_800_000_000L, // 30 minutes
            emitInitialDiscontinuity = true,
            onTsBytes = { bytes, offset, len -> out.write(bytes, offset, len) }
        )
        val sps = byteArrayOf(0x67, 0x42, 0x00, 0x1E, 0x9A.toByte(), 0x74, 0x05, 0x81.toByte(), 0xEC.toByte(), 0x80.toByte())
        val pps = byteArrayOf(0x68, 0xCE.toByte(), 0x3C, 0x80.toByte())
        val idrSlice = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65, 0x88.toByte(), 0x84.toByte(), 0x21)
        muxer.writeH264Sample(
            annexBNalsWithoutAud = idrSlice,
            ptsUs = 0L,
            isKeyFrame = true,
            spsList = listOf(sps),
            ppsList = listOf(pps)
        )
        val tsBytes = out.toByteArray()
        assertTrue(tsBytes.size >= 3 * MpegTsMuxer.TS_PACKET_SIZE)
        assertEquals(0, tsBytes.size % MpegTsMuxer.TS_PACKET_SIZE)

        // Third packet is the first video packet (PID 0x0100) containing the adaptation field + PCR
        val videoPktOffset = 2 * MpegTsMuxer.TS_PACKET_SIZE
        assertEquals(0x47.toByte(), tsBytes[videoPktOffset])
        val afFlags = tsBytes[videoPktOffset + 5].toInt() and 0xFF
        // bit 7 (0x80) = discontinuity_indicator, bit 6 (0x40) = random_access_indicator, bit 4 (0x10) = PCR_flag
        assertTrue("Expected discontinuity_indicator (0x80) to be set", (afFlags and 0x80) != 0)
        assertTrue("Expected PCR_flag (0x10) to be set", (afFlags and 0x10) != 0)
    }

    @Test
    fun disableAllSubtitlesSetsFlagEnabledZeroAndDefaultZero() {
        val out = ByteArrayOutputStream()
        out.write(byteArrayOf(0x1A, 0x45, 0xDF.toByte(), 0xA3.toByte(), 0x84.toByte(), 0x42, 0x86.toByte(), 0x81.toByte(), 0x01))
        out.write(
            byteArrayOf(
                0x18, 0x53, 0x80.toByte(), 0x67,
                0x01, 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
            )
        )
        // Video TrackEntry + Subtitle TrackEntry with omitted FlagDefault (= 1), FlagForced = 1, Language = "spa", Name = "Forzados"
        val videoEntry = byteArrayOf(
            0xD7.toByte(), 0x81.toByte(), 0x01,
            0x83.toByte(), 0x81.toByte(), 0x01,
            0x86.toByte(), 0x85.toByte(), 'V'.code.toByte(), '_'.code.toByte(), 'A'.code.toByte(), 'V'.code.toByte(), 'C'.code.toByte()
        )
        val subEntry = byteArrayOf(
            0xD7.toByte(), 0x81.toByte(), 0x03, // TrackNumber = 3
            0x83.toByte(), 0x81.toByte(), 0x11, // TrackType = 17 (Subtitle)
            0x55, 0xAA.toByte(), 0x81.toByte(), 0x01, // FlagForced = 1
            0x22, 0xB5.toByte(), 0x9C.toByte(), 0x83.toByte(), 's'.code.toByte(), 'p'.code.toByte(), 'a'.code.toByte(),
            0x53, 0x6E, 0x88.toByte(), 'F'.code.toByte(), 'o'.code.toByte(), 'r'.code.toByte(), 'z'.code.toByte(), 'a'.code.toByte(), 'd'.code.toByte(), 'o'.code.toByte(), 's'.code.toByte(),
            0x86.toByte(), 0x8B.toByte(), 'S'.code.toByte(), '_'.code.toByte(), 'T'.code.toByte(), 'E'.code.toByte(), 'X'.code.toByte(), 'T'.code.toByte(), '/'.code.toByte(), 'U'.code.toByte(), 'T'.code.toByte(), 'F'.code.toByte(), '8'.code.toByte()
        )
        val tracksPayload = ByteArrayOutputStream()
        tracksPayload.write(byteArrayOf(0xAE.toByte(), (0x80 or videoEntry.size).toByte()))
        tracksPayload.write(videoEntry)
        tracksPayload.write(byteArrayOf(0xAE.toByte(), (0x80 or subEntry.size).toByte()))
        tracksPayload.write(subEntry)
        val tracksArr = tracksPayload.toByteArray()
        out.write(byteArrayOf(0x16, 0x54, 0xAE.toByte(), 0x6B, (0x80 or tracksArr.size).toByte()))
        out.write(tracksArr)

        val mkvBytes = out.toByteArray()
        val info = MatroskaEbmlTrackPatcher.parseHeader(mkvBytes)!!
        assertEquals(1, info.subtitleTracks.size)
        assertTrue(info.subtitleTracks[0].isDefault)
        assertTrue(info.subtitleTracks[0].isForced)
        assertTrue(info.subtitleTracks[0].isEnabled)

        val patch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
            info = info,
            subtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL
        )
        assertNotNull(patch)
        val patchedMkv = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
            sourceBuffer = mkvBytes,
            sliceOffset = 0,
            sliceLength = mkvBytes.size,
            rangeGlobalStart = 0L,
            patch = patch
        )!!
        assertEquals(mkvBytes.size, patchedMkv.size)
        val reparsed = MatroskaEbmlTrackPatcher.parseHeader(patchedMkv)!!
        assertEquals(1, reparsed.subtitleTracks.size)
        val sub = reparsed.subtitleTracks[0]
        assertTrue("Expected FlagEnabled=0 when DISABLE_ALL", !sub.isEnabled)
        assertTrue("Expected FlagDefault=0 when DISABLE_ALL", !sub.isDefault)
        assertTrue("Expected FlagForced=0 when DISABLE_ALL", !sub.isForced)
        assertEquals("", sub.language)
        assertEquals("", sub.name)
    }
}
