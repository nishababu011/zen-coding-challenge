package com.zendesk.config;

import java.util.Map;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.model.Ticket;
import com.zendesk.search.ticket.TicketMatcher;
import com.zendesk.util.IOUtil;
import com.zendesk.util.SearchConstants;
import com.zendesk.util.TicketSearchConstants;

/**
 * 
 * @author 
 *
 */
public class TicketSearchConfig {

	/**
	 * 
	 * @param ticketMatcherMap
	 */
	public static void populateTicketMatcherConfig(Map<String, TicketMatcher> ticketMatcherMap) {
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_ID, (SearchCriteria searchCriteria,
				Ticket ticket) -> ticket.get_id().equals(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_CREATED_AT, (SearchCriteria searchCriteria,
				Ticket ticket) -> ticket.getCreated_at() != null && ticket.getCreated_at().equals(IOUtil.parseDate(searchCriteria.getFieldValue(), SearchConstants.SEARCH_DATE_FORMAT)));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_DESCRIPTION,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getDescription() != null
						&& ticket.getDescription().equalsIgnoreCase( searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_DUE_AT,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getDue_at() != null
						&& ticket.getDue_at().equals(IOUtil.parseDate(searchCriteria.getFieldValue(), SearchConstants.SEARCH_DATE_FORMAT)));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_EXTERNAL_ID,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getExternal_id() != null
						&& ticket.getExternal_id().equals( searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_HAS_INCIDENTS, (SearchCriteria searchCriteria,
				Ticket ticket) -> ticket.isHas_incidents() != null && ticket.isHas_incidents() == IOUtil.parseBoolean( searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_ORGANIZATION_ID, (SearchCriteria searchCriteria,
				Ticket ticket) -> ticket.getOrganization_id() == IOUtil.parseLong(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_PRIORITY,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getPriority() != null
						&& ticket.getPriority().equals(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_STATUS,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getStatus() != null
						&& ticket.getStatus().equals(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_SUBJECT,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getSubject() != null
						&& ticket.getSubject().equals(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_SUBMITTER_ID, (SearchCriteria searchCriteria,
				Ticket ticket) -> ticket.getSubmitter_id() == IOUtil.parseLong(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_ASSIGNEE_ID, (SearchCriteria searchCriteria,
				Ticket ticket) -> ticket.getAssignee_id() == IOUtil.parseLong(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_TAGS,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getTags() != null
						&& ticket.getTags().contains(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_TYPE,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getType() != null
						&& ticket.getType().equals(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_URL,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getUrl() != null
						&& ticket.getUrl().equals(searchCriteria.getFieldValue()));
		ticketMatcherMap.put(TicketSearchConstants.SEARCH_FIELD_TICKET_VIA,
				(SearchCriteria searchCriteria, Ticket ticket) -> ticket.getVia() != null
						&& ticket.getVia().equals( searchCriteria.getFieldValue()));

	}
}
