package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginDonor;
import utilities.TestContext;

public class LoginDonorStep extends BaseSteps {
    public LoginDonorStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();


    @When("^enter his mobile number (\\d+)$")
    public void enterHisMobileNumberMobileNumber(int mobilenum) {
        loginDonor.userEnterHisMobileNum(mobilenum);
    }

    @Then("user will move to home page")
    public void userWillMoveToHomePage() {
        loginDonor.verifyUserLoggedIn();
    }
}
