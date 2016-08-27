package com.ecwid.maleorang.method.v3_0.lists

import com.ecwid.maleorang.MailchimpClient
import org.testng.Assert
import org.testng.annotations.Parameters
import org.testng.annotations.Test

/**
 * Created by apocheau on 27/08/16.
 */
class ListsTest
@Parameters("mailchimp.test.apikey", "mailchimp.test.listid")
constructor(private val apiKey: String, private val listId: String) {

    @Test
    fun testGetList() {
        MailchimpClient(apiKey).use { client ->
            client.execute(GetListMethod(listId)).apply {
                Assert.assertNotNull(id)
                Assert.assertNotNull(name)
            }
        }
    }

    @Test
    fun testGetLists() {
        MailchimpClient(apiKey).use { client ->
            client.execute(GetListsMethod()).apply {
                Assert.assertNotNull(lists)
                Assert.assertNotNull(total_items)
            }
        }
    }
}