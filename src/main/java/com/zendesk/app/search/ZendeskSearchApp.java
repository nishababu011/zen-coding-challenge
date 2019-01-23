package com.zendesk.app.search;

import com.zendesk.config.SearchConfig;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.initialiser.SearchDataInitialiser;
import com.zendesk.service.SearchService;
import com.zendesk.service.SearchServiceImpl;
import com.zendesk.util.CLIUtil;
import com.zendesk.util.LogUtil;
import com.zendesk.util.SearchConstants;
import com.zendesk.util.UserInputProcessor;

/**
 * 
 * The main class of the application
 *
 */
public class ZendeskSearchApp {

	/**
	 * This the main method that drives the application
	 * @param hh
	 */
	public static void main(String hh[]) {
		SearchConfig.loadConfig();
		LogUtil.logToConsole(SearchConstants.SEARCH_WELCOME);
		SearchCriteria searchCriteria = new SearchCriteria();
		CLIUtil cliScanner = new CLIUtil();
		String userInput = null;

		while (true) {
			if (!searchCriteria.isSubMenuActive()) {
				LogUtil.logToConsole(SearchConstants.SEARCH_WELCOME_OPTIONS_STR);
			}
			userInput = cliScanner.getInput();
			UserInputProcessor.processUserInput(searchCriteria, userInput);
			if (searchCriteria.isListSelected()) {
				searchCriteria.reset();
				continue;
			}
			if (verifySearchCriteria(searchCriteria)) {
				performSearch(searchCriteria);
			
			}

		}

	}
	
	
	/**
	 * Method verifies the search criteria all the required value to perform
	 * search
	 * @param searchCriteria
	 * @return
	 */
	private static boolean verifySearchCriteria(SearchCriteria searchCriteria) {
		if(searchCriteria.getSearchType() != null && searchCriteria.getFieldName() != null
				&& searchCriteria.getFieldValue() != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method invokes the service method to perform search
	 * Irrespective of the output the searchCriteria will be reset.
	 * @param searchCriteria
	 */
	private static void performSearch(SearchCriteria searchCriteria) {
		SearchService searchService = new SearchServiceImpl();
		searchService.performSearch(searchCriteria, searchCriteria.getSearchType());
		searchCriteria.reset();
	}
	

}
