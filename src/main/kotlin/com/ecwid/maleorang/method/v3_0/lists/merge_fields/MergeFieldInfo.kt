package com.ecwid.maleorang.method.v3_0.lists.merge_fields

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import com.google.gson.annotations.SerializedName

class MergeFieldInfo : MailchimpObject() {

    @JvmField
    @Field
    var merge_id: Int? = null

    @JvmField
    @Field
    var tag: String? = null

    @JvmField
    @Field
    var name: String? = null

    @JvmField
    @Field
    var type: Type? = null

    enum class Type {
        @SerializedName("text")
        TEXT,
        @SerializedName("number")
        NUMBER,
        @SerializedName("address")
        ADDRESS,
        @SerializedName("phone")
        PHONE,
        @SerializedName("date")
        DATE,
        @SerializedName("url")
        URL,
        @SerializedName("imageurl")
        IMAGEURL,
        @SerializedName("radio")
        RADIO,
        @SerializedName("dropdown")
        DROPDOWN,
        @SerializedName("birthday")
        BIRTHDAY,
        @SerializedName("zip")
        ZIP
    }

    @JvmField
    @Field
    var required: Boolean? = null

    @JvmField
    @Field
    var default_value: String? = null

    @JvmField
    @Field
    var public: Boolean? = null

    @JvmField
    @Field
    var display_order: Int? = null

    @JvmField
    @Field
    var options: OptionsInfo? = null

    class OptionsInfo : MailchimpObject() {

        @JvmField
        @Field
        var default_country: Int? = null

        @JvmField
        @Field
        var phone_format: String? = null

        @JvmField
        @Field
        var date_format: String? = null

        @JvmField
        @Field
        var choices: Array<String>? = null

        @JvmField
        @Field
        var size: Int? = null

    }

    @JvmField
    @Field
    var help_text: String? = null

    @JvmField
    @Field
    var list_id: String? = null

}
