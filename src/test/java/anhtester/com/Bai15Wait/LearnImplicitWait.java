package anhtester.com.Bai15Wait;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class LearnImplicitWait extends BaseTest {

    @Test(priority = 1)
    public void ImplicitWaitDemo() {

        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.id("iusername")).sendKeys("admin01");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(),'Dự án 123456')]")).click();
    }


    @Test(priority = 2)
    public void ImplicitWaitDemo2() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.id("iusername")).sendKeys("admin01");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();
    }

}
