package anhtester.com.Bai19PageNavigation.testcases;

import anhtester.com.Bai19PageNavigation.pages.DashboardPage;
import anhtester.com.Bai19PageNavigation.pages.LoginPage;
import anhtester.com.common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setupTest(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogout(){
        dashboardPage = loginPage.logIn("admin01", "123456");
        dashboardPage.logOut();
    }

}
