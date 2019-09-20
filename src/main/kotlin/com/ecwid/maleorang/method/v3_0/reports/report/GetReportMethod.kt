package com.ecwid.maleorang.method.v3_0.reports.report

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Method;
import com.ecwid.maleorang.annotation.HttpMethod;
import com.ecwid.maleorang.annotation.APIVersion;
import com.ecwid.maleorang.annotation.QueryStringParam;
import com.ecwid.maleorang.annotation.Field

import java.util.Date;

/**
 *
 * @author Raisin-Alejandro-Palacios
 *
 * An implementation of https://developer.mailchimp.com/documentation/mailchimp/reference/reports/
 *
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/reports")
class GetReportMethod : MailchimpMethod<GetReportMethod.Response>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var count: Int? = null

    @JvmField
    @QueryStringParam
    var offset: Int? = null

    @JvmField
    @QueryStringParam
    var type: String? = null

    @JvmField
    @QueryStringParam
    var before_send_time: Date? = null

    @JvmField
    @QueryStringParam
    var since_send_time: Date? = null

    class Response : MailchimpObject() {

        @JvmField
        @Field
        var reports: List<ReportInfo>? = null

        @JvmField
        @Field
        var total_items: Int? = null

    }

}


