package com.zendesk.util;

/**
 * 
 * @author
 *
 */
public class LogUtil {
	
	public static final String EMPTY_STR = "";
	
	/**
	 * 
	 * @param result
	 */
	public static void logToConsole(String result) {
		System.out.println(result != null  ? result :  EMPTY_STR);
	}

}
