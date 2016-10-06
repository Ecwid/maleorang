package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignShareVIPReport : MailchimpObject() {
    @JvmField
    @Field
    var share_url: String? = null

    @JvmField
    @Field
    var share_password: String? = null
	
}
