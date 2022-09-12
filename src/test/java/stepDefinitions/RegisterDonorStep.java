package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestContext;

public class RegisterDonorStep extends BaseSteps {
    public RegisterDonorStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();







    @Given("^user on be a friend of shefaa page And choose user type option (.*)$")
    public void userOnBeAFriendOfShefaaPageAndChooseUserTypeOptionUserType(String usertype) {
        registerDonor.userClickOnBeFriendOfShefaaButoon();
       registerDonor.userChooseType(usertype);

    }

    @When("^enter his mobile number And Confirm rules and conditions (\\d+)$")
    public void enterHisMobileNumberAndConfirmRulesAndConditionsMobileNumber(int mobilenum) {
     registerDonor.userfillthefields(mobilenum);
     registerDonor.confirmrules();
    }

    @And("^enter the correct otp And confirm (\\d+)$")
    public void enterTheCorrectOtpAndConfirmOtp(int otp,String type) throws InterruptedException {
       registerDonor.enterotp(otp);
       registerDonor.userchoosethebutton(type);
    }
    @Then("user will move to his profile page")
    public void userWillMoveToHisProfilePage() {
    }
}
