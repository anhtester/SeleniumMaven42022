package anhtester.com.Bai24ParameterMultiBrowser.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonPage {

    private WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);//Khởi tạo giá trị cho class WebUI
    }

    //Class chung
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;
    private TaskPage taskPage;

    //Object chung
    public By headerPage = By.xpath("//li[@class='nav-item active']/a");
    public By buttonDangXuat = By.xpath("//div[@class='page-header']//a[normalize-space()='Logout']");
    private By menuProject = By.xpath("//span[contains(text(),'Projects')]");
    private By menuTask = By.xpath("//span[normalize-space()='Tasks']");
    //Hàm chung để get khởi tạo của các trang khai báo trên và các hàm xử lý chung


    public LoginPage dangXuat() {
        WebUI.clickElement(buttonDangXuat);

        return new LoginPage(driver);
    }

    public ProjectPage openProject() {
        WebUI.clickElement(menuProject);
        boolean checkPage = WebUI.checkElementExist(headerPage);
        Assert.assertTrue(checkPage, "Fail. Chưa mở được trang Project. Element not found " + headerPage);
        String checkText = WebUI.getElementText(headerPage);
        Assert.assertTrue(checkText.contains(getProjectPage().pageText), "Fail. Text of Header Project page not match.");
        return new ProjectPage(driver);
    }

    public TaskPage openTask() {
        WebUI.clickElement(menuTask);
        boolean checkPage = WebUI.checkElementExist(headerPage);
        Assert.assertTrue(checkPage, "Fail. Chưa mở được trang Tasks. Element not found " + headerPage);

        String checkText = WebUI.getElementText(headerPage);
        Assert.assertTrue(checkText.contains(getTaskPage().pageText), "Fail. Text of Header Tasks page not match.");
        return new TaskPage(driver);
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(driver);
        }
        return dashboardPage;
    }

    public ProjectPage getProjectPage() {
        if (projectPage == null) {
            projectPage = new ProjectPage(driver);
        }
        return projectPage;
    }

    public TaskPage getTaskPage() {
        if (taskPage == null) {
            taskPage = new TaskPage(driver);
        }
        return taskPage;
    }

}
