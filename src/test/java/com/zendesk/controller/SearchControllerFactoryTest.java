package com.zendesk.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zendesk.controller.organization.OrganizationSearchController;
import com.zendesk.controller.ticket.TicketSearchController;
import com.zendesk.controller.user.UserSearchController;
import com.zendesk.util.SearchConstants;

public class SearchControllerFactoryTest {
	SearchControllerFactory searchControllerFactory;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		searchControllerFactory = new SearchControllerFactory();
	}

	@After
	public void tearDown() throws Exception { 
		searchControllerFactory = null;
	}

	@Test
	public void testGetSearchControllerByTypeForNull() {
		SearchController searchController = searchControllerFactory.getSearchControllerByType(null);
		assertNull(searchController);
	}
	
	@Test
	public void testGetSearchControllerByTypeForBlank() {
		SearchController searchController = searchControllerFactory.getSearchControllerByType("");
		assertNull(searchController);
	}
	
	@Test
	public void testGetSearchControllerByTypeForUser() {
		SearchController searchController = searchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_USERS);
		assertNotNull(searchController);
		assertTrue(searchController instanceof UserSearchController);
	}
	
	@Test
	public void testGetSearchControllerByTypeForTickets() {
		SearchController searchController = searchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_TICKETS);
		assertNotNull(searchController);
		assertTrue(searchController instanceof TicketSearchController);
	}
	
	@Test
	public void testGetSearchControllerByTypeForOrg() {
		SearchController searchController = searchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_ORGANIZATIONS);
		assertNotNull(searchController);
		assertTrue(searchController instanceof OrganizationSearchController);
	}

}
