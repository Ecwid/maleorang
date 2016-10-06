package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class CampaignShareVIPReport : MailchimpObject() {
    @JvmField
    @Field
    var share_url: String? = null

    @JvmField
    @Field
    var share_password: String? = null
	
}
