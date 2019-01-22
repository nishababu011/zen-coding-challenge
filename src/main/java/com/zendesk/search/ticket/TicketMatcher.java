package com.zendesk.search.ticket;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.model.Ticket;

/**
 * Matcher interface for Ticket
 */
public interface TicketMatcher {
	public  boolean searchByFieldName(SearchCriteria searchCriteria,Ticket ticket);
}
