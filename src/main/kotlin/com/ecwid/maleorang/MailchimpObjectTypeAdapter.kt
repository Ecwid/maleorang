package com.ecwid.maleorang

import com.ecwid.maleorang.util.ClassUtil.mailchimpObjectFields
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.lang.reflect.Constructor

internal class MailchimpObjectTypeAdapter(private val gson: Gson, private val type: TypeToken<out MailchimpObject>) : TypeAdapter<MailchimpObject>() {

    override fun write(out: JsonWriter, value: MailchimpObject) {
        gson.getAdapter(Map::class.java).write(out, value.mapping)
    }

    override fun read(reader: JsonReader): MailchimpObject? {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        }

        @Suppress("UNCHECKED_CAST")
        val constructor = try {
            type.getRawType().getDeclaredConstructor().apply {
                isAccessible = true
            } as Constructor<out MailchimpObject>
        } catch (e: NoSuchMethodException) {
            throw IllegalArgumentException("No no-arg counstructor found in ${type.rawType}")
        }

        val result = try {
            constructor.newInstance()
        } catch (e: Exception) {
            throw RuntimeException("Failed to invoke $constructor with no args", e)
        }

        reader.beginObject()
        while (reader.hasNext()) {
            val key = when(reader.peek()) {
                JsonToken.NAME -> reader.nextName()
                else -> reader.nextString()
            }

            val value = result.javaClass.mailchimpObjectFields[key].let { field ->
                if (field != null) {
                    gson.getAdapter(TypeToken.get(field.genericType)).read(reader)
                } else when (reader.peek()) {
                    JsonToken.BEGIN_OBJECT -> gson.getAdapter(MailchimpObject::class.java).read(reader)
                    JsonToken.BEGIN_ARRAY -> readList(reader)
                    else -> gson.getAdapter(Any::class.java).read(reader)
                }
            }

            result.mapping[key] = value
        }
        reader.endObject()

        return result
    }

    private fun readList(reader: JsonReader): List<*> {
        val result = mutableListOf<Any>()

        reader.beginArray()
        while (reader.peek() != JsonToken.END_ARRAY) {
            result += when (reader.peek()) {
                JsonToken.BEGIN_OBJECT -> gson.getAdapter(MailchimpObject::class.java).read(reader)
                JsonToken.BEGIN_ARRAY -> readList(reader)
                else -> gson.getAdapter(Any::class.java).read(reader)
            }
        }
        reader.endArray()

        return result
    }
}