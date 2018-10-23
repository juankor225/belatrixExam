package com.juan.examen.EXAMENBLTX;

import org.apache.log4j.Logger;

public class JobLogger {
	public static Logger LOG = Logger.getLogger(JobLogger.class);
	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logMessage;
	private static boolean logWarning;
	private static boolean logError;
	private static boolean logToDatabase;

	
	public JobLogger(boolean logToFileParam, boolean logToConsoleParam,
			boolean logToDatabaseParam, boolean logMessageParam,
			boolean logWarningParam, boolean logErrorParam) {
		logError = logErrorParam;
		logMessage = logMessageParam;
		logWarning = logWarningParam;
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;

	}
	
	public static void LogMessage(String message) throws Exception {
		message.trim();
		
		if (message == null || message.length() == 0) {
			return;
		}

		if (!logToConsole && !logToFile && !logToDatabase) {
			throw new Exception("Invalid configuration");
		}
		
		if (!logError && !logMessage && !logWarning) {
			throw new Exception("Error or Warning or Message must be specified");
		}
		
		if(logError){
			LOG.error(message);
			return;
		}
		if(logMessage){
			LOG.info(message);
			return;
		}
		if(logWarning){
			LOG.warn(message);
			return;
		}
		
		if(logToDatabase){
			LOG.trace(message);
			return;
		}	
		
		if(logToFile){
			LOG.fatal(message);
			return;
		}	
		if(logToConsole){
			LOG.info(message);
			return;
		}
	}

	public static void main(String[] args) {
		JobLogger log = new JobLogger(false,false,true,false,false,false);
		try {
			log.LogMessage("blabalalbalal");
		} catch (Exception e) {
			LOG.error(e);
		}
		
	}
}
