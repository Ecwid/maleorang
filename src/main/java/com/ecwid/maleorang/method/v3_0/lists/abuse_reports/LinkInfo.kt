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
}
