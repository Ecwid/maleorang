package com.ecwid.maleorang

import com.google.common.reflect.TypeToken

import java.lang.annotation.*
import java.lang.reflect.Type


/**
 * Abstract class representing MailChimp API calls.
 */
abstract class MailchimpMethod<R : MailchimpObject>() : MailchimpObject() {
    /**
     * Get the method result type.
     */
    val resultType: Class<R> = object : TypeToken<R>(javaClass) { }.type.let { type ->
        @Suppress("UNCHECKED_CAST")
        if (type is Class<*>) {
            type as Class<R>
        } else {
            throw IllegalArgumentException("The result type must be a raw class without parameters: $type")
        }
    }
}
