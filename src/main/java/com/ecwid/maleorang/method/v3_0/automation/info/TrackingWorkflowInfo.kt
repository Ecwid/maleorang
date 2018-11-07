package com.ecwid.maleorang.method.v3_0.automation.info

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class TrackingWorkflowInfo : MailchimpObject() {

    @JvmField
    @Field
    var opens: Boolean? = null

    @JvmField
    @Field
    var html_clicks: Boolean? = null

    @JvmField
    @Field
    var text_clicks: Boolean? = null

    @JvmField
    @Field
    var goal_tracking: Boolean? = null

    @JvmField
    @Field
    var ecomm360: Boolean? = null

    @JvmField
    @Field
    var google_analytics: Boolean? = null

    @JvmField
    @Field
    var clicktale: Boolean? = null

    @JvmField
    @Field
    var salesforce: MailchimpObject? = null

    @JvmField
    @Field
    var capsule: MailchimpObject? = null
	
}
