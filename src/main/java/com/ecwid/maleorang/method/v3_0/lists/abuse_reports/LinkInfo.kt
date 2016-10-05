package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by apocheau on 27/08/16.
 */
class LinkInfo : MailchimpObject() {

    @JvmField
    @Field
    var rel: String? = null

    @JvmField
    @Field
    var href: String? = null

    @JvmField
    @Field
    var method: String? = null

    @JvmField
    @Field
    var targetSchema: String? = null

    @JvmField
    @Field
    var schema: String? = null

    fun setRel(rel: String): LinkInfo{
        this.rel = rel
        return this
    }

    fun setHref(href: String): LinkInfo{
        this.href = href
        return this
    }

    fun setMethod(method: String): LinkInfo{
        this.method = method
        return this
    }

    fun setTargetSchema(targetSchema: String): LinkInfo{
        this.targetSchema = targetSchema
        return this
    }

    fun setSchema(schema: String): LinkInfo{
        this.schema = schema
        return this
    }
}
