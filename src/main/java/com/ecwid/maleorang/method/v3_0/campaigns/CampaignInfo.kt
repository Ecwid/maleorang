package com.ecwid.maleorang.method.v3_0.campaigns

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import com.google.gson.annotations.SerializedName
import java.util.*

class CampaignInfo : MailchimpObject() {

    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var type: Type? = null

    enum class Type {
        @SerializedName("regular")
        REGULAR,
        @SerializedName("plaintext")
        PLAINTEXT,
        @SerializedName("absplit")
        ABSPLIT,
        @SerializedName("rss")
        RSS,
        @SerializedName("variate")
        VARIATE
    }

    @JvmField
    @Field
    var create_time: Date? = null

    @JvmField
    @Field
    var archive_url: String? = null

    @JvmField
    @Field
    var long_archive_url: String? = null

    @JvmField
    @Field
    var status: Status? = null

    enum class Status {
        @SerializedName("save")
        SAVE,
        @SerializedName("paused")
        PAUSED,
        @SerializedName("schedule")
        SCHEDULE,
        @SerializedName("sending")
        SENDING,
        @SerializedName("sent")
        SENT
    }

    @JvmField
    @Field
    var emails_sent: Int? = null

    @JvmField
    @Field
    var send_time: Date? = null

    @JvmField
    @Field
    var content_type: String? = null

    @JvmField
    @Field
    var recipients: RecipientsInfo? = null

    class RecipientsInfo : MailchimpObject() {

        @JvmField
        @Field
        var list_id: String? = null

        @JvmField
        @Field
        var list_name: String? = null

        @JvmField
        @Field
        var segment_text: String? = null

        @JvmField
        @Field
        var recipient_count: Int? = null

        @JvmField
        @Field
        var segment_opts: SegmentOptsInfo? = null

        class SegmentOptsInfo : MailchimpObject() {

            @JvmField
            @Field
            var saved_segment_id: Int? = null

            @JvmField
            @Field
            var match: String? = null

            @JvmField
            @Field
            var conditions: Array<ConditionInfo>? = null

            open class ConditionInfo : MailchimpObject() {

                @JvmField
                @Field
                var condition_type: String? = null

            }

            class TextMergeConditionInfo : ConditionInfo() {

                @JvmField
                @Field
                var field: String? = null

                @JvmField
                @Field
                var op: String? = null

                @JvmField
                @Field
                var value: String? = null

                init {
                    condition_type = "TextMerge"
                }

            }

        }
    }

    @JvmField
    @Field
    var settings: SettingsInfo? = null

    class SettingsInfo : MailchimpObject() {

        @JvmField
        @Field
        var subject_line: String? = null

        @JvmField
        @Field
        var title: String? = null

        @JvmField
        @Field
        var from_name: String? = null

        @JvmField
        @Field
        var reply_to: String? = null

        @JvmField
        @Field
        var use_conversation: Boolean? = null

        @JvmField
        @Field
        var to_name: String? = null

        @JvmField
        @Field
        var folder_id: String? = null

        @JvmField
        @Field
        var authenticate: Boolean? = null

        @JvmField
        @Field
        var auto_footer: Boolean? = null

        @JvmField
        @Field
        var inline_css: Boolean? = null

        @JvmField
        @Field
        var auto_tweet: Boolean? = null

        @JvmField
        @Field
        var auto_fb_post: Array<String>? = null

        @JvmField
        @Field
        var fb_comments: Boolean? = null

        @JvmField
        @Field
        var timewarp: Boolean? = null

        @JvmField
        @Field
        var template_id: Int? = null

        @JvmField
        @Field
        var drag_and_drop: Boolean? = null

    }

    @JvmField
    @Field
    var variate_settings: VariateSettingsInfo? = null

    class VariateSettingsInfo : MailchimpObject() {

        @JvmField
        @Field
        var winning_combination_id: String? = null

        @JvmField
        @Field
        var winning_campaign_id: String? = null

        @JvmField
        @Field
        var winner_criteria: WinnerCriteria? = null

        enum class WinnerCriteria {
            @SerializedName("opens")
            OPENS,
            @SerializedName("clicks")
            CLICKS,
            @SerializedName("manual")
            MANUAL,
            @SerializedName("total_revenue")
            TOTAL_REVENUE
        }

        @JvmField
        @Field
        var wait_time: Int? = null

        @JvmField
        @Field
        var test_size: Int? = null

        @JvmField
        @Field
        var subject_lines: Array<String>? = null

        @JvmField
        @Field
        var send_times: Array<Date>? = null

        @JvmField
        @Field
        var from_names: Array<String>? = null

        @JvmField
        @Field
        var reply_to_addresses: Array<String>? = null

        @JvmField
        @Field
        var contents: Array<String>? = null

        @JvmField
        @Field
        var combinations: Array<CombinationInfo>? = null

        class CombinationInfo : MailchimpObject() {

            @JvmField
            @Field
            var id: String? = null

            @JvmField
            @Field
            var subject_line: String? = null

            @JvmField
            @Field
            var send_time: Int? = null

            @JvmField
            @Field
            var from_name: Int? = null

            @JvmField
            @Field
            var reply_to: Int? = null

            @JvmField
            @Field
            var content_description: Int? = null

            @JvmField
            @Field
            var recipients: Int? = null
        }
    }

    @JvmField
    @Field
    var tracking: TrackingInfo? = null

    class TrackingInfo : MailchimpObject() {

        @JvmField
        @Field
        var opens: Boolean? = null

        @JvmField
        @Field
        var html_clicks: Boolean? = null

        @JvmField
        @Field
        var text_clicks: Boolean? = null

        @JvmField
        @Field
        var goal_tracking: Boolean? = null

