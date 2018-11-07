package com.ecwid.maleorang.method.v3_0.automation.info

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class RecipientsWorkflowInfo : MailchimpObject() {
    @JvmField
    @Field
    var list_id: String? = null

    @JvmField
    @Field
    var list_name: String? = null

    @JvmField
    @Field
    var segment_opts: MailchimpObject? = null //TODO create SegmentOpts Object
	
}
