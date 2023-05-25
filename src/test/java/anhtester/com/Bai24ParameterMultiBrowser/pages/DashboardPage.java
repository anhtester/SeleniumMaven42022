package anhtester.com.Bai24ParameterMultiBrowser.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    public By menuTrangChu = By.xpath("//a[normalize-space()='Home']");

}
