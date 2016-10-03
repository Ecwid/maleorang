package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by apocheau on 27/08/16.
 */
class   AbuseReportInfo : MailchimpObject() {

    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var campaign_id: String? = null

    @JvmField
    @Field
    var list_id: String? = null

    @JvmField
    @Field
    var email_id: String? = null

    @JvmField
    @Field
    var email_address: String? = null

    @JvmField
    @Field
    var merge_fields: Object? = null

    @JvmField
    @Field
    var vip: Boolean? = null

    @JvmField
    @Field
    var date: String? = null

    @JvmField
    @Field
    var _links: List<LinkInfo>? = null
}
