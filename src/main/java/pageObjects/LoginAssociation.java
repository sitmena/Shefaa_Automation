package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

public class LoginAssociation {

    private final WebDriver webDriver;

    public LoginAssociation(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "mobilenum")
    private WebElement mobileNum;
    @FindBy(id = "pass")
    private WebElement password;
    @FindBy(id = "loginbtn")
    private WebElement loginBtn;
    @FindBy(id = "homeIcon")
    private WebElement homeIcon;


public void enterfields(int mobilenum,String pass){
    this.mobileNum.sendKeys(""+mobilenum+"");
    this.password.sendKeys(pass);
}

public void chooselogin(){
    this.loginBtn.click();
}
    public void verifyuserunderhomepage(){
        Wait.untilElementIsVisible(webDriver,homeIcon,20L);
        Assert.assertTrue(homeIcon.isDisplayed());
    }
}
