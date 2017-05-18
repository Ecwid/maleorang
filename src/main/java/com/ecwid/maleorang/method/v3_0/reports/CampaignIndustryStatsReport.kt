package com.ecwid.maleorang.method.v3_0.reports

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignIndustryStatsReport : MailchimpObject() {
	
    @JvmField
    @Field
    var type: String? = null	
	
    @JvmField
    @Field
    var open_rate: Double? = null
		
    @JvmField
    @Field
    var click_rate: Double? = null
		
    @JvmField
    @Field
    var bounce_rate: Double? = null
		
    @JvmField
    @Field
    var unopen_rate: Double? = null
		
    @JvmField
    @Field
    var unsub_rate: Double? = null
		
    @JvmField
    @Field
    var abuse_rate: Double? = null
	
}
