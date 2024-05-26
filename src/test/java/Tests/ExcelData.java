package Tests;

import com.Bank.ReadData.ExcelLibrary;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class ExcelData {
    @Test
    public void readExcelData() throws Exception {

        ExcelLibrary obj = new ExcelLibrary();
        String invalidName = obj.readData("Test", 0, 0);
        String invalidPassword = obj.readData("Test", 0, 1);
        System.out.println("The invalid Name is "+ invalidName);
        System.out.println("The invalid password is "+ invalidPassword);
    }
//    @Test
//    public void readExcelData() throws Exception {
//        String path ="C:\\Users\\elattar\\Desktop\\test\\Banking\\TestData\\LoginData.xlsx";
//        String fileName = "LoginData";
//        String sheetName = "Test";
//
//        File file = new File(path);
//        // to read the file
//        FileInputStream fis =new FileInputStream(file);
//        XSSFWorkbook wb = new XSSFWorkbook(fis);
//
//        XSSFSheet sheet = wb.getSheet(sheetName);
//
//        int Rows = sheet.getLastRowNum();
//        System.out.println("Total Rows "+ Rows);
//
//        for (int i = 0; i <= Rows; i++) {
//          Row row = sheet.getRow(i);
//            for (int j = 0; j < row.getLastCellNum(); j++) {
//               String data = sheet.getRow(i).getCell(j).getStringCellValue();
//               System.out.print(data+ " ");
//            }
//            System.out.println();
//        }
//        wb.close();
//    }
}
