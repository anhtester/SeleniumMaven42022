package anhtester.com.Bai8DropdownRadioCheckbox;

import anhtester.com.common.BaseTestOLD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LearnCheckbox extends BaseTestOLD {

    public static void main(String[] args) throws InterruptedException {

        createDriver();

        driver.get("https://demo.anhtester.com/basic-checkbox-demo.html");

        //driver.findElement(By.id("isAgeSelected")).click();

        Thread.sleep(2000);

        //Kiểm tra xem checkbox đã được chọn hay chưa
        System.out.println(driver.findElement(By.id("isAgeSelected")).isSelected());

        //Multi checkbox
        //driver.findElement(By.xpath("//label[normalize-space()='Option 2']")).click();
        //Thread.sleep(2000);
        //System.out.println(driver.findElement(By.xpath("//label[normalize-space()='Option 2']/child::input")).isSelected());


        Thread.sleep(1000);
        List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div//input"));

        System.out.println(listCheckbox.size());

        for (int i = 0; i < listCheckbox.size(); i++) {
            listCheckbox.get(i).click();
            Thread.sleep(1000);
        }

        Thread.sleep(1000);

        for (int i = 0; i < listCheckbox.size(); i++) {
            System.out.println(listCheckbox.get(i).isSelected());
            Thread.sleep(1000);
        }

        closeDriver();

    }

}
