package com.ecwid.maleorang.method.v3_0.reports

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignTimeseriesReport : MailchimpObject() {
    @JvmField
    @Field
    var timestamp: Date? = null

    @JvmField
    @Field
    var emails_sent: Int? = null
	
    @JvmField
    @Field
    var unique_opens: Int? = null
		
    @JvmField
    @Field
    var recipients_clicks: Int? = null
	
}
