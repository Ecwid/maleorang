package com.ecwid.maleorang.method.v3_0.reports

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

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
