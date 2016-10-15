package com.ecwid.maleorang.method.v3_0.reports

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignListStatsReport : MailchimpObject() {
    @JvmField
    @Field
    var sub_rate: Double? = null

    @JvmField
    @Field
    var unsub_rate: Double? = null
	
    @JvmField
    @Field
    var open_rate: Double? = null	
	
    @JvmField
    @Field
    var click_rate: Double? = null
	
}
