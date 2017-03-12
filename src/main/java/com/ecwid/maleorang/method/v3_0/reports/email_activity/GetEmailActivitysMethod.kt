package com.ecwid.maleorang.method.v3_0.reports.email_activity

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*

/**
 * [Get a list of member’s subscriber activity in a specific campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/reports/email-activity/#read-get_reports_campaign_id_email_activity)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/reports/{campaign_id}/email-activity")
class GetEmailActivitysMethod(@JvmField @PathParam val campaign_id: String) : MailchimpMethod<GetEmailActivitysMethod.Response>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null

    @JvmField
    @QueryStringParam
    var count: Int? = null

    @JvmField
    @QueryStringParam
    var offset: Int? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var emails: List<EmailActivityInfo>? = null

        @JvmField
        @Field
        var campaign_id: String? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }

}
