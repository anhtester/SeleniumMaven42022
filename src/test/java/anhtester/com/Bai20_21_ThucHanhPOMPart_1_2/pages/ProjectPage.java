package anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages;

import anhtester.com.datatest.ConstantData;
import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends CommonPage {

    WebDriver driver;

    public ProjectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    public String pageText = "Dự án";
    public By headerPage = By.xpath("//li[@class='nav-item active']//a[contains(@href, '/erp/projects-list')]");
    By buttonThemMoi = By.xpath("//a[normalize-space()='Thêm mới']");
    By inputTieuDe = By.xpath("//input[@placeholder='Tiêu đề']");
    By dropdownKhachHang = By.xpath("//span[@id='select2-client_id-container']");
    By inputKhachHang = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");

    By inputNote = By.id("summary");

    By buttonLuu = By.xpath("//span[contains(text(),'Lưu')]");


    public void clickButtonThemMoi() {
        WebUI.clickElement(buttonThemMoi);
    }

    public void enterData(String projectName) {
        WebUI.setText(inputTieuDe, projectName);
        WebUI.clickElement(dropdownKhachHang);
        WebUI.setText(inputKhachHang, "Huong Nguyen");
        driver.findElement(inputKhachHang).sendKeys(Keys.ENTER);

        WebUI.sleep(1);

        driver.findElement(By.xpath("//label[contains(text(),'Ngày bắt đầu')]/following-sibling::div")).click();

        driver.findElement(By.xpath("//a[normalize-space()='21']")).click();

        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

        WebUI.sleep(1);

        driver.findElement(By.xpath("//label[contains(text(),'Ngày kết thúc')]/following-sibling::div")).click();

        driver.findElement(By.xpath("(//a[normalize-space()='25'])[2]")).click();

        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();

        WebUI.setText(inputNote, "Note");

    }

    public void addProject(String projectName) {
        clickButtonThemMoi();
        enterData(projectName);
    }

}
