package com.ecwid.maleorang.method.v3_0.batches

import com.ecwid.maleorang.annotation.Field
import com.ecwid.maleorang.MailchimpObject

import java.util.Date

class BatchStatus : MailchimpObject() {
    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var status: String? = null

    @JvmField
    @Field
    var total_operations: Int? = null

    @JvmField
    @Field
    var finished_operations: Int? = null

    @JvmField
    @Field
    var errored_operations: Int? = null

    @JvmField
    @Field
    var submitted_at: Date? = null

    @JvmField
    @Field
    var completed_at: Date? = null

    @JvmField
    @Field
    var response_body_url: String? = null
}
