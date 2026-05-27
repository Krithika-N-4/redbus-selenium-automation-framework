package com.setup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLog {
	
	public static Logger getLogger(Class <?> cls) {
		return LoggerFactory.getLogger(cls);
	}
}
