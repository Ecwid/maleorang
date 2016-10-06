package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class CampaignForwardsReport : MailchimpObject() {
    @JvmField
    @Field
    var forwards_count: Int? = null

    @JvmField
    @Field
    var forwards_opens: Int? = null
	
}
