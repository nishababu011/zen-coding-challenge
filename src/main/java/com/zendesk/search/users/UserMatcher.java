package com.zendesk.search.users;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.model.User;

/**
 * Matcher interface for User
 */
public interface  UserMatcher {

	public  boolean searchByFieldName(SearchCriteria searchCriteria,User user);

}
