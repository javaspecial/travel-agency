package com.helper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PosLog {
	private static Log logger = LogFactory.getLog(PosLog.class);

	public static void error(String message) {
		logger.error(message);
	}
	public static void error(Class classes,String message) {
		LogFactory.getLog(classes).error(message);
	}
	public static void debug(String message) {
		logger.debug(message);
	}

	public static void info(String message) {
		logger.info(message);
	}
}
