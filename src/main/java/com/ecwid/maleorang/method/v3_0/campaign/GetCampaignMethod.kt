package com.ecwid.maleorang.method.v3_0.campaign


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*
import org.apache.commons.codec.digest.DigestUtils

/**
 * [Get information about a specific list member](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#read-get_lists_list_id_members_subscriber_hash)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}")
class GetMemberMethod(
        @JvmField
        @PathParam
        val campaign_id: String
) : MailchimpMethod<CampaignInfo>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null
}
