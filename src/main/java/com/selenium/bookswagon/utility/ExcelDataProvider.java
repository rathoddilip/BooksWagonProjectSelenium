package com.selenium.bookswagon.utility;

import java.io.IOException;

public class ExcelDataProvider {

    public static Object[][] testData(String excelPath, String sheetName) throws IOException, IOException {

        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        int rowCount = excelUtils.getRowCount();
        int colCount = excelUtils.getColCount();
        Object[][] data = new Object[rowCount - 1][colCount-1];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount-1; j++) {
                String cellData = excelUtils.getCellDataString(i, j);
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }
}
