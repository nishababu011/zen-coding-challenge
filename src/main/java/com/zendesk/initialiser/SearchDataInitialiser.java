package com.zendesk.initialiser;

import com.zendesk.common.SearchData;
import com.zendesk.model.Organization;
import com.zendesk.model.Ticket;
import com.zendesk.model.User;
import com.zendesk.util.DataLoadUtil;
import com.zendesk.util.SearchConstants;

/**
 * The search data is loaded one time dynamically from the json file
 * This is to avoid performance overhead on reading the files on each search operation.
 * 
 */
public class SearchDataInitialiser {
	
	 public static final SearchData SEARCH_DATA;

	/**
	 * This method reads the data from the json data files and loads into the memory
	 */
	 static{
		SEARCH_DATA = new SearchData();
		SEARCH_DATA.setUsers((User[]) DataLoadUtil.loadDataByType(SearchConstants.SEARCH_FIELD_USERS,
				SearchConstants.SEARCH_FIELD_USERS_FILE_PATH));
		SEARCH_DATA.setTickets((Ticket[]) DataLoadUtil.loadDataByType(SearchConstants.SEARCH_FIELD_TICKETS,
				SearchConstants.SEARCH_FIELD_TICKETS_FILE_PATH));
		SEARCH_DATA.setOrganizations((Organization[]) DataLoadUtil.loadDataByType(
				SearchConstants.SEARCH_FIELD_ORGANIZATIONS, SearchConstants.SEARCH_FIELD_ORGANIZATIONS_FILE_PATH));
	}
}
