package anhtester.com.Bai17POM.testcases;

import anhtester.com.Bai17POM.pages.LoginPage;
import anhtester.com.common.BaseTestOLD;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestOLD extends BaseTestOLD {

    public LoginPage loginPage;

    @BeforeMethod
    public void loginTest(){
        //Truyền driver từ BaseTestOLD sang các class Page
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
