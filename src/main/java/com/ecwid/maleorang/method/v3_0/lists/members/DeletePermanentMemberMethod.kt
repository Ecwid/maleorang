package com.ecwid.maleorang.method.v3_0.lists.members

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.APIVersion
import com.ecwid.maleorang.annotation.HttpMethod
import com.ecwid.maleorang.annotation.Method
import com.ecwid.maleorang.annotation.PathParam
import org.apache.commons.codec.digest.DigestUtils

/**
 * [Permanently delete a list member](https://mailchimp.com/developer/api/marketing/list-members/delete-list-member/)
 */
@Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/lists/{list_id}/members/{subscriber_hash}/actions/delete-permanent")
class DeletePermanentMemberMethod(
        @JvmField
        @PathParam
        val list_id: String,

        email: String
) : MailchimpMethod<MailchimpObject>() {
        @JvmField
        @PathParam
        val subscriber_hash: String = DigestUtils.md5Hex(email.toLowerCase())
}
