package com.ecwid.maleorang.annotation


/**
 * Marks subclasses of [com.ecwid.maleorang.MailchimpMethod] to describe the corresponding MailChimp API method.
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Method(val version: APIVersion, val httpMethod: HttpMethod, val path: String)