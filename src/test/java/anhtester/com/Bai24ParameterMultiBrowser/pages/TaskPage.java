package anhtester.com.Bai24ParameterMultiBrowser.pages;

import org.openqa.selenium.WebDriver;

public class TaskPage {

    WebDriver driver;
    public TaskPage(WebDriver driver){
        this.driver = driver;
    }

    public String pageText = "Tasks";

}
