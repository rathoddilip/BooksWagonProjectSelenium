package com.selenium.bookswagon.test;

import com.selenium.bookswagon.base.BaseClass;
import com.selenium.bookswagon.pages.Home;
import com.selenium.bookswagon.pages.Login;
import com.selenium.bookswagon.utility.CustomListener;
import com.selenium.bookswagon.utility.DataProviderClass;
import com.selenium.bookswagon.utility.Operations;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(CustomListener.class)
@Feature("Login to application")
public class BookswagonTest extends BaseClass {

    String username = "diliprathodtest@gmail.com";
    String password = "Login@123";

    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Login")
    @Description("Login to application with valid credentials")
    @Test(priority = 1)
    public void login_to_application() throws InterruptedException {

        Login login = new Login(driver);
        login.login_to_application_with_valid_credential(username, password);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Login to application with valid credentials")
    @Story("Test login account by using data provider credentials ")
    @Test(priority = 2,dataProvider = "testDataSetFromExcelFile", dataProviderClass = DataProviderClass.class)
    public void login_to_application_using_dataProvider_data(String emailId, String passwd) throws InterruptedException {

        Login login = new Login(driver);
        login.login_to_application_with_valid_credential(emailId, passwd);
        Home home = new Home(driver);
        home.logout_from_account();
        String expectedUrl = "https://www.bookswagon.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Login")
    @Description("Login to application with valid credentials from object repository property file")
    @Test(priority = 3)
    public void login_to_application_get_login_credential_from_object_repo() throws InterruptedException, IOException {

        Login login = new Login(driver);
        String actual = login.login_to_application_from_object_repo_lib();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
        System.out.println("You're successfully logged in..!!");
    }

    @Test(priority = 4)
    public void login_test() throws InterruptedException {

        Login login = new Login(driver);
        String actual = login.login_to_application_with_valid_credential(username, password);
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
        System.out.println("You're successfully logged in..!!");
    }

    @Test(priority = 5)
    public void add_to_wishlist_test() throws InterruptedException {

        Login login = new Login(driver);
        login.login_to_application_with_valid_credential(username, password);
        Home homePage = new Home(driver);
        String actual = homePage.add_to_cart();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
        System.out.println("Book is added to cart is successfully!!");
    }

    @Test(priority = 6)
    public void place_order_test() throws InterruptedException {

        Operations operations = new Operations(driver);
        String act_title = operations.buy_book();
        String exp_title = "Bookswagon.com: Buy Books Online: Bookstore in India: Highest Discount";
        Assert.assertEquals(act_title, exp_title);
    }
    @Test(priority = 7)
    public void search_book_test() throws InterruptedException {

        login_to_application();
        Operations operations = new Operations(driver);
        String actual = operations.add_to_wishlist_books();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void buy_book_before_login() throws InterruptedException, IOException {

        Operations operations = new Operations(driver);
        String act_title = operations.buy_test();
        String exp_title = "Bookswagon.com: Buy Books Online: Bookstore in India: Highest Discount";
        Assert.assertEquals(act_title, exp_title);
    }

    @Test(priority = 8)
    public void remove_book_test() throws InterruptedException {

        login_to_application();
        Operations operations = new Operations(driver);
        String actual_title = operations.remove_from_cart();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title, expected_title);
        System.out.println("book is removed successfully");
    }

    @Test(priority = 9)
    public void search_book_before_login_test() throws InterruptedException {

        Operations operations = new Operations(driver);
        String actual = operations.add_to_wishlist_books();
        login_to_application();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
    }
}
