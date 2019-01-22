package com.zendesk.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;

public class UserInputProcessorTest {

	SearchCriteria searchCriteria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		searchCriteria = new SearchCriteria();
	}

	@After
	public void tearDown() throws Exception { 
		searchCriteria = null;
	}

	@Test
	public void testProcessUserInputNullBlank() {
		UserInputProcessor.processUserInput(searchCriteria, "");
		UserInputProcessor.processUserInput(null, "");
		UserInputProcessor.processUserInput(searchCriteria, null);

	}

	@Test
	public void testProcessUserInputForValid() {
		UserInputProcessor.processUserInput(searchCriteria, "1");
		assertTrue(searchCriteria.isSearchSelected());
		assertTrue(searchCriteria.isSubMenuActive());

		searchCriteria.reset();
		UserInputProcessor.processUserInput(searchCriteria, "2");
		assertFalse(searchCriteria.isSearchSelected());
		

		searchCriteria.reset();
		searchCriteria.setSubMenuActive(true);
		searchCriteria.setSearchSelected(true);
		UserInputProcessor.processUserInput(searchCriteria, "3");
		assertEquals(searchCriteria.getSearchType(), SearchConstants.SEARCH_FIELD_ORGANIZATIONS);

	}

	@Test
	public void testProcessUserInputWithSpaces() {
		searchCriteria.reset();
		searchCriteria.setSubMenuActive(true);
		searchCriteria.setSearchSelected(true);
		UserInputProcessor.processUserInput(searchCriteria, "1 ");
		assertEquals(searchCriteria.getSearchType(), SearchConstants.SEARCH_FIELD_USERS);

		searchCriteria.reset();
		searchCriteria.setSubMenuActive(true);
		searchCriteria.setSearchSelected(true);
		UserInputProcessor.processUserInput(searchCriteria, " 2");
		assertEquals(searchCriteria.getSearchType(), SearchConstants.SEARCH_FIELD_TICKETS);

		searchCriteria.reset();
		searchCriteria.setSubMenuActive(true);
		searchCriteria.setSearchSelected(true);
		UserInputProcessor.processUserInput(searchCriteria, " 3");
		assertEquals(searchCriteria.getSearchType(), SearchConstants.SEARCH_FIELD_ORGANIZATIONS);

	}

	@Test
	public void testProcessSearchInputsBlank() {
		searchCriteria.reset();
		try {
		UserInputProcessor.processSearchInputs(searchCriteria, "");	
		}catch(InvalidUserInputException e) {
			assertEquals(e.toString(), SearchConstants.SEARCH_ENTER_INVALID_USER_ENTRY);
		}
	}
	
	@Test
	public void testProcessSearchInputsNull() {
		searchCriteria.reset();
		try {
		UserInputProcessor.processSearchInputs(searchCriteria, null);	
		}catch(InvalidUserInputException e) {
			assertEquals(e.toString(), SearchConstants.SEARCH_ENTER_INVALID_USER_ENTRY);
		}
	}
	
	@Test
	public void testProcessSearchInputs() {
		try {
		UserInputProcessor.processSearchInputs(searchCriteria, "1");
		assertEquals(searchCriteria.getSearchType(), SearchConstants.SEARCH_FIELD_USERS);
		
		
		UserInputProcessor.processSearchInputs(searchCriteria, "2");
		assertEquals(searchCriteria.getSearchType(), SearchConstants.SEARCH_FIELD_TICKETS);
		
		UserInputProcessor.processSearchInputs(searchCriteria, "3");
		assertEquals(searchCriteria.getSearchType(), SearchConstants.SEARCH_FIELD_ORGANIZATIONS);
		
		}catch(InvalidUserInputException e) {
			assertEquals(e.toString(), SearchConstants.SEARCH_ENTER_INVALID_USER_ENTRY);
		}
	}

}
