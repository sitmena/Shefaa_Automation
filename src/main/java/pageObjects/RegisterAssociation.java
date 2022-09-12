package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

import javax.swing.*;
import java.io.File;
import java.util.Date;

public class RegisterAssociation {


    private final WebDriver webDriver;

    public RegisterAssociation(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "licnum")
    private WebElement licNum;
    @FindBy(id = "inquiry")
    private WebElement inquiryBtn;
    @FindBy(id = "sendbtn")
    private WebElement sendBtn;
    @FindBy(id = "mobilenumber")
    private WebElement mobileNum;
    @FindBy(id = "dateofbirth")
    private WebElement dob;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "id")
    private WebElement id;
    @FindBy(id = "confirmbtn")
    private WebElement confirmationBtn;
    @FindBy(id = "otp1")
    private WebElement otp1;
    @FindBy(id = "associationname")
    private WebElement associationName;
    @FindBy(id = "associationtype")
    private WebElement associationType;
    @FindBy(id = "associationlogo")
    private WebElement associationLogo;
    @FindBy(id = "expirydate")
    private WebElement expiryDate;
    @FindBy(id = "licensefile")
    private WebElement licenseFile;
    @FindBy(id = "iban")
    private WebElement iban;
    @FindBy(id = "bankaccount")
    private WebElement bankAccount;
    @FindBy(id = "associationnumber")
    private WebElement associationNumber;
    @FindBy(id = "email1")
    private WebElement email1;
    @FindBy(id = "associationlocation")
    private WebElement associationLocation;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "town")
    private WebElement town;
    @FindBy(id = "locationlink")
    private WebElement locationLink;
    @FindBy(id = "numberofproviders")
    private WebElement numberOfProviders;
    @FindBy(id = "hospitalname")
    private WebElement hospitalName;
    @FindBy(id = "discountrate")
    private WebElement discountRate;
    @FindBy(id = "ownername")
    private WebElement ownerName;
    @FindBy(id = "ceoname")
    private WebElement ceoName;
    @FindBy(id = "ceonumber")
    private WebElement ceoNumber;
    @FindBy(id = "rules")
    private WebElement rules;
    @FindBy(id = "successmessage")
    private WebElement successMsg;
    @FindBy(id = "emailotp")
    private WebElement emailOtp;
    @FindBy(id = "confirmotp")
    private WebElement confirmOtp;





    public void userfillrequiredfields(int mobilenum, Date dob, String email, int id){
        this.licNum.sendKeys(""+mobilenum+"");
        this.dob.sendKeys();
        this.email.sendKeys();
        this.id.sendKeys(""+id+"");

    }
    public void confirm()
    {

        this.confirmationBtn.click();
        Wait.untilElementIsVisible(webDriver,otp1,20L);
        Assert.assertTrue(otp1.isDisplayed());
    }

    public void fillEmailOtp(){
        this.emailOtp.click();
    }

    public void confirmOtp(){
        this.confirmOtp.click();
    }

    public void userFilllicNumber(int licnum) throws InterruptedException{

        this.licNum.sendKeys(""+licnum+"");
        // This sleep is temp and fluent wait should be added to core in order to use elementisenabled
        Thread.sleep(2000);
        Assert.assertTrue(inquiryBtn.isEnabled());

    }
    public void chooseInquiry()
    {

        this.inquiryBtn.click();
        Wait.untilElementIsVisible(webDriver,associationName,20L);
        Assert.assertTrue(associationName.isDisplayed());


    }

    public void userfillassociationinfo (String associationname, String associationtype, ImageIcon associationlogo, Date expirydate, File licensefile,int iban,int bankaccount,int associationnumber,String email,String associationlocation, String city,String town,String locationlink,int numberofproviders,String hospitalname, int discountrate,String ownername, String ceoname,int ceonumber) {
      this.associationName.sendKeys();
      this.associationType.sendKeys();
      this.associationLogo.sendKeys();
      this.expiryDate.sendKeys();
      this.licenseFile.sendKeys();
      this.iban.sendKeys(""+iban+"");
      this.bankAccount.sendKeys(""+bankaccount+"");
      this.associationNumber.sendKeys(""+associationnumber+"");
      this.email1.sendKeys();
      this.associationLocation.sendKeys();
      this.city.sendKeys();
      this.town.sendKeys();
      this.locationLink.sendKeys();
      this.numberOfProviders.sendKeys(""+numberofproviders+"");
      this.hospitalName.sendKeys();
      this.discountRate.sendKeys(""+discountrate+"");
      this.ownerName.sendKeys();
      this.ceoName.sendKeys();
      this.ceoNumber.sendKeys(""+ceonumber+"");


    }

    public void confirmrules() throws InterruptedException{

        this.rules.click();
        Thread.sleep(2000);
        Assert.assertTrue(sendBtn.isEnabled());
    }


    public void pressSendBtn(){
        this.sendBtn.click();
        Wait.untilElementIsVisible(webDriver,successMsg,20L);
        Assert.assertTrue(successMsg.isDisplayed());

    }

}
