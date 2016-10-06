package com.ecwid.maleorang.method.v3_0.campaign

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignInfo : MailchimpObject() {
    @JvmField
    @Field
    var id: String? = null
	
    @JvmField
    @Field
    var type: String? = null	
	
    @JvmField
    @Field
    var create_time: String? = null
		
    @JvmField
    @Field
    var archive_url: String? = null
		
    @JvmField
    @Field
    var long_archive_url: String? = null
		
    @JvmField
    @Field
    var status: String? = null
		
    @JvmField
    @Field
    var emails_sent: Int? = null
		
    @JvmField
    @Field
    var content_type: String? = null
		
    @JvmField
    @Field
    var recipients: RecipientsCampaignInfo? = null
	
}
