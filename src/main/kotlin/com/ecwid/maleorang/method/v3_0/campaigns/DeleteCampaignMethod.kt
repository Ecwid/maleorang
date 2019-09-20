package com.ecwid.maleorang.method.v3_0.campaigns

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.APIVersion
import com.ecwid.maleorang.annotation.HttpMethod
import com.ecwid.maleorang.annotation.Method
import com.ecwid.maleorang.annotation.PathParam

/**
 * [Remove a campaign from your MailChimp account](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#delete-delete_campaigns_campaign_id)
 */
@Method(httpMethod = HttpMethod.DELETE, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}")
class DeleteCampaignMethod(
        @JvmField
        @PathParam
        val campaign_id: String
) : MailchimpMethod<MailchimpObject>()
