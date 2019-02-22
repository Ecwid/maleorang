package com.ecwid.maleorang.method.v3_0.reports.sent_to

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Method;
import com.ecwid.maleorang.annotation.HttpMethod;
import com.ecwid.maleorang.annotation.APIVersion;
import com.ecwid.maleorang.annotation.PathParam;
import com.ecwid.maleorang.annotation.QueryStringParam;
import com.ecwid.maleorang.annotation.Field

/**
 *
 * @author Raisin-Alejandro-Palacios
 *
 * An implementation of https://developer.mailchimp.com/documentation/mailchimp/reference/reports/sent-to/#read-get_reports_campaign_id_sent_to
 *
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/reports/{campaign_id}/sent-to")
class GetSentToMethod(@JvmField @PathParam val campaign_id: String) : MailchimpMethod<GetSentToMethod.Response>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var count: Int? = null

    @JvmField
    @QueryStringParam
    var offset: Int? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var sent_to: List<SentToInfo>? = null

        @JvmField
        @Field
        var campaign_id: String? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }

}