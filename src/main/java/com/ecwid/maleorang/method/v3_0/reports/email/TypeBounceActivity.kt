package com.ecwid.maleorang.method.v3_0.reports.email

import com.google.gson.annotations.SerializedName

/**
 * Created by larar on 15/10/2016.
 */

enum class TypeBounceActivity(val type: String) {
    @SerializedName("hard")
    HARD("hard"),
    @SerializedName("soft")
    SOFT("soft"),
    @SerializedName("null")
    NONE("null")
}