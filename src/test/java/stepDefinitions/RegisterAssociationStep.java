package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterAssociation;
import utilities.TestContext;

import javax.swing.*;
import java.io.File;
import java.util.Date;

public class RegisterAssociationStep extends BaseSteps {
    public RegisterAssociationStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();






    @When("^enter his mobile number And date of birth And email And id And confirm (\\d+) (.*) (.*) (\\d+)$")
    public void enterHisMobileNumberAndDateOfBirthAndEmailAndIdAndConfirmMobileNumberDateOfBirthEmailId(int mobilenum, Date dob,String email,int id) {
      registerAssociation.userfillrequiredfields(mobilenum,dob,email,id);
      registerAssociation.confirm();
    }




    @And("^enter the correct email otp And confirm (.*)$")
    public void enterTheCorrectEmailOtpAndConfirmOtp() {
        registerAssociation.fillEmailOtp();
        registerAssociation.confirmOtp();
    }

    @And("^enter his license number And choose inquiry (\\d+)$")
    public void enterHisLicenseNumberAndChooseInquiryLicenseNumber(int licnum)throws InterruptedException {
        registerAssociation.userFilllicNumber(licnum);
        registerAssociation.chooseInquiry();

    }

    @And("^fill the association name And association type And association logo And expiry date And license file And iban And bank account And association number And email And association location And city And town And location link And number of service providers And hospital name And discount rate And owner name And ceo name And ceo number And confirm the rules (.*) (.*) (.*) (.*) (.*) (\\d+) (\\d+)(\\d+) (.*) (.*) (.*) (.*) (.*) (\\d+) (.*) (\\d+) (.*) (.*)(\\d+)$")
    public void fillTheAssociationNameAndAssociationTypeAndAssociationLogoAndExpiryDateAndLicenseFileAndIbanAndBankAccountAndAssociationNumberAndEmailAndAssociationLocationAndCityAndTownAndLocationLinkAndNumberOfServiceProvidersAndHospitalNameAndDiscountRateAndOwnerNameAndCeoNameAndCeoNumberAndConfirmTheRulesAssociationNameAssociationTypeAssociationLogoExpiryDateLicenseFileIbanBankAccountAssociationNumberEmailAssociationLocationCityTownLocationLinkNumberOfServiceProvidersHospitalNameDiscountRateOwnerNameCeoNameCeoNumber(String associationname, String associationtype, ImageIcon associationlogo, Date expirydate, File licensefile,int iban,int bankaccount,int associationnumber,String email,String associationlocation, String city,String town,String locationlink,int numberofproviders,String hospitalname, int discountrate,String ownername, String ceoname,int ceonumber) throws InterruptedException {
   registerAssociation.userfillassociationinfo(associationname,associationtype,associationlogo,expirydate,licensefile,iban,bankaccount,associationnumber,email,associationlocation,city,town,locationlink,numberofproviders,hospitalname,discountrate,ownername,ceoname,ceonumber);
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
