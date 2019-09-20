package com.ecwid.maleorang.examples;

import com.ecwid.maleorang.MailchimpClient;
import com.ecwid.maleorang.MailchimpObject;
import com.ecwid.maleorang.method.v3_0.lists.members.EditMemberMethod;
import com.ecwid.maleorang.method.v3_0.lists.members.MemberInfo;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Demonstrates how to use an existing method implementation (namely {@link com.ecwid.maleorang.method.v3_0.lists.members.EditMemberMethod.CreateOrUpdate}).
 */
public class ExistingMethodExample {

    private final String apiKey, listId;

    @Parameters({"mailchimp.test.apikey", "mailchimp.test.listid"})
    private ExistingMethodExample(String apiKey, String listId) {
        this.apiKey = apiKey;
        this.listId = listId;
    }

    /**
     * Subscribes a user to a list.
     */
    @Test
    public void subscribeUserToList() throws Exception {
        MailchimpClient client = new MailchimpClient(apiKey);
        try {
            EditMemberMethod.CreateOrUpdate method = new EditMemberMethod.CreateOrUpdate(listId, "vasya.pupkin@gmail.com");
            method.status = "subscribed";
            method.merge_fields = new MailchimpObject();
            method.merge_fields.mapping.put("FNAME", "Vasya");
            method.merge_fields.mapping.put("LNAME", "Pupkin");

            MemberInfo member = client.execute(method);
            System.err.println("The user has been successfully subscribed: " + member);
        } finally {
            client.close();
        }
    }

    /**
     * Subscribes a user to a list using a client with custom timeOut parameters.
     */
    @Test
    public void usingClientWithTimeOutParameters() throws Exception {
        Integer connectTimeOut = 25000;
        int socketTimeOut = 400000;
        int connectionRequestTimeOut = 25000;
        MailchimpClient client = new MailchimpClient(apiKey,connectTimeOut,socketTimeOut,connectionRequestTimeOut);
        try {
            EditMemberMethod.CreateOrUpdate method = new EditMemberMethod.CreateOrUpdate(listId, "vasya.pupkin@gmail.com");
            method.status = "subscribed";
            method.merge_fields = new MailchimpObject();
            method.merge_fields.mapping.put("FNAME", "Vasya2");
            method.merge_fields.mapping.put("LNAME", "Pupkin2");

            MemberInfo member = client.execute(method);
            System.err.println("The user has been successfully subscribed: " + member);
        } finally {
            client.close();
        }
    }



}
