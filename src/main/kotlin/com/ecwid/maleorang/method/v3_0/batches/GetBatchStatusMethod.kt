package com.ecwid.maleorang.method.v3_0.batches


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*

/**
 * [Get the status of a batch operation request](http://developer.mailchimp.com/documentation/mailchimp/reference/batches/#read-get_batches_batch_id)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/batches/{batch_id}")
class GetBatchStatusMethod(
        @JvmField
        @PathParam
        val batch_id: String
) : MailchimpMethod<BatchStatus>() {
    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null
}
