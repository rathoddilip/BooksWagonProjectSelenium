package com.selenium.bookswagon.pages;

import com.selenium.bookswagon.base.BaseClass;
import com.selenium.bookswagon.utility.LogClass;
import com.selenium.bookswagon.utility.ObjectRepositoryLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Login extends BaseClass {

    public static String propertyFilePath="/home/arjun/Dilip/BooksWagonProject/src/test/resources/objectRepoLib.properties";

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement Login_Btn;

    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    WebElement sign_in_email;

    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    WebElement sign_in_pwd;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_btnLogin\"]")
    WebElement login;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String login_to_application_with_valid_credential(String emailId,String password) throws InterruptedException {
       Thread.sleep(4000);
        LogClass.info("clicking on login");
        Login_Btn.click();
        Thread.sleep(2000);
        LogClass.info("Enter email id");
        sign_in_email.sendKeys(emailId);
        Thread.sleep(2000);
        LogClass.info("Enter password");
        sign_in_pwd.sendKeys(password);
        Thread.sleep(2000);
        LogClass.info("click on login button");
        login.click();
        Thread.sleep(3000);
        LogClass.info("you're login successfully");
        return driver.getTitle();
    }
    public String login_to_application_from_object_repo_lib() throws InterruptedException, IOException {
        Thread.sleep(4000);
        LogClass.info("clicking on login");
        Login_Btn.click();
        Thread.sleep(2000);
        LogClass.info("Enter email id");
        sign_in_email.sendKeys(ObjectRepositoryLibrary.getLocatorProperty(propertyFilePath,"usernameFromRepo"));
        Thread.sleep(2000);
        LogClass.info("Enter password");
        sign_in_pwd.sendKeys(ObjectRepositoryLibrary.getLocatorProperty(propertyFilePath,"passwordFromRepo"));
        Thread.sleep(2000);
        LogClass.info("click on login button");
        login.click();
        Thread.sleep(3000);
        LogClass.info("you're login successfully");
        return driver.getTitle();
    }
}
