package anhtester.com.Bai20ThucHanhPOMPart1.testcases;

import anhtester.com.Bai20ThucHanhPOMPart1.pages.DashboardPage;
import anhtester.com.Bai20ThucHanhPOMPart1.pages.LoginPage;
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

    @Test(priority = 1)
    public void testOpenProjectPage(){
        dashboardPage = loginPage.logIn("admin01", "123456");
        dashboardPage.openProject();
    }

    @Test(priority = 2)
    public void testLogout(){
        dashboardPage = loginPage.logIn("admin01", "123456");
        dashboardPage.logOut();
    }

}
