package Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//open the document in the java readable format
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\CommonData.properties");
	
		//creat object of properties class from java.util
		Properties p = new Properties();
	
		//load the file input stream into properties
		p.load(fis);
	
		//provide the key and read the value
		String value = p.getProperty("url");
		System.out.println(value);
	
	}

}
