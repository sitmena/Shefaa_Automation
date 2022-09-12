package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.DeclineAssociation;
import utilities.TestContext;

public class DeclineRegisterAssociationStep extends BaseSteps {
    public DeclineRegisterAssociationStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();
    @Given("system manager on login page And choose signin button")
    public void systemManagerOnLoginPageAndChooseSigninButton() {

        declineAssociation.systemmanagerClickOnLoginButton();
    }

    @Then("system manager will move to requests page And choose any new request And show it")
    public void systemManagerWillMoveToRequestsPageAndChooseAnyNewRequestAndShowIt() {
    }

    @Then("^system manager write a a reason in the field and press decline button And close the request (.*)$")
    public void systemManagerWriteAAReasonInTheFieldAndPressDeclineButtonAndCloseTheRequestDeclineReason() {
    }
}
