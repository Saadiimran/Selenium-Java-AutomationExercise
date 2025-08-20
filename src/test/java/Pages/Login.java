package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement submitButton;

    public Login(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    public void login(String email,String password) {

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
