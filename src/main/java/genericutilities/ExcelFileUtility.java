package genericutilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * this method will read data from excel file and the value for caller
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetname, int rowNum, int cellNum ) throws Throwable
	{
		FileInputStream fes = new FileInputStream(".\\src\\main\\resources\\TestDataAS.xlsx");
		Workbook wb = WorkbookFactory.create(fes);
		String value = wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	
	}
	
	
}

