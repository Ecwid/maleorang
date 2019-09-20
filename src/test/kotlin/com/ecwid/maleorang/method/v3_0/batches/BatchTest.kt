package com.ecwid.maleorang.method.v3_0.batches

import com.ecwid.maleorang.MailchimpClient
import com.ecwid.maleorang.MailchimpException
import com.ecwid.maleorang.method.v3_0.lists.members.DeleteBatchMethod
import com.ecwid.maleorang.method.v3_0.lists.members.DeleteMemberMethod
import com.ecwid.maleorang.method.v3_0.lists.members.EditMemberMethod
import org.testng.Assert.*
import org.testng.annotations.Parameters
import org.testng.annotations.Test

class BatchTest
@Parameters("mailchimp.test.apikey", "mailchimp.test.listid")
constructor(private val apiKey: String, private val listId: String) {

    @Test
    fun testGetBatches() {
        MailchimpClient(apiKey).use { client ->
            client.execute(GetBatchesStatusMethod()).apply {
                assertNotNull(batches)
                assertNotNull(total_items)
            }
        }
    }

    @Test
    fun testCreateGetAndDelete() {
        MailchimpClient(apiKey).use { client ->
            val batchId = client.execute(StartBatchMethod(listOf(
                    EditMemberMethod.CreateOrUpdate(listId, "vasya.pupkin@gmail.com"),
                    DeleteMemberMethod(listId, "vasya.pupkin@gmail.com")
            ))).id!!

            client.execute(GetBatchStatusMethod(batchId)).apply {
                assertEquals(id, batchId)
                assertNotNull(status)
            }

            client.execute(DeleteBatchMethod(batchId));

            try {
                client.execute(GetBatchStatusMethod(batchId))
                fail()
            } catch(e: MailchimpException) {
                assertEquals(e.code, 404)
            }
        }
    }
}