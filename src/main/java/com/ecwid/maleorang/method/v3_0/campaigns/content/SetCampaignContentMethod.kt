package com.ecwid.maleorang.method.v3_0.campaigns.content

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import com.google.gson.annotations.SerializedName

/**
 * [Set the content for a campaign](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/content/#edit-put_campaigns_campaign_id_content)
 */
@Method(httpMethod = HttpMethod.PUT, version = APIVersion.v3_0, path = "/campaigns/{campaign_id}/content")
class SetCampaignContentMethod(@JvmField @PathParam val campaign_id: String) : MailchimpMethod<ContentInfo>() {

    @JvmField
    @Field
    var plain_text: String? = null

    @JvmField
    @Field
    var html: String? = null

    @JvmField
    @Field
    var url: String? = null

    @JvmField
    @Field
    var template: Template? = null

    class Template : MailchimpObject() {

        @JvmField
        @Field
        var id: Int? = null

        @JvmField
        @Field
        var sections: Map<String, String>? = null

    }

    @JvmField
    @Field
    var archive: Archive? = null

    class Archive : MailchimpObject() {

        @JvmField
        @Field
        var archive_content: String? = null

        @JvmField
        @Field
        var archive_type: ArchiveType? = null

        enum class ArchiveType {
            @SerializedName("zip")
            ZIP,
            @SerializedName("tar.gz")
            TAR_GZ,
            @SerializedName("tar.bz2")
            TAR_BZ2,
            @SerializedName("tar")
            TAR,
            @SerializedName("tgz")
            TGZ,
            @SerializedName("tbz")
            TBZ,
        }
    }

    @JvmField
    @Field
    var variate_contents: Array<VariateContents>? = null

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

        @JvmField
        @Field
        var url: String? = null

        @JvmField
        @Field
        var template: Template? = null

        @JvmField
        @Field
        var archive: Archive? = null

    }


}
