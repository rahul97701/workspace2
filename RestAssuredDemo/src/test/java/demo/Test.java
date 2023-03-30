package demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Test {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test.class);
		BasicConfigurator.configure();
		logger.debug("Hello from debug mode");
		logger.error("Hello from error mode");
		logger.fatal("Hello from fatal mode");
		logger.info("Hello from info mode");
	
		
	}

}
