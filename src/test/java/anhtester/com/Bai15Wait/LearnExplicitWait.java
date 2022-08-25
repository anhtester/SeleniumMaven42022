package anhtester.com.Bai15Wait;

import anhtester.com.common.BaseTestOLD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LearnExplicitWait extends BaseTestOLD {

    WebDriverWait wait;

    @Test(priority = 1)
    public void ExplicitWaitDemo1() {

        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.id("iusername")).sendKeys("admin01");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án

        //Chời đợi đến khi element tìm thấy trong DOM và sẵn sàng hiển thị để thao tác
        //Đối tượng By
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Dự án')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();
    }

    @Test
    public void ImplicitWaitDemo2() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ecommerce.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        WebElement element = driver.findElement(By.xpath("//div[normalize-space()='Automobile & Motorcycle']"));

        element.click();

    }

    @Test
    public void ExplicitWaitDemo3() {

        driver.get("https://ecommerce.anhtester.com/");

        waitForElementVisible(By.xpath("//i[@class='la la-close fs-20']"), 5).click();

        waitForElementPresent(By.xpath("//div[normalize-space()='Automobile & Motorcycle']"), 2).click();

    }

}
