package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

public class RegisterDonor {
    private final WebDriver webDriver;

    public RegisterDonor(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "befriendofshefaa")
    private WebElement beFriendOfShefaa;
    @FindBy(id = "donortype")
    private WebElement donorType;
    @FindBy(id = "associationtype")
    private WebElement associationType;
    @FindBy(id = "titledonor")
    private WebElement titleDonor;
    @FindBy(id = "titleassociation")
    private WebElement titleAssociation;

    @FindBy(id = "mobilenumber")
    private WebElement mobileNum;
    @FindBy(id = "otp")
    private WebElement otp;
    @FindBy(id = "rules")
    private WebElement rules;
    @FindBy(id = "registerbtn")
    private WebElement registerBtn;
    @FindBy(id = "loginbtn")
    private WebElement loginBtn;
    @FindBy(id = "profile")
    private WebElement profileIcon;
    @FindBy(id = "hello")
    private WebElement helloWord;



    public void userClickOnBeFriendOfShefaaButoon(){

        this.beFriendOfShefaa.click();
        Wait.untilElementIsVisible(webDriver,donorType,20L);
       Assert.assertTrue(donorType.isDisplayed());

    }

    public void userChooseType(String usertype) {
        boolean titleAppeared=false;
if (usertype.equals("donor")){
        this.donorType.click();
        try {
            Wait.untilElementIsVisible(webDriver,titleDonor,20L);
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
        Assert.assertTrue(registerBtn.isEnabled());
    }




 public void userchoosethebutton (String buttontype){

       boolean titleAppeared=false;
if (buttontype.equals("Register")){
        this.registerBtn.click();
        try {
            Wait.untilElementIsVisible(webDriver,profileIcon,20L);
            titleAppeared=true;
        }
        catch (Throwable t){
            t.printStackTrace();
        }

}
else{
    this.loginBtn.click();
    try {
        Wait.untilElementIsVisible(webDriver,helloWord,20L);
        titleAppeared=true;
    }
    catch (Throwable t){
        t.printStackTrace();
    }
}
Assert.assertTrue(titleAppeared);
    }

public void verifyUserMovedToProfile(){
        Assert.assertTrue(profileIcon.isDisplayed());
}







}