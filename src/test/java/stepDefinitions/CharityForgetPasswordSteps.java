package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestContext;

public class CharityForgetPasswordSteps extends BaseSteps {
    public CharityForgetPasswordSteps(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();
    @When("choose forget password option")
    public void chooseForgetPasswordOption() {
        charityForgetPassword.chooseforgetpassword();
    }

    @When("^enter his mobile number And send (\\d+)$")
    public void enterHisMobileNumberAndSendMobileNumber(int mobilenum)throws InterruptedException  {
        charityForgetPassword.fillmobilenumber(mobilenum);
        charityForgetPassword.choosesendbtn();
    }

    @Then("success message will appears and forget password sent")
    public void successMessageWillAppearsAndForgetPasswordSent() {
        charityForgetPassword.verifysuccessmessage();
    }
}
