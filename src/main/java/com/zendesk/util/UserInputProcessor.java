package com.zendesk.util;

import org.apache.log4j.Logger;

import com.zendesk.common.SearchAppMenu;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;

/**
 * 
 * This class contains method that interprets the user inputs
 *
 */
public class UserInputProcessor {
	
	final static Logger logger = Logger.getLogger(UserInputProcessor.class);
	
	/**
	 * Method to map the user inputs to appropriate actions
	 * @param searchCriteria
	 * @param userInputStr
	 */
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
		if (SearchConstants.SEARCH_MENU_USERS.equals(userInput)) {
			searchCriteria.setSearchType(SearchConstants.SEARCH_FIELD_USERS);
		} else if (SearchConstants.SEARCH_MENU_TICKETS.equals(userInput)) {
			searchCriteria.setSearchType(SearchConstants.SEARCH_FIELD_TICKETS);
		} else if (SearchConstants.SEARCH_MENU_ORGANIZATIONS.equals(userInput)) {
			searchCriteria.setSearchType(SearchConstants.SEARCH_FIELD_ORGANIZATIONS);
		} else {
			logger.debug(SearchConstants.SEARCH_ENTER_INVALID_USER_ENTRY + " : user entered for Submenu: " +  userInput);
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_USER_ENTRY);
		}

	}
	

}
