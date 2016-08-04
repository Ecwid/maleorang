package com.ecwid.maleorang.examples;

import com.ecwid.maleorang.MailchimpClient;
import com.ecwid.maleorang.MailchimpObject;
import com.ecwid.maleorang.method.v3_0.members.EditMemberMethod;
import com.ecwid.maleorang.method.v3_0.members.MemberInfo;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by basil on 09.08.16.
 */
public class MembersMethodsExample {

    private final String apiKey, listId;

    @Parameters({"mailchimp.test.apikey", "mailchimp.test.listid"})
    private MembersMethodsExample(String apiKey, String listId) {
        this.apiKey = apiKey;
        this.listId = listId;
    }

    /**
     * This example shows how to subsribe a user.
     */
    @Test
    public void run() throws Exception {
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
}
