package com.ecwid.maleorang.method.v3_0.reports.sent_to

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * @author Raisin_Alejandro_Palacios
 *
 * A DTO class to capture the response information from https://developer.mailchimp.com/documentation/mailchimp/reference/reports/sent-to/#read-get_reports_campaign_id_sent_to
 *
 */
class SentToInfo : MailchimpObject() {

    @JvmField
    @Field
    var email_address: String? = null

    @JvmField
    @Field
    var status: String? = null

    @JvmField
    @Field
    var absplit_group: String? = null

}