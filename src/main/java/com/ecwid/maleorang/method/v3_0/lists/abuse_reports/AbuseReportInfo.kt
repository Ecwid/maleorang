package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by apocheau on 27/08/16.
 */
class   AbuseReportInfo : MailchimpObject() {

    @JvmField
    @Field
    var id: String? = null

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
    var merge_fields: Object? = null

    @JvmField
    @Field
    var vip: Boolean? = null

    @JvmField
    @Field
    var date: String? = null

    @JvmField
    @Field
    var _links: List<LinkInfo>? = null

    fun setId(id: String): AbuseReportInfo{
        this.id = id
        return this
    }

    fun setCampaign_id(campaign_id: String): AbuseReportInfo{
        this.campaign_id = campaign_id
        return this
    }

    fun setListId(list_id: String): AbuseReportInfo{
        this.list_id = list_id
        return this
    }

    fun setEmailId(email_id: String): AbuseReportInfo{
        this.email_id = email_id
        return this
    }

    fun setEmailAddress(email_address: String): AbuseReportInfo{
        this.email_address = email_address
        return this
    }

    fun setMergeFields(merge_fields: Object): AbuseReportInfo{
        this.merge_fields = merge_fields
        return this
    }

    fun setVip(vip: Boolean): AbuseReportInfo{
        this.vip = vip
        return this
    }

    fun setDate(date: String): AbuseReportInfo{
        this.date = date
        return this
    }

    fun setLinks(_links: List<LinkInfo>): AbuseReportInfo{
        this._links = _links
        return this
    }
}
