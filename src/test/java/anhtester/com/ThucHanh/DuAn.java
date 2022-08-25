package anhtester.com.ThucHanh;

import anhtester.com.common.BaseTestOLD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DuAn extends BaseTestOLD {

    @Test(priority = 1)
    public void loginToHRM() throws InterruptedException {
        driver.get("https://hrm.anhtester.com");
        Thread.sleep(500);

        String loginPageText = driver.findElement(By.xpath("//h4[@class='mb-3 f-w-600']")).getText();
        System.out.println(loginPageText);
        Assert.assertEquals(loginPageText.trim(), "Welcome to HRM System", "Text không thuộc trang Login");

        driver.findElement(By.id("iusername")).sendKeys("admin01");
        Thread.sleep(500);
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(6000);
    }

    @Test(priority = 2)
    public void openDuAn() throws InterruptedException {
        System.out.println("openDuAn");
        driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();
        Thread.sleep(2000);
        String pageDuAnURL = driver.getCurrentUrl();
        System.out.println(pageDuAnURL);
        Assert.assertTrue(pageDuAnURL.contains("/projects-list"), "Không đúng URL của trang Dự Án");
        //Assert.assertEquals(pageDuAnURL, "https://hrm.anhtester.com/erp/projects-list", "Không đúng URL của trang Dự Án");

    }

    @Test(priority = 3)
    public void addNewDuAn() throws InterruptedException {
        System.out.println("addNewDuAn");
        String tenDuAn = "Dự Án 3006A1";

        driver.findElement(By.xpath("//a[normalize-space()='Thêm mới']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Tiêu đề']")).sendKeys(tenDuAn);

        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@id='select2-client_id-container']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Lam Nguyen");
        Thread.sleep(500);
        driver.findElement(By.xpath("//ul[@id='select2-client_id-results']//li[normalize-space()='Lam Nguyen']")).click();

        Thread.sleep(500);
        driver.findElement(By.name("budget_hours")).sendKeys("100");

        Thread.sleep(500);
        driver.findElement(By.xpath("//label[normalize-space()='Priority']/following-sibling::span")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Cao");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@class='select2-results']//li[normalize-space()='Cao nhất']")).click();

        Thread.sleep(500);
        driver.findElement(By.xpath("//label[contains(text(),'Ngày bắt đầu')]/following-sibling::div")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[normalize-space()='21']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

        Thread.sleep(500);
        driver.findElement(By.xpath("//label[contains(text(),'Ngày kết thúc')]/following-sibling::div")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//a[normalize-space()='25'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();

        Thread.sleep(500);
        driver.findElement(By.id("summary")).sendKeys("Note");

        Thread.sleep(500);

        WebElement inputNHOM = driver.findElement(By.xpath("//div[@id='employee_ajax']//li"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", inputNHOM);
        Thread.sleep(500);
        js.executeScript("arguments[0].click();", inputNHOM);
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id='employee_ajax']//li//input")).sendKeys("Hai Mai");
        driver.findElement(By.xpath("//div[@id='employee_ajax']//li//input")).sendKeys(Keys.ENTER);
        Thread.sleep(500);

        //Nhấn nút Lưu
        driver.findElement(By.xpath("//span[normalize-space()='Lưu']")).click();

        Thread.sleep(2000);
        //Tìm kiếm để kiểm tra lại
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//div[@id='xin_table_wrapper']//input")));
        driver.findElement(By.xpath("//div[@id='xin_table_wrapper']//input")).sendKeys(tenDuAn);
        Thread.sleep(1000);

        String titleDuAn = driver.findElement(By.xpath("//table[@id='xin_table']//tbody//td[1]")).getText();
        Assert.assertEquals(titleDuAn, tenDuAn, "Tên dự án sai");
    }


}
