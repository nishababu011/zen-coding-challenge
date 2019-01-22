package com.zendesk.service;

import org.apache.log4j.Logger;

import com.zendesk.controller.SearchController;
import com.zendesk.controller.SearchControllerFactory;
import com.zendesk.controller.organization.OrganizationSearchController;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;
import com.zendesk.util.LogUtil;
import com.zendesk.util.SearchConstants;

/**
 * 
 * SearchServiceImpl
 *
 */
public class SearchServiceImpl implements SearchService {

	final static Logger logger = Logger.getLogger(SearchServiceImpl.class);
	
	/**
	 * This method performs the search by calling the appropriate controller
	 * based on the search type
	 */
	public void performSearch(SearchCriteria searchCriteria, String searchType) {
		try {
			SearchController searchController = new SearchControllerFactory().getSearchControllerByType(searchType);
			if(searchController != null) {
				searchController.performSearch(searchCriteria);
			} else {
				logger.debug(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME + searchType);
				throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
			}
		} catch (InvalidUserInputException e) {
			LogUtil.logToConsole(e.toString());
			searchCriteria.reset();
		}
	}
}
