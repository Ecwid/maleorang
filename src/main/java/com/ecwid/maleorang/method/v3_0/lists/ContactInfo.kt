package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by apocheau on 26/08/16.
 */
class ContactInfo : MailchimpObject() {

    @JvmField
    @Field
    var company: String? = null

    @JvmField
    @Field
    var address1: String? = null

    @JvmField
    @Field
    var address2: String? = null

    @JvmField
    @Field
    var city: String? = null

    @JvmField
    @Field
    var state: String? = null

    @JvmField
    @Field
    var zip: String? = null

    @JvmField
    @Field
    var country: String? = null

    @JvmField
    @Field
    var phone: String? = null
}
