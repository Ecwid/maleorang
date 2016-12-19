package com.ecwid.maleorang.method.v3_0.segments

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */
class SegmentInfo : MailchimpObject() {

    @JvmField
    @Field
    var id: String? = null

    @JvmField
    @Field
    var name: String? = null

    @JvmField
    @Field
    var member_count: Int? = null

    @JvmField
    @Field
    var type: TypeSegment? = null

    @JvmField
    @Field
    var create_at: Date? = null

    @JvmField
    @Field
    var updated_at: Date? = null

    @JvmField
    @Field
    var options: MailchimpObject? = null //TODO: must create a options object

    @JvmField
    @Field
    var list_id: String? = null

}
