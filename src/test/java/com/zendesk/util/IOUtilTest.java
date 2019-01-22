package com.zendesk.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IOUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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

}
