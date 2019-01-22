package com.zendesk.common;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.util.LogUtil;
import com.zendesk.util.SearchConstants;
import com.zendesk.exception.InvalidUserInputException;

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
	
	public static SearchAppMenu mapByUserInput(String userInput) throws InvalidUserInputException {
		if("1".equals(userInput)) {
			return SEARCH;
		} else if("2".equals(userInput)) {
			return VIEW_LIST_FIELDS;
		} else if("3".equals(userInput)) {
			return EXIT;
		} else {
			throw new InvalidUserInputException("Invalid Menu option entered");
		}
		
	}
	

}