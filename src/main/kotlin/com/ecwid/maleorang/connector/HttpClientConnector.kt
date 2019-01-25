package com.ecwid.maleorang.connector

import org.apache.commons.codec.binary.Base64
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.*
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.apache.http.util.EntityUtils

import java.io.IOException
import java.net.URI
import java.nio.charset.Charset

/**
 * Implementation of [Connector] which uses Apache HttpClient library to access MailChimp API service point.
 */
open class HttpClientConnector(builder: HttpClientBuilder) : Connector {
    private val client = builder.build()

    /**
     * Creates instances sharing the same [PoolingHttpClientConnectionManager](http://static.javadoc.io/org.apache.httpcomponents/httpclient/4.5.2/org/apache/http/impl/conn/PoolingClientConnectionManager.html).
     */
    constructor() : this(DEFAULT_HTTPCLIENT_BUILDER)

    @Throws(IOException::class)
    override fun call(request: Connector.Request): Connector.Response {
        val httpRequest = when (request.method) {
            "GET" -> HttpGet()
            "POST" -> HttpPost()
            "PATCH" -> HttpPatch()
            "PUT" -> HttpPut()
            "DELETE" -> HttpDelete()
            else -> throw IllegalArgumentException("Http method ${request.method} is not supported")
        }

        httpRequest.uri = URI.create(request.url)
        httpRequest.addHeader("Authorization", "Basic ${String(Base64.encodeBase64(("${request.username}:${request.password}").toByteArray(UTF8)), UTF8)}")

        if (request.requestBody != null) {
            if (httpRequest is HttpEntityEnclosingRequestBase) {
                httpRequest.entity = StringEntity(request.requestBody, UTF8)
            } else {
                throw IllegalArgumentException("Request body is not supported for method " + request.method)
            }
        }

        client.execute(httpRequest).use { response ->
            val statusCode = response.statusLine.statusCode
            val reasonPhrase = response.statusLine.reasonPhrase
            val responseBody = response.entity?.let { EntityUtils.toString(response.entity, UTF8) }
            return Connector.Response(statusCode, reasonPhrase, responseBody)
        }
    }

    @Throws(IOException::class)
    override fun close() {
        client.close()
    }

    private companion object {
        private val UTF8 = Charsets.UTF_8

        private val DEFAULT_HTTPCLIENT_BUILDER = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(15000).setSocketTimeout(15000).setConnectionRequestTimeout(15000).build())
                .setConnectionManager(PoolingHttpClientConnectionManager().apply {
                    defaultMaxPerRoute = 10
                    maxTotal = 10
                })
                .setConnectionManagerShared(true)
    }
}
