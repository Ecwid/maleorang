package com.ecwid.maleorang.method.v3_0.reports


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/reports")
class GetCampaignsReportsMethod : MailchimpMethod<GetCampaignsReportsMethod.Response>() {

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

    @JvmField
    @QueryStringParam
    var type: String? = null

    @JvmField
    @QueryStringParam
    var before_send_time: Date? = null

    @JvmField
    @QueryStringParam
    var since_send_time: Date? = null


    class Response : MailchimpObject() {
        @JvmField
        @Field
        var reports: List<CampaignReportInfo>? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }
}
