package com.ecwid.maleorang.method.v3_0.lists.members


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*
import org.apache.commons.codec.digest.DigestUtils

/**
 * [Get information about a specific list member](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#read-get_lists_list_id_members_subscriber_hash)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/lists/{list_id}/members/{subscriber_hash}")
class GetMemberMethod(
        @JvmField
        @PathParam
        val list_id: String,

        email: String
) : MailchimpMethod<MemberInfo>() {
    @JvmField
    @PathParam
    val subscriber_hash: String = DigestUtils.md5Hex(email.toLowerCase())

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null
}
