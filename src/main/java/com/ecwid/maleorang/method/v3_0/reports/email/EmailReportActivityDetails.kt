package com.ecwid.maleorang.method.v3_0.reports.email

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field
import java.util.*

/**
 * Created by: Manuel Lara <lararojas.mr@gmail.com>
 */

class EmailReportActivityDetails : MailchimpObject() {
    @JvmField
    @Field
    var action: TypeEmailActivity? = null

    @JvmField
    @Field
    var type: TypeBounceActivity? = null
	
    @JvmField
    @Field
    var timestamp: Date? = null
	
    @JvmField
    @Field
    var url: String? = null
		
    @JvmField
    @Field
    var ip: String? = null


    fun setAction(action: String) {
        this.action = TypeEmailActivity.valueOf(action)
    }

    fun setType(type: String) {
        this.type = TypeBounceActivity.valueOf(type)
    }

}
