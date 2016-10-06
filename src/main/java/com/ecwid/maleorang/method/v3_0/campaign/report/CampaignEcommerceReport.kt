package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class CampaignEcommerceReport : MailchimpObject() {
    @JvmField
    @Field
    var total_orders: Int? = null

    @JvmField
    @Field
    var total_spent: Double? = null
	
    @JvmField
    @Field
    var total_revenue: Double? = null	
	
}
