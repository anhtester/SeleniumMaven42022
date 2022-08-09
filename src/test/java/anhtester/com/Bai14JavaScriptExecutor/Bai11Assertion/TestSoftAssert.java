package anhtester.com.Bai14JavaScriptExecutor.Bai11Assertion;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssert extends BaseTest {

    @Test(priority = 1)
    public void RunTest() {

        driver.get("https://anhtester.com");

        SoftAssert softassert = new SoftAssert();

        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();

        System.out.println("*** Checking For The First Title ***");

        softassert.assertEquals(originalTitle, expectedTitle); //Fail

        System.out.println("*** Checking For The Second Title ***");

        softassert.assertEquals(originalTitle, "Anh Tester - Automation"); //Fail

        driver.findElement(By.id("btn-login")).click();

        softassert.assertAll(); //Tổng kết các assert bên trên => Bắt buộc khai báo
    }

}
