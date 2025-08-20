package Test;

import Base.Basetest;
import Pages.Homepage;
import Pages.Login;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Basetest {

    @Test
    public void testlogin(){
        Homepage homepage = new Homepage(driver);
        Login login = new Login(driver);

        String loginURL = ConfigReader.getProperty("loginUrl");

        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");
        String searchquery = ConfigReader.getProperty("searchQuery");

        homepage.search(searchquery);

        driver.navigate().to(loginURL);

        login.login(email, password);

        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"),"Login failed!");
    }

}
