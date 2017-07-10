package com.ecwid.maleorang

import com.ecwid.maleorang.connector.Connector
import com.ecwid.maleorang.connector.HttpClientConnector
import com.google.gson.JsonParser
import java.io.Closeable
import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger

/**
 * MailChimp API wrapper.
 *
 * @constructor Thread safety of the created instances depends on the supplied [connector].
 */
open class MailchimpClient protected constructor (
        private val apiKey: String, private val connector: Connector
) : Closeable {
    private val log = Logger.getLogger(javaClass.getName())

    /**
     * Instances created via this constructor are thread safe since they share a thread safe pool of http connections.
     * However in terms of performance it doesn't matter whether you reuse the same instance for the whole application or re-create it on every operation.
     */
    constructor(apiKey: String) : this(apiKey, HttpClientConnector())

    /**
     * Execute a MailChimp API method.
     *
     * @param[method] MailChimp API method to be executed
     * @return execution result
     */
    @Throws(IOException::class, MailchimpException::class)
    fun <R : MailchimpObject> execute(method: MailchimpMethod<R>): R {
        val methodInfo = MailchimpMethodInfo(method)
        val request = Connector.Request(methodInfo.httpMethod.name, methodInfo.buildUrl(apiKey), "ignorable", apiKey, methodInfo.requestBody)

        if (log.isLoggable(Level.FINE)) {
            val sb = StringBuilder("Request: ")
            sb.append(request.method).append(' ').append(request.url)
            if (request.requestBody != null) {
                sb.append('\n').append("Body: ").append(request.requestBody)
            }
            log.info(sb.toString())
        }

        val response = connector.call(request)

        if (log.isLoggable(Level.FINE)) {
            val sb = StringBuilder("Response: ")
            sb.append(response.statusCode).append(' ').append(response.reasonPhrase)
            if (response.responseBody != null) {
                sb.append('\n').append("Body: ").append(response.responseBody)
            }
            log.info(sb.toString())
        }

        if (response.statusCode !in 200..299) {
            var code = response.statusCode
            var description = response.reasonPhrase

            if (response.responseBody != null) {
                try {
                    val error = JsonParser().parse(response.responseBody).asJsonObject
                    code = error.get("status").asInt
                    description = error.get("detail").asString
                } catch (e: Exception){}
            }

            throw MailchimpException(code, description)
        }

        return MailchimpObject.fromJson(response.responseBody ?: "{}", method.resultType)
    }

    /**
     * Terminate the wrapper usage and release associated resources.
     */
    @Throws(IOException::class)
    override fun close() {
        connector.close()
    }
}