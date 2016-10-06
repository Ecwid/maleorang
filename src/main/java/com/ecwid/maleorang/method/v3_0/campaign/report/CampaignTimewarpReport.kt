package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class CampaignTimewarpReport : MailchimpObject() {
    @JvmField
    @Field
    var gmt_offset: Int? = null

    @JvmField
    @Field
    var opens: Int? = null
	
    @JvmField
    @Field
    var last_open: Date? = null	
	
    @JvmField
    @Field
    var unique_opens: Int? = null
		
    @JvmField
    @Field
    var clicks: Int? = null
		
    @JvmField
    @Field
    var subject_line: String? = null
		
    @JvmField
    @Field
    var last_click: Date? = null
		
    @JvmField
    @Field
    var unique_clicks: Int? = null
		
    @JvmField
    @Field
    var bounces: Int? = null
	
}
