package com.saltbrook.datamodel;

import org.junit.jupiter.api.Assertions;

public class BaseUnitTestCase {
	
	protected void assertEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}
	
	protected void assertNull(Object obj) {
		Assertions.assertNull(obj);
	}
	
	protected void assertNotNull(Object obj) {
		Assertions.assertNotNull(obj);
	}
	
	protected void assertSame(Object expected, Object actual) {
		Assertions.assertSame(expected, actual);
	}
	
	protected void assertNotSame(Object expected, Object actual) {
		Assertions.assertNotSame(expected, actual);
	}
	
	protected void assertTrue(boolean condition) {
		Assertions.assertTrue(condition);
	}
}
