package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginVolunteer;
import utilities.TestContext;

public class LoginVolunteerStep extends BaseSteps {
    public LoginVolunteerStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();

    @Given("user on login page And choose signin button")
    public void userOnLoginPageAndChooseSigninButton() {
        loginVolunteer.userClickOnLoginButton();
    }

    @When("^enter his mobile number (\\d+)$")
    public void enterHisMobileNumberMobileNumber(int mobilenum) {
        loginVolunteer.userEnterHisMobileNum(mobilenum);
    }
}
