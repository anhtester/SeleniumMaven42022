package anhtester.com.Bai8DropdownRadioCheckbox;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LearnDropdownListDynamic extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        createDriver();

        driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[normalize-space()='Select a Category']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Select a Category']/following-sibling::div//input")).sendKeys("Shops");
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//em[normalize-space()='Shops']")).click();
        //Enter (dành cho 1 giá trị hoặc giá trị cần nằm đầu tiên)
        driver.findElement(By.xpath("//a[normalize-space()='Select a Category']/following-sibling::div//input")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        WebElement textForDropdown = driver.findElement(By.xpath("//div[contains(@class,'chosen-container-active')]"));

        //Kiểm tra lại Text đã chọn bằng IF ELSE
        if(textForDropdown.getText().equals("Shops")){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        closeDriver();
    }

}
