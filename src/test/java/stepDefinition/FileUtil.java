package stepDefinition;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtil {

	public static Giftcard getData() throws Exception {

		// read excel file

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\tjmax.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		// getting first worksheet

		Sheet firstSheet = workbook.getSheetAt(0);

		Row r = firstSheet.getRow(0);
		Cell c = r.getCell(1);
		String rname = c.getStringCellValue();

		r = firstSheet.getRow(1);
		c = r.getCell(1);
		String sname = c.getStringCellValue();

		r = firstSheet.getRow(2);
		c = r.getCell(1);
		String message = c.getStringCellValue();

		r = firstSheet.getRow(3);
		c = r.getCell(1);
		String email = c.getStringCellValue();

		r = firstSheet.getRow(4);
		c = r.getCell(1);
		String configemail = c.getStringCellValue();

		// Populate POJO

		Giftcard giftcard = new Giftcard(rname, sname, message, email, configemail);

		System.out.println(giftcard);

		inputStream.close();

		return giftcard;

	}

	public static StoreLocation getData1() throws Exception {

		// read excel file

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\tjmax.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		// getting first worksheet

		Sheet secondSheet = workbook.getSheetAt(1);

		Row r = secondSheet.getRow(0); // first row
		Cell c = r.getCell(1);
		int zip = (int) c.getNumericCellValue();
		
		r = secondSheet.getRow(1); // second row
		c = r.getCell(1);
		String city = c.getStringCellValue();

		r = secondSheet.getRow(2); // third row
		c = r.getCell(1);
		String city1 = c.getStringCellValue();

		// Populate POJO

		StoreLocation storelocation = new StoreLocation(zip, city, city1);

		System.out.println(storelocation);

		inputStream.close();

		return storelocation;

	}
	
	public static SearchItem getData2() throws Exception {

		// read excel file

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\tjmax.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		// getting first worksheet

		Sheet thirdSheet = workbook.getSheetAt(2);

		Row r = thirdSheet.getRow(0);
		Cell c = r.getCell(1);
		String item= c.getStringCellValue();

		// Populate POJO

		SearchItem searchitem = new SearchItem(item);

		System.out.println(searchitem);

		inputStream.close();

		return searchitem;

	}

	public static DeleteItem getData3() throws Exception {

		// read excel file

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\tjmax.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		// getting first worksheet

		Sheet fourthSheet = workbook.getSheetAt(3);

		Row r = fourthSheet.getRow(0);
		Cell c = r.getCell(1);
		String item= c.getStringCellValue();

		// Populate POJO

		DeleteItem deleteitem = new DeleteItem(item);

		System.out.println(deleteitem);

		inputStream.close();

		return deleteitem;

	}


}
