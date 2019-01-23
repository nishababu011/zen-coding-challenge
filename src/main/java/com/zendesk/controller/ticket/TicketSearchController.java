package com.zendesk.controller.ticket;

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
import com.zendesk.model.Ticket;
import com.zendesk.search.ticket.TicketMatcher;
import com.zendesk.util.LogUtil;
import com.zendesk.util.OrganizationSearchConstants;
import com.zendesk.util.SearchConstants;
import com.zendesk.util.UserSearchConstants;

/**
 * Controller class for Ticket
 * 
 */
public class TicketSearchController implements SearchController {
	
	final static Logger logger = Logger.getLogger(TicketSearchController.class);
	
	/**
	 * This method applies the filters and logs the results to the user console
	 */
	public void performSearch(SearchCriteria searchCriteria) throws InvalidUserInputException {
		checkIfDataLoaded();
		Stream<Ticket> str = Arrays.stream(SearchDataInitialiser.SEARCH_DATA.getTickets());
		TicketMatcher ticketMatcher = SearchConfig.ticketMatcherMap.get(searchCriteria.getFieldName());
		if (ticketMatcher == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		Predicate<Ticket> ticketFilter = (Ticket u) -> ticketMatcher.searchByFieldName(searchCriteria, u);

		Stream<Ticket> results = str.filter(ticketFilter);
		if (results != null) {
			results.forEach(u -> {
				LogUtil.logToConsole(searchCriteria.isRelatedEntitySearch() ? u.getSubjectWithLabel() : u.toString());
				searchCriteria.setResultsFound(true);
				if(!searchCriteria.isRelatedEntitySearch()) {
					searchForRelatedUser(u);
					searchForRelatedOrganization(u);
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
	private void searchForRelatedUser(Ticket t) {
		SearchCriteria searchCriteria = new SearchCriteria();
		if (t.getSubmitter_id() != null) {
			searchCriteria.setFieldName(UserSearchConstants.SEARCH_FIELD_USERS_ID);
			searchCriteria.setFieldValue(String.valueOf(t.getSubmitter_id()));
			searchCriteria.setRelatedEntitySearch(true);
			try {
				SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_USERS)
						.performSearch(searchCriteria);
			} catch (InvalidUserInputException e) {
				logger.debug("Error in finding related users.." + t.getSubmitter_id());
			}

		}
	}
	
	/**
	 * 
	 * @param u
	 * @throws InvalidUserInputException
	 */
	private void searchForRelatedOrganization(Ticket t) {
		SearchCriteria searchCriteria = new SearchCriteria();
		if (t.getOrganization_id() != null) {
			searchCriteria.setFieldName(OrganizationSearchConstants.SEARCH_FIELD_ORG_ID);
			searchCriteria.setFieldValue(String.valueOf(t.getOrganization_id()));
			searchCriteria.setRelatedEntitySearch(true);
			try {
				SearchControllerFactory.getSearchControllerByType(SearchConstants.SEARCH_FIELD_ORGANIZATIONS)
						.performSearch(searchCriteria);
			} catch (InvalidUserInputException e) {
				logger.debug("Error in finding related organizations.." + t.getOrganization_id());
			}

		}
	}

	/**
	 * This method checks if the static data has been loaded to filter the results
	 */
	private void checkIfDataLoaded() throws InvalidUserInputException {
		if (SearchDataInitialiser.SEARCH_DATA == null || SearchDataInitialiser.SEARCH_DATA.getTickets() == null) {
			logger.debug(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME + ": Search Data is not loaded" );
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}

	}

}
