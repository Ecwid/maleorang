package com.ecwid.maleorang.method.v3_0.lists.merge_fields

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*

/**
 * [Get a list of all merge fields (formerly merge vars) for a list](https://developer.mailchimp.com/documentation/mailchimp/reference/lists/merge-fields/#read-get_lists_list_id_merge_fields)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/lists/{list_id}/merge-fields")
class GetMergeFieldsMethod(@JvmField @PathParam val list_id: String) : MailchimpMethod<GetMergeFieldsMethod.Response>() {

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
    var type: MergeFieldInfo.Type? = null

    @JvmField
    @QueryStringParam
    var required: Boolean? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var merge_fields: List<MergeFieldInfo>? = null

        @JvmField
        @Field
        var list_id: String? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }

}