package com.ecwid.maleorang.connector

import java.io.Closeable
import java.io.IOException

/**
 * Abstract connector to access MailChimp API service point.
 */
interface Connector : Closeable {
    class Request(val method: String, val url: String, val username: String, val password: String, val requestBody: String?)
    class Response(val statusCode: Int, val reasonPhrase: String, val responseBody: String?)

    @Throws(IOException::class)
    fun call(request: Request): Response
}
