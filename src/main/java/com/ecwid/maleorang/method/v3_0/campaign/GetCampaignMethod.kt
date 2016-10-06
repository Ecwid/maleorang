package com.ecwid.maleorang.method.v3_0.campaign


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*
import org.apache.commons.codec.digest.DigestUtils

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}")
class GetCampaignMethod(
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
