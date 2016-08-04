package com.ecwid.maleorang.annotation


/**
 * Marks fields of [com.ecwid.maleorang.MailchimpMethod] to be used in query string mapping.
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class QueryStringParam(
        /**
         * Property name in query string mapping. If not specified, the field name will be used.
         */
        val name: String = ""
)
