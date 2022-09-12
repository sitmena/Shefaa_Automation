package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

public class DeclineAssociation {
    private final WebDriver webDriver;

    public DeclineAssociation(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "loginmanager")
    private WebElement loginManager;

    public void systemmanagerClickOnLoginButton(){

        this.loginManager.click();
    }

}
