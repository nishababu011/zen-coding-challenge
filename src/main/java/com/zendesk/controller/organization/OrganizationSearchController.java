package com.zendesk.controller.organization;

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
import com.zendesk.model.Organization;
import com.zendesk.search.organization.OrganizationMatcher;
import com.zendesk.util.LogUtil;
import com.zendesk.util.SearchConstants;
import com.zendesk.util.TicketSearchConstants;
import com.zendesk.util.UserSearchConstants;

/**
 * Controller class for Organization
 * @author 
 *
 */
public class OrganizationSearchController implements SearchController {
	
	final static Logger logger = Logger.getLogger(OrganizationSearchController.class);

	/**
	 * This method applies the filters and logs the results to the user console
	 */
	public void performSearch(SearchCriteria searchCriteria) throws InvalidUserInputException {
		checkIfDataLoaded();
		Stream<Organization> str = Arrays.stream(SearchDataInitialiser.SEARCH_DATA.getOrganizations());
		OrganizationMatcher orgMatcher = SearchConfig.organizationMatcherMap.get(searchCriteria.getFieldName());
		if (orgMatcher == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		Predicate<Organization> orgFilter = (Organization u) -> orgMatcher.searchByFieldName(searchCriteria, u);
		Stream<Organization> results = str.filter(orgFilter);
		if (results != null) {
			results.forEach(u -> {
				LogUtil.logToConsole(searchCriteria.isRelatedEntitySearch() ? u.getNameWithLabel() : u.toString());
				searchCriteria.setResultsFound(true);
				if(!searchCriteria.isRelatedEntitySearch()) {
					searchForRelatedUser(u);
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
	private void searchForRelatedUser(Organization o) {
		SearchCriteria searchCriteria = new SearchCriteria();
		if (o.get_id() != null) {
			searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ORG_ID);
			searchCriteria.setFieldValue(String.valueOf(o.get_id()));
			searchCriteria.setRelatedEntitySearch(true);
			try {
				SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_USERS)
						.performSearch(searchCriteria);
			} catch (InvalidUserInputException e) {
				logger.debug("Error in finding related users.." + o.get_id());
			}

		}
	}
	
	/**
	 * 
	 * @param u
	 * @throws InvalidUserInputException
	 */
	private void searchForRelatedTickets(Organization o) {
		SearchCriteria searchCriteria = new SearchCriteria();
		if (o.get_id() != null) {
			searchCriteria.setFieldName(TicketSearchConstants.SEARCH_FIELD_TICKET_ORGANIZATION_ID);
			searchCriteria.setFieldValue(String.valueOf(o.get_id()));
			searchCriteria.setRelatedEntitySearch(true);
			try {
				SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_TICKETS)
						.performSearch(searchCriteria);
			} catch (InvalidUserInputException e) {
				logger.debug("Error in finding related tickets.." + o.get_id());
			}

		}
	}
	
	
	
	/**
	 * This method checks if the static data has been loaded to filter the results
	 */
	private void checkIfDataLoaded() throws InvalidUserInputException{
		if(SearchDataInitialiser.SEARCH_DATA == null || SearchDataInitialiser.SEARCH_DATA.getOrganizations() == null) {
			logger.debug(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME + ": Search Data is not loaded" );
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		
	}
	
	

}
