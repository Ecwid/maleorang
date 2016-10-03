package com.ecwid.maleorang.method.v3_0.lists.members

import com.ecwid.maleorang.MailchimpClient
import com.ecwid.maleorang.method.v3_0.lists.GetAbuseReportMethod
import com.ecwid.maleorang.method.v3_0.lists.GetAbuseReportsMethod
import org.testng.Assert
import org.testng.annotations.Parameters
import org.testng.annotations.Test

class AbuseReportsTest
@Parameters("mailchimp.test.apikey", "mailchimp.test.listid", "mailchimp.test.abusereportid")
constructor(private val apiKey: String, private val listId: String, private val abuseReportId: String) {

    @Test
    fun testGetAbuseReports() {
        MailchimpClient(apiKey).use { client ->
            client.execute(GetAbuseReportsMethod(listId)).apply {
                Assert.assertNotNull(listId)
                Assert.assertNotNull(_links)
                Assert.assertNotNull(abuse_reports)
                Assert.assertNotNull(total_items)
            }
        }
    }

    @Test
    fun testGetAbuseReport() {
        MailchimpClient(apiKey).use { client ->
            client.execute(GetAbuseReportMethod(listId, abuseReportId)).apply {
                Assert.assertNotNull(id)
                Assert.assertNotNull(campaign_id)
                Assert.assertNotNull(listId)
                Assert.assertNotNull(email_id)
                Assert.assertNotNull(email_address)
                Assert.assertNotNull(merge_fields)
                Assert.assertNotNull(vip)
                Assert.assertNotNull(date)
                Assert.assertNotNull(_links)
            }
        }
    }
}
