package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    WebDriver driver;

    @FindBy(id = "search_query_top")
    WebElement searchBox;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    public Homepage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    public void search(String query){
        searchBox.sendKeys(query);
        searchButton.click();
    }
}
