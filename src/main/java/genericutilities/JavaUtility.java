package genericutilities;

import java.util.Date;

/**
 * This class consist of java related methods
 * 
 */
public class JavaUtility {

	public String Systemdate() {
		
		Date d = new Date();
		String dArr[] = d.toString().split(" ");
		String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"-"+dArr[3].replace(";", "-");
		return currentDate;
		
		
		
	}



}

