package com.ecwid.maleorang.annotation


/**
 * Marks fields of [com.ecwid.maleorang.MailchimpMethod] to be used in path mapping.
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class PathParam(
        /**
         * Property name in path mapping. If not specified, the field name will be used.
         */
        val name: String = ""
)
