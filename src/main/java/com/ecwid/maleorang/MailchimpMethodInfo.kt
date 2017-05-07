package com.ecwid.maleorang

import com.ecwid.maleorang.annotation.*
import com.ecwid.maleorang.util.ClassUtil.getAnnotatedFields
import com.ecwid.maleorang.util.DateUtil.formatDate
import java.net.URLEncoder
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


internal class MailchimpMethodInfo(private val method: MailchimpMethod<*>) {
    private val methodAnnotation: Method = method.javaClass.let {
        var c: Class<*>? = it
        while (c != null) {
            val a = c.getAnnotation(Method::class.java)
            if (a != null) {
                return@let a
            } else {
                c = c.superclass
            }
        }
        throw IllegalArgumentException("Neither ${method.javaClass} nor its superclasses are annotated with ${Method::class.java}")
    }

    val version: APIVersion = methodAnnotation.version
    val httpMethod: HttpMethod = methodAnnotation.httpMethod
    val pathParams: Map<String, String?> = method.getParams(PathParam::class.java, { it.name })
    val queryStringParams: Map<String, String?> = method.getParams(QueryStringParam::class.java, { it.name })

    val requestBody: String? = when (httpMethod) {
        HttpMethod.POST, HttpMethod.PATCH, HttpMethod.PUT -> method.toJson()
        else -> null.apply { require(method.mapping.isEmpty(), { "$httpMethod method is not supposed to have request " +
                "body: $method mapping: "+ method.mapping }) }
    }

    fun buildUrl(apiKey: String): String {
        val prefix = apiKey.lastIndexOf('-').let { dash ->
            if (dash > 0) {
                apiKey.substring(dash + 1)
            } else {
                throw IllegalArgumentException("Wrong api key: $apiKey")
            }
        }

        return "https://${prefix}.api.mailchimp.com/${version}${buildPath()}${buildQueryString()}"
    }

    fun buildPath(): String {
        val result = StringBuffer()

        val matcher = PATH_PLACEHOLDER_PATTERN.matcher(methodAnnotation.path)
        while (matcher.find()) {
            val name = matcher.group(1)
            val value = pathParams[name] ?: throw IllegalArgumentException("Missing path parameter: $name")
            matcher.appendReplacement(result, Matcher.quoteReplacement(value))
        }
        matcher.appendTail(result)

        return result.toString()
    }

    private fun buildQueryString(): String {
        val sb = StringBuilder()
        for ((key, value) in queryStringParams) {
            if (value != null) {
                sb.append(if (sb.length == 0) '?' else '&')
                sb.append(URLEncoder.encode(key, "UTF-8"))
                sb.append('=')
                sb.append(URLEncoder.encode(value, "UTF-8"))
            }
        }
        return sb.toString()
    }

    private companion object {
        private val PATH_PLACEHOLDER_PATTERN = Pattern.compile("\\{(\\w+)\\}")

        private fun <A : Annotation> MailchimpMethod<*>.getParams(annotationClass: Class<A>, nameProvider: (A) -> String): Map<String, String?> {
            return Collections.unmodifiableMap(TreeMap<String, String?>().apply {
                for (field in this@getParams.javaClass.getAnnotatedFields(annotationClass)) {
                    val annotation = field.getAnnotation(annotationClass)!!

                    val name = nameProvider(annotation).let { if (it.isNotEmpty()) it else field.name }
                    require(name.matches("\\w+".toRegex()), { "Invalid param name: $name" })
                    require(!this.containsKey(name), { "Duplicate param name: $name" })

                    field.get(this@getParams).let { value ->
                        this@apply[name] = when (value) {
                            null -> null
                            is MailchimpObject -> value.toJson()
                            is Date -> formatDate(value)
                            else -> value.toString()
                        }
                    }
                }
            })
        }
    }
}
