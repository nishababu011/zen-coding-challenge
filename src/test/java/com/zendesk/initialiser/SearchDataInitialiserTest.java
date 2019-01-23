package com.zendesk.initialiser;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SearchDataInitialiserTest {

	@Test
	public void testLoadSearchData() {
		//SearchDataInitialiser.loadSearchData();
		assertNotNull(SearchDataInitialiser.SEARCH_DATA);
		assertNotNull(SearchDataInitialiser.SEARCH_DATA.getUsers());
		assertNotNull(SearchDataInitialiser.SEARCH_DATA.getTickets());
		assertNotNull(SearchDataInitialiser.SEARCH_DATA.getOrganizations());
	}

}
