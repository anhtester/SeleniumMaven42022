package anhtester.com.Bai18PageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Clock IN']")
    private WebElement buttonCheckIn;

    public DashboardPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, LoginPageFactory.class);

    }

    public void clickCheckin(){
        buttonCheckIn.click();
    }

}
