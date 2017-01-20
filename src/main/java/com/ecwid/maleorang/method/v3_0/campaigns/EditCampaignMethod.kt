package com.ecwid.maleorang.method.v3_0.campaigns

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*
import com.ecwid.maleorang.method.v3_0.campaigns.CampaignInfo.*

/**
 * Base class for campaign create or update operations.
 */
sealed class EditCampaignMethod : MailchimpMethod<CampaignInfo>() {

    /**
     * [Create a new MailChimp campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#create-post_campaigns)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns")
    class Create() : EditCampaignMethod()

    /**
     * [Update some or all of the settings for a specific campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#edit-patch_campaigns_campaign_id)
     */
    @Method(httpMethod = HttpMethod.PATCH, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}")
    class Update(
            @JvmField
            @PathParam
            val campaign_id: String
    ) : EditCampaignMethod()

    @JvmField
    @Field
    var type: CampaignInfo.Type? = null

    @JvmField
    @Field
    var recipients: RecipientsInfo? = null

    @JvmField
    @Field
    var settings: SettingsInfo? = null

    @JvmField
    @Field
    var variate_settings: VariateSettingsInfo? = null

    @JvmField
    @Field
    var tracking: TrackingInfo? = null

    @JvmField
    @Field
    var rss_opts: RSSOptsInfo? = null

    @JvmField
    @Field
    var social_card: SocialCardInfo? = null

}
