package anhtester.com.Bai18PageFactory.testcases;

import anhtester.com.Bai18PageFactory.pages.DashboardPageFactory;
import anhtester.com.Bai18PageFactory.pages.LoginPageFactory;
import anhtester.com.common.BaseTest;
import anhtester.com.utils.WebUI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestFactory extends BaseTest {

    private LoginPageFactory loginPageFactory;
    private DashboardPageFactory dashboardPageFactory;

    @BeforeMethod
    public void setupTest(){
        loginPageFactory = new LoginPageFactory(driver);
        dashboardPageFactory = new DashboardPageFactory(driver);
    }

    @Test
    public void testLoginFactory(){
        loginPageFactory.login("admin01", "123456");
        //WebUI.sleep(6);
        //dashboardPageFactory.clickCheckin();
    }


}
