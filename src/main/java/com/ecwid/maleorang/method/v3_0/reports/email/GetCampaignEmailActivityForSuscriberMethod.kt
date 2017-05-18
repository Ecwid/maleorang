package com.ecwid.maleorang.method.v3_0.reports.email


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import java.util.*
import org.apache.commons.codec.digest.DigestUtils

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = " /reports/{campaign_id}/email-activity/{subscriber_hash}")
class GetCampaignEmailActivityForSuscriberMethod(
        @JvmField
        @PathParam
        val campaign_id: String,
        email: String
) : MailchimpMethod<GetCampaignEmailActivityForSuscriberMethod.Response>() {
    
	@JvmField
    @PathParam
    val subscriber_hash: String = DigestUtils.md5Hex(email.toLowerCase())

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


    class Response : MailchimpObject() {
        @JvmField
        @Field
        var emails: CampaignEmailActivityInfo? = null

	@JvmField
        @Field
        var campaign_id: String? = null
		
        @JvmField
        @Field
        var total_items: Int? = null
    }
}
