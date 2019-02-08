package com.ecwid.maleorang

import org.testng.Assert
import org.testng.annotations.Test
import org.testng.Assert.assertEquals

class MailchimpClientTest {

    @Test
    fun test_ConstrutorWithoutOptionalParameteres(){

        val apiKey  = "mockKey"
        val client = MailchimpClient(apiKey)
        Assert.assertNotNull(client.socketTimeOut)
        Assert.assertNotNull(client.connectTimeOut)
        Assert.assertNotNull(client.connectionRequestTimeOut)

    }

    @Test
    fun test_ConstructorWithOptionalParameters(){

        val apiKey  = "234"
        val socketTimeOut = 1111
        val connectionTimeOut = 2345
        val requestConnectionTimeOut = 6789

        val client = MailchimpClient(apiKey,socketTimeOut,connectionTimeOut,requestConnectionTimeOut)
        assertEquals(client.socketTimeOut,socketTimeOut)
        assertEquals(client.connectTimeOut,connectionTimeOut)
        assertEquals(client.connectionRequestTimeOut,requestConnectionTimeOut)

    }

}