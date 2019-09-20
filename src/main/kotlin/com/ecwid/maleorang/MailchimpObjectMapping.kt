package com.ecwid.maleorang

import com.ecwid.maleorang.util.ClassUtil.mailchimpObjectFields
import com.google.common.base.Objects
import java.lang.reflect.Field
import java.util.*


internal class MailchimpObjectMapping(val owner: MailchimpObject) : AbstractMap<String, Any?>() {
    private val reflections: Map<String, Field> = owner.javaClass.mailchimpObjectFields
    private val regular: MutableMap<String, Any?> = LinkedHashMap()

    override val size: Int
        get() = reflections.size + regular.size

    override fun containsKey(key: String) = reflections.containsKey(key) || regular.containsKey(key)

    override val entries = object : AbstractSet<MutableMap.MutableEntry<String, Any?>>() {
        override val size: Int
            get() = this@MailchimpObjectMapping.size

        override fun iterator() = object : MutableIterator<MutableMap.MutableEntry<String, Any?>> {
            inner class ReflectiveEntry(override val key: String, val f: Field) : MutableMap.MutableEntry<String, Any?> {
                override val value: Any?
                    get() = f.getFieldValue()
                override fun setValue(newValue: Any?) = f.setFieldValue(newValue)

                override fun equals(other: Any?) = when (other) {
                    is MutableMap.MutableEntry<*, *> -> key == other.key && value == other.value
                    else -> false
                }

                override fun hashCode() = Objects.hashCode(key, value)
                override fun toString() = "$key=$value"
            }

            private val i1 = reflections.entries.asSequence().map { ReflectiveEntry(it.key, it.value) }.iterator()
            private val i2 = regular.entries.iterator()
            private var lastEntry: MutableMap.MutableEntry<String, Any?>? = null

            override fun hasNext() = i1.hasNext() || i2.hasNext()

            override fun next() = when {
                i1.hasNext() -> i1.next()
                i2.hasNext() -> i2.next()
                else -> throw NoSuchElementException()
            }.apply { lastEntry = this }

            override fun remove() = lastEntry.let {
                when (it) {
                    null -> throw IllegalStateException()
                    is ReflectiveEntry -> removeError(it.key)
                    else -> i2.remove()
                }
            }
        }
    }

    override fun get(key: String): Any? = reflections.get(key).let { field ->
        if (field != null) { field.getFieldValue() } else { regular.get(key) }
    }

    override fun put(key: String, value: Any?): Any? = reflections.get(key).let { field ->
        if (field != null) { field.setFieldValue(value) } else { regular.put(key, value) }
    }

    override fun putAll(from: Map<out String, Any?>) = from.forEach { put(it.key, it.value) }

    override fun remove(key: String): Any? = when {
        reflections.containsKey(key) -> removeError(key)
        else -> regular.remove(key)
    }

    private fun Field.getFieldValue(): Any? = get(owner)
    private fun Field.setFieldValue(value: Any?): Any? = get(owner).apply { set(owner, value) }
    private fun removeError(key: String): Nothing = throw IllegalArgumentException("Cannot remove reflective mapping: $key")
}