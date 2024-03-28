package Practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Throwable {

		//open the document in java readable formate
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\TestDataAS.xlsx");
		
		//create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Navigate to req. sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//Navigate to req. row
		Row r = sh.getRow(1);
		
		//Navigate to req. cell
		Cell cl = r.getCell(2);
		
		//capture the data in the cell
		String value = cl.getStringCellValue();
		System.out.println(value);
	
	}

}
