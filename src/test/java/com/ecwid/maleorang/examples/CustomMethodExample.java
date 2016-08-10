package com.ecwid.maleorang.examples;

import com.ecwid.maleorang.MailchimpClient;
import com.ecwid.maleorang.MailchimpMethod;
import com.ecwid.maleorang.MailchimpObject;
import com.ecwid.maleorang.annotation.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Demonstrates how to create and use your own implementation of a MailChimp method.
 */
public class CustomMethodExample {
    private final String apiKey, listId;

    /**
     * Custom implementation for http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/#edit-put_lists_list_id_members_subscriber_hash method.
     */
    @Method(httpMethod = HttpMethod.PUT, version = APIVersion.v3_0, path = "/lists/{list_id}/members/{subscriber_hash}")
    private static class SubscribeRequest extends MailchimpMethod<SubscribeResponse> {
        /**
         * This param will be included into the endpoint path.
         */
        @PathParam
        public final String list_id;

        /**
         * This param will be included into the endpoint path.
         */
        @PathParam
        public final String subscriber_hash;

        /**
         * This param will be included into the query string.
         * It is not a part of the method API and is added here just for demonstration.
         */
        @QueryStringParam
        public final String dummy = "dummy";

        /**
         * This param will be included into the request body.
         */
        @Field
        public final String email_address;

        /**
         * This param will be included into the request body.
         */
        @Field
        public String status;

        /**
         * This param will be included into the request body.
         */
        @Field
        public MergeFields merge_fields;

        public SubscribeRequest(String listId, String email) {
            this.list_id = listId;
            this.subscriber_hash = DigestUtils.md5Hex(email.toLowerCase());
            this.email_address = email;
        }
    }

    private static class SubscribeResponse extends MailchimpObject {
        @Field
        public String id;

        @Field
        public String email_address;

        @Field
        public String status;

        @Field
        public MergeFields merge_fields;
    }

    private static class MergeFields extends MailchimpObject {
        @Field
        public String FNAME, LNAME;
    }

    @Parameters({"mailchimp.test.apikey", "mailchimp.test.listid"})
    public CustomMethodExample(String apiKey, String listId) {
        this.apiKey = apiKey;
        this.listId = listId;
    }

    /**
     * Subscribes a user to list.
     */
    @Test
    public void run() throws Exception {
        MailchimpClient client = new MailchimpClient(apiKey);
        try {
            SubscribeRequest request = new SubscribeRequest(listId, "vasya.pupkin@gmail.com");
            request.status = "subscribed";
            request.merge_fields = new MergeFields();
            request.merge_fields.FNAME = "Vasya";
            request.merge_fields.LNAME = "Pupkin";

            SubscribeResponse response = client.execute(request);
            System.err.println("The user has been successfully subscribed: " + response);
        } finally {
            client.close();
        }
    }

}
