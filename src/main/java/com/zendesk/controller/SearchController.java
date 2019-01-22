package com.zendesk.controller;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;

/**
 * Abstract controller that can be extended to implement
 * entity specific logic
 * @author 
 *
 */
public abstract class SearchController {

	public abstract void performSearch(SearchCriteria searchCriteria) throws InvalidUserInputException;
}
