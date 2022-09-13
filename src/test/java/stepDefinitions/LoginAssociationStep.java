package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestContext;

public class LoginAssociationStep extends BaseSteps {
    public LoginAssociationStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();




    @When("^enter his mobile number And password (\\d+)(.*)$")
    public void enterHisMobileNumberAndPasswordMobileNumberPassword() {

    }

    @And("choose login button")
    public void chooseLoginButton() {
    }

    @Then("user will move to  association home page")
    public void userWillMoveToAssociationHomePage() {
    }
}
