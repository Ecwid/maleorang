package com.ecwid.maleorang.method.v3_0.lists


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*

/**
 * [Get details about a specific abuse report](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/abuse-reports/#read-get_lists_list_id_abuse_reports_report_id)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/lists/{list_id}/abuse-reports/{report_id}")
class GetAbuseReportMethod(
        @JvmField
        @PathParam
        val list_id: String,

        @JvmField
        @PathParam
        val report_id: String
) : MailchimpMethod<AbuseReportInfo>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null

    @JvmField
    @QueryStringParam
    var count: Int? = null

    @JvmField
    @QueryStringParam
    var offset: Int? = null
}
