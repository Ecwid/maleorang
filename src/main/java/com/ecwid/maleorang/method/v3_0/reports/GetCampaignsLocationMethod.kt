package com.ecwid.maleorang.method.v3_0.reports


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/reports/{campaign_id}/locations")
class GetCampaignLocationMethod(
        @JvmField
        @PathParam
        val campaign_id: String
) : MailchimpMethod<GetCampaignLocationMethod.Response>() {

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
        var locations: List<CampaignLocationInfo>? = null

        @JvmField
        @Field
        var campaign_id: String? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }
}
