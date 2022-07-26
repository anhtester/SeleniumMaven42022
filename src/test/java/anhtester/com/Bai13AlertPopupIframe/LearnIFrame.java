package anhtester.com.Bai13AlertPopupIframe;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LearnIFrame extends BaseTest {

    @Test
    public void handleIFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(9000);

        //1. Lấy ra tất cả các thẻ iframe tồn tại trong trang
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        Thread.sleep(1000);

        //2. CHuyển hướng theo vị trí của iframe
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //Đến iframe đầu tiên (vì nó bắt đầu là 0)
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //3. Switch to lớp đầu tiên không phải iframe
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Contact Anh Tester']")).getText());


        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());

        //Switch to iframe icon of Messenger
        driver.switchTo().frame(1); //Chuyển hướng đến iframe thứ 2
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        Thread.sleep(2000);
    }

}
