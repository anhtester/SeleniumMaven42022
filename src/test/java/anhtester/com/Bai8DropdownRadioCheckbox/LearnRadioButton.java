package anhtester.com.Bai8DropdownRadioCheckbox;

import anhtester.com.common.BaseTestOLD;
import org.openqa.selenium.By;

public class LearnRadioButton extends BaseTestOLD {

    public static void main(String[] args) throws InterruptedException {

        createDriver();

        driver.get("https://demo.anhtester.com/basic-radiobutton-demo.html");
        Thread.sleep(1000);
        Boolean radioMale1 = driver.findElement(By.xpath("//div[normalize-space()='Radio Button Demo']/following-sibling::div//label[normalize-space()='Male']/child::input")).isSelected();
        System.out.println(radioMale1);

        driver.findElement(By.xpath("//div[normalize-space()='Radio Button Demo']/following-sibling::div//label[normalize-space()='Male']/child::input")).click();
        Thread.sleep(1000);

        Boolean radioMale2 = driver.findElement(By.xpath("//div[normalize-space()='Radio Button Demo']/following-sibling::div//label[normalize-space()='Male']/child::input")).isSelected();
        System.out.println(radioMale2);

        //Kiểm tra dạng Radio
        //Click chọn giá trị thứ 2
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[normalize-space()='Radio Button Demo']/following-sibling::div//label[normalize-space()='Female']/child::input")).click();
        //Kiểm tra giá trị thứ 2 là TRUE
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Radio Button Demo']/following-sibling::div//label[normalize-space()='Female']/child::input")).isSelected());
        //Kiểm tra giá trị 1 là FALSE
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Radio Button Demo']/following-sibling::div//label[normalize-space()='Male']/child::input")).isSelected());

        closeDriver();

    }

}
