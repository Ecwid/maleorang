package com.ecwid.maleorang.method.v3_0.reports

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class CampaignReportInfo : MailchimpObject() {
    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var campaign_title: String? = null
	
    @JvmField
    @Field
    var type: String? = null	
	
    @JvmField
    @Field
    var list_id: String? = null
		
    @JvmField
    @Field
    var list_name: String? = null
		
    @JvmField
    @Field
    var subject_line: String? = null
		
    @JvmField
    @Field
    var emails_sent: Int? = null
		
    @JvmField
    @Field
    var abuse_reports: Int? = null
		
    @JvmField
    @Field
    var unsubscribed: Int? = null

    @JvmField
    @Field
    var send_time: String? = null
	
    @JvmField
    @Field
    var rss_last_send: String? = null
	
    @JvmField
    @Field
    var bounces: CampaignBounceReport? = null
			
    @JvmField
    @Field
    var forwards: CampaignForwardsReport? = null
			
    @JvmField
    @Field
    var opens: CampaignOpensReport? = null
			
    @JvmField
    @Field
    var clicks: CampaignClicksReport? = null
			
    @JvmField
    @Field
    var facebook_likes: CampaignFacebookLikesReport? = null
			
    @JvmField
    @Field
    var industry_stats: CampaignIndustryStatsReport? = null
			
    @JvmField
    @Field
    var list_stats: CampaignListStatsReport? = null
	
    @JvmField
    @Field
    var ab_split: MailchimpObject? = null
				
    @JvmField
    @Field
    var timewarp: CampaignTimewarpReport? = null
			
    @JvmField
    @Field
    var timeseries: List<CampaignTimeseriesReport>? = null
	
    @JvmField
    @Field
    var share_report: CampaignShareVIPReport? = null
				
    @JvmField
    @Field
    var ecommerce: CampaignEcommerceReport? = null
	
    @JvmField
    @Field
    var delivery_status: CampaignDeliveryStatusReport? = null
	
}
