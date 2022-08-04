package anhtester.com.Bai18PageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    WebDriver driver;

    //Object

    @FindAll({
            @FindBy(xpath = "//input[@id='iusername']"),
            @FindBy(id = "iusername"),
            @FindBy(name = "iusername")
    })
    private WebElement inputEmail;

//    @FindBy(xpath = "//input[@id='iusername']")
//    @CacheLookup
//    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='ipassword']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSignin;

    public LoginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //Kết nối giữa ten WebElement và Locator
        //Chưa tìm kiếm liền. Khi nào gọi tên WebElement sử dụng thì nó mới bắt đầu tìm kiếm
    }

    public void login(String email, String password){
        driver.get("https://hrm.anhtester.com/");
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonSignin.click();
    }

}
