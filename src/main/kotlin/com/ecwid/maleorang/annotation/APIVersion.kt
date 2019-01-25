package com.ecwid.maleorang.annotation


/**
 * MailChimp API version.
 */
enum class APIVersion {
    v3_0;

    /**
     * MailChimp API version string representation.
     */
    override fun toString(): String = name.substring(1).replace("_", ".")
}
