package com.ecwid.maleorang.method.v3_0.reports.sent_to

import com.ecwid.maleorang.MailchimpClient
import org.testng.Assert
import org.testng.annotations.Parameters
import org.testng.annotations.Test


class SentToTest
@Parameters("mailchimp.test.apikey")
constructor(private val apiKey: String) {

    val campaignId = ""

    @Test (enabled = false)
    fun testGetSentTo(){
        MailchimpClient(apiKey).use { client ->
            client.execute(GetSentToMethod(campaignId)).apply {
                Assert.assertNotNull(sent_to)
                Assert.assertNotNull(campaign_id)
                Assert.assertNotNull(total_items)
                println(total_items)
                val result = sent_to
                if (result!=null){
                    result.iterator().forEach {
                        println(it)
                    }
                }
            }

        }
    }

}