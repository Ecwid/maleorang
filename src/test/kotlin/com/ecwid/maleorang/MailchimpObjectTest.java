package com.ecwid.maleorang;

import com.ecwid.maleorang.annotation.Field;
import com.ecwid.maleorang.util.ClassUtil;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;


public class MailchimpObjectTest {

    private static class TestBase extends MailchimpObject {
        @Field
        String f1;
    }

    private static class TestObject extends TestBase {
        @Field
        int f2;

        @Field(name="f-3")
        Date f3;

        String ignored;
    }

    @Test
    public void testGetMailchimpObjectFields() {
        TestObject o = new TestObject();
        assertEquals(o.mapping.size(), 3);

        Iterator<Map.Entry<String, java.lang.reflect.Field>> i = ClassUtil.INSTANCE.getMailchimpObjectFields(o.getClass()).entrySet().iterator();
        Map.Entry<String, java.lang.reflect.Field> entry = i.next();
        assertEquals(entry.getKey(), "f1");
        assertEquals(entry.getValue().getType(), String.class);
        entry = i.next();
        assertEquals(entry.getKey(), "f2");
        assertEquals(entry.getValue().getType(), int.class);
        entry = i.next();
        assertEquals(entry.getKey(), "f-3");
        assertEquals(entry.getValue().getType(), Date.class);
        assertFalse(i.hasNext());
    }

    @Test
    public void testPutAndGet() {
        TestObject o = new TestObject();
        assertEquals(o.mapping.size(), 3);

        o.f1 = "f1_value";
        o.f2 = 666;
        o.mapping.put("f-3", new Date(123456));
        o.mapping.put("f-4", new Date(654321));

        assertEquals(o.mapping.size(), 4);
        assertEquals(o.mapping.get("f1"), "f1_value");
        assertEquals(o.mapping.get("f2"), 666);
        assertEquals(o.mapping.get("f-3"), new Date(123456));
        assertEquals(o.mapping.get("f-4"), new Date(654321));
        assertEquals(o.f3, new Date(123456));

        assertEquals(o.mapping.put("f2", 777), 666);
        assertEquals(o.mapping.get("f2"), 777);
        assertEquals(o.f2, 777);

        assertEquals(o.mapping.put("f-4", 777), new Date(654321));
        assertEquals(o.mapping.get("f-4"), 777);

        try {
            o.mapping.put("f2", "a string");
            fail();
        } catch(IllegalArgumentException e) {
            // types mismatch
        }
    }

    @Test
    public void testContains() {
        TestObject o = new TestObject();
        assertEquals(o.mapping.size(), 3);

        assertTrue(o.mapping.containsKey("f1"));
        assertTrue(o.mapping.containsKey("f2"));
        assertTrue(o.mapping.containsKey("f-3"));
        assertFalse(o.mapping.containsKey("f-4"));

        assertFalse(o.mapping.containsValue("f1_value"));
        o.f1 = "f1_value";
        assertTrue(o.mapping.containsValue("f1_value"));

        assertFalse(o.mapping.containsValue(666));
        o.f2 = 666;
        assertTrue(o.mapping.containsValue(666));

        assertFalse(o.mapping.containsValue(new Date(111222333)));
        o.f3 = new Date(111222333);
        assertTrue(o.mapping.containsValue(new Date(111222333)));

        assertFalse(o.mapping.containsValue(MailchimpObjectTest.this));
        o.mapping.put("f-4", MailchimpObjectTest.this);
        assertTrue(o.mapping.containsValue(MailchimpObjectTest.this));
    }

    @Test
    public void testRemove() {
        TestObject o = new TestObject();

        assertEquals(o.mapping.size(), 3);
        assertNull(o.mapping.remove("f-4"));
        assertEquals(o.mapping.size(), 3);
        o.mapping.put("f-4", null);
        assertEquals(o.mapping.size(), 4);
        assertNull(o.mapping.remove("f-4"));
        assertEquals(o.mapping.size(), 3);
        o.mapping.put("f-4", new Date(654321));
        assertEquals(o.mapping.size(), 4);
        assertEquals(o.mapping.remove("f-4"), new Date(654321));
        assertEquals(o.mapping.size(), 3);

        try {
            o.mapping.remove("f-3");
            fail();
        } catch (IllegalArgumentException e) {
            // cannot remove reflective mapping
        }
    }

