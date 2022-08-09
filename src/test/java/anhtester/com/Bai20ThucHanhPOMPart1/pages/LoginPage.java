package anhtester.com.Bai20ThucHanhPOMPart1.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private DashboardPage dashboardPage;

    //Hàm xây dựng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver); //Khởi tạo giá trị cho class WebUI
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        dashboardPage = new DashboardPage(driver);
    }

    //Login
    private String pageText = "Welcome to HRM System";
    private By inputUsername = By.xpath("//input[@id='iusername']");
    private By inputPassword = By.xpath("//input[@id='ipassword']");
    private By buttonSignin = By.xpath("//button[@type='submit']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");

    //Forgot password
    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");
    private By inputEmailForgotPassword = By.xpath("//input[@placeholder='Email address']");
    private By buttonReset = By.xpath("//button[@type='submit']");
    private By linkClickHere = By.xpath("//a[normalize-space()='Click here']");
    private By alertMessage = By.xpath("//div[@class='toast-message']");


    public DashboardPage logIn(String username, String password) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);
        WebUI.sleep(5);
        //Wait for page loaded
        //Xử lý Assert
        //wait.until(ExpectedConditions.presenceOfElementLocated(dashboardPage.menuTrangChu));
        boolean checkMenu = WebUI.checkElementExist(dashboardPage.menuTrangChu);
        Assert.assertTrue(checkMenu, "Login failed. Không tìm thấy menu Trang chủ.");

        return new DashboardPage(driver); //Khởi tạo trang Dashboard
    }

    public void loginWithUsernameInValid(String username, String password) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);
        //Xử lý Assert
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error alert not display.");
        Assert.assertEquals(WebUI.getElementText(alertMessage), "Invalid Login Credentials.", "Fail. Text not match.");
    }

    public void loginWithPasswordInValid(String username, String password) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);
        //Xử lý Assert
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error alert not display.");
        Assert.assertEquals(WebUI.getElementText(alertMessage), "Invalid Login Credentials.", "Fail. Text not match.");

    }

    public void resetPassword(String emailForgot) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.clickElement(linkForgotPassword);

        Assert.assertEquals(WebUI.getElementText(pageTextForgotPassword), "Reset your password");

        WebUI.setText(inputEmailForgotPassword, emailForgot);
        WebUI.clickElement(buttonReset);

        //Assert cái message hiển thị thành công (tồn tại)
        Assert.assertEquals(WebUI.getElementText(alertMessage), "Main.xin_error_msg__available");

        WebUI.clickElement(linkClickHere);
    }

}
