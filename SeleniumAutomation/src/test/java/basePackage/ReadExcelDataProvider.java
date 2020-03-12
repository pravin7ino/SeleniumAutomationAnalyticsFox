package basePackage;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataProvider {
	
	public static Object[][] getExcelData(String filePath, String sheetName) throws Exception
	{
		FileInputStream fis = null;
		XSSFWorkbook workBook = null;
		XSSFSheet sheet = null;
		Object[][] excelData = null; 
		System.out.println(filePath);
		fis = new FileInputStream(filePath);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		
		excelData = new Object[rows][columns];
		
		for(int i=1; i<=rows; i++)
		{
			for(int j=0; j<columns; j++)
			{
				DataFormatter formatter = new DataFormatter();
				excelData[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j)).trim();
			}
		}
		workBook.close();
		fis.close();
		return excelData;
		
	}
}