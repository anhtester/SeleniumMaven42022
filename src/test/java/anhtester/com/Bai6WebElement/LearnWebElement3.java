package anhtester.com.Bai6WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebElement3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver; //Khai báo driver chung
        //Khởi tạo driver cho trình duyệt cụ thể cần automation
        WebDriverManager.chromedriver().setup(); //Cú pháp cài đặt driver cho Chrome Browser thích hợp version
        driver = new ChromeDriver(); //Cú pháp khởi tạo driver cho Chrome Browser
        driver.manage().window().maximize();

        driver.get("https://demo.anhtester.com/basic-radiobutton-demo.html");
        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath("(//input[@name='optradio'])[1]"));
        element1.click();

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath("(//input[@name='optradio'])[1]"));
        element2.isSelected();

        System.out.println(element2.isSelected());

        Thread.sleep(2000);
        driver.quit();
    }

}
