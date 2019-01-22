package com.zendesk.initialiser;

import com.zendesk.common.SearchData;
import com.zendesk.model.Organization;
import com.zendesk.model.Ticket;
import com.zendesk.model.User;
import com.zendesk.util.DataLoadUtil;
import com.zendesk.util.SearchConstants;

/**
 * 
 * @author 
 *
 */
public class SearchDataInitialiser {
	
	 public static SearchData SEARCH_DATA;

	/**
	 * This method reads the data from the json data files and loads into the memory
	 */
	public static void loadSearchData(){
		SEARCH_DATA = new SearchData();
		SEARCH_DATA.setUsers((User[]) DataLoadUtil.loadDataByType(SearchConstants.SEARCH_FIELD_USERS,
				SearchConstants.SEARCH_FIELD_USERS_FILE_PATH));
		SEARCH_DATA.setTickets((Ticket[]) DataLoadUtil.loadDataByType(SearchConstants.SEARCH_FIELD_TICKETS,
				SearchConstants.SEARCH_FIELD_TICKETS_FILE_PATH));
		SEARCH_DATA.setOrganizations((Organization[]) DataLoadUtil.loadDataByType(
				SearchConstants.SEARCH_FIELD_ORGANIZATIONS, SearchConstants.SEARCH_FIELD_ORGANIZATIONS_FILE_PATH));
	}
}
