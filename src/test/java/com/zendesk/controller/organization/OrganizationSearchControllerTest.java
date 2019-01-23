package com.zendesk.controller.organization;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zendesk.config.SearchConfig;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;
import com.zendesk.util.OrganizationSearchConstants;

public class OrganizationSearchControllerTest {

	OrganizationSearchController organizationSearchController;

	SearchCriteria searchCriteria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SearchConfig.loadConfig();
	}


	@Before
	public void setUp() throws Exception {
		organizationSearchController = new OrganizationSearchController();
		searchCriteria = new SearchCriteria();
	}

	@After
	public void tearDown() throws Exception {
		organizationSearchController = null;
		searchCriteria = null;
	}

	@Test
	public void testPerformSearchForId() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_ID);
		searchCriteria.setFieldValue("101");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_ID);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForurl() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_URL);
		searchCriteria.setFieldValue("http://initech.zendesk.com/api/v2/organizations/101.json");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_URL);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForExternalId() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_EXTERNAL_ID);
		searchCriteria.setFieldValue("9270ed79-35eb-4a38-a46f-35725197ea8d");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_EXTERNAL_ID);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForName() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_NAME);
		searchCriteria.setFieldValue("Enthaze");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_NAME);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForDomainNames() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_DOMAIN_NAMES);
		searchCriteria.setFieldValue("ecratic.com");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_DOMAIN_NAMES);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForCreatedAt() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_CREATED_AT);
		searchCriteria.setFieldValue("2016-05-21T11:10:28 -10:00");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_CREATED_AT);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForDetails() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_DETAILS);
		searchCriteria.setFieldValue("MegaCorp");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_DETAILS);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForSharedTicket() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_SHARED_TICKETS);
		searchCriteria.setFieldValue("false");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_SHARED_TICKETS);
		searchCriteria.setFieldValue("falll");
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_SHARED_TICKETS);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForTags() throws InvalidUserInputException {

		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_TAGS);
		searchCriteria.setFieldValue("Fulton");
		organizationSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_TAGS);
		searchCriteria.setFieldValue(null);
		organizationSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());
	}

}
