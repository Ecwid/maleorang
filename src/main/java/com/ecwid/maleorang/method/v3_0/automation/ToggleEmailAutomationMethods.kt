package com.ecwid.maleorang.method.v3_0.automation

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*

/**
 * Base class for automations activate/deactivate operations
 */
sealed class ToggleEmailAutomationMethods : MailchimpMethod<MailchimpObject>() {
    /**
     * [Pause Automation](http://developer.mailchimp.com/documentation/mailchimp/reference/automations/emails/#action-post_automations_workflow_id_emails_workflow_email_id_actions_pause)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/automations/{workflow_id}/emails/{workflow_email_id}/actions/pause")
    class Deactivate(

            @JvmField
            @PathParam
            val workflow_id: String,

            @JvmField
            @PathParam
            val workflow_email_id: String

    ) : ToggleEmailAutomationMethods()

    /**
     * [Activate Automation](http://developer.mailchimp.com/documentation/mailchimp/reference/automations/emails/#action-post_automations_workflow_id_emails_workflow_email_id_actions_start)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/automations/{workflow_id}/emails/{workflow_email_id}/actions/start")
    class Activate(

            @JvmField
            @PathParam
            val workflow_id: String,

            @JvmField
            @PathParam
            val workflow_email_id: String

    ) : ToggleEmailAutomationMethods()

}