package com.zendesk.controller;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;

/**
 * 
 * @author 
 *
 */
public abstract class SearchController {

	public abstract void performSearch(SearchCriteria searchCriteria) throws InvalidUserInputException;
}
