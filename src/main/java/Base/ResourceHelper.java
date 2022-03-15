package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;



public class ResourceHelper {
	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath() + resource;
		return path;
	}
	
	public static String getBaseResourcePath() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		//System.out.println("***** testing TYA Automation.");
		return path;
	}
	
	public static InputStream getResourcePathInputStream(String path) throws FileNotFoundException{
		return new FileInputStream(ResourceHelper.getResourcePath(path));
	}

	
}
