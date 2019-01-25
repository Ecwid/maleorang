package com.ecwid.maleorang.method.v3_0.batches

import com.ecwid.maleorang.annotation.Field
import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpMethodInfo
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.APIVersion
import com.ecwid.maleorang.annotation.HttpMethod
import com.ecwid.maleorang.annotation.Method


/**
 * [Start a batch operation](http://developer.mailchimp.com/documentation/mailchimp/reference/batches/#create-post_batches)
 */
@Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/batches")
class StartBatchMethod(operations: List<MailchimpMethod<*>>) : MailchimpMethod<BatchStatus>() {

    class Operation internal constructor(info: MailchimpMethodInfo): MailchimpObject() {
        @JvmField
        @Field
        val method = info.httpMethod.name

        @JvmField
        @Field
        val path = info.buildPath()

        @JvmField
        @Field
        val params = info.queryStringParams

        @JvmField
        @Field
        val body = info.requestBody

        @JvmField
        @Field
        var operation_id: String? = null
    }

    @JvmField
    @Field
    val operations = operations.map { Operation(MailchimpMethodInfo(it)) }
}
