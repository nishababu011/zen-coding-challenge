package com.zendesk.controller;

import com.zendesk.controller.organization.OrganizationSearchController;
import com.zendesk.controller.ticket.TicketSearchController;
import com.zendesk.controller.user.UserSearchController;
import com.zendesk.util.SearchConstants;

/**
 * Factory class that provides the Controllers based
 * on the entity type.
 * @author 
 *
 */
public class SearchControllerFactory {

	/**
	 * @param searchType
	 * @return
	 */
	public static SearchController getSearchControllerByType(String searchType) {

		if (SearchConstants.SEARCH_FIELD_USERS.equals(searchType)) {
			return new UserSearchController();
		} else if (SearchConstants.SEARCH_FIELD_TICKETS.equals(searchType)) {
			return new TicketSearchController();
		} else if (SearchConstants.SEARCH_FIELD_ORGANIZATIONS.equals(searchType)) {
			return new OrganizationSearchController();
		}
		return null;
	}

}
