package com.zendesk.initialiser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchDataInitialiserTest {

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
	public void testLoadSearchData() {
		SearchDataInitialiser.loadSearchData();
		assertNotNull(SearchDataInitialiser.SEARCH_DATA);
		assertNotNull(SearchDataInitialiser.SEARCH_DATA.getUsers());
		assertNotNull(SearchDataInitialiser.SEARCH_DATA.getTickets());
		assertNotNull(SearchDataInitialiser.SEARCH_DATA.getOrganizations());
	}

}
