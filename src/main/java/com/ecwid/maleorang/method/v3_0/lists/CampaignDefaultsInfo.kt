package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by apocheau on 26/08/16.
 */
class CampaignDefaultsInfo : MailchimpObject() {

    @JvmField
    @Field
    var from_name: String? = null
    @JvmField
    @Field
    var from_email: String? = null
    @JvmField
    @Field
    var subject: String? = null
    @JvmField
    @Field
    var language: String? = null
}
