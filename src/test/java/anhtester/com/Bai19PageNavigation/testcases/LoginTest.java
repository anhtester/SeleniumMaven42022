package anhtester.com.Bai19PageNavigation.testcases;

import anhtester.com.Bai19PageNavigation.pages.LoginPage;
import anhtester.com.common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public LoginPage loginPage;

    @BeforeMethod
    public void loginTest(){
        //Truyền driver từ BaseTest sang các class Page
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void testLoginValid(){
        loginPage.logIn("admin01", "123456");
    }

    @Test(priority = 2)
    public void testForgotPassword(){
        loginPage.resetPassword("client01@mailinator.com");

    }

}
