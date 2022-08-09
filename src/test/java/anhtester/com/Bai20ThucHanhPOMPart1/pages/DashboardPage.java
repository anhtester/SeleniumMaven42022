package anhtester.com.Bai20ThucHanhPOMPart1.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    WebDriver driver;
    ProjectPage projectPage;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
        projectPage = new ProjectPage(driver);
    }

    private By menuProject = By.xpath("//span[contains(text(),'Dự án')]");
    private By menuTask = By.xpath("//span[normalize-space()='Tasks']");
    private By buttonDangXuat = By.xpath("//a[@class='btn btn-smb btn-outline-primary rounded-pill']");

    public By menuTrangChu = By.xpath("//a[normalize-space()='Trang chủ']");

    public ProjectPage openProject() {
        WebUI.clickElement(menuProject);
        boolean checkPage = WebUI.checkElementExist(projectPage.headerPage);
        Assert.assertTrue(checkPage, "Fail. Chưa mở được trang Project. Element not found " + projectPage.headerPage);

        return new ProjectPage(driver);
    }

    public void openTask() {
        WebUI.clickElement(menuTask);
    }

    public void logOut() {
        WebUI.clickElement(buttonDangXuat);
    }

}
