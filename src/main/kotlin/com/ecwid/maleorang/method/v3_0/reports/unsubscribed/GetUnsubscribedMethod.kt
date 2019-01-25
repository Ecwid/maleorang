package com.ecwid.maleorang.method.v3_0.reports.unsubscribed

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*

/**
 * [Get information about members who have unsubscribed from a specific campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/reports/unsubscribed/#read-get_reports_campaign_id_unsubscribed)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/reports/{campaign_id}/unsubscribed")
class GetUnsubscribedMethod(@JvmField @PathParam val campaign_id: String) : MailchimpMethod<GetUnsubscribedMethod.Response>() {

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
        var unsubscribes: List<UnsubscribeInfo>? = null

        @JvmField
        @Field
        var campaign_id: String? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }

}