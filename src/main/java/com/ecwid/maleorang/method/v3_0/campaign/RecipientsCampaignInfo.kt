package com.ecwid.maleorang.method.v3_0.campaign

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class RecipientsCampaignInfo : MailchimpObject() {
    @JvmField
    @Field
    var list_id: String? = null
	
    @JvmField
    @Field
    var segment_opts: MailchimpObject? = null
	
}
