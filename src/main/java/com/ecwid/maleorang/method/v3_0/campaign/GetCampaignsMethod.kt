package com.ecwid.maleorang.method.v3_0.lists.members


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import java.util.*

/**
 * [Get information about members in a list](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#read-get_lists_list_id_members)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/lists/{list_id}/members")
class GetMembersMethod(
        @JvmField
        @PathParam
        val list_id: String
) : MailchimpMethod<GetMembersMethod.Response>() {

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
    var email_type: String? = null

    @JvmField
    @QueryStringParam
    var status: String? = null

    @JvmField
    @QueryStringParam
    var since_timestamp_opt: Date? = null

    @JvmField
    @QueryStringParam
    var before_timestamp_opt: Date? = null

    @JvmField
    @QueryStringParam
    var since_last_changed: Date? = null

    @JvmField
    @QueryStringParam
    var before_last_changed: Date? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var members: List<MemberInfo>? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }
}
