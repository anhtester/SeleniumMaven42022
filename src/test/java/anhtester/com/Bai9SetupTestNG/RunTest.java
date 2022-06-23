package anhtester.com.Bai9SetupTestNG;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunTest extends BaseTest {

    @Test
    public void loginCRM(){
        createDriver();
        
        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin01");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        closeDriver();
    }

    @Test
    public void openProjectPage() throws InterruptedException {
        createDriver();

        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("leader01");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//span[normalize-space()='Dự án']")).click();
        //Assert.assertTrue(false, "Cố tình fail");

        closeDriver();
    }

}
