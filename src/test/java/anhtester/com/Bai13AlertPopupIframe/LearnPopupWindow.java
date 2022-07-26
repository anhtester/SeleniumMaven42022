package anhtester.com.Bai13AlertPopupIframe;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class LearnPopupWindow extends BaseTest {

    @Test
    public void TestPopup01() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("btnLogin")).click();

        Thread.sleep(2000);
    }

    @Test
    public void TestPopup02() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Thread.sleep(1000);
        //Switch to new tab

        //1. Lưu lại mã định danh của Tab đầu tiên
        String mainWindow = driver.getWindowHandle();

        //2. Lấy ra tất cả các Tab hiện hành đang mở
        Set<String> windows = driver.getWindowHandles();

        //3. Duyệt SET trên với For để kiểm tra từng Tab và chuyển hướng theo Title của Tab
//        for (String window : windows) {
//            System.out.println(window);
//            if (!mainWindow.equals(window)) {
//                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
//                //Switch to new tab
//                driver.switchTo().window(window);
//
//                Thread.sleep(2000);
//                //Get title của tab
//                System.out.println(driver.switchTo().window(window).getTitle());
//                if (driver.switchTo().window(window).getTitle().equals("Guru99 Bank Home Page")) {
//                    Thread.sleep(1000);
//                    driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
//                    driver.findElement(By.name("btnLogin")).click();
//                }
//                System.out.println("Đã chuyển đến new tab Window: " + window);
//            }
//        }

        //3. Duyệt SET trên với For để kiểm tra từng Tab
//        for (String window : windows) {
//            System.out.println(window);
//                Thread.sleep(2000);
//                //Get title của tab
//                System.out.println(driver.switchTo().window(window).getTitle());
//                //SO sánh title của từng tab
//                if(driver.switchTo().window(window).getTitle().equals("Guru99 Bank Home Page")){
//                    //Switch to đến chính cái tab có title như ý muốn
//                    driver.switchTo().window(window);
//                    System.out.println("Đã chuyển đến new tab Window: " + window);
//
//                    //Code auto
//                    Thread.sleep(1000);
//                    driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
//                    driver.findElement(By.name("btnLogin")).click();
//                }
//
//        }

        //4. Cách chuyển hướng theo vị trí của Tab
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());

        System.out.println(tabs.get(0));
        System.out.println(tabs.get(1)); //Lấy tab thứ 2 (vì ArrayList bắt đầu là 0)
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(1000);
        driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("btnLogin")).click();

        driver.switchTo().window(mainWindow); //Chuyển hướng về tab đầu

        Thread.sleep(2000);
    }

}
