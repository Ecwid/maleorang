package com.ecwid.maleorang.method.v3_0.campaigns

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import com.ecwid.maleorang.method.v3_0.campaigns.CampaignInfo.Status
import com.ecwid.maleorang.method.v3_0.campaigns.CampaignInfo.Type
import java.util.*

/**
 * [Get all campaigns in an account.](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#read-get_campaigns)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/campaigns")
class GetCampaignsMethod : MailchimpMethod<GetCampaignsMethod.Response>() {

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
    var type: Type? = null

    @JvmField
    @QueryStringParam
    var status: Status? = null

    @JvmField
    @QueryStringParam
    var before_send_time: Date? = null

    @JvmField
    @QueryStringParam
    var since_send_time: Date? = null

    @JvmField
    @QueryStringParam
    var before_create_time: Date? = null

    @JvmField
    @QueryStringParam
    var since_create_time: Date? = null

    @JvmField
    @QueryStringParam
    var list_id: String? = null

    @JvmField
    @QueryStringParam
    var folder_id: String? = null

    @JvmField
    @QueryStringParam
    var sort_field: String? = null

    @JvmField
    @QueryStringParam
    var sort_dir: SortDir? = null

    enum class SortDir {
        ASC,
        DESC
    }

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var campaigns: List<CampaignInfo>? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }
}