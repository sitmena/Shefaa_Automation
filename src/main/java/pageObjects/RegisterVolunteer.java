package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestContext;
import utilities.Wait;

public class RegisterVolunteer {
    private final WebDriver webDriver;

    public RegisterVolunteer(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "registernewuser")
    private WebElement registerNew;
    @FindBy(id = "volunteertype")
    private WebElement volunteerType;
    @FindBy(id = "associationtype")
    private WebElement associationType;
    @FindBy(id = "titlevolunteer")
    private WebElement titleVolunteer;
    @FindBy(id = "titleassociation")
    private WebElement titleAssociation;

    @FindBy(id = "mobilenumber")
    private WebElement mobileNum;
    @FindBy(id = "otp")
    private WebElement otp;
    @FindBy(id = "rules")
    private WebElement rules;
    @FindBy(id = "confirm")
    private WebElement confirmBtn;
    @FindBy(id = "profile")
    private WebElement profileIcon;



    public void userClickOnRegisterButton(){

        this.registerNew.click();
        Wait.untilElementIsVisible(webDriver,volunteerType,20L);
       Assert.assertTrue(volunteerType.isDisplayed());

    }

    public void userChooseType(String usertype) {
        boolean titleAppeared=false;
if (usertype.equals("volunteer")){
        this.volunteerType.click();
        try {
            Wait.untilElementIsVisible(webDriver,titleVolunteer,20L);
            titleAppeared=true;
        }
        catch (Throwable t){
            t.printStackTrace();
        }

}
else{
    this.associationType.click();
    try {
        Wait.untilElementIsVisible(webDriver,titleAssociation,20L);
        titleAppeared=true;
    }
    catch (Throwable t){
        t.printStackTrace();
    }
}
Assert.assertTrue(titleAppeared);
    }


    public void userfillthefields (int mobilenum){

        this.mobileNum.sendKeys(""+mobilenum+"");
    }
    public void confirmrules (){

        this.rules.click();
        Wait.untilElementIsVisible(webDriver,otp,20L);
        Assert.assertTrue(otp.isDisplayed());
    }
    public void enterotp (int otp) throws InterruptedException {

        this.otp.sendKeys(""+otp+"");
        // This sleep is temp and fluent wait should be added to core in order to use elementisenabled
        Thread.sleep(2000);
        Assert.assertTrue(confirmBtn.isEnabled());
    }
    public void confirmtheprocess (){

        this.confirmBtn.click();
        Wait.untilElementIsVisible(webDriver,profileIcon,20L);
        Assert.assertTrue(profileIcon.isDisplayed());
    }




}