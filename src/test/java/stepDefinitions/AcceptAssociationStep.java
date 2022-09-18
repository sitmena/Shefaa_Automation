package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestContext;

public class AcceptAssociationStep extends BaseSteps {
    public AcceptAssociationStep(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();
    @Given("system manager on Admin page And choose signin button")
    public void systemManagerOnAdminPageAndChooseSigninButton() {

        acceptAssociation.systemmanagerClickOnSigninButton();
    }

    @When("^enter his email And password And choose login(.*) (.*)$")
    public void enterHisEmailAndPasswordEmailPassword(String email,String password) {
        acceptAssociation.fillRequiredFields(email,password);
        acceptAssociation.chooseLogin();
    }

    @And("system manager will move to requests page And choose any new request And show it")
    public void systemManagerWillMoveToRequestsPageAndChooseAnyNewRequestAndShowIt() {
        acceptAssociation.chooseRequest();
        acceptAssociation.show();
    }


    @Then("^enter the required fields And accept (\\d+) (\\d+)$")
    public void enterTheRequiredFieldsAndAcceptOperationalRatioSustainabilityRatio(int operationalratio,int Sustainabilityratio) throws InterruptedException {
        acceptAssociation.fillRatioFields(operationalratio,Sustainabilityratio);
        acceptAssociation.accept();
    }

    @Then("close the form")
    public void closeTheForm() {
        acceptAssociation.close();
    }
}
