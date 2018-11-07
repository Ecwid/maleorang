package com.ecwid.maleorang.method.v3_0.reports.email

import com.google.gson.annotations.SerializedName

/**
 * Created by larar on 15/10/2016.
 */

enum class TypeEmailActivity(val type: String) {
    @SerializedName("bounce")
    BOUNCE("bounce"),
    @SerializedName("click")
    CLICK("click"),
    @SerializedName("open")
    OPEN("open")
}