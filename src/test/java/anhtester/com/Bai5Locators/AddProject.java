package anhtester.com.Bai5Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProject {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hrm.anhtester.com");

        Thread.sleep(1000);

        //Tìm element bằng thuộc tính
        driver.findElement(By.id("iusername")).sendKeys("admin01");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(1000);
        //Tìm element bằng Xpath tuyệt đối
        driver.findElement(By.xpath("//button[normalize-space()='AddProject']")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Thêm mới']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Tiêu đề']")).sendKeys("Name 01");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@id='select2-client_id-container']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Lam Nguyen");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='select2-client_id-results']//li[normalize-space()='Lam Nguyen']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[normalize-space()='Priority']/following-sibling::span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Cao");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='select2-results']//li[normalize-space()='Cao nhất']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[contains(text(),'Ngày bắt đầu')]/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='22']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();


        Thread.sleep(2000);
        driver.quit();

    }

}
