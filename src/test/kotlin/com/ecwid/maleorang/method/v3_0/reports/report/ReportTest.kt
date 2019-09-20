package com.ecwid.maleorang.method.v3_0.reports.report
import com.ecwid.maleorang.MailchimpClient
import org.testng.Assert
import org.testng.annotations.Test
import org.testng.annotations.Parameters

class ReportTest
@Parameters("mailchimp.test.apikey")
constructor(private val apiKey: String) {

    @Test
    fun testGetReport(){
        MailchimpClient(apiKey).use { client ->
            client.execute(GetReportMethod()).apply {
                Assert.assertNotNull(reports)
                Assert.assertNotNull(total_items)
                val result = reports
                if (result!=null){
                    result.iterator().forEach { println(it) }
                }
            }

        }
    }

}
