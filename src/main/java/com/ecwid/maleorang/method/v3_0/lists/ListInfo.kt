package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by apocheau on 27/08/16.
 */
class ListInfo : MailchimpObject() {

    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var name: String? = null

    @JvmField
    @Field
    var contact: ContactInfo? = null

    @JvmField
    @Field
    var permission_reminder: String? = null

    @JvmField
    @Field
    var use_archive_bar: String? = null

    @JvmField
    @Field
    var campaign_defaults: CampaignDefaultsInfo? = null

    @JvmField
    @Field
    var notify_on_subscribe: String? = null

    @JvmField
    @Field
    var notify_on_unsubscribe: String? = null

    @JvmField
    @Field
    var date_created: Date? = null

    @JvmField
    @Field
    var list_rating: Int? = null

    @JvmField
    @Field
    var email_type_option: Boolean? = null

    @JvmField
    @Field
    var subscribe_url_short: String? = null

    @JvmField
    @Field
    var subscribe_url_long: String? = null

    @JvmField
    @Field
    var beamer_address: String? = null

    @JvmField
    @Field
    var visibility: String? = null

    @JvmField
    @Field
    var stats: StatsInfo? = null
}