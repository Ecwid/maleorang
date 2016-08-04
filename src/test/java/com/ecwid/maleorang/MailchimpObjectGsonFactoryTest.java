package com.ecwid.maleorang;

import com.ecwid.maleorang.annotation.Field;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;

public class MailchimpObjectGsonFactoryTest {

	private static class PlainOldObject {
		@Expose(serialize=true, deserialize=true) // has no effect
		String ignored = "ignored";
	}

	private static class TestObject extends MailchimpObject {
		@Field
		@Expose(serialize=false, deserialize=false) // has no effect
		@SerializedName("hasNoEffect") // has no effect
		Date date;

		@Field
		@Expose(serialize=false, deserialize=false) // has no effect
		@SerializedName("hasNoEffect") // has no effect
		Timestamp timestamp;

		@Field
		@Expose(serialize=false, deserialize=false) // has no effect
		@SerializedName("hasNoEffect") // has no effect
		Integer integer;

		@Field
		@Expose(serialize=false, deserialize=false) // has no effect
		@SerializedName("hasNoEffect") // has no effect
		MailchimpObject object;

		@Field
		@Expose(serialize=false, deserialize=false) // has no effect
		@SerializedName("hasNoEffect") // has no effect
		TestObject child;

		@Field(name="children_array")
		@Expose(serialize=false, deserialize=false) // has no effect
		@SerializedName("hasNoEffect") // has no effect
		TestObject array[];

		@Field(name="children_list")
		@Expose(serialize=false, deserialize=false) // has no effect
		@SerializedName("hasNoEffect") // has no effect
		List<TestObject> list;

		@Field
		PlainOldObject plainOldObject;

		@Expose(serialize=true, deserialize=true) // has no effect
		String ignored = "ignored";
	}

	@Test
	public void test() {
		Gson gson = MailchimpObjectGsonFactory.INSTANCE.createGson();

		TestObject o = new TestObject();
		o.date = new Date(0);
		o.timestamp = new Timestamp(0);
		o.integer = 666;
		o.object = new MailchimpObject();
		o.object.mapping.put("key", "value");
		o.child = new TestObject();
		o.child.integer = 555;
		o.array = new TestObject[] { new TestObject() };
		o.array[0].integer = 111;
		o.list = Arrays.asList(new TestObject());
		o.list.get(0).integer = 222;
		o.plainOldObject = new PlainOldObject();

		JsonObject json = gson.toJsonTree(o).getAsJsonObject();
		assertEquals(json.entrySet().size(), 8);
		assertEquals(json.get("date").getAsString(), "1970-01-01T00:00:00Z");
		assertEquals(json.get("timestamp").getAsString(), "1970-01-01T00:00:00Z");
		assertEquals(json.get("integer").getAsInt(), 666);
		assertEquals(json.get("object").getAsJsonObject().get("key").getAsString(), "value");
		assertEquals(json.get("child").getAsJsonObject().get("integer").getAsInt(), 555);
		assertEquals(json.get("children_array").getAsJsonArray().get(0).getAsJsonObject().get("integer").getAsInt(), 111);
		assertEquals(json.get("children_list").getAsJsonArray().get(0).getAsJsonObject().get("integer").getAsInt(), 222);
		assertEquals(json.get("plainOldObject").getAsJsonObject().entrySet().size(), 0);
		assertNull(json.get("ignored"));
		json.addProperty("ignored", "really ignored?");
		json.get("plainOldObject").getAsJsonObject().addProperty("ignored", "really ignored?");

		o = gson.fromJson(json, TestObject.class);
		assertEquals(o.date, new Date(0));
		assertEquals(o.timestamp, new Timestamp(0));
		assertEquals((int) o.integer, 666);
		assertEquals(o.object.mapping.get("key"), "value");
		assertEquals((int) o.child.integer, 555);
		assertEquals((int) o.array[0].integer, 111);
		assertEquals((int) o.list.get(0).integer, 222);
		assertEquals(o.ignored, "ignored");
		assertEquals(o.plainOldObject.ignored, "ignored");
	}

	@Test
	public void testDeserialization_untyped() {
		Gson gson = MailchimpObjectGsonFactory.INSTANCE.createGson();

		MailchimpObject test1 = gson.fromJson("{ test1:{test1:{test1:{test1:{}}}} }", MailchimpObject.class);
		assertEquals(test1.getClass(), MailchimpObject.class);
		test1 = (MailchimpObject) test1.mapping.get("test1");
		assertEquals(test1.getClass(), MailchimpObject.class);
		test1 = (MailchimpObject) test1.mapping.get("test1");
		assertEquals(test1.getClass(), MailchimpObject.class);
		test1 = (MailchimpObject) test1.mapping.get("test1");
		assertEquals(test1.getClass(), MailchimpObject.class);
		test1 = (MailchimpObject) test1.mapping.get("test1");
		assertEquals(test1.getClass(), MailchimpObject.class);
		assertNull(test1.mapping.get("test1"));

		MailchimpObject test2 = gson.fromJson("{ 'test2':[{\"test2\":[{},{}]},true,[{}]] }", MailchimpObject.class);
		assertEquals(test2.getClass(), MailchimpObject.class);
		Iterator i = ((List) test2.mapping.get("test2")).iterator();

		test2 = (MailchimpObject) i.next();
		assertEquals(test2.getClass(), MailchimpObject.class);
		assertEquals(((List) test2.mapping.get("test2")).size(), 2);
		assertEquals(((List) test2.mapping.get("test2")).get(0).getClass(), MailchimpObject.class);
		assertEquals(((List) test2.mapping.get("test2")).get(1).getClass(), MailchimpObject.class);

		assertEquals(i.next(), true);

		List<?> test2_list = (List) i.next();
		assertEquals(test2_list.size(), 1);
		test2 = (MailchimpObject) test2_list.get(0);
		assertEquals(test2.getClass(), MailchimpObject.class);

		assertFalse(i.hasNext());
	}
}
