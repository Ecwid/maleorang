package com.ecwid.maleorang.method.v3_0.automation.info

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class AutomationCampaignSetting : MailchimpObject() {

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
    var authenticate: Boolean? = null

    @JvmField
    @Field
    var auto_footer: Boolean? = null

    @JvmField
    @Field
    var inline_css: Boolean? = null

}
