package com.ecwid.maleorang.method.v3_0.automation.info

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class ReportSummaryWorkflow : MailchimpObject() {

    @JvmField
    @Field
    var opens: Int? = null

    @JvmField
    @Field
    var unique_opens: Int? = null

    @JvmField
    @Field
    var open_rate: Double? = null

    @JvmField
    @Field
    var clicks: Int? = null

    @JvmField
    @Field
    var subscriber_clicks: Int? = null

    @JvmField
    @Field
    var click_rate: Int? = null

	
}
