package com.help.test.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Myshowlog {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/test/resources/com/help/test/log/log4j.properties");
		Logger logger = Logger.getLogger(Myshowlog.class);
		logger.debug(" debug ");
		logger.error(" error zheshi yige 111b bug");
		logger.info(" this is a bug for the just test");
	}

}
