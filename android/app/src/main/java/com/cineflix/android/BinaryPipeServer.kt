package com.cineflix.android

import android.util.Log
import fi.iki.elonen.NanoHTTPD

class BinaryPipeServer(
    private val onChunkReceived: (String, ByteArray) -> Boolean
) : NanoHTTPD("127.0.0.1", 3999) {

    init {
        // Habilitar subida de bloques binarios grandes limitados por tiempo/RAM
    }

    override fun serve(session: IHTTPSession): Response {
        if (session.method == Method.POST && session.uri == "/deliverChunk") {
            val requestId = session.parameters["requestId"]?.firstOrNull()
                ?: return newFixedLengthResponse(Response.Status.BAD_REQUEST, "text/plain", "Missing requestId")

            val contentLengthStr = session.headers["content-length"]
            val length = contentLengthStr?.toIntOrNull() ?: 0

            // Leemos los bytes puros sin interpretar ningún String, directamente del Socket TCP del loopback
            if (length > 0) {
                val bytes = ByteArray(length)
                var bytesRead = 0
                val inputStream = session.inputStream
                while (bytesRead < length) {
                    val read = inputStream.read(bytes, bytesRead, length - bytesRead)
                    if (read == -1) break
                    bytesRead += read
                }

                // Inyectamos el bloque crudo al DataSource de ExoPlayer 
                val delivered = onChunkReceived(requestId, bytes)
                if (delivered) {
                    return newFixedLengthResponse(Response.Status.OK, "text/plain", "ok")
                } else {
                    return newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "expired")
                }
            }

            // Si Javascript envia length = 0 (por error en la lectura de Telegram o EOF final)
             onChunkReceived(requestId, ByteArray(0))
             return newFixedLengthResponse(Response.Status.OK, "text/plain", "empty")
        }
        
        // CORS preventivo
        if (session.method == Method.OPTIONS) {
            val response = newFixedLengthResponse(Response.Status.OK, "text/plain", "")
            response.addHeader("Access-Control-Allow-Origin", "*")
            response.addHeader("Access-Control-Allow-Methods", "POST, OPTIONS")
            return response
        }

        return super.serve(session)
    }
}
