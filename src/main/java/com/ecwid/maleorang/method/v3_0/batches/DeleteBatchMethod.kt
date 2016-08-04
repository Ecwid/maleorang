package com.ecwid.maleorang.method.v3_0.members

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.APIVersion
import com.ecwid.maleorang.annotation.HttpMethod
import com.ecwid.maleorang.annotation.Method
import com.ecwid.maleorang.annotation.PathParam
import org.apache.commons.codec.digest.DigestUtils

/**
 * [Remove a list member](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#delete-delete_lists_list_id_members_subscriber_hash)
 */
@Method(httpMethod = HttpMethod.DELETE, version = APIVersion.v3_0, path = "/batches/{batch_id}")
class DeleteBatchMethod(
        @JvmField
        @PathParam
        val batch_id: String
) : MailchimpMethod<MailchimpObject>()
