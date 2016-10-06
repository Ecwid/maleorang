package com.ecwid.maleorang.method.v3_0.campaign.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

class CampaignFacebookLikesReport : MailchimpObject() {
    @JvmField
    @Field
    var recipient_likes: Int? = null
	
    @JvmField
    @Field
    var unique_likes: Int? = null	
	
    @JvmField
    @Field
    var facebook_likes: Int? = null
	
}
