package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterAssociation;
import utilities.TestContext;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class RegisterAssociationStep extends BaseSteps {
    public RegisterAssociationStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();






    @When("^enter his mobile number And date of birth And email And id And confirm (\\d+) (\\d+) (.*) (\\d+) (.*) (\\d+)$")
    public void enterHisMobileNumberAndDateOfBirthAndEmailAndIdAndConfirmMobileNumberDateOfBirthEmailId(int mobilenum,int year,String month,int day,String email,int id) throws IOException, InterruptedException {
      registerAssociation.userfillrequiredfields(mobilenum,year,month,day,email,id);
      registerAssociation.confirm();
    }


    @And("^enter the correct mobile otp And confirm (.*)$")
    public void enterTheCorrectMobileOtpAndConfirmOtp() {
registerAssociation.fillmobileotp();
        registerAssociation.confirmmobileOtp();

    }

    @And("^enter the correct email otp And confirm (.*)$")
    public void enterTheCorrectEmailOtpAndConfirmOtp() {
        registerAssociation.fillEmailOtp();
        registerAssociation.confirmemailOtp();
    }

    @And("^enter his license number And choose inquiry (\\d+)$")
    public void enterHisLicenseNumberAndChooseInquiryLicenseNumber(int licnum)throws InterruptedException {
        registerAssociation.userFilllicNumber(licnum);
        registerAssociation.chooseInquiry();

    }

    @And("^fill the registration form And confirm the rules (\\d+)(\\d+)(.*)(\\d+)(.*)(.*)(\\d+)(\\d+)(.*)(\\d+)$")
    public void fillTheRegistrationForm( int iban,int associationnumber,String email,int secondotp,String associationlocation,String locationlink,int numberofproviders, int discountrate,String ceoname,int ceonumber) throws InterruptedException, IOException {
   registerAssociation.userfillassociationinfo(iban,associationnumber,email,secondotp,associationlocation,locationlink,numberofproviders,discountrate,ceoname,ceonumber);

   registerAssociation.confirmrules();
    }


    @And("press on send button")
    public void pressOnSendButton() {

        registerAssociation.pressSendBtn();
    }

    @Then("form will sent to the system manager")
    public void formWillSentToTheSystemManager() {
    }



}
