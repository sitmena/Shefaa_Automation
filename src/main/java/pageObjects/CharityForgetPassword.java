package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

public class CharityForgetPassword {
    private final WebDriver webDriver;

    public CharityForgetPassword(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "forgetpassword")
    private WebElement forgetPassword;
    @FindBy(id = "mobilenum")
    private WebElement mobileNum;
    @FindBy(id = "send")
    private WebElement sendBtn;
    @FindBy(id = "successmsg")
    private WebElement successMsg;

    public void chooseforgetpassword(){
        this.forgetPassword.click();
        Wait.untilElementIsVisible(webDriver,mobileNum,20L);
        Assert.assertTrue(mobileNum.isDisplayed());
    }
    public void fillmobilenumber(int mobilenum) throws InterruptedException {
        this.mobileNum.sendKeys(""+mobilenum+"");
        // This sleep is temp and fluent wait should be added to core in order to use elementisenabled
        Thread.sleep(2000);
        Assert.assertTrue(sendBtn.isEnabled());
    }
    public void choosesendbtn(){
        this.sendBtn.click();
    }
public void verifysuccessmessage(){
    Wait.untilElementIsVisible(webDriver,successMsg,20L);
    Assert.assertTrue(successMsg.isDisplayed());
}
}
