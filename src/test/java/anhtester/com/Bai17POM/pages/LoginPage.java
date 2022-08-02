package anhtester.com.Bai17POM.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    //Hàm xây dựng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
        WebUI.openURL(driver, "https://hrm.anhtester.com/");
        WebUI.setText(driver, inputEmail, email);
        WebUI.setText(driver, inputPassword, password);
        WebUI.clickElement(driver, buttonSignin);
    }

    public void logInEmailInValid(String email, String password) {
        WebUI.openURL(driver, "https://hrm.anhtester.com/");
        WebUI.setText(driver, inputEmail, email);
        WebUI.setText(driver, inputPassword, password);
        WebUI.clickElement(driver, buttonSignin);
        //Xử lý Assert
    }

    public void logInPasswordInValid(String email, String password) {
        WebUI.openURL(driver, "https://hrm.anhtester.com/");
        WebUI.setText(driver, inputEmail, email);
        WebUI.setText(driver, inputPassword, password);
        WebUI.clickElement(driver, buttonSignin);
        //Xử lý Assert
    }

    public void resetPassword(String emailForgot) {
        WebUI.openURL(driver, "https://hrm.anhtester.com/");
        WebUI.clickElement(driver, linkForgotPassword);

        Assert.assertEquals(WebUI.getElementText(driver, pageTextForgotPassword), "Reset your password");

        WebUI.setText(driver, inputEmailForgotPassword, emailForgot);
        WebUI.clickElement(driver, buttonReset);

        //Assert cái message hiển thị thành công (tồn tại)
        Assert.assertEquals(WebUI.getElementText(driver, alertMessageResetPassword), "Main.xin_error_msg__available");

        WebUI.clickElement(driver, linkClickHere);
    }

}
