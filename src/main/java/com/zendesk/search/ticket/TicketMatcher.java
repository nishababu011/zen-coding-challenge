package com.zendesk.search.ticket;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.model.Ticket;

/**
 * 
 * @author
 *
 */
public interface TicketMatcher {
	public  boolean searchByFieldName(SearchCriteria searchCriteria,Ticket ticket);
}
