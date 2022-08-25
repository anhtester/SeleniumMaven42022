package anhtester.com.Bai14JavaScriptExecutor.Bai11Assertion;

import anhtester.com.common.BaseTestOLD;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert extends BaseTestOLD {

    @Test(priority = 1)
    public void checkTitle() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester - Automation Testing";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle);

        Assert.assertEquals(driver.findElement(By.id("btn-login")).getText().trim(), "LOG IN", "Text not Login");

        Assert.assertTrue(driver.findElement(By.id("btn-login")).getText().trim().equals("Login"), "Text of button not match");

        driver.findElement(By.id("btn-login")).click();
    }

}
