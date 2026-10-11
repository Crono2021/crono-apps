package com.cineflix.android.ui.player

import java.io.IOException
import java.util.zip.CRC32

/** Strict, bounded index reader, NOT an extractor. Supports one Copy stream and one video.
 * Encoded/encrypted headers, coder chains, multiple files and compressed data fail closed.
 * All offsets are Long. The caller supplies random access over the original Telegram volumes.
 */
internal object StoredSevenZip {
    data class Video(val offset: Long, val size: Long, val name: String)
    private const val MAX_HEADER = 1024 * 1024
    private fun check(ok: Boolean, reason: String) {
        if (!ok) throw IOException("7z no compatible o dañado: $reason")
    }

    fun inspect(total: Long, read: (Long, Int) -> ByteArray): Video {
        check(total >= 32, "cabecera incompleta")
        val start = read(0, 32)
        check(start.size == 32, "lectura incompleta")
        check(start.take(6) == listOf(0x37, 0x7a, 0xbc, 0xaf, 0x27, 0x1c).map { it.toByte() }, "firma incorrecta")
        check(start[6].toInt() == 0, "versión desconocida")
        val s = Cursor(start, 8)
        val startCrc = s.le(4)
        check(crc(start.copyOfRange(12, 32)) == startCrc, "CRC de cabecera")
        val nextOffset = s.le(8)
        val nextSize = s.le(8)
        val nextCrc = s.le(4)
        check(nextOffset <= total - 32 && nextSize in 1..MAX_HEADER.toLong() &&
            nextSize == total - 32 - nextOffset, "faltan partes o tamaño de índice inválido")
        val header = read(32 + nextOffset, nextSize.toInt())
        check(header.size.toLong() == nextSize && crc(header) == nextCrc, "CRC del índice")
        val c = Cursor(header)
        check(c.byte() == 1, "índice comprimido/cifrado no admitido")
        c.expect(4) // MainStreamsInfo (no external/additional streams)
        c.expect(6) // PackInfo
        val packPos = c.number()
        check(c.number() == 1L, "se requiere un solo flujo")
        c.expect(9)
        val packed = c.number()
        var id = c.byte()
        if (id == 10) { c.digest(); id = c.byte() }
        check(id == 0, "PackInfo inválido")
        c.expect(7); c.expect(11)
        check(c.number() == 1L && c.byte() == 0, "carpetas múltiples o externas")
        check(c.number() == 1L, "múltiples métodos")
        check(c.byte() == 1 && c.byte() == 0, "solo se admite Copy, sin compresión ni cifrado")
        c.expect(12)
        val unpacked = c.number()
        check(unpacked > 0 && unpacked == packed, "tamaño Copy inválido")
        id = c.byte()
        var folderCrcDefined = false
        if (id == 10) { folderCrcDefined = c.digest(); id = c.byte() }
        check(id == 0, "UnpackInfo inválido")
        id = c.byte()
        if (id == 8) {
            id = c.byte()
            if (id == 13) { check(c.number() == 1L, "múltiples subflujos"); id = c.byte() }
            if (id == 10) {
                // A single stream inherits its folder CRC when one is defined.
                if (!folderCrcDefined) c.digest()
                id = c.byte()
            }
            check(id == 0, "SubStreamsInfo inválido")
            id = c.byte()
        }
        check(id == 0, "StreamsInfo inválido")
        c.expect(5)
        check(c.number() == 1L, "se requiere un único archivo de vídeo")
        var name: String? = null
        while (true) {
            val property = c.byte()
            if (property == 0) break
            val data = c.bytes(c.number())
            when (property) {
                17 -> {
                    check(name == null && data.size >= 3 && data.size % 2 == 1 && data[0].toInt() == 0,
                        "nombre externo o inválido")
                    val decoded = String(data.copyOfRange(1, data.size), Charsets.UTF_16LE)
                    check(decoded.endsWith('\u0000') && !decoded.dropLast(1).contains('\u0000'), "nombre inválido")
                    name = decoded.dropLast(1)
                }
                18, 19, 20, 21, 25 -> Unit // Dates, attributes, padding do not affect byte mapping.
                else -> check(false, "propiedad de archivo no admitida ($property)")
            }
        }
        c.expect(0)
        check(c.finished(), "datos inesperados en índice")
        val videoName = name ?: throw IOException("7z sin nombre de vídeo")
        check(Regex(".*\\.(mkv|mp4|avi|ts|mov)$", RegexOption.IGNORE_CASE).matches(videoName), "el archivo no es vídeo")
        check(packPos <= nextOffset && packed <= nextOffset - packPos, "datos fuera de las partes")
        return Video(32 + packPos, packed, videoName)
    }

    private fun crc(bytes: ByteArray): Long = CRC32().apply { update(bytes) }.value
    private class Cursor(private val data: ByteArray, private var pos: Int = 0) {
        fun byte(): Int {
            check(pos < data.size, "índice truncado")
            return data[pos++].toInt() and 255
        }
        fun expect(value: Int) = check(byte() == value, "estructura inesperada")
        fun le(count: Int): Long {
            var value = 0L
            repeat(count) { value = value or (byte().toLong() shl (8 * it)) }
            check(value >= 0, "entero fuera de rango")
            return value
        }
        fun number(): Long {
            val first = byte()
            var mask = 128
            var value = 0L
            for (i in 0..7) {
                if (first and mask == 0) return value or ((first and (mask - 1)).toLong() shl (8 * i))
                value = value or (byte().toLong() shl (8 * i))
                mask = mask ushr 1
            }
            check(value >= 0, "entero fuera de rango")
            return value
        }
        fun bytes(count: Long): ByteArray {
            check(count >= 0 && count <= data.size - pos, "propiedad truncada")
            return data.copyOfRange(pos, pos + count.toInt()).also { pos += count.toInt() }
        }
        fun digest(): Boolean {
            val all = byte()
            check(all in 0..1, "CRC inválido")
            val defined = if (all == 1) true else byte() and 128 != 0
            if (defined) le(4)
            return defined
        }
        fun finished() = pos == data.size
    }
}
