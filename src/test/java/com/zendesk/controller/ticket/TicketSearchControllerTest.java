package com.zendesk.controller.ticket;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zendesk.config.SearchConfig;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;
import com.zendesk.initialiser.SearchDataInitialiser;
import com.zendesk.util.TicketSearchConstants;

public class TicketSearchControllerTest {
	
	TicketSearchController ticketSearchController;

	SearchCriteria searchCriteria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SearchDataInitialiser.loadSearchData();
		SearchConfig.loadConfig();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ticketSearchController = new TicketSearchController();
		searchCriteria = new SearchCriteria();
		
	}

	@After
	public void tearDown() throws Exception {
		ticketSearchController = null;
		searchCriteria = null;
		
	}

	@Test
	public void testPerformSearchForId() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_ID);
		searchCriteria.setFieldValue("436bf9b0-1147-4c0a-8439-6f79833bff5b");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_ID);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForUrl() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_URL);
		searchCriteria.setFieldValue("http://initech.zendesk.com/api/v2/tickets/436bf9b0-1147-4c0a-8439-6f79833bff5b.json");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_URL);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForExternalId() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_EXTERNAL_ID);
		searchCriteria.setFieldValue("9210cdc9-4bee-485f-a078-35396cd74063");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_EXTERNAL_ID);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForCreatedAt() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_CREATED_AT);
		searchCriteria.setFieldValue("2016-04-28T11:19:34 -10:00");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_CREATED_AT);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForType() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_TYPE);
		searchCriteria.setFieldValue("incident");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_TYPE);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForSubject() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_SUBJECT);
		searchCriteria.setFieldValue("A Catastrophe in Korea (North)");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_SUBJECT);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForDescription() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_DESCRIPTION);
		searchCriteria.setFieldValue("Nostrud ad sit velit cupidatat laboris ipsum nisi amet laboris ex exercitation amet et proident. Ipsum fugiat aute dolore tempor nostrud velit ipsum.");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_DESCRIPTION);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForPriority() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_PRIORITY);
		searchCriteria.setFieldValue("high");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_PRIORITY);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForStatus() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_STATUS);
		searchCriteria.setFieldValue("pending");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_STATUS);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForSubmitterId() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_SUBMITTER_ID);
		searchCriteria.setFieldValue("38");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_SUBMITTER_ID);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForAssigneeId() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_ASSIGNEE_ID);
		searchCriteria.setFieldValue("24");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_ASSIGNEE_ID);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForOrganzationId() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_ORGANIZATION_ID);
		searchCriteria.setFieldValue("116");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_ORGANIZATION_ID);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForDueDate() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_DUE_AT);
		searchCriteria.setFieldValue("2016-07-31T02:37:50 -10:00");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_DUE_AT);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForVia() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_VIA);
		searchCriteria.setFieldValue("web");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_VIA);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForTags() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_TAGS);
		searchCriteria.setFieldValue("Ohio");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_TAGS);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForHasIncidents() throws InvalidUserInputException {

		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_HAS_INCIDENTS);
		searchCriteria.setFieldValue("false");
		ticketSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());
		
		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_HAS_INCIDENTS);
		searchCriteria.setFieldValue("tt");
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_HAS_INCIDENTS);
		searchCriteria.setFieldValue(null);
		ticketSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

}
