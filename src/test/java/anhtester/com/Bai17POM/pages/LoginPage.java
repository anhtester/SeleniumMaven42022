package anhtester.com.Bai17POM.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    //Hàm xây dựng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver); //Khởi tạo giá trị cho class WebUI
    }

    //Login
    private String pageText = "Welcome to HRM System";
    private By inputEmail = By.xpath("//input[@id='iusername']");
    private By inputPassword = By.xpath("//input[@id='ipassword']");
    private By buttonSignin = By.xpath("//button[@type='submit']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");

    //Forgot password
    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");
    private By inputEmailForgotPassword = By.xpath("//input[@placeholder='Email address']");
    private By buttonReset = By.xpath("//button[@type='submit']");
    private By linkClickHere = By.xpath("//a[normalize-space()='Click here']");
    private By alertMessageResetPassword = By.xpath("//div[@class='toast-message']");


    public void logIn(String email, String password) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);

    }

    public void logInEmailInValid(String email, String password) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);
        //Xử lý Assert
    }

    public void logInPasswordInValid(String email, String password) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);
        //Xử lý Assert
    }

    public void resetPassword(String emailForgot) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.clickElement(linkForgotPassword);

        Assert.assertEquals(WebUI.getElementText(pageTextForgotPassword), "Reset your password");

        WebUI.setText(inputEmailForgotPassword, emailForgot);
        WebUI.clickElement(buttonReset);

        //Assert cái message hiển thị thành công (tồn tại)
        Assert.assertEquals(WebUI.getElementText(alertMessageResetPassword), "Main.xin_error_msg__available");

        WebUI.clickElement(linkClickHere);
    }

}
