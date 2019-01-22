package com.zendesk.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zendesk.config.SearchConfig;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.initialiser.SearchDataInitialiser;

public class SearchServiceImplTest {
	
	SearchService serviceService;
	
	SearchCriteria searchCriteria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		serviceService = new SearchServiceImpl();
		searchCriteria =  new SearchCriteria();
	}

	@After
	public void tearDown() throws Exception {
		serviceService = null;
		searchCriteria =  null;
	}

	@Test
	public void testPerformSearchForBlank() {
		serviceService.performSearch(searchCriteria, "");
	}
	
	@Test
	public void testPerformSearchForNull() {
		serviceService.performSearch(searchCriteria, null);
	}
	
	@Test
	public void testPerformSearchForUserForNoDataLoaded() {
		serviceService.performSearch(searchCriteria, "Users");
	}
	
	@Test
	public void testPerformSearchForTicketsForNoDataLoaded() {
		serviceService.performSearch(searchCriteria, "Tickets");
	}
	
	@Test
	public void testPerformSearchForOrgForNoDataLoaded() {
		serviceService.performSearch(searchCriteria, "Organizations");
	}
	
	@Test
	public void testPerformSearchForUsers() {
		SearchDataInitialiser.loadSearchData();
		SearchConfig.loadConfig();
		serviceService.performSearch(searchCriteria, "Users");
		
		searchCriteria.setFieldName("Id");
		searchCriteria.setFieldValue("1");
		
		serviceService.performSearch(searchCriteria, "Users");
	}
	
	@Test
	public void testPerformSearchForTickets() {
		SearchDataInitialiser.loadSearchData();
		SearchConfig.loadConfig();
		serviceService.performSearch(searchCriteria, "Tickets");
		
		searchCriteria.setFieldName("Id");
		searchCriteria.setFieldValue("1");
		
		serviceService.performSearch(searchCriteria, "Tickets");
	}
	
	@Test
	public void testPerformSearchForOrgs() {
		SearchDataInitialiser.loadSearchData();
		SearchConfig.loadConfig();
		serviceService.performSearch(searchCriteria, "Organizations");
		
		searchCriteria.setFieldName("Id");
		searchCriteria.setFieldValue("1");
		
		serviceService.performSearch(searchCriteria, "Organizations");
	}

}
