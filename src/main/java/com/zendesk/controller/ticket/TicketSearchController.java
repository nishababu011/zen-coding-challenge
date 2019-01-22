package com.zendesk.controller.ticket;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.zendesk.config.SearchConfig;
import com.zendesk.controller.SearchController;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;
import com.zendesk.initialiser.SearchDataInitialiser;
import com.zendesk.model.Ticket;
import com.zendesk.search.ticket.TicketMatcher;
import com.zendesk.util.LogUtil;
import com.zendesk.util.SearchConstants;


/**
 * 
 * @author 
 *
 */
public class TicketSearchController extends SearchController {
	
	/**
	 * 
	 */
	public void performSearch(SearchCriteria searchCriteria) throws InvalidUserInputException{
		checkIfDataLoaded();
		Stream<Ticket> str = Arrays.stream(SearchDataInitialiser.SEARCH_DATA.getTickets());
		TicketMatcher ticketMatcher = SearchConfig.ticketMatcherMap.get(searchCriteria.getFieldName());
		if(ticketMatcher == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		Predicate<Ticket> ticketFilter = (Ticket u) -> ticketMatcher.searchByFieldName(searchCriteria, u);

		Stream<Ticket> results = str.filter(ticketFilter);
		if (results != null) {
			results.forEach(u -> {
				LogUtil.logToConsole(u.toString());
				searchCriteria.setResultsFound(true);
			});
		}

		if (!searchCriteria.isResultsFound()) {
			LogUtil.logToConsole(SearchConstants.SEARCH_NO_RESULTS_FOUND);
			searchCriteria.reset();
		}
	}
	
	/**
	 * 
	 */
	private void checkIfDataLoaded() throws InvalidUserInputException{
		if(SearchDataInitialiser.SEARCH_DATA == null || SearchDataInitialiser.SEARCH_DATA.getTickets() == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		
	}

}
