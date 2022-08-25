package anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.testcases;

import anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages.DashboardPage;
import anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages.LoginPage;
import anhtester.com.common.BaseTestOLD;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTestOLD extends BaseTestOLD {

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

    @Test
    public void testNavigateToProject(){
        dashboardPage = loginPage.logIn("leader01", "123456");
        dashboardPage.openProject();
    }

}
