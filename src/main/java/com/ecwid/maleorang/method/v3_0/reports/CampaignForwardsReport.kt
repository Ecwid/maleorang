package com.ecwid.maleorang.method.v3_0.reports

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignForwardsReport : MailchimpObject() {
    @JvmField
    @Field
    var forwards_count: Int? = null

    @JvmField
    @Field
    var forwards_opens: Int? = null
	
}
