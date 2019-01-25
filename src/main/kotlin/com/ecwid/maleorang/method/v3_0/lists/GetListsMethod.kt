package com.ecwid.maleorang.method.v3_0.lists


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import java.util.*

/**
 * [Get information about members in a list](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#read-get_lists_list_id_members)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/lists")
class GetListsMethod : MailchimpMethod<GetListsMethod.Response>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null

    @JvmField
    @QueryStringParam
    var count: Int? = null

    @JvmField
    @QueryStringParam
    var offset: Int? = null

    @JvmField
    @QueryStringParam
    var email: String? = null

    @JvmField
    @QueryStringParam
    var since_date_created: Date? = null

    @JvmField
    @QueryStringParam
    var before_date_created: Date? = null

    @JvmField
    @QueryStringParam
    var since_campaign_last_send: Date? = null

    @JvmField
    @QueryStringParam
    var before_campaign_last_send: Date? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var lists: List<ListInfo>? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }
}
