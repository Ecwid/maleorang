package com.ecwid.maleorang.method.v3_0.reports

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignLocationInfo : MailchimpObject() {
    @JvmField
    @Field
    var country_code: String? = null

    @JvmField
    @Field
    var region: String? = null
	
    @JvmField
    @Field
    var opens: Int? = null
}
