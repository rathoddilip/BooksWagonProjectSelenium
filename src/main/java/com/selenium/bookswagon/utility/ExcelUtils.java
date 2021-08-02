package com.selenium.bookswagon.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    String excelPath;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {

        this.excelPath = excelPath;
        FileInputStream fileInputStream = new FileInputStream(excelPath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        fileInputStream.close();
    }


    public int getColCount() {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("number of column: " + colCount);

        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return colCount;
    }

    public int getRowCount() {
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("number of rows: " + rowCount);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return rowCount;
    }

    public String getCellDataString(int rowNumber, int colNumber) {
        String cellData = null;
        try {
            cellData = sheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();

        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return cellData;
    }
}
