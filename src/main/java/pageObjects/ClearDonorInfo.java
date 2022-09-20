package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

public class ClearDonorInfo {

    private final WebDriver webDriver;

    public ClearDonorInfo(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "savebtn")
    private WebElement saveBtn;
    @FindBy(id = "clearsuccessmsg")
    private WebElement clearsuccessMsg;

    public void clearoptionalfields() throws InterruptedException {
        this.firstName.clear();
        // This sleep is temp and fluent wait should be added to core in order to use elementisenabled
        Thread.sleep(2000);
        Assert.assertTrue(saveBtn.isEnabled());
    }
    public void verifyclearprocess(){
        Wait.untilElementIsVisible(webDriver,clearsuccessMsg,20L);
        Assert.assertTrue(clearsuccessMsg.isDisplayed());
    }
}
