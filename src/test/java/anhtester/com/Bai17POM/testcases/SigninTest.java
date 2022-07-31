package anhtester.com.Bai17POM.testcases;

import anhtester.com.Bai17POM.pages.SigninPage;
import anhtester.com.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SigninTest extends BaseTest {

    public SigninPage signinPage;

    @BeforeMethod
    public void signInTest(){
        signinPage = new SigninPage(driver); //Truyền driver từ BaseTest sang các class Page
    }

    @Test
    public void testSignInValid01(){

        signinPage.signIn("admin01", "123456");
    }

    @Test
    public void testSignInValid02(){

        signinPage.signIn("client01", "123456");
    }

    @Test
    public void testSignInValid03(){

        signinPage.signIn("leader01", "123456");
    }

}
