package org.api.catlibrary.util.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LogTracking {
	private static Logger logger = LogManager.getLogger(LogTracking.class);
	
	private static boolean startFirst=false;
	private static Date dateTimeStart = null;
	private static Date dateTimeStop = null;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss.SSS");
	
	public static void start(LogInfo info) {
		dateTimeStart = new Date();
		ThreadContext.put("transactionRef", info.getTransactionRef());
		ThreadContext.put("nodeRef", info.getNodeRef());
		ThreadContext.put("consumerRef", info.getConsumerRef());
		startFirst=true;
		return;
	}
	
	public static void stop(LogInfo info) throws Exception {
		if (!startFirst) throw new Exception("You need to call log start method first");
		dateTimeStop = new Date();
		long millisecs = Math.abs(dateTimeStop.getTime() - dateTimeStart.getTime());
		float diff = TimeUnit.SECONDS.convert(millisecs, TimeUnit.MILLISECONDS);
		ThreadContext.put("transactionElapsed", Long.toString(millisecs));
		ThreadContext.put("eventTime", dateTimeStop.toString());
		logger.info(info.getMessage());
		ThreadContext.clearAll();
		startFirst=false;
		return;
	}
	
	public static void error(LogInfo info, Exception e) throws Exception {
		if (!startFirst) throw new Exception("You need to call log start method first");
		dateTimeStop = new Date();
		long millisecs = Math.abs(dateTimeStop.getTime() - dateTimeStart.getTime());
		float diff = TimeUnit.SECONDS.convert(millisecs, TimeUnit.MILLISECONDS);
		ThreadContext.put("transactionElapsed", Long.toString(millisecs));
		ThreadContext.put("eventTime", dateTimeStop.toString());
		logger.error(info.getMessage(), e);
		ThreadContext.clearAll();
		startFirst=false;
		return;
	}

}
