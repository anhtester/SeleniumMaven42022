package anhtester.com.Bai19PageNavigation.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuProject = By.xpath("//span[contains(text(),'Dự án')]");
    private By menuTask = By.xpath("//span[normalize-space()='Tasks']");
    private By buttonDangXuat = By.xpath("//a[@class='btn btn-smb btn-outline-primary rounded-pill']");

    public ProjectPage openProject(){
        WebUI.clickElement(menuProject);

        return new ProjectPage(driver);
    }

    public void openTask(){
        WebUI.clickElement(menuTask);
    }

    public void logOut(){
        WebUI.clickElement(buttonDangXuat);
    }

}
