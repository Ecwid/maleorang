package com.ecwid.maleorang.method.v3_0.campaign.report.email

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class EmailReportActivityDetails : MailchimpObject() {
    @JvmField
    @Field
    var action: String? = null

    @JvmField
    @Field
    var type: String? = null
	
    @JvmField
    @Field
    var timestamp: String? = null	
	
    @JvmField
    @Field
    var url: String? = null
		
    @JvmField
    @Field
    var ip: String? = null
	
}
