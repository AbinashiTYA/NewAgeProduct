/*package Base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class loggerTest {
	private static boolean root = false;

	public static Logger getLogger(Class clas){
		if (root) {
			return Logger.getLogger(clas);
		}
		//String log4jLOcation = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		//String log4jLocation = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/resources/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
}*/