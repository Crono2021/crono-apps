package com.cineflix.android

import android.util.Log
import fi.iki.elonen.NanoHTTPD

class BinaryPipeServer(
    private val onChunkReceived: (String, ByteArray) -> Boolean
) : NanoHTTPD("127.0.0.1", 3999) {

    init {
        // Habilitar subida de bloques binarios grandes limitados por tiempo/RAM
    }

    private fun cors(r: Response): Response {
        r.addHeader("Access-Control-Allow-Origin", "*")
        r.addHeader("Access-Control-Allow-Methods", "POST, OPTIONS, GET")
        r.addHeader("Access-Control-Allow-Headers", "*")
        return r
    }

    override fun serve(session: IHTTPSession): Response {
        if (session.method == Method.OPTIONS) {
            return cors(newFixedLengthResponse(Response.Status.OK, "text/plain", ""))
        }

        if (session.method == Method.POST && session.uri == "/deliverChunk") {
            val requestId = session.parameters["requestId"]?.firstOrNull()
                ?: return cors(newFixedLengthResponse(Response.Status.BAD_REQUEST, "text/plain", "Missing requestId"))

            val contentLengthStr = session.headers["content-length"]
            val length = contentLengthStr?.toIntOrNull() ?: 0

            if (length > 0) {
                val bytes = ByteArray(length)
                var bytesRead = 0
                val inputStream = session.inputStream
                while (bytesRead < length) {
                    val read = inputStream.read(bytes, bytesRead, length - bytesRead)
                    if (read == -1) break
                    bytesRead += read
                }

                val delivered = onChunkReceived(requestId, bytes)
                if (delivered) {
                    return cors(newFixedLengthResponse(Response.Status.OK, "text/plain", "ok"))
                } else {
                    return cors(newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "expired"))
                }
            }

             onChunkReceived(requestId, ByteArray(0))
             return cors(newFixedLengthResponse(Response.Status.OK, "text/plain", "empty"))
        }

        return cors(super.serve(session))
    }
}
