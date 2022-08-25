package anhtester.com.Bai15Wait;

import anhtester.com.common.BaseTestOLD;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LearnFluentWait extends BaseTestOLD {

    @Test(priority = 3)
    public void FluentWaitDemo() throws InterruptedException {

        //Set timeout for FluentWait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.id("iusername")).sendKeys("admin01");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Dự án')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();

    }

}
