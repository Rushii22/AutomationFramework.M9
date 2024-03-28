package genericutilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	/**
	 *  this method will read data from property file and return the value to caller
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	
	}
	
}
