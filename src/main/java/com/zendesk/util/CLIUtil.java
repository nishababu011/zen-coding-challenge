package com.zendesk.util;

import java.util.Scanner;

public class CLIUtil {

	private final Scanner scanner;

	public CLIUtil() {
		this(new Scanner(System.in));
	}

	CLIUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getInput() {
		return scanner.nextLine();
	}
	
	/**
	 * 
	 * @param userInput
	 */
	public static void exitOnUserInput(String userInput) {
		if (userInput != null &&  SearchConstants.SEARCH_QUIT.equalsIgnoreCase(userInput.trim())) {
			System.exit(0);
		}
		
	}

}
