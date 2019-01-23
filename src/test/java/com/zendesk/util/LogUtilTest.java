package com.zendesk.util;

import org.junit.Test;

public class LogUtilTest {

	@Test
	public void testLogToConsole() {
		LogUtil.logToConsole(null);
		LogUtil.logToConsole("Test");
	}

}
