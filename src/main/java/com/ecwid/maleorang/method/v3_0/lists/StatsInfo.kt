package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by apocheau on 26/08/16.
 */
class StatsInfo : MailchimpObject() {

    @JvmField
    @Field
    var member_count: Int? = null

    @JvmField
    @Field
    var unsubscribe_count: Int? = null

    @JvmField
    @Field
    var cleaned_count: Int? = null

    @JvmField
    @Field
    var member_count_since_send: Int? = null

    @JvmField
    @Field
    var unsubscribe_count_since_send: Int? = null

    @JvmField
    @Field
    var cleaned_count_since_send: Int? = null

    @JvmField
    @Field
    var campaign_count: Int? = null

    @JvmField
    @Field
    var campaign_last_send: Int? = null

    @JvmField
    @Field
    var merge_field_count: Int? = null

    @JvmField
    @Field
    var avg_sub_rate: Double? = null

    @JvmField
    @Field
    var avg_unsub_rate: Double? = null

    @JvmField
    @Field
    var target_sub_rate: Double? = null

    @JvmField
    @Field
    var open_rate: Double? = null

    @JvmField
    @Field
    var click_rate: Double? = null

    @JvmField
    @Field
    var last_sub_date: Date? = null

    @JvmField
    @Field
    var last_unsub_date: Date? = null
}
