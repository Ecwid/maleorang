package com.ecwid.maleorang.method.v3_0.campaign

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignSettingsInfo : MailchimpObject() {
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
    var use_conversation: String? = null

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
    var fb_comments: Boolean? = null

    @JvmField
    @Field
    var timewrap: Boolean? = null

    @JvmField
    @Field
    var drag_and_drop: Boolean? = null
}
