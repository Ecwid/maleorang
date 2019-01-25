package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*

sealed class EditListMethod : MailchimpMethod<ListInfo>() {

    /**
     * [Create a new list in your MailChimp account](https://developer.mailchimp.com/documentation/mailchimp/reference/lists/#create-post_lists)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/lists")
    class Create() : EditListMethod()

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
    var email_type_option: Boolean? = null

    @JvmField
    @Field
    var visibility: String? = null

}