package com.ecwid.maleorang.method.v3_0.reports.email


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/reports/{campaign_id}/email-activity")
class GetCampaignsEmailActivityMethod(
        @JvmField
        @PathParam
        val campaign_id: String
) : MailchimpMethod<GetCampaignsEmailActivityMethod.Response>() {

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
        var emails: List<CampaignEmailActivityInfo>? = null

	@JvmField
        @Field
        var campaign_id: String? = null
		
        @JvmField
        @Field
        var total_items: Int? = null
    }
}
