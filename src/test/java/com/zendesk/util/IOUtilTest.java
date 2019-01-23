package com.zendesk.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class IOUtilTest {


	@Test
	public void testReadFile() {
		byte[]  dataU = IOUtil.readFile(SearchConstants.SEARCH_FIELD_USERS_FILE_PATH);
		assertNotNull(dataU);
		byte[]  dataT = IOUtil.readFile(SearchConstants.SEARCH_FIELD_TICKETS_FILE_PATH);
		assertNotNull(dataT);
		byte[]  dataO = IOUtil.readFile(SearchConstants.SEARCH_FIELD_ORGANIZATIONS_FILE_PATH);
		assertNotNull(dataO);
		
		byte[]  dataN = IOUtil.readFile(SearchConstants.SEARCH_FIELD_TICKETS);
		assertNull(dataN);
		
		byte[]  dataEmpty = IOUtil.readFile(null);
		assertNull(dataEmpty);
	}


	@Test
	public void testParseDate() {
		Date date = IOUtil.parseDate("2016-04-15T05:19:46 -10:00", "yyyy-MM-dd'T'HH:mm:ss");
		assertNotNull(date);
	}
	
	@Test
	public void testParseDatewithNull() {
		Date date = IOUtil.parseDate("", "yyyy-MM-dd'T'HH:mm:ss");
		assertNull(date);
		Date dateBlank = IOUtil.parseDate("", "");
		assertNull(dateBlank);
		
		Date dateNull = IOUtil.parseDate(null, null);
		assertNull(dateNull);
	}
	
	@Test
	public void testParseBooleanwithNull() {
		Boolean booleanStr = IOUtil.parseBoolean("");
		assertNull(booleanStr);
		
		 booleanStr = IOUtil.parseBoolean(null);
		assertNull(booleanStr);
	}
	
	@Test
	public void testParseBoolean() {
		Boolean booleanStr = IOUtil.parseBoolean("true");
		assertTrue(booleanStr);
		
		 booleanStr = IOUtil.parseBoolean("false");
		assertFalse(booleanStr);
	}

}
