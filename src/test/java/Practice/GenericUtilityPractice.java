package Practice;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtility;
import genericutilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String args[]) throws Throwable {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("password");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Sheet1", 1, 2);
		System.out.println(data);
		
		JavaUtility jUtil=new JavaUtility();
		String date = jUtil.Systemdate();
		System.out.println(date);
		
		
		
	}
	
	
}
