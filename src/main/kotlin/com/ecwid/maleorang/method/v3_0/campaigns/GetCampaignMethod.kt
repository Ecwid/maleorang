package com.ecwid.maleorang.method.v3_0.campaigns

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*

/**
 * [Get information about a specific campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#read-get_campaigns_campaign_id)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}")
class GetCampaignMethod(@JvmField @PathParam val campaign_id: String) : MailchimpMethod<CampaignInfo>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null

}
