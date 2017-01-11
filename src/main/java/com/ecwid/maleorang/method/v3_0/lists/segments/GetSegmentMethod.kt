package com.ecwid.maleorang.method.v3_0.list.segments


import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.annotation.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/lists/{list_id}/segments/{segment_id}")
class GetSegmentMethod(
        @JvmField
        @PathParam
        val list_id: String,

        @JvmField
        @PathParam
        val segment_id: String
) : MailchimpMethod<SegmentInfo>() {

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null
}
