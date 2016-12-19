package com.ecwid.maleorang.method.v3_0.lists


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import com.ecwid.maleorang.method.v3_0.reports.email.TypeSegment
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path ="/lists/{list_id}/segments")
class GetSegmentsMethod(
        @JvmField
        @PathParam
        val list_id: String
) : MailchimpMethod<GetSegmentsMethod.Response>() {

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

    @JvmField
    @QueryStringParam
    var type: TypeSegment? = null

    @JvmField
    @QueryStringParam
    var since_create_at: Date? = null

    @JvmField
    @QueryStringParam
    var before_created_at: Date? = null

    @JvmField
    @QueryStringParam
    var since_updated_at: Date? = null

    @JvmField
    @QueryStringParam
    var before_updated_at: Date? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var segments: List<SegmentInfo>? = null

        @JvmField
        @Field
        var list_id: String? = null

        @JvmField
        @Field
        var total_items: Int? = null

    }
}
