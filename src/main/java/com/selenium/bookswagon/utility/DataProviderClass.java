package com.selenium.bookswagon.utility;

import com.selenium.bookswagon.base.BaseClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class DataProviderClass extends BaseClass {

    String excelPath = "/home/arjun/Dilip/BooksWagonProject/src/main/resources/BooksWagonLoginCreadentials.xlsx";
    String sheetName = "loginCredentials";

    // @DataProvider passes data to test
    @DataProvider(name = "testDataSetFromExcelFile")
    public  Object[][] getDataTest() throws IOException {
        File file = new File(excelPath);
        try {
            if (!file.exists()) {

                throw new CustomException(CustomException.ExceptionType.FILE_NOT_EXIST, "File not Exist Please check file path and file name");
            }
        } catch (CustomException exception) {

            System.out.println(exception.getMessage());
        }
        Object[][] data = ExcelDataProvider.testData(excelPath, sheetName);
        return data;
    }
}
