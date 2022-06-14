package anhtester.com.Bai7WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicWebDriver {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.get("https://anhtester.com");
        Thread.sleep(1000);
        driver.findElement(By.id("btn-login22")).click();
        Thread.sleep(2000);
//        driver.navigate().back();
//        Thread.sleep(2000);
//        driver.navigate().forward();
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

//        String html = driver.getPageSource();
//        System.out.println(driver.getPageSource());
//
//        System.out.println(html.contains("placeholder=\"Email\""));

        Cookie newCookie = new Cookie("number", "1234567890");
        driver.manage().addCookie(newCookie);

        System.out.println(newCookie.getValue());
        System.out.println(driver.manage().getCookieNamed("ci_session"));

        Thread.sleep(2000);
        driver.quit();
    }

}
