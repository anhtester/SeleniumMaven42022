package anhtester.com.Bai20ThucHanhPOMPart1.testcases;

import anhtester.com.Bai20ThucHanhPOMPart1.pages.LoginPage;
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
    public void testLoginSuccess(){
        loginPage.logIn("admin01", "123456");
    }

    @Test(priority = 2)
    public void testLoginWithUsernameInValid(){
        loginPage.loginWithUsernameInValid("admin0123", "123456");
    }

    @Test(priority = 3)
    public void testLoginWithPasswordInValid(){
        loginPage.loginWithPasswordInValid("admin01", "123456789");
    }

    @Test(priority = 4)
    public void testForgotPassword(){
        loginPage.resetPassword("client01@mailinator.com");

    }

}
