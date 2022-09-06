package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterVolunteer;
import utilities.TestContext;

public class RegisterVoulnteerStep extends BaseSteps {
    public RegisterVoulnteerStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();







    @Given("^user on register page And choose user type option (.*)$")
    public void userOnRegisterPageAndChooseUserTypeOptionUserType(String usertype) {
        registerVolunteer.userClickOnRegisterButton();
       registerVolunteer.userChooseType(usertype);

    }

    @When("^enter his mobile number And Confirm rules and conditions (\\d+)$")
    public void enterHisMobileNumberAndConfirmRulesAndConditionsMobileNumber(int mobilenum) {
     registerVolunteer.userfillthefields(mobilenum);
     registerVolunteer.confirmrules();
    }

    @And("^enter the correct otp And confirm (\\d+)$")
    public void enterTheCorrectOtpAndConfirmOtp(int otp) throws InterruptedException {
       registerVolunteer.enterotp(otp);
       registerVolunteer.confirmtheprocess();
    }
    @Then("user will move to his profile page")
    public void userWillMoveToHisProfilePage() {
    }
}