    @Test
    public void testClear() {
        TestObject o = new TestObject();
        try {
            o.mapping.clear();
            fail();
        } catch(IllegalArgumentException e) {
            // cannot remove reflective mapping
        }
    }

    @Test
    public void testKeySet() {
        TestObject o = new TestObject();
        Set<String> set = o.mapping.keySet();

        o.mapping.put("f-4", 111);
        assertEquals(set.size(), 4);

        Iterator<String> i = set.iterator();
        assertEquals(i.next(), "f1");
        assertEquals(i.next(), "f2");
        assertEquals(i.next(), "f-3");

        try {
            i.remove();
            fail();
        } catch (IllegalArgumentException e) {
            // cannot remove reflective mapping
        }

        assertEquals(set.size(), 4);
        assertEquals(i.next(), "f-4");
        i.remove();
        assertFalse(i.hasNext());
        assertEquals(set.size(), 3);

        assertTrue(set.contains("f-3"));
        assertFalse(set.contains("rrr"));
        o.mapping.put("rrr", null);
        assertTrue(set.contains("rrr"));
        assertEquals(set.size(), 4);
        assertTrue(set.remove("rrr"));
        assertFalse(set.contains("rrr"));
        assertFalse(set.remove("rrr"));
        assertEquals(set.size(), 3);

        try {
            o.mapping.remove("f-3");
            fail();
        } catch (IllegalArgumentException e) {
            // cannot remove reflective mapping
        }
    }

    @Test
    public void testValues() {
        TestObject o = new TestObject();

        assertFalse(o.mapping.values().contains(new Date(666)));
        o.f3 = new Date(666);
        assertTrue(o.mapping.values().contains(new Date(666)));

        assertFalse(o.mapping.values().contains(111));
        o.mapping.put("f-4", 111);
        assertTrue(o.mapping.values().contains(111));

        Iterator<Object> i = o.mapping.values().iterator();
        assertNull(i.next());
        assertEquals(i.next(), 0);
        assertEquals(i.next(), new Date(666));

        try {
            i.remove();
            fail();
        } catch (IllegalArgumentException e) {
            // cannot remove reflective mapping
        }

        assertEquals(i.next(), 111);
        assertFalse(i.hasNext());

        assertEquals(o.mapping.size(), 4);
        i.remove();
        assertEquals(o.mapping.size(), 3);
        assertFalse(i.hasNext());
    }

    @Test
    public void testEntrySet() {
        TestObject o = new TestObject();
        Set<Map.Entry<String, Object>> set = o.mapping.entrySet();

        o.f3 = new Date(222222);
        assertEquals(set.size(), 3);
        o.mapping.put("f-4", 456);
        assertEquals(set.size(), 4);

        assertTrue(set.contains(new AbstractMap.SimpleEntry<String, Object>("f1", null)));
        assertFalse(set.contains(new AbstractMap.SimpleEntry<String, Object>("f-3", null)));
        assertTrue(set.contains(new AbstractMap.SimpleEntry<String, Object>("f-3", new Date(222222))));
        assertTrue(set.contains(new AbstractMap.SimpleEntry<String, Object>("f-4", 456)));
        assertFalse(set.contains(new AbstractMap.SimpleEntry<String, Object>("f-5", 456)));

        assertFalse(set.remove(new AbstractMap.SimpleEntry<Object, Object>("f1", 777)));
        assertEquals(set.size(), 4);
        try {
            set.remove(new AbstractMap.SimpleEntry<Object, Object>("f1", null));
            fail();
        } catch (IllegalArgumentException e) {
            // cannot remove reflective mapping
        }

        assertTrue(set.remove(new AbstractMap.SimpleEntry<Object, Object>("f-4", 456)));
        assertEquals(set.size(), 3);
    }
}