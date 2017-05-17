package com.ecwid.maleorang.method.v3_0.automation.info

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import com.ecwid.maleorang.method.v3_0.campaign.*
import java.util.*

/**
 * Created by Ing. Manuel Lara on 07/05/17.
 */
class WorkflowEmailQueue : MailchimpObject() {

    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var workflow_id: String? = null

    @JvmField
    @Field
    var email_id: String? = null

    @JvmField
    @Field
    var list_id: MailchimpObject? = null

    @JvmField
    @Field
    var email_address: String? = null

    @JvmField
    @Field
    var next_send: String? = null

    @JvmField
    @Field
    var _links: MailchimpObject? = null

}
