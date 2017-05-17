package com.ecwid.maleorang.method.v3_0.automation

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*

/**
 * Base class for automations activate/deactivate operations
 */
sealed class ToggleAutomationMethods : MailchimpMethod<MailchimpObject>() {
    /**
     * [Pause Automation](http://developer.mailchimp.com/documentation/mailchimp/reference/automations/#)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/automations/{workflow_id}/actions/pause-all-emails")
    class Deactivate(

            @JvmField
            @PathParam
            val workflow_id: String

    ) : ToggleAutomationMethods()

    /**
     * [Activate Automation](http://developer.mailchimp.com/documentation/mailchimp/reference/automations/#)
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/automations/{workflow_id}/actions/start-all-emails")
    class Activate(

            @JvmField
            @PathParam
            val workflow_id: String

    ) : ToggleAutomationMethods()

}