package com.ecwid.maleorang.method.v3_0.reports.email_activity

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import com.google.gson.annotations.SerializedName
import java.util.*

class EmailActivityInfo : MailchimpObject() {

    @JvmField
    @Field
    var campaign_id: String? = null

    @JvmField
    @Field
    var list_id: String? = null

    @JvmField
    @Field
    var email_id: String? = null

    @JvmField
    @Field
    var email_address: String? = null

    @JvmField
    @Field
    var activity: Array<ActivityInfo>? = null

    class ActivityInfo : MailchimpObject() {

        @JvmField
        @Field
        var action: Action? = null

        enum class Action {
            @SerializedName("open")
            OPEN,
            @SerializedName("click")
            CLICK,
            @SerializedName("bounce")
            BOUNCE
        }

        @JvmField
        @Field
        var type: Type? = null

        enum class Type {
            @SerializedName("hard")
            HARD,
            @SerializedName("soft")
            SOFT
        }

        @JvmField
        @Field
        var timestamp: Date? = null

        @JvmField
        @Field
        var url: String? = null

        @JvmField
        @Field
        var ip: String? = null

    }

}