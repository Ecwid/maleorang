package com.ecwid.maleorang.method.v3_0.automation


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import com.ecwid.maleorang.method.v3_0.automation.info.WorkflowInfo

/**
 * [Get information about automations](http://developer.mailchimp.com/documentation/mailchimp/reference/automations/#read-get_automations)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/automations")
class GetAutomationsMethod : MailchimpMethod<GetAutomationsMethod.Response>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null

    @JvmField
    @QueryStringParam
    var before_create_time: String? = null

    @JvmField
    @QueryStringParam
    var since_create_time: String? = null

    @JvmField
    @QueryStringParam
    var before_send_time: String? = null

    @JvmField
    @QueryStringParam
    var since_send_time: String? = null

    @JvmField
    @QueryStringParam
    var status: String? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var automations: List<WorkflowInfo>? = null

        @JvmField
        @Field
        var total_items: Int? = null

        @JvmField
        @Field
        var _links: MailchimpObject? = null
    }
}
