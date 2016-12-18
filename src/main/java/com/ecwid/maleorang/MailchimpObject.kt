package com.ecwid.maleorang

import com.ecwid.maleorang.annotation.Field
import com.google.gson.JsonParseException


/**
 * Base class for all objects wrapping the request and response bodies of MailChimp API calls.
 */
open class MailchimpObject {

    /**
     * Map representation of this object.
     *
     * Some entries in the map are "regular" mappings, whereas others are "reflective" ones.
     * Reflective mappings are represented by fields marked with [com.ecwid.maleorang.annotation.Field].
     * Changes in such fields are reflected in the map and vice versa.
     * Reflective mappings cannot be removed from this map.
     */
    @JvmField
    val mapping: MutableMap<String, Any?> = MailchimpObjectMapping(this)

    @JvmField
    @Field
    var _links: String? = null

    /**
     * Serializes this object to JSON.
     */
    fun toJson(): String = MailchimpObjectGsonFactory.createGson().toJson(this)

    final override fun toString(): String = javaClass.simpleName + toJson()
    final override fun equals(other: Any?): Boolean = other is MailchimpObject && mapping == other.mapping
    final override fun hashCode(): Int = mapping.hashCode()

    companion object {
        /**
         * Deserializes an object from JSON.
         *
         * @throws IllegalArgumentException if `json` cannot be deserialized to an object of class `clazz`.
         */
        @JvmStatic
        fun <T : MailchimpObject> fromJson(json: String, clazz: Class<T>): T {
            try {
                return MailchimpObjectGsonFactory.createGson().fromJson(json, clazz)
            } catch (e: JsonParseException) {
                throw IllegalArgumentException(e)
            }
        }
    }
}