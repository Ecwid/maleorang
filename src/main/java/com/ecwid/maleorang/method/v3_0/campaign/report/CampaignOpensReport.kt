package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignOpensReport : MailchimpObject() {
    @JvmField
    @Field
    var opens_total: Int? = null

    @JvmField
    @Field
    var unique_opens: Int? = null
	
    @JvmField
    @Field
    var open_rate: Double? = null
		
    @JvmField
    @Field
    var last_open: Date? = null
	
}
