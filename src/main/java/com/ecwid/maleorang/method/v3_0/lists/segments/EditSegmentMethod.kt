package com.ecwid.maleorang.method.v3_0.segments

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */
sealed class EditSegmentMethod : MailchimpMethod<SegmentInfo>() {
    /**
     *
     */
    @Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/lists/{list_id}/segments")
    class Create(
            @JvmField
            @PathParam
            val list_id: String

    ) : EditSegmentMethod()

    /**
     *
     */
    @Method(httpMethod = HttpMethod.PATCH, version = APIVersion.v3_0, path = "/lists/{list_id}/segments/{segment_id}")
    class Update(
            @JvmField
            @PathParam
            val list_id: String,

            @JvmField
            @PathParam
            val segment_id: String

    ) : EditSegmentMethod()


    @JvmField
    @Field
    var name: String? = null

    @JvmField
    @Field
    var static_segment: List<String>? = null

    @JvmField
    @Field
    var options: MailchimpObject? = null //TODO create a options object for Segments


}