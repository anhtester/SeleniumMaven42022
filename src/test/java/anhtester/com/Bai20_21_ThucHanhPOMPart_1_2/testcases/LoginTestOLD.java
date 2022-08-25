package anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.testcases;

import anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages.CommonPage;
import anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages.LoginPage;
import anhtester.com.common.BaseTestOLD;
import anhtester.com.datatest.ConstantData;
import anhtester.com.utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestOLD extends BaseTestOLD {

    public LoginPage loginPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void loginTest(){
        //Truyền driver từ BaseTestOLD sang các class Page
        loginPage = new LoginPage(driver);
        commonPage = new CommonPage(driver);
    }

    @Test(priority = 1)
    public void testLoginSuccess(){
        loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        commonPage.dangXuat();
        WebUI.sleep(2);
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
