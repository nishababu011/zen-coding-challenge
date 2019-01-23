package com.zendesk.controller.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zendesk.config.SearchConfig;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;
import com.zendesk.util.UserSearchConstants;

public class UserSearchControllerTest {
	
	UserSearchController userSearchController;

	SearchCriteria searchCriteria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SearchConfig.loadConfig();
	}

	@Before
	public void setUp() throws Exception {
		userSearchController = new UserSearchController();
		searchCriteria = new SearchCriteria();
		
	}

	@After
	public void tearDown() throws Exception {
		userSearchController = null;
		searchCriteria = null;
	}

	@Test
	public void testPerformSearchForId() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ID);
		searchCriteria.setFieldValue("1");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ID);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForUrl() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_URL);
		searchCriteria.setFieldValue("http://initech.zendesk.com/api/v2/users/1.json");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_URL);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForExternalId() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_EXTERNAL_ID);
		searchCriteria.setFieldValue("74341f74-9c79-49d5-9611-87ef9b6eb75f");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_EXTERNAL_ID);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForName() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_NAME);
		searchCriteria.setFieldValue("Francisca Rasmussen");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_NAME);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	
	@Test
	public void testPerformSearchForAlias() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ALIAS);
		searchCriteria.setFieldValue("Miss Coffey");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ALIAS);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForCreatedAt() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_CREATED_AT);
		searchCriteria.setFieldValue("2016-04-15T05:19:46 -10:00");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_CREATED_AT);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForActive() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ACTIVE);
		searchCriteria.setFieldValue("true");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ACTIVE);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());
		
		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ACTIVE);
		searchCriteria.setFieldValue("fff");
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForVerified() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_VERIFIED);
		searchCriteria.setFieldValue("true");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_VERIFIED);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());
		
		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_VERIFIED);
		searchCriteria.setFieldValue("fdf");
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForShared() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_SHARED);
		searchCriteria.setFieldValue("true");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_SHARED);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());
		
		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_SHARED);
		searchCriteria.setFieldValue("sss");
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForLocale() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_LOCALE);
		searchCriteria.setFieldValue("en-AU");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_LOCALE);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForTimezone() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_TIMEZONE);
		searchCriteria.setFieldValue("Sri Lanka");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_TIMEZONE);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForLastLoginAt() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_LAST_LOGIN);
		searchCriteria.setFieldValue("2013-08-04T01:03:27 -10:00");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_LAST_LOGIN);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForEmail() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_EMAIL);
		searchCriteria.setFieldValue("coffeyrasmussen@flotonic.com");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_EMAIL);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForPhone() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_PHONE);
		searchCriteria.setFieldValue("8335-422-718");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_PHONE);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

	@Test
	public void testPerformSearchForSignature() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_SIGNATURE);
		searchCriteria.setFieldValue("Don't Worry Be Happy!");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_SIGNATURE);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForOrganizatonId() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ORG_ID);
		searchCriteria.setFieldValue("119");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ORG_ID);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForTags() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_TAGS);
		searchCriteria.setFieldValue("Sutton");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_TAGS);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForSuspended() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_SUSPENDED);
		searchCriteria.setFieldValue("true");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_SUSPENDED);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());
		
		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_SUSPENDED);
		searchCriteria.setFieldValue("fd");
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}
	
	@Test
	public void testPerformSearchForRole() throws InvalidUserInputException {

		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ROLE);
		searchCriteria.setFieldValue("admin");
		userSearchController.performSearch(searchCriteria);
		assertTrue(searchCriteria.isResultsFound());

		searchCriteria.reset();
		searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ROLE);
		searchCriteria.setFieldValue(null);
		userSearchController.performSearch(searchCriteria);
		assertFalse(searchCriteria.isResultsFound());

	}

}
