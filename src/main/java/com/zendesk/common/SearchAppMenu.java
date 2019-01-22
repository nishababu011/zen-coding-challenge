package com.zendesk.common;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.util.LogUtil;
import com.zendesk.util.SearchConstants;
import com.zendesk.exception.InvalidUserInputException;

/**
 * This enum stores the values in the Main Menu of the application
 * and the action associated with each of it
 * @author 
 *
 */
public enum SearchAppMenu {
	
	SEARCH{
		public void performAction(SearchCriteria searchCriteria) {
			searchCriteria.setSubMenuActive(true);
			searchCriteria.setSearchSelected(true);
			LogUtil.logToConsole(SearchConstants.SEARCH_TYPES_STR);
		}
		
	}, VIEW_LIST_FIELDS {
		public void performAction(SearchCriteria searchCriteria) {
			searchCriteria.setSubMenuActive(true);
			searchCriteria.setSearchSelected(false);
			searchCriteria.setListSelected(true);
			LogUtil.logToConsole(SearchConstants.SEARCH_FIELDS_STR);
			searchCriteria.reset();
		}
	}, EXIT {
		public void performAction(SearchCriteria searchCriteria) {
			System.exit(0);
		}
	};
	
	public abstract void performAction(SearchCriteria searchCriteria);
	
	/**
	 * This method maps the ENUM string to the user entered values
	 * @param userInput
	 * @return
	 * @throws InvalidUserInputException
	 */
	public static SearchAppMenu mapByUserInput(String userInput) throws InvalidUserInputException {
		if(SearchConstants.SEARCH_MENU_OPTION.equals(userInput)) {
			return SEARCH;
		} else if(SearchConstants.SEARCH_LIST_FIELDS_OPTION.equals(userInput)) {
			return VIEW_LIST_FIELDS;
		} else if(SearchConstants.SEARCH_EXIT_OPTION.equals(userInput)) {
			return EXIT;
		} else {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ERROR_INVALID_MENU_OPTION);
		}
	}
}
