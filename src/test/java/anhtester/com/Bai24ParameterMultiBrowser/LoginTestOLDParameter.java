package anhtester.com.Bai24ParameterMultiBrowser;

import anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages.CommonPage;
import anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages.LoginPage;
import anhtester.com.common.BaseTestOLD;
import anhtester.com.utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestOLDParameter extends BaseTestOLD {

    public LoginPage loginPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void loginTest(){
        //Truyền driver từ BaseTestOLD sang các class Page
        loginPage = new LoginPage(driver);
        commonPage = new CommonPage(driver);
    }

    @Test(priority = 1)
    @Parameters({"username", "password"})
    public void testLoginSuccess(String username, String password){
        loginPage.logIn(username, password);
        commonPage.dangXuat();
        WebUI.sleep(2);
    }

    @Test(priority = 2)
    @Parameters({"username", "password"})
    public void testLoginWithUsernameInValid(String username, String password){
        loginPage.loginWithUsernameInValid(username, password);

    }

}
