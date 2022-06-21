package anhtester.com.Bai8DropdownRadioCheckbox;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdownListStatic extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        createDriver();

        driver.get("https://demo.anhtester.com/basic-select-dropdown-demo.html");

        Thread.sleep(2000);

        Select select = new Select(driver.findElement(By.id("select-demo")));

        Boolean check = select.isMultiple();
        System.out.println(check);

        select.selectByVisibleText("Friday");

        System.out.println(select.getOptions().size()); //Số lượng Option có trong thẻ Select

        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(2000);

        closeDriver();
    }

}
