package com.zendesk.search.config;

import java.util.Map;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.model.User;
import com.zendesk.search.users.UserMatcher;
import com.zendesk.util.IOUtil;
import com.zendesk.util.SearchConstants;
import com.zendesk.util.UserSearchConstants;



/**
 * This config stores the map of each fields of User 
 * and its corresponding Matcher class implementation.
 * This map is loaded statically on start of the application
 */
public class UserSearchConfig {

	/**
	 * This config store a map of search field and the respective implementation
	 * of the UserMatcher interface
	 * @param userMatcherMap
	 */
	public static void populateUserMatcherConfig(Map<String, UserMatcher> userMatcherMap) {
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_ID,
				(SearchCriteria searchCriteria, User user) -> user.get_id() == IOUtil.parseLong((String)searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_ACTIVE, (SearchCriteria searchCriteria,
				User user) -> user.isActive() == IOUtil.parseBoolean(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_ALIAS,
				(SearchCriteria searchCriteria, User user) -> user.getAlias() != null
						&& user.getAlias().equals( searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_CREATED_AT,
				(SearchCriteria searchCriteria, User user) -> user.getCreated_at() != null
						&& user.getCreated_at().equals(IOUtil.parseDate(searchCriteria.getFieldValue(), SearchConstants.SEARCH_DATE_FORMAT)));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_EMAIL,
				(SearchCriteria searchCriteria, User user) -> user.getEmail() != null
						&& user.getEmail().equals(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_EXTERNAL_ID,
				(SearchCriteria searchCriteria, User user) -> user.getExternal_id() != null
						&& user.getExternal_id().equals(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_LAST_LOGIN,
				(SearchCriteria searchCriteria, User user) -> user.getLast_login_at() != null
						&& user.getLast_login_at().equals(IOUtil.parseDate(searchCriteria.getFieldValue(), SearchConstants.SEARCH_DATE_FORMAT)));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_LOCALE,
				(SearchCriteria searchCriteria, User user) -> user.getLocale() != null
						&& user.getLocale().equals(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_NAME, (SearchCriteria searchCriteria,
				User user) -> user.getName() != null && user.getName().equals(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_ORG_ID, (SearchCriteria searchCriteria,
				User user) -> user.getOrganization_id() != null && user.getOrganization_id() == IOUtil.parseLong(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_PHONE,
				(SearchCriteria searchCriteria, User user) -> user.getPhone() != null
						&& user.getPhone().equals( searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_ROLE, (SearchCriteria searchCriteria,
				User user) -> user.getRole() != null && user.getRole().equals(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_SHARED, (SearchCriteria searchCriteria,
				User user) -> user.isShared() != null && user.isShared() == IOUtil.parseBoolean(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_SIGNATURE,
				(SearchCriteria searchCriteria, User user) -> user.getSignature() != null
						&& user.getSignature().equals((String) searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_SUSPENDED, (SearchCriteria searchCriteria,
				User user) -> user.isSuspended() != null && user.isSuspended() == IOUtil.parseBoolean(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_TAGS,
				(SearchCriteria searchCriteria, User user) -> user.getTags() != null
						&& user.getTags().contains(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_TIMEZONE,
				(SearchCriteria searchCriteria, User user) -> user.getTimezone() != null
						&& user.getTimezone().equals( searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_URL, (SearchCriteria searchCriteria,
				User user) -> user.getUrl() != null && user.getUrl().equals(searchCriteria.getFieldValue()));
		userMatcherMap.put(UserSearchConstants.SEARCH_FIELD_USERS_VERIFIED, (SearchCriteria searchCriteria,
				User user) -> user.isVerified()!= null && user.isVerified() == IOUtil.parseBoolean(searchCriteria.getFieldValue()));

	}
}
