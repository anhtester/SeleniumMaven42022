package anhtester.com.Bai19PageNavigation.testcases;

import anhtester.com.Bai19PageNavigation.pages.DashboardPage;
import anhtester.com.Bai19PageNavigation.pages.LoginPage;
import anhtester.com.Bai19PageNavigation.pages.ProjectPage;
import anhtester.com.common.BaseTestOLD;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectTestOLD extends BaseTestOLD {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;

    @BeforeMethod
    public void setupTest() {
        //Lúc nào nó cũng sẽ khởi tạo trước
        //Vì nó là hành động đầu tiên
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testOpenProject() {
        //Login
        //Nhấn menu Project tại trang Dashboard

        //Tạo sự liên kết trang thông qua gán dấu = từ đối tượng trang = hàm đã liên kết
        //Không cần khởi tạo trang từ đầu ( dashboardPage = new DashboardPage(driver); )
        //DashboardPage sẽ được khởi tạo luôn khi Login thành công
        //dashboardPage = new DashboardPage(driver);
        dashboardPage = loginPage.logIn("admin01", "123456"); //dashboardPage = new DashboardPage(driver);
        dashboardPage.openProject();

    }

    @Test
    public void testAddProject() {
        dashboardPage = loginPage.logIn("admin01", "123456");
        projectPage = dashboardPage.openProject();
        projectPage.addProject();
    }

}
