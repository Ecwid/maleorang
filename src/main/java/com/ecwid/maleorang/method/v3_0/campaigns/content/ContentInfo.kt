package com.ecwid.maleorang.method.v3_0.campaigns.content

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

class ContentInfo : MailchimpObject() {

    @JvmField
    @Field
    var variate_contents: VariateContents? = null

    class VariateContents : MailchimpObject() {

        @JvmField
        @Field
        var content_label: String? = null

        @JvmField
        @Field
        var plain_text: String? = null

        @JvmField
        @Field
        var html: String? = null

    }

    @JvmField
    @Field
    var plain_text: String? = null

    @JvmField
    @Field
    var html: String? = null

}