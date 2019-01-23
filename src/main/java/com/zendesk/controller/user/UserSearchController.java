package com.zendesk.controller.user;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.zendesk.config.SearchConfig;
import com.zendesk.controller.SearchController;
import com.zendesk.controller.SearchControllerFactory;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;
import com.zendesk.initialiser.SearchDataInitialiser;
import com.zendesk.model.User;
import com.zendesk.search.users.UserMatcher;
import com.zendesk.util.LogUtil;
import com.zendesk.util.OrganizationSearchConstants;
import com.zendesk.util.SearchConstants;
import com.zendesk.util.TicketSearchConstants;


/**
 * Controller class for User
 *
 */
public class UserSearchController implements SearchController {
	
	final static Logger logger = Logger.getLogger(UserSearchController.class);

	/**
	 * This method applies the filters and logs the results to the user console
	 */
	public void performSearch(SearchCriteria searchCriteria) throws InvalidUserInputException {
		checkIfDataLoaded();
		Stream<User> str = Arrays.stream(SearchDataInitialiser.SEARCH_DATA.getUsers());
		UserMatcher userMatcher = SearchConfig.userMatcherMap.get(searchCriteria.getFieldName());
		if (userMatcher == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		Predicate<User> userFilter = (User u) -> userMatcher.searchByFieldName(searchCriteria, u);
		Stream<User> results = str.filter(userFilter);
		if (results != null) {
			results.forEach(u -> {
				LogUtil.logToConsole(searchCriteria.isRelatedEntitySearch() ? u.getNameWithLabel() : u.toString());
				searchCriteria.setResultsFound(true);
				if(!searchCriteria.isRelatedEntitySearch()) {
					searchForRelatedOrganization(u);
					searchForRelatedTickets(u);
				}
				
			});
		}

		if (!searchCriteria.isResultsFound()) {
			LogUtil.logToConsole(SearchConstants.SEARCH_NO_RESULTS_FOUND);
			searchCriteria.reset();
		}
	}
	
	/**
	 * 
	 * @param u
	 * @throws InvalidUserInputException
	 */
	private void searchForRelatedOrganization(User u) {
		SearchCriteria searchCriteria = new SearchCriteria();
		if (u.getOrganization_id() != null) {
			searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_ID);
			searchCriteria.setFieldValue(String.valueOf(u.getOrganization_id()));
			searchCriteria.setRelatedEntitySearch(true);
			try {
				SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_ORGANIZATIONS)
						.performSearch(searchCriteria);
			} catch (InvalidUserInputException e) {
				logger.debug("Error in finding related organizations.." + u.getOrganization_id());
			}

		}
	}
	
	/**
	 * 
	 * @param u
	 * @throws InvalidUserInputException
	 */
	private void searchForRelatedTickets(User u) {
		SearchCriteria searchCriteria = new SearchCriteria();
		if (u.get_id() != null) {
			searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_SUBMITTER_ID);
			searchCriteria.setFieldValue(String.valueOf(u.get_id()));
			searchCriteria.setRelatedEntitySearch(true);
			try {
				SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_TICKETS)
						.performSearch(searchCriteria);
			} catch (InvalidUserInputException e) {
				logger.debug("Error in finding related tickets.." + u.get_id());
			}

		}
	}
	
	
	/**
	 * This method checks if the static data has been loaded to filter the results
	 */
	private void checkIfDataLoaded() throws InvalidUserInputException{
		if(SearchDataInitialiser.SEARCH_DATA == null || SearchDataInitialiser.SEARCH_DATA.getUsers() == null) {
			logger.debug(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME + ": Search Data is not loaded" );
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		
	}

}
