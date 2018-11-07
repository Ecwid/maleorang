package com.ecwid.maleorang.method.v3_0.reports

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignClicksReport : MailchimpObject() {
    @JvmField
    @Field
    var clicks_total: Int? = null

    @JvmField
    @Field
    var unique_clicks: Int? = null
	
    @JvmField
    @Field
    var unique_subscriber_clicks: Int? = null	
	
    @JvmField
    @Field
    var click_rate: Double? = null
		
    @JvmField
    @Field
    var last_click: Date? = null
	
}
