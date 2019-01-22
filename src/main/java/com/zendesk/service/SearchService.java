package com.zendesk.service;

import com.zendesk.dto.SearchCriteria;

/**
 * SearchService
 */
public interface SearchService {
	
	public void performSearch(SearchCriteria searchCriteria, String searchType);

}
