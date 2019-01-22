package com.zendesk.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendesk.model.Organization;
import com.zendesk.model.Ticket;
import com.zendesk.model.User;


/**
 * 
 * Manages the method to read data from files
 *
 */
public class DataLoadUtil {

	/**
	 * 
	 * @param dataType
	 * @param path
	 * @return
	 */
	public static Object[] loadDataByType(String dataType, String path) {
		ObjectMapper mapper = new ObjectMapper();
		Object[] dataObjs = null;
		try {
			if (dataType != null) {
				switch (dataType) {
				case SearchConstants.SEARCH_FIELD_USERS:
					dataObjs = (User[]) mapper.readValue(IOUtil.readFile(path), User[].class);
					break;
				case SearchConstants.SEARCH_FIELD_TICKETS:
					dataObjs = mapper.readValue(IOUtil.readFile(path), Ticket[].class);
					break;
				case SearchConstants.SEARCH_FIELD_ORGANIZATIONS:
					dataObjs = mapper.readValue(IOUtil.readFile(path), Organization[].class);
					break;
				default:
					dataObjs = null;
					break;
				}
			}

		} catch (JsonGenerationException e) {
			System.out.println("JsonGenerationException");

		} catch (JsonMappingException e) {
			System.out.println("JsonMappingException");
			e.printStackTrace();

		} catch (JsonParseException e) {
			System.out.println("JsonParseException");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataObjs;
	}
}
