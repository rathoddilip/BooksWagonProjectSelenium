package com.selenium.bookswagon.utility;

public class CustomException extends Exception{

    ExceptionType type;

    public enum ExceptionType {
        FILE_NOT_EXIST,IS_NOT_A_DIRECTORY,
    }

    public CustomException(ExceptionType type, String message) {

        super(message);
        this.type = type;
    }
}
