package com.ecwid.maleorang.method.v3_0.lists.merge_fields

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.MailchimpMethod;
import com.ecwid.maleorang.annotation.APIVersion
import com.ecwid.maleorang.annotation.HttpMethod
import com.ecwid.maleorang.annotation.Method
import com.ecwid.maleorang.annotation.PathParam

/**
 * @author Raisin-AlejandroPalacios
 *
 * [Remove merge field from a specific list](https://developer.mailchimp.com/documentation/mailchimp/reference/lists/merge-fields/)
 *
 */
@Method(httpMethod = HttpMethod.DELETE, version = APIVersion.v3_0, path = "/lists/{list_id}/merge-fields/{merge_id}")
class DeleteMergeFieldMethod(
        @JvmField
        @PathParam
        val list_id: String,

        @JvmField
        @PathParam
        val merge_id: Int
) : MailchimpMethod<MailchimpObject>()






