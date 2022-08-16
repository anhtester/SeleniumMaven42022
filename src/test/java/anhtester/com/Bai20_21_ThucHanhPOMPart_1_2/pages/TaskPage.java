package anhtester.com.Bai20_21_ThucHanhPOMPart_1_2.pages;

import org.openqa.selenium.WebDriver;

public class TaskPage {

    WebDriver driver;
    public TaskPage(WebDriver driver){
        this.driver = driver;
    }

    public String pageText = "Tasks";

}
