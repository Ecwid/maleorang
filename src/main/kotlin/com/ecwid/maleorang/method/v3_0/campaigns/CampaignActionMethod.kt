package com.ecwid.maleorang.method.v3_0.campaigns

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import java.util.*

/**
 * Base class for campaign action operations.
 */
sealed class CampaignActionMethod<R : MailchimpObject> : MailchimpMethod<R>() {

    /**
     * [Cancel a Regular or Plain-Text Campaign after you send](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#action-post_campaigns_campaign_id_actions_cancel_send)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/actions/cancel-send")
    class CancelSend(@JvmField @PathParam val campaign_id: String) : CampaignActionMethod<MailchimpObject>()

    /**
     * [Pause an RSS-Driven campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#action-post_campaigns_campaign_id_actions_pause)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/actions/pause")
    class Pause(@JvmField @PathParam val campaign_id: String) : CampaignActionMethod<MailchimpObject>()

    /**
     * [Replicate a campaign in saved or send status](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#action-post_campaigns_campaign_id_actions_replicate)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/actions/replicate")
    class Replicate(@JvmField @PathParam val campaign_id: String) : CampaignActionMethod<CampaignInfo>()

    /**
     * [Resume an RSS-Driven campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#action-post_campaigns_campaign_id_actions_resume)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/actions/resume")
    class Resume(@JvmField @PathParam val campaign_id: String) : CampaignActionMethod<MailchimpObject>()

    /**
     * [Schedule a campaign for delivery](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#action-post_campaigns_campaign_id_actions_schedule)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/actions/schedule")
    class Schedule(@JvmField @PathParam val campaign_id: String) : CampaignActionMethod<MailchimpObject>() {

        /**
         * The date and time in UTC to schedule the campaign for delivery. Campaigns may only be scheduled to send on the quarter-hour (:00, :15, :30, :45).
         */
        @JvmField
        @Field
        var schedule_time: Date? = null

        @JvmField
        @Field
        var timewarp: Boolean? = null

    }

    /**
     * [Send a MailChimp campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#action-post_campaigns_campaign_id_actions_send)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/actions/send")
    class Send(@JvmField @PathParam val campaign_id: String) : CampaignActionMethod<MailchimpObject>()

    /**
     * [Send a Test email](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#action-post_campaigns_campaign_id_actions_test)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/actions/test")
    class Test(@JvmField @PathParam val campaign_id: String) : CampaignActionMethod<MailchimpObject>()

    /**
     * [Unschedule a scheduled campaign that hasn’t started sending](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/#action-post_campaigns_campaign_id_actions_unschedule)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/actions/unschedule")
    class Unschedule(@JvmField @PathParam val campaign_id: String) : CampaignActionMethod<MailchimpObject>()

}