package DataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {

DataFormatter formatter = new DataFormatter();
	@Test(dataProvider = "driveTest")
	public void testCaseData(String greeting,String communication ,String d)
	{
		System.out.println(greeting+communication+d);
	}
	
	//multiple sets of datato our tests
	//array
	//5 sets of data as 5 arrays from data provider to your tests
	//then test will run 5 times with 5 separate sets of data
	
@DataProvider(name="driveTest")
public Object[][] getData() throws IOException
{
//Object[][] data = {{"hello","text","1"},{"bye","message","2"},{"solo","call","67"}};
	
	//data from excel
	//every row of excel should be one arry
	
	FileInputStream file = new FileInputStream("C:\\Users\\pcpower\\Desktop\\Exceldriven.xlsx");
	
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
		row = sheet.getRow(i+1);
		for(int j=0;j<columnCount;j++)
		{
			
			XSSFCell cell= row.getCell(j);
			
		data[i][j] = formatter.formatCellValue(cell);
			
		}
	}
	
	return data;
//return data;
}
}
