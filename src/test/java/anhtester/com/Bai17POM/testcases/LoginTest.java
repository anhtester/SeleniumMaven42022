package anhtester.com.Bai17POM.testcases;

import anhtester.com.Bai17POM.pages.LoginPage;
import anhtester.com.common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public LoginPage loginPage;

    @BeforeMethod
    public void loginTest(){
        loginPage = new LoginPage(driver); //Truyền driver từ BaseTest sang các class Page
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
