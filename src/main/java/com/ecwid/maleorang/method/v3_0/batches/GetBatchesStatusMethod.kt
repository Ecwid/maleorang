package com.ecwid.maleorang.method.v3_0.batches

import com.ecwid.maleorang.annotation.Field
import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.APIVersion
import com.ecwid.maleorang.annotation.HttpMethod
import com.ecwid.maleorang.annotation.Method
import com.ecwid.maleorang.annotation.QueryStringParam


/**
 * [Get a list of batch requests](http://developer.mailchimp.com/documentation/mailchimp/reference/batches/#read-get_batches)
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/batches")
class GetBatchesStatusMethod : MailchimpMethod<GetBatchesStatusMethod.Response>() {
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

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var batches: List<BatchStatus>? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }
}
