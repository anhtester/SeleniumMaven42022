package anhtester.com.Bai24ParameterMultiBrowser.testcases;

import anhtester.com.Bai24ParameterMultiBrowser.pages.CommonPage;
import anhtester.com.Bai24ParameterMultiBrowser.pages.LoginPage;
import anhtester.com.common.BaseTest;
import anhtester.com.datatest.ConstantData;
import anhtester.com.utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public LoginPage loginPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void loginTest() {
        //Truyền driver từ BaseTestOLD sang các class Page
        loginPage = new LoginPage(driver);
        commonPage = new CommonPage(driver);
    }

    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        commonPage.dangXuat();
        WebUI.sleep(1);
    }

    @Test(priority = 2)
    public void testLoginWithUsernameInValid() {
        loginPage.loginWithUsernameInValid("admin123", "123456");
    }

    @Test(priority = 3)
    public void testLoginWithPasswordInValid() {
        loginPage.loginWithPasswordInValid("frances.burns", "123456789");
    }

    @Test(priority = 4)
    public void testForgotPassword() {
        loginPage.resetPassword("client01@mailinator.com");
    }

}
