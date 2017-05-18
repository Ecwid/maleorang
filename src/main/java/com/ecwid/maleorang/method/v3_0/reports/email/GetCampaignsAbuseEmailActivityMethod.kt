package com.ecwid.maleorang.method.v3_0.reports.email


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/reports/{campaign_id}/abuse-reports")
class GetCampaignsAbuseEmailActivityMethod(
        @JvmField
        @PathParam
        val campaign_id: String
) : MailchimpMethod<GetCampaignsAbuseEmailActivityMethod.Response>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var abuse_report: List<CampaignEmailAbuseInfo>? = null

	    @JvmField
        @Field
        var campaign_id: String? = null
		
        @JvmField
        @Field
        var total_items: Int? = null
    }
}
