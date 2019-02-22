package com.ecwid.maleorang.method.v3_0.reports.report

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

import java.util.Date;

/**
 * @author Raisin-Alejandro-Palacios
 *
 * A DTO class to capture response information from https://developer.mailchimp.com/documentation/mailchimp/reference/reports/#read-get_reports
 *
 */
class ReportInfo : MailchimpObject() {

    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var type: String? = null

    @JvmField
    @Field
    var send_time: Date? = null

}