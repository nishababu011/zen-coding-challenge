package com.zendesk.util;

import com.zendesk.common.SearchAppMenu;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;

public class UserInputProcessor {
	
	public static void processUserInput(SearchCriteria searchCriteria, String userInputStr) {
		if (userInputStr != null && searchCriteria != null) {
			String userInput = userInputStr.trim();

			try {
				CLIUtil.exitOnUserInput(userInput);
				if (!searchCriteria.isSubMenuActive() && userInput != null && userInput.trim().length() > 0) {
					SearchAppMenu.mapByUserInput(userInput).performAction(searchCriteria);
				} else if (searchCriteria.isSubMenuActive() && searchCriteria.isSearchSelected()) {
					if (searchCriteria.getSearchType() == null) {
						processSearchInputs(searchCriteria, userInput);
					}
					searchCriteria.setSearch(true);
					searchCriteria.setSearchSelected(false);
					LogUtil.logToConsole(SearchConstants.SEARCH_ENTER_FIELD_NAME);
				} else if (searchCriteria.isSearch() && searchCriteria.getFieldName() == null) {
					searchCriteria.setFieldName(userInput);
					LogUtil.logToConsole(SearchConstants.SEARCH_ENTER_FIELD_VALUE);
				} else if (searchCriteria.isSearch() && searchCriteria.getFieldValue() == null) {
					searchCriteria.setFieldValue(userInput);
				} else if (searchCriteria.isSearch() && searchCriteria.getFieldName() != null
						&& searchCriteria.getFieldValue() != null) {
					searchCriteria.setSearchSelected(false);
					searchCriteria.setSearch(false);
				}
			} catch (InvalidUserInputException e) {
				LogUtil.logToConsole(e.toString());
				searchCriteria.reset();
			}
		}
	}

	/**
	 * 
	 * @param searchCriteria
	 * @param userInput
	 * @throws InvalidUserInputException
	 */
	public static void processSearchInputs(SearchCriteria searchCriteria, String userInput)
			throws InvalidUserInputException {

		CLIUtil.exitOnUserInput(userInput);
		if ("1".equals(userInput)) {
			searchCriteria.setSearchType(SearchConstants.SEARCH_FIELD_USERS);
		} else if ("2".equals(userInput)) {
			searchCriteria.setSearchType(SearchConstants.SEARCH_FIELD_TICKETS);
		} else if ("3".equals(userInput)) {
			searchCriteria.setSearchType(SearchConstants.SEARCH_FIELD_ORGANIZATIONS);
		} else {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_USER_ENTRY);
		}

	}
	

}
