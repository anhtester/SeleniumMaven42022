package anhtester.com.utils;

import org.openqa.selenium.By;

public class ObjectRepository {

    //Object của Sign in page
    public static By inputEmail = By.xpath("//input[@id='iusername']");
    public static By inputPassword = By.xpath("//input[@id='ipassword']");
    public static By buttonSignin = By.xpath("//button[@type='submit']");

    //Object của Dashboard page
    public static By inputEmail2 = By.xpath("//input[@id='iusername']");
    public static By inputPassword2 = By.xpath("//input[@id='ipassword']");
    public static By buttonSignin2 = By.xpath("//button[@type='submit']");

    //Object của Project page
    public static By inputEmail3 = By.xpath("//input[@id='iusername']");
    public static By inputPassword3 = By.xpath("//input[@id='ipassword']");
    public static By buttonSignin3 = By.xpath("//button[@type='submit']");


}
