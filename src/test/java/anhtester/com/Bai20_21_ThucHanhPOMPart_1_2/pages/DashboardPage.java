package anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends CommonPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    public By menuTrangChu = By.xpath("//a[normalize-space()='Trang chủ']");

}
