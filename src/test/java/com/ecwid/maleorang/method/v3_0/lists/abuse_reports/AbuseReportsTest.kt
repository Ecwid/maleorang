package com.ecwid.maleorang.method.v3_0.lists.members

import com.ecwid.maleorang.MailchimpClient
import com.ecwid.maleorang.connector.Connector
import com.ecwid.maleorang.connector.HttpClientConnector
import com.ecwid.maleorang.method.v3_0.lists.GetAbuseReportMethod
import com.ecwid.maleorang.method.v3_0.lists.GetAbuseReportsMethod
import org.mockito.Mockito.`when`
import org.mockito.Mockito.spy
import org.testng.Assert
import org.testng.annotations.Parameters
import org.testng.annotations.Test

class AbuseReportsTest
@Parameters("mailchimp.test.apikey", "mailchimp.test.listid", "mailchimp.test.abusereportid")
constructor(private val apiKey: String, private val listId: String, private val abuseReportId: String) {

    var json = "{\"id\": 42,\"campaign_id\": \"839488a60b\",\"list_id\": \"1a2df69511\",\"email_id\": \"62eeb292278cc15f5817cb78f7790b08\",\"email_address\": \"urist.mcvankab@freddiesjokes.com\",\"date\": \"2015-07-15T19:19:31+00:00\",\"links\": [{\"rel\": \"self\",\"href\": \"https://usX.api.mailchimp.com/3.0/lists/1a2df69511/abuse-reports/42\",\"method\": \"GET\",\"targetSchema\": \"https://api.mailchimp.com/schema/3.0/Lists/Abuse/Instance.json\" },{ \"rel\": \"parent\",\"href\": \"https://usX.api.mailchimp.com/3.0/lists/1a2df69511/abuse-reports\",\"method\": \"GET\",\"targetSchema\": \"https://api.mailchimp.com/schema/3.0/Lists/Abuse/Collection.json\",\"schema\": \"https://api.mailchimp.com/schema/3.0/CollectionLinks/Lists/Abuse.json\" }]}"
    var request = Connector.Request("", "", "", "", "")
    var response = Connector.Response(200, "", json)

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

        var connector = HttpClientConnector()
        var spiedConnector = spy(connector)
//        when(spiedConnector.call()).thenReturn(response);

//        val connector = `mock`(HttpClientConnector::class.java)
        `when`(spiedConnector.call(request)).thenReturn(response)

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
