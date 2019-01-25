package com.ecwid.maleorang;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class MailchimpMethodTest {
	@Test
	public void testGetResultType() throws Exception {
		class Result extends MailchimpObject { }
		class Method extends MailchimpMethod<Result> { }

		assertEquals(new Method().getResultType(), Result.class);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetResultType_BadParam() {
		class Result extends MailchimpObject { }
		class Method<T extends MailchimpObject> extends MailchimpMethod<T> { }

		new Method<Result>().getResultType();
	}
}
