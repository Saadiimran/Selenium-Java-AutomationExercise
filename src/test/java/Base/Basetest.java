package Base;

import config.ConfigReader;
import io.restassured.RestAssured;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Set;

public class Basetest {
    protected WebDriver driver;
    protected Cookie sessionCookie;
    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();

        driver.get("https://petstore.swagger.io/#/user/login");



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();


        String username = "username";  // Example username
        String password = "password";
        driver.get("https://petstore.swagger.io/v2/user/login?username=\" + username + \"&password=\" + password");
        Thread.sleep(3000);
        driver.manage().window().minimize();

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Retrieved Cookies: ");

        for (Cookie cookie: cookies){
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("-----------------------");

            sessionCookie = driver.manage().getCookieNamed("userId");
            RestAssured.baseURI = "https://petstore.swagger.io/v2";
            assert sessionCookie != null;
        }
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null)
            driver.quit();
    }
}
