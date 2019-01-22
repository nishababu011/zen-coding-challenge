package com.zendesk.controller;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;

/**
 * Controller that can be implemented
 * entity specific logic
 *
 */
public interface SearchController {
	public void performSearch(SearchCriteria searchCriteria) throws InvalidUserInputException;
}