        @JvmField
        @Field
        var ecomm360: Boolean? = null

        @JvmField
        @Field
        var google_analytics: String? = null

        @JvmField
        @Field
        var clicktale: String? = null

        @JvmField
        @Field
        var salesforce: SalesforceInfo? = null

        class SalesforceInfo : MailchimpObject() {

            @JvmField
            @Field
            var campaign: Boolean? = null

            @JvmField
            @Field
            var notes: Boolean? = null
        }

        @JvmField
        @Field
        var highrise: HighriseInfo? = null

        class HighriseInfo : MailchimpObject() {

            @JvmField
            @Field
            var campaign: Boolean? = null

            @JvmField
            @Field
            var notes: Boolean? = null
        }

        @JvmField
        @Field
        var capsule: CapsuleInfo? = null

        class CapsuleInfo : MailchimpObject() {

            @JvmField
            @Field
            var notes: Boolean? = null
        }
    }

    @JvmField
    @Field
    var rss_opts: RSSOptsInfo? = null

    class RSSOptsInfo : MailchimpObject() {

        @JvmField
        @Field
        var feed_url: String? = null

        @JvmField
        @Field
        var frequency: Frequency? = null

        enum class Frequency {
            @SerializedName("daily")
            DAILY,
            @SerializedName("weekly")
            WEEKLY,
            @SerializedName("monthly")
            MONTHLY
        }

        @JvmField
        @Field
        var schedule: ScheduleInfo? = null

        class ScheduleInfo : MailchimpObject() {

            @JvmField
            @Field
            var hour: Int? = null

            @JvmField
            @Field
            var daily_send: DailySendInfo? = null

            class DailySendInfo : MailchimpObject() {

                @JvmField
                @Field
                var sunday: Boolean? = null

                @JvmField
                @Field
                var monday: Boolean? = null

                @JvmField
                @Field
                var tuesday: Boolean? = null

                @JvmField
                @Field
                var wednesday: Boolean? = null

                @JvmField
                @Field
                var thursday: Boolean? = null

                @JvmField
                @Field
                var friday: Boolean? = null

                @JvmField
                @Field
                var saturday: Boolean? = null

            }

            @JvmField
            @Field
            var weekly_send_day: DayOfWeek? = null

            @JvmField
            @Field
            var monthly_send_date: Int? = null

        }

        @JvmField
        @Field
        var last_sent: String? = null

        @JvmField
        @Field
        var constrain_rss_img: Boolean? = null
    }

    @JvmField
    @Field
    var ab_split_opts: ABSplitOptsInfo? = null

    class ABSplitOptsInfo : MailchimpObject() {

        @JvmField
        @Field
        var split_test: Type? = null

        enum class Type {
            @SerializedName("subject")
            SUBJECT,
            @SerializedName("from_name")
            FROM_NAME,
            @SerializedName("schedule")
            SCHEDULE
        }

        @JvmField
        @Field
        var pick_winner: PickWinner? = null

        enum class PickWinner {
            @SerializedName("opens")
            SUBJECT,
            @SerializedName("clicks")
            FROM_NAME,
            @SerializedName("manual")
            SCHEDULE
        }

        @JvmField
        @Field
        var wait_units: WaitUnits? = null

        enum class WaitUnits {
            @SerializedName("hours")
            HOURS,
            @SerializedName("days")
            DAYS
        }

        @JvmField
        @Field
        var wait_time: Int? = null

        @JvmField
        @Field
        var split_size: Int? = null

        @JvmField
        @Field
        var from_name_a: String? = null

        @JvmField
        @Field
        var from_name_b: String? = null

        @JvmField
        @Field
        var reply_email_a: String? = null

        @JvmField
        @Field
        var reply_email_b: String? = null

        @JvmField
        @Field
        var subject_a: String? = null

        @JvmField
        @Field
        var subject_b: String? = null

        @JvmField
        @Field
        var send_time_a: Date? = null

        @JvmField
        @Field
        var send_time_b: Date? = null

        @JvmField
        @Field
        var send_time_winner: Date? = null

    }

    @JvmField
    @Field
    var social_card: SocialCardInfo? = null

    class SocialCardInfo : MailchimpObject() {

        @JvmField
        @Field
        var image_url: String? = null

        @JvmField
        @Field
        var description: String? = null

        @JvmField
        @Field
        var title: String? = null

    }

    @JvmField
    @Field
    var report_summary: ReportSummaryInfo? = null

    class ReportSummaryInfo : MailchimpObject() {

        @JvmField
        @Field
        var opens: Int? = null

        @JvmField
        @Field
        var unique_opens: Int? = null

        @JvmField
        @Field
        var open_rate: Double? = null

        @JvmField
        @Field
        var clicks: Int? = null

        @JvmField
        @Field
        var subscriber_clicks: Int? = null

        @JvmField
        @Field
        var click_rate: Double? = null

        @JvmField
        @Field
        var ecommerce: EcommerceInfo? = null

        class EcommerceInfo : MailchimpObject() {

            @JvmField
            @Field
            var total_orders: Int? = null

            @JvmField
            @Field
            var total_spent: Double? = null

            @JvmField
            @Field
            var total_revenue: Double? = null
        }
    }

    @JvmField
    @Field
    var delivery_status: DeliveryStatusInfo? = null

    class DeliveryStatusInfo : MailchimpObject() {

        @JvmField
        @Field
        var enabled: Boolean? = null

        @JvmField
        @Field
        var can_cancel: Boolean? = null

        @JvmField
        @Field
        var status: String? = null

        @JvmField
        @Field
        var emails_sent: Int? = null

        @JvmField
        @Field
        var emails_canceled: Int? = null

    }
}