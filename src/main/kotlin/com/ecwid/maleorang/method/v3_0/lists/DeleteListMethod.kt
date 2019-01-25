package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.APIVersion
import com.ecwid.maleorang.annotation.HttpMethod
import com.ecwid.maleorang.annotation.Method
import com.ecwid.maleorang.annotation.PathParam

/**
 * [Delete a list from your MailChimp account](https://developer.mailchimp.com/documentation/mailchimp/reference/lists/#delete-delete_lists_list_id)
 */
@Method(httpMethod = HttpMethod.DELETE, version = APIVersion.v3_0, path = "/lists/{list_id}")
class DeleteListMethod(
        @JvmField
        @PathParam
        val list_id: String
) : MailchimpMethod<MailchimpObject>()