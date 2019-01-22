package com.zendesk.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataLoadUtilTest {

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
	public void testLoadDataByType() {
		Object[] objNull = DataLoadUtil.loadDataByType(null, null);
		assertNull(objNull);

	}

	@Test
	public void testLoadDataByTypeForUser() {
		// Users
		Object[] objUsers = DataLoadUtil.loadDataByType(SearchConstants.SEARCH_FIELD_USERS,
				SearchConstants.SEARCH_FIELD_USERS_FILE_PATH);
		assertNotNull(objUsers);

	}

	@Test
	public void testLoadDataByTypeForTickets() {
		// Tickets
		Object[] objTickets = DataLoadUtil.loadDataByType(SearchConstants.SEARCH_FIELD_TICKETS,
				SearchConstants.SEARCH_FIELD_TICKETS_FILE_PATH);
		assertNotNull(objTickets);

	}

	@Test
	public void testLoadDataByTypeForOrganisation() {
		// Organizations
		Object[] objOrgs = DataLoadUtil.loadDataByType(SearchConstants.SEARCH_FIELD_ORGANIZATIONS,
				SearchConstants.SEARCH_FIELD_ORGANIZATIONS_FILE_PATH);
		assertNotNull(objOrgs);
	}

}
