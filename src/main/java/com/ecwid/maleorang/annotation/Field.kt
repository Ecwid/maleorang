package com.ecwid.maleorang.annotation


/**
 * Marks fields of [com.ecwid.maleorang.MailchimpObject] to be serialized/deserialed to/from JSON.
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class Field(
        /**
         * Property name in JSON mapping. If not specified, the field name will be used.
         */
        val name: String = ""
)