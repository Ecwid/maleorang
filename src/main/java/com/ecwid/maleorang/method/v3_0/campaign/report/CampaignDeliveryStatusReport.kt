package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class CampaignDeliveryStatusReport : MailchimpObject() {
    @JvmField
    @Field
    var enabled: Boolean? = null

    @JvmField
    @Field
    var can_cancel: Boolean? = null
	
    @JvmField
    @Field
    var status: String? = null	
	
    @JvmField
    @Field
    var emails_sent: Int? = null
		
    @JvmField
    @Field
    var emails_canceled: Int? = null
	
}
