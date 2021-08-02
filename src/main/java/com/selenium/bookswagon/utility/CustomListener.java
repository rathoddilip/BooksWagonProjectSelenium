package com.selenium.bookswagon.utility;

import com.selenium.bookswagon.base.BaseClass;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CustomListener extends BaseClass implements ITestListener {
    ScreenshotTestImage screenshotTestImage = new ScreenshotTestImage();
    public static int rowDynamic = 1;

    public CustomListener() {
    }

    public void onStart(ITestContext result) {
        try {
            MyScreenRecorder.startRecording(result.getName());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onFinish(ITestContext result) {
        try {
            MyScreenRecorder.stopRecording();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("SUCCESS Test");

        try {
            screenshotTestImage.success(result.getMethod().getMethodName());
            WriteTestStatusToExcel.writeStatus(rowDynamic, 2, "PASS");
            LogClass.info(result.getMethod().getMethodName() + " :take success screenshot in interface listener method");
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Error pass: " + "_" + 2 + "_" + "pass");
        }
        rowDynamic++;
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED Test");

        try {
            screenshotTestImage.failed(result.getMethod().getMethodName());
            WriteTestStatusToExcel.writeStatus(rowDynamic, 2, "FAIL");
            LogClass.error(result.getMethod().getMethodName() + " :take failed screenshot in interface listener method");
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Error fail: " + "_" + 2 + "_" + "fail");
        }
        rowDynamic++;
    }
}
