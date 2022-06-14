package anhtester.com.Bai6WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebElement {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver; //Khai báo driver chung
        //Khởi tạo driver cho trình duyệt cụ thể cần automation
        WebDriverManager.chromedriver().setup(); //Cú pháp cài đặt driver cho Chrome Browser thích hợp version
        driver = new ChromeDriver(); //Cú pháp khởi tạo driver cho Chrome Browser
        driver.manage().window().maximize();

        driver.get("https://crm.anhtester.com/signin");
        Thread.sleep(2000);
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement buttonSignIn = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys("admin02@mailinator.com");
        Thread.sleep(1000);
        //inputEmail.clear();
        inputPassword.sendKeys("123456");

        buttonSignIn.isEnabled();
        System.out.println(buttonSignIn.isEnabled());

        //buttonSignIn.click();
        buttonSignIn.submit();

        Thread.sleep(2000);
        driver.quit();
    }

}
