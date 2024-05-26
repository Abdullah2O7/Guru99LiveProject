package com.Bank.ReadData;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadExcel {
    public void readExcelData() throws Exception {
        String path ="C:\\Users\\elattar\\Desktop\\test\\Banking\\TestData\\LoginData.xls";
        String fileName = "LoginData";
        String sheetName = "Test";

        File file = new File(path);
        // to read the file
        FileInputStream fis =new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheet(sheetName);

        int totalRows = sheet.getLastRowNum();
        System.out.println("Total Rows"+ totalRows);
    }
}
