package com.ecwid.maleorang.method.v3_0.reports.email

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignEmailAbuseInfo : MailchimpObject() {
    @JvmField
    @Field
    var id: Int? = null

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
    var merge_fields: MailchimpObject? = null

    @JvmField
    @Field
    var vip: Boolean? = null

    @JvmField
    @Field
    var date: Date? = null

}
