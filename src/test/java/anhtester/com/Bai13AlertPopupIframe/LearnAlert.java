package anhtester.com.Bai13AlertPopupIframe;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LearnAlert extends BaseTest {

    @Test
    public void testAlert_01() throws InterruptedException {
        driver.get("https://demo.anhtester.com/javascript-alert-box-demo.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[1]")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().accept(); //Nhấn nút Ok hoặc Yes hoặc Xác nhận hoặc Confirm

    }

    @Test
    public void testAlert_02() throws InterruptedException {
        driver.get("https://demo.anhtester.com/javascript-alert-box-demo.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!", "Text on Alert not match");
        Thread.sleep(2000);

        //Check nút Ok
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        WebElement textConfirmOK = driver.findElement(By.xpath("//p[@id='confirm-demo']"));
        Assert.assertEquals(textConfirmOK.getText(), "You pressed OK!", "Text không chính xác");

        //Check nút Cancel
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!", "Text on Alert not match");
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        WebElement textConfirmCancel = driver.findElement(By.xpath("//p[@id='confirm-demo']"));
        Assert.assertEquals(textConfirmCancel.getText(), "You pressed Cancel!", "Text không chính xác");

    }

    @Test
    public void testAlert_03() throws InterruptedException {
        driver.get("https://demo.anhtester.com/javascript-alert-box-demo.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt')]")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please enter your name", "Text on Alert not match");
        Thread.sleep(2000);

        //sendKeys một giá trị vài ô input
        driver.switchTo().alert().sendKeys("Anh Tester");
        Thread.sleep(1000);
        //Check nút Ok
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        WebElement prompt_demo = driver.findElement(By.xpath("//p[@id='prompt-demo']"));
        Assert.assertEquals(prompt_demo.getText(), "You have entered 'Anh Tester' !", "Data input not match");

    }

}
