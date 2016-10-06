package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignBounceReport : MailchimpObject() {
    @JvmField
    @Field
    var hard_bounces: Int? = null

    @JvmField
    @Field
    var soft_bounces: Int? = null
	
    @JvmField
    @Field
    var syntax_errors: Int? = null
}
