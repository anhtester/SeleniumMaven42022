package anhtester.com.Bai14JavaScriptExecutor;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LearnJSExecutor extends BaseTest {

    JavascriptExecutor js; //khai báo

    @Test
    public void jsExecutorDemo01() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();", button); //Click ngầm
        Thread.sleep(1000);

        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);
        Thread.sleep(1000);
        String domainName = js.executeScript("return document.URL;").toString();
        System.out.println("Domain is: " + domainName);
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,1000)");
        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");

        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorDemo02() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Tất Cả Khóa Học')]"));

        js.executeScript("arguments[0].scrollIntoView(false);", element); //Hàm cuộn chuột này hay
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(2000);

    }

    @Test
    public void jsExecutorDemo03() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        WebElement element = driver.findElement(By.xpath("(//a[@class='category-content'])[1]"));

        js.executeScript("arguments[0].style.border='3px solid red'", element);

        String innerhtml = js.executeScript("return arguments[0].innerHTML;", element).toString();
        System.out.println(innerhtml);
        String innerText = js.executeScript("return arguments[0].innerText;", element).toString();
        System.out.println(innerText);
        Thread.sleep(2000);

    }

    @Test
    public void jsExecutorDemo04() throws InterruptedException {

        driver.get("https://ecommerce.anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        WebElement element = driver.findElement(By.xpath("//div[normalize-space()='Automobile & Motorcycle']"));
        Thread.sleep(3000);

        //element.click();
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);

    }

    @Test
    public void jsExecutorDemo05() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Tất Cả Khóa Học')]"));

        String attr = js.executeScript("arguments[0].getAttribute('class')", element).toString();
        System.out.println(attr);
        //js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);

    }

}
