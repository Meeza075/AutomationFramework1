package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelFileUtility {
	public String toReadDataFromExcelFile(String sheetname, int row,int cell) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);	
      Workbook wb= WorkbookFactory.create(fis);
      String value=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
      return value;
      
	}
	

}
