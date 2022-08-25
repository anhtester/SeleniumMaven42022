package anhtester.com.Bai24ParameterMultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameter {

    @Test
    @Parameters({"Number1", "Number2", "Message"})
    public void sumNumber(@Optional("8") int a, @Optional("12") int b, String message) {
        System.out.println(message + ": " + (a + b));
    }

}
