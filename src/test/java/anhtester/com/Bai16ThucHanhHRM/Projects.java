package anhtester.com.Bai16ThucHanhHRM;

import anhtester.com.common.BaseTest;
import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Projects extends BaseTest {

    String tenDuAn = "Project 2807A8";

    @Test
    public void createProject() {
        driver.get("https://hrm.anhtester.com");

        String loginPageText = driver.findElement(By.xpath("//h4[@class='mb-3 f-w-600']")).getText();
        System.out.println(loginPageText);
        Assert.assertEquals(loginPageText.trim(), "Welcome to HRM System", "Text không thuộc trang Login");

        WebUI.setText(driver, By.id("iusername"), "admin01");
        WebUI.setText(driver, By.id("ipassword"), "123456");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"), 5);
        WebUI.clickElement(driver, By.xpath("//span[contains(text(),'Dự án')]"));

        //driver.findElement(By.id("iusername")).sendKeys("admin01");
        //driver.findElement(By.id("ipassword")).sendKeys("123456");
        //driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();

        String pageDuAnURL = driver.getCurrentUrl();
        System.out.println(pageDuAnURL);
        Assert.assertTrue(pageDuAnURL.contains("/projects-list"), "Không đúng URL của trang Dự Án");

        driver.findElement(By.xpath("//a[normalize-space()='Thêm mới']")).click();

        WebUI.setText(driver, By.xpath("//input[@placeholder='Tiêu đề']"), tenDuAn);

        driver.findElement(By.xpath("//span[@id='select2-client_id-container']")).click();

        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Lam Nguyen");

        driver.findElement(By.xpath("//ul[@id='select2-client_id-results']//li[normalize-space()='Lam Nguyen']")).click();

        driver.findElement(By.name("budget_hours")).sendKeys("100");

        driver.findElement(By.xpath("//label[normalize-space()='Priority']/following-sibling::span")).click();

        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Cao");

        WebUI.sleep(1);

        driver.findElement(By.xpath("//span[@class='select2-results']//li[normalize-space()='Cao nhất']")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Ngày bắt đầu')]/following-sibling::div")).click();

        driver.findElement(By.xpath("//a[normalize-space()='21']")).click();

        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Ngày kết thúc')]/following-sibling::div")).click();

        driver.findElement(By.xpath("(//a[normalize-space()='25'])[2]")).click();

        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();

        driver.findElement(By.id("summary")).sendKeys("Note");

        WebElement inputNHOM = driver.findElement(By.xpath("//div[@id='employee_ajax']//li"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", inputNHOM);
        js.executeScript("arguments[0].click();", inputNHOM);

        driver.findElement(By.xpath("//div[@id='employee_ajax']//li//input")).sendKeys("Hai Mai");
        driver.findElement(By.xpath("//div[@id='employee_ajax']//li//input")).sendKeys(Keys.ENTER);

        //Nhấn nút Lưu
        driver.findElement(By.xpath("//span[normalize-space()='Lưu']")).click();

        //Tìm kiếm để kiểm tra lại
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//div[@id='xin_table_wrapper']//input")));
        driver.findElement(By.xpath("//div[@id='xin_table_wrapper']//input")).sendKeys(tenDuAn);

        WebUI.waitForElementVisible(driver, By.xpath("//td[normalize-space()='" + tenDuAn + "']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='" + tenDuAn + "']")));

        String titleDuAn = driver.findElement(By.xpath("//table[@id='xin_table']//tbody//td[1]")).getText();
        Assert.assertEquals(titleDuAn.toLowerCase(), tenDuAn.toLowerCase(), "Tên dự án sai");
    }

}
