package excelReadExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel2 {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream("./testData/RegisterStudent.xls");
		
		//workbook
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("smokeTest");
		//XSSFSheet sheet = workbook.getSheet("Student");
		
		int rowCount = sheet.getLastRowNum();
		int columnCount =sheet.getRow(0).getLastCellNum();
		
		System.out.println("no. of Rows: " + rowCount);
		System.out.println("no. of Columns: " + columnCount);
		
		
		
		for(int i = 1; i <= rowCount; i++) {
			
			
		
			HSSFRow currentRow = sheet.getRow(i);
			
			String firstName = currentRow.getCell(0).toString();
			String lastName = currentRow.getCell(1).toString();
			String email = currentRow.getCell(2).toString();
			String mobile = currentRow.getCell(3).toString();
			String address = currentRow.getCell(4).toString();
			
			
			System.out.println("*******************");
			System.out.println("FirstName: " + firstName);
			System.out.println("Address details: " + address);
		}
		
		
		

	}

}
