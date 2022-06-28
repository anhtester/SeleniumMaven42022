package anhtester.com.Bai9SetupTestNG;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TasksTest extends BaseTest {

    @Test(priority = 1, description = "Login to HRM system")
    public void loginCRM(){
        driver.get("https://hrm.anhtester.com/");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin01");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 2, description = "Open Task menu")
    public void openTasksPage() throws InterruptedException {
        driver.findElement(By.xpath("//span[normalize-space()='Tasks']")).click();
    }

}
