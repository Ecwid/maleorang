package com.ecwid.maleorang.util

import com.ecwid.maleorang.MailchimpObject
import com.google.common.cache.CacheBuilder
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.util.*


internal object ClassUtil {
    fun Class<*>.getAnnotatedFields(annotationClass: Class<out Annotation>): List<Field> {
        val classes = LinkedList<Class<*>>().apply {
            var c: Class<*>? = this@getAnnotatedFields
            while (c != null) { addFirst(c); c = c.superclass }
        }

        return Collections.unmodifiableList(ArrayList<Field>().apply {
            for (c in classes) {
                for (f in c.declaredFields) {
                    if (f.getAnnotation(annotationClass) != null) {
                        require(!Modifier.isStatic(f.modifiers), { "The annotated field must not be static: $f" })
                        f.isAccessible = true
                        this += f
                    }
                }
            }
        })
    }

    private val fieldsCache = CacheBuilder.newBuilder().softValues().build<Class<out MailchimpObject>, Map<String, Field>>()

    val Class<out MailchimpObject>.mailchimpObjectFields: Map<String, Field>
        get() = fieldsCache.get(this, {
            Collections.unmodifiableMap(LinkedHashMap<String, Field>().apply {
                for (f in getAnnotatedFields(com.ecwid.maleorang.annotation.Field::class.java)) {
                    var name = f.getAnnotation(com.ecwid.maleorang.annotation.Field::class.java).name
                    if (name.isEmpty()) {
                        name = f.name
                    }

                    if (put(name, f) != null) {
                        throw IllegalArgumentException("Ambiguous reflective mapping: " + name)
                    }
                }
            })
        })
}
