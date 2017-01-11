package com.ecwid.maleorang.method.v3_0.list.segments

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.APIVersion
import com.ecwid.maleorang.annotation.HttpMethod
import com.ecwid.maleorang.annotation.Method
import com.ecwid.maleorang.annotation.PathParam

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */
@Method(httpMethod = HttpMethod.DELETE, version = APIVersion.v3_0, path = "/lists/{list_id}/segments/{segment_id}")
class DeleteSegmentMethod(
        @JvmField
        @PathParam
        val list_id: String,

        @JvmField
        @PathParam
        val segment_id: String
) : MailchimpMethod<MailchimpObject>()
