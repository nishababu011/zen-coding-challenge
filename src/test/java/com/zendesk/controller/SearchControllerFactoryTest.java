package com.zendesk.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zendesk.controller.organization.OrganizationSearchController;
import com.zendesk.controller.ticket.TicketSearchController;
import com.zendesk.controller.user.UserSearchController;
import com.zendesk.util.SearchConstants;

public class SearchControllerFactoryTest {

	@Test
	public void testGetSearchControllerByTypeForNull() {
		SearchController searchController = SearchControllerFactory.getSearchControllerByType(null);
		assertNull(searchController);
	}
	
	@Test
	public void testGetSearchControllerByTypeForBlank() {
		SearchController searchController = SearchControllerFactory.getSearchControllerByType("");
		assertNull(searchController);
	}
	
	@Test
	public void testGetSearchControllerByTypeForUser() {
		SearchController searchController = SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_USERS);
		assertNotNull(searchController);
		assertTrue(searchController instanceof UserSearchController);
	}
	
	@Test
	public void testGetSearchControllerByTypeForTickets() {
		SearchController searchController = SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_TICKETS);
		assertNotNull(searchController);
		assertTrue(searchController instanceof TicketSearchController);
	}
	
	@Test
	public void testGetSearchControllerByTypeForOrg() {
		SearchController searchController = SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_ORGANIZATIONS);
		assertNotNull(searchController);
		assertTrue(searchController instanceof OrganizationSearchController);
	}

}
