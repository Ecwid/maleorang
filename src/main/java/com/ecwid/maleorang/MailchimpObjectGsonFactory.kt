package com.ecwid.maleorang

import com.ecwid.maleorang.util.DateUtil.formatDate
import com.ecwid.maleorang.util.DateUtil.parseDate
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

/**
 * Factory creating [Gson] objects to be used for MailChimp API calls wrapping.
 */
internal object MailchimpObjectGsonFactory {

    /**
     * Creates a new [Gson] object.
     */
    fun createGson() = GsonBuilder()
            .setExclusionStrategies(object : ExclusionStrategy {
                override fun shouldSkipField(fa: FieldAttributes) = true
                override fun shouldSkipClass(type: Class<*>) = false
            })
            .registerTypeAdapter(Date::class.java, object : JsonSerializer<Date>, JsonDeserializer<Date> {
                override fun serialize(date: Date, type: Type, jsc: JsonSerializationContext): JsonElement {
                    return JsonPrimitive(formatDate(date))
                }

                override fun deserialize(je: JsonElement, type: Type, jdc: JsonDeserializationContext): Date? {
                    return if (!je.asString.isEmpty()) parseDate(je.asString) else null
                }
            })
            .registerTypeAdapterFactory(object : TypeAdapterFactory {
                override fun <T : Any> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
                    if (MailchimpObject::class.java.isAssignableFrom(type.rawType)) {
                        @Suppress("UNCHECKED_CAST", "CAST_NEVER_SUCCEEDS")
                        return MailchimpObjectTypeAdapter(gson, type as TypeToken<MailchimpObject>) as TypeAdapter<T>
                    } else {
                        return null
                    }
                }
            })
            .create()
}
