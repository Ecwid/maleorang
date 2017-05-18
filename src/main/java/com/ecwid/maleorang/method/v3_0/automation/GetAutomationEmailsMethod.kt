package com.ecwid.maleorang.method.v3_0.automation


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import com.ecwid.maleorang.method.v3_0.automation.info.WorkflowEmailInfo

/**
 * [Get information about automations](http://developer.mailchimp.com/documentation/mailchimp/reference/automations/emails/#read-get_automations_workflow_id)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/automations/{workflow_id}/emails")
class GetAutomationEmailsMethod(

        @JvmField
        @PathParam
        val workflow_id: String

) : MailchimpMethod<GetAutomationEmailsMethod.Response>() {

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var emails: List<WorkflowEmailInfo>? = null

        @JvmField
        @Field
        var total_items: Int? = null

        @JvmField
        @Field
        var _links: MailchimpObject? = null
    }
}
