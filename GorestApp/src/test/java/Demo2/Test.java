package Demo2;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Test {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test.class);
		BasicConfigurator.configure();
		logger.debug("Hello");
		
	}

}
