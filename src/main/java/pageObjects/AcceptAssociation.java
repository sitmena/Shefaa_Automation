package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

public class AcceptAssociation {
    private final WebDriver webDriver;

    public AcceptAssociation(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "signinbtn")
    private WebElement signinBtn;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login")
    private WebElement login;
    @FindBy(id = "request")
    private WebElement request;
    @FindBy(id = "showbtn")
    private WebElement showBtn;
    @FindBy(id = "operationalratio")
    private WebElement operationalRatio;
    @FindBy(id = "Sustainabilityratio")
    private WebElement SustainabilityRatio;
    @FindBy(id = "accept")
    private WebElement accept;
    @FindBy(id = "close")
    private WebElement close;
    @FindBy(id = "sucessMsg")
    private WebElement sucessMsg;

    public void systemmanagerClickOnSigninButton(){

        this.signinBtn.click();
        Wait.untilElementIsVisible(webDriver,email,20L);
        Assert.assertTrue(email.isDisplayed());
    }

    public void fillRequiredFields(String email,String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
    }
    public void chooseLogin(){
        this.login.click();
        Wait.untilElementIsVisible(webDriver,request,20L);
        Assert.assertTrue(request.isDisplayed());
    }

    public void chooseRequest(){
        this.request.click();
        Wait.untilElementIsVisible(webDriver,showBtn,20L);
        Assert.assertTrue(showBtn.isDisplayed());
    }

    public void show(){
        this.showBtn.click();
        Wait.untilElementIsVisible(webDriver,operationalRatio,20L);
        Assert.assertTrue(operationalRatio.isDisplayed());
    }
   public void fillRatioFields(int operationalratio,int Sustainabilityratio) throws InterruptedException {
       this.operationalRatio.sendKeys(""+operationalratio+"");
       this.SustainabilityRatio.sendKeys(""+Sustainabilityratio+"");
       // This sleep is temp and fluent wait should be added to core in order to use elementisenabled
       Thread.sleep(2000);
       Assert.assertTrue(accept.isEnabled());
   }

    public void accept() throws InterruptedException {
        this.accept.click();
        Wait.untilElementIsVisible(webDriver,sucessMsg,20L);
        Assert.assertTrue(sucessMsg.isDisplayed());

    }
    public void close(){
        this.close.click();
    }
}
