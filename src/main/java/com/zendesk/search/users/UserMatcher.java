package com.zendesk.search.users;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.model.User;

/**
 * 
 * @author 
 * 
 */
public interface  UserMatcher {

	public  boolean searchByFieldName(SearchCriteria searchCriteria,User user);

}
