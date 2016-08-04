package com.ecwid.maleorang

/**
 * Indicates a MailChimp API error.
 */
class MailchimpException(
        /**
         * Error code.
         */
        @JvmField
        val code: Int,

        /**
         * Error description.
         */
        @JvmField
        val description: String
) : Exception("API Error ($code): $description")
