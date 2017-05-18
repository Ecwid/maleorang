package com.ecwid.maleorang.method.v3_0.automation.info

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import com.ecwid.maleorang.method.v3_0.campaign.*
import java.util.*

/**
 * Created by Ing. Manuel Lara on 07/05/17.
 */
class QueueEmailListInfo : MailchimpObject() {

    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var workflow_id: String? = null

    @JvmField
    @Field
    var position: String? = null

    @JvmField
    @Field
    var delay: MailchimpObject? = null

    @JvmField
    @Field
    var create_time: String? = null

    @JvmField
    @Field
    var start_time: String? = null

    @JvmField
    @Field
    var status: String? = null

    @JvmField
    @Field
    var archive_url: String? = null

    @JvmField
    @Field
    var emails_sent: String? = null

    @JvmField
    @Field
    var send_time: String? = null

    @JvmField
    @Field
    var content_type: String? = null

    @JvmField
    @Field
    var social_card: MailchimpObject? = null

    @JvmField
    @Field
    var recipients: RecipientsWorkflowInfo? = null

    @JvmField
    @Field
    var settings: AutomationCampaignSetting? = null

    @JvmField
    @Field
    var tracking: TrackingWorkflowInfo? = null

    @JvmField
    @Field
    var trigger_settings: MailchimpObject? = null

    @JvmField
    @Field
    var report_summary: ReportSummaryWorkflow? = null

    @JvmField
    @Field
    var _links: MailchimpObject? = null

}
