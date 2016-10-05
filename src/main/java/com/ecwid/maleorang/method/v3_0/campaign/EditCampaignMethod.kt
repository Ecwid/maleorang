package com.ecwid.maleorang.method.v3_0.lists.members

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import org.apache.commons.codec.digest.DigestUtils
import java.util.*

/**
 * Base class for member create or update operations.
 */
sealed class EditMemberMethod : MailchimpMethod<MemberInfo>() {
    /**
     * [Add a new list member](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#create-post_lists_list_id_members)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/lists/{list_id}/members")
    class Create(
            @JvmField
            @PathParam
            val list_id: String,

            @JvmField
            @Field
            val email_address: String
    ) : EditMemberMethod()

    /**
     * [Update a list member](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#edit-patch_lists_list_id_members_subscriber_hash)
     */
    @Method(httpMethod = HttpMethod.PATCH, version = APIVersion.v3_0, path = "/lists/{list_id}/members/{subscriber_hash}")
    class Update(
            @JvmField
            @PathParam
            val list_id: String,

            email_address: String
    ) : EditMemberMethod() {
        @JvmField
        @PathParam
        val subscriber_hash: String = DigestUtils.md5Hex(email_address.toLowerCase())
    }

    /**
     * [Add or update a list member](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#edit-put_lists_list_id_members_subscriber_hash)
     */
    @Method(httpMethod = HttpMethod.PUT, version = APIVersion.v3_0, path = "/lists/{list_id}/members/{subscriber_hash}")
    class CreateOrUpdate(
            @JvmField
            @PathParam
            val list_id: String,

            @JvmField
            @Field
            val email_address: String
    ) : EditMemberMethod() {
        @JvmField
        @PathParam
        val subscriber_hash: String = DigestUtils.md5Hex(email_address.toLowerCase())

        @JvmField
        @Field
        var status_if_new: String? = null
    }

    @JvmField
    @Field
    var email_type: String? = null

    @JvmField
    @Field
    var status: String? = null

    @JvmField
    @Field
    var merge_fields: MailchimpObject? = null

    @JvmField
    @Field
    var interests: MailchimpObject? = null

    @JvmField
    @Field
    var language: String? = null

    @JvmField
    @Field
    var vip: Boolean? = null

    @JvmField
    @Field
    var location: MailchimpObject? = null

    @JvmField
    @Field
    var ip_signup: String? = null

    @JvmField
    @Field
    var timestamp_signup: Date? = null

    @JvmField
    @Field
    var ip_opt: String? = null

    @JvmField
    @Field
    var timestamp_opt: Date? = null
}