package DataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excel {

	@Test
	public void getExcl() throws IOException
	{
	
	FileInputStream file = new FileInputStream("C:\\Users\\pcpower\\Desktop\\Exceldriven.xlsx");
	
	System.out.println(file);

	
	XSSFWorkbook wb = new XSSFWorkbook(file);
	
	XSSFSheet sheet = wb.getSheetAt(0);
	
	int rowCount = sheet.getPhysicalNumberOfRows();
	
	XSSFRow row =sheet.getRow(0);
	
	int columnCount = row.getLastCellNum();
	
	Object data[][] = 	new Object[rowCount-1][columnCount];
	
	
	//data[0][0] = {"hello"};
	//data[0][1] = {"text"}
	//data[0][2] = {"1"}
	for(int i=0;i<rowCount-1;i++)
	{
		System.out.println("outerloop started");
		 row = sheet.getRow(i+1);
		for(int j =0;j<columnCount;j++)
		{
		System.out.println(row.getCell(j)+"hi");
			
		}
	}
	{
		
	}
	}
}