package com.ecwid.maleorang.method.v3_0.lists.merge_fields

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import com.ecwid.maleorang.method.v3_0.lists.members.MemberInfo

/**
 * Base class for editing merge fields (formerly merge vars) for a specific list
 */
sealed class EditMergeFieldMethod : MailchimpMethod<MemberInfo>() {

    /**
     * [Add a new merge field for a specific list](https://developer.mailchimp.com/documentation/mailchimp/reference/lists/merge-fields/#create-post_lists_list_id_merge_fields)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/lists/{list_id}/merge-fields")
    class Create(
            @JvmField
            @PathParam
            val list_id: String,

            @JvmField
            @Field
            val type: MergeFieldInfo.Type? = null
    ) : EditMergeFieldMethod()

    /**
     * [Update a specific merge field in a list](https://developer.mailchimp.com/documentation/mailchimp/reference/lists/merge-fields/#edit-patch_lists_list_id_merge_fields_merge_id)
     */
    @Method(httpMethod = HttpMethod.PATCH, version = APIVersion.v3_0, path = "/lists/{list_id}/merge-fields/{merge_id}")
    class Update(
            @JvmField
            @PathParam
            val list_id: String,

            @JvmField
            @PathParam
            val merge_id: String
    ) : EditMergeFieldMethod()

    @JvmField
    @Field
    var tag: String? = null

    @JvmField
    @Field
    var name: String? = null

    @JvmField
    @Field
    var required: Boolean? = null

    @JvmField
    @Field
    var default_value: String? = null

    @JvmField
    @Field
    var public: Boolean? = null

    @JvmField
    @Field
    var display_order: Int? = null

    @JvmField
    @Field
    var options: OptionsInfo? = null

    class OptionsInfo : MailchimpObject() {

        @JvmField
        @Field
        var default_country: Int? = null

        @JvmField
        @Field
        var phone_format: String? = null

        @JvmField
        @Field
        var date_format: String? = null

        @JvmField
        @Field
        var choices: Array<String>? = null

        @JvmField
        @Field
        var size: Int? = null

    }

    @JvmField
    @Field
    var help_text: String? = null

}