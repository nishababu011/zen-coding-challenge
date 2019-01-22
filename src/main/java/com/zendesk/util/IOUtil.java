package com.zendesk.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * Methods to read user input and parse user input
 *
 */
public class IOUtil {
	
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public static byte[] readFile(String filePath) {
		byte[] jsonData = null;
		try {
			if (filePath != null) {
				jsonData = Files.readAllBytes(Paths.get(filePath));
			}
		} catch (IOException e) {
			LogUtil.logToConsole("Error in reading the file from path " + filePath);
		}
		return jsonData;
	}

	/**
	 * 
	 * @param dateStr
	 * @param dateFormat
	 * @return
	 */
	public static Date parseDate(String dateStr, String dateFormat) {
		Date date = null;
		try {
			if(dateStr != null && dateFormat != null) {
				SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);  
				formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
				 date = formatter.parse(dateStr); 
			}
		} catch(ParseException e) {
			date = null;
		}
		return date;
	}
	
	/**
	 * 
	 * @param longValue
	 * @return
	 */
	public static Long parseLong(String longValue) {
		long value = 0L;
		try {
			if(longValue != null) {
				value = Long.parseLong(longValue);
			}
		} catch(Exception e) {
			value = 0L;
		}
		return value;
	}
	
	/**
	 * 
	 * @param booleanValue
	 * @return
	 */
	public static Boolean parseBoolean(String booleanValue) {
		Boolean value = null;
		
		try {
			if(booleanValue != null) {
				if("true".equalsIgnoreCase(booleanValue) || "false".equalsIgnoreCase(booleanValue))
				value = Boolean.parseBoolean(booleanValue);
			}
		} catch(Exception e) {
			value = null;
		}
		return value;
	}
	
	

}
