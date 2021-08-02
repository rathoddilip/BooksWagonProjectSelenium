package com.selenium.bookswagon.utility;

import com.selenium.bookswagon.base.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepositoryLibrary extends BaseClass {


    public static String getLocatorProperty(String propertyFilePath, String key) throws IOException {

        String property = "";
        Properties properties = new Properties();
        properties.load(new FileInputStream(propertyFilePath));
        property = properties.getProperty(key);
        try {
            if (property.isEmpty())
            {
                throw new CustomException(CustomException.ExceptionType.FILE_NOT_EXIST,"please check properties file");
            }

        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
        }
        return property;
    }
}
