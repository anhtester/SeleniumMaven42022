package anhtester.com.Bai20ThucHanhPOMPart1.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProjectPage {

    WebDriver driver;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

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

    public void enterData() {
        WebUI.setText(inputTieuDe, "Project 0708A1");
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

    public void addProject() {
        clickButtonThemMoi();
        enterData();
    }

}
