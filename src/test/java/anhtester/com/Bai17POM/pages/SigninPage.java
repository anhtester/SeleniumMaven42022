package anhtester.com.Bai17POM.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {

    WebDriver driver;

    //Hàm xây dựng
    public SigninPage(WebDriver driver){
        this.driver = driver;
    }

    private String pageText = "Welcome to HRM System";
    private By inputEmail = By.xpath("//input[@id='iusername']");
    private By inputPassword = By.xpath("//input[@id='ipassword']");
    private By buttonSignin = By.xpath("//button[@type='submit']");

    public void signIn(String email, String password){
        driver.get("https://hrm.anhtester.com/");
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonSignin).click();
    }

    public void signIn02(String email, String password){
        driver.get("https://hrm.anhtester.com/");
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonSignin).click();
        WebUI.sleep(6);

    }

}
