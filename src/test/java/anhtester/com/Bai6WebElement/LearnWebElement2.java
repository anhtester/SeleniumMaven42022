package anhtester.com.Bai6WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebElement2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver; //Khai báo driver chung
        //Khởi tạo driver cho trình duyệt cụ thể cần automation
        WebDriverManager.chromedriver().setup(); //Cú pháp cài đặt driver cho Chrome Browser thích hợp version

        driver = new ChromeDriver(); //Cú pháp khởi tạo driver cho Chrome Browser

        driver.manage().window().maximize();

        System.out.println(driver.manage().window().getSize());

        driver.get("https://anhtester.com/");

        Thread.sleep(2000);
//        WebElement inputEmail = driver.findElement(By.xpath("//h1[normalize-space()='Anh Tester - Automation Testing']"));
//        inputEmail.isDisplayed();
//
//        System.out.println(inputEmail.isDisplayed());

        WebElement websiteModule = driver.findElement(By.id("btn-signup"));

        Point point = websiteModule.getLocation();

        System.out.println(point);



        Thread.sleep(2000);
        driver.quit();
    }

}
