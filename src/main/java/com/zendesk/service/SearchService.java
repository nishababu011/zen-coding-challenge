package com.zendesk.service;

import com.zendesk.dto.SearchCriteria;

/**
 * 
 * @author 
 *
 */
public interface SearchService {
	
	public void performSearch(SearchCriteria searchCriteria, String searchType);

}
