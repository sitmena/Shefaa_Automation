package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

public class LoginDonor {
    private final WebDriver webDriver;

    public LoginDonor(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "signinbtn")
    private WebElement signinBtn;
    @FindBy(id = "mobilenum")
    private WebElement mobileNum;
    @FindBy(id = "otp")
    private WebElement otp;
    public void userClickOnLoginButton(){

        this.signinBtn.click();
        Wait.untilElementIsVisible(webDriver,mobileNum,20L);
        Assert.assertTrue(mobileNum.isDisplayed());

    }
    public void userEnterHisMobileNum (int mobilenum){

        this.mobileNum.sendKeys(""+mobilenum+"");
        Wait.untilElementIsVisible(webDriver,otp,20L);
        Assert.assertTrue(otp.isDisplayed());

    }





}
