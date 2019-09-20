package com.ecwid.maleorang.method.v3_0.reports.unsubscribed

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class UnsubscribeInfo : MailchimpObject() {

    @JvmField
    @Field
    var email_id: String? = null

    @JvmField
    @Field
    var email_address: String? = null

    @JvmField
    @Field
    var merge_fields: MailchimpObject? = null

    @JvmField
    @Field
    var vip: Boolean? = null

    @JvmField
    @Field
    var timestamp: Date? = null

    @JvmField
    @Field
    var reason: String? = null

    @JvmField
    @Field
    var campaign_id: String? = null

    @JvmField
    @Field
    var list_id: String? = null

}