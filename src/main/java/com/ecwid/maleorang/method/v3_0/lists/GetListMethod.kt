package com.ecwid.maleorang.method.v3_0.lists


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*

/**
 * [Get information about a specific list]
 * (http://developer.mailchimp.com/documentation/mailchimp/reference/lists/#read-get_lists_list_id)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/lists/{list_id}")
class GetListMethod(
        @JvmField
        @PathParam
        val list_id: String
) : MailchimpMethod<ListInfo>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null
}
