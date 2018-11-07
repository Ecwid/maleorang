package com.ecwid.maleorang.method.v3_0.reports.email

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignEmailActivityInfo : MailchimpObject() {
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
    var activity: List<EmailReportActivityDetails>? = null
}
