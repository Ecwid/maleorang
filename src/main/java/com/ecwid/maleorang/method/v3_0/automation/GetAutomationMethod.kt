package com.ecwid.maleorang.method.v3_0.automation


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*
import com.ecwid.maleorang.method.v3_0.automation.info.WorkflowInfo

/**
 * [Get information about a specific automation workflow](http://developer.mailchimp.com/documentation/mailchimp/reference/automations/#read-get_automations_workflow_id)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/automations/{workflow_id}")
class GetAutomationMethod(
        @JvmField
        @PathParam
        val workflow_id: String
) : MailchimpMethod<WorkflowInfo>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null
}
