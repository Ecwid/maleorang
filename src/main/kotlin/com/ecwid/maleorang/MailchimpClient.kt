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
open class MailchimpClient protected constructor(
        private val apiKey: String, private val connector: Connector, private val connectTimeOut: Int , private val socketTimeOut: Int, private val connectionRequestTimeOut: Int
) : Closeable {
    private val log = Logger.getLogger(javaClass.getName())

    /**
     * Instances created via this constructor are thread safe since they share a thread safe pool of http connections.
     * However in terms of performance it doesn't matter whether you reuse the same instance for the whole application or re-create it on every operation.
     * TimeOut parameters are optional. If not provided, Mailchimp client will use 15000 Milliseconds for connect and connectionRequest timeouts, and 300000 Milliseconds for
     * socketTimeOut
     */
    @JvmOverloads
    constructor(apiKey: String, connectTimeOut: Int = 15000, socketTimeOut: Int = 300000, connectionRequestTimeOut: Int = 15000) :
            this(apiKey, HttpClientConnector(connectTimeOut, socketTimeOut, connectionRequestTimeOut), connectTimeOut, socketTimeOut, connectionRequestTimeOut)


    /**
     * Execute a MailChimp API method.
     *
     * @param[method] MailChimp API method to be executed
     * @return execution result
     */
    @Throws(IOException::class, MailchimpException::class)
    open fun <R : MailchimpObject> execute(method: MailchimpMethod<R>): R {
        val methodInfo = MailchimpMethodInfo(method)
        val request = Connector.Request(methodInfo.httpMethod.name, methodInfo.buildUrl(apiKey), "ignorable", apiKey, methodInfo.requestBody)

        if (log.isLoggable(Level.FINEST)) {
            val sb = StringBuilder("Request: ")
            sb.append(request.method).append(' ').append(request.url)
            if (request.requestBody != null) {
                sb.append('\n').append("Body: ").append(request.requestBody)
            }
            log.finest(sb.toString())
        }

        val response = connector.call(request)

        if (log.isLoggable(Level.FINEST)) {
            val sb = StringBuilder("Response: ")
            sb.append(response.statusCode).append(' ').append(response.reasonPhrase)
            if (response.responseBody != null) {
                sb.append('\n').append("Body: ").append(response.responseBody)
            }
            log.finest(sb.toString())
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