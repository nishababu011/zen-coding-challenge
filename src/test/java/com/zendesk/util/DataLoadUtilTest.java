package com.zendesk.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DataLoadUtilTest {

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
