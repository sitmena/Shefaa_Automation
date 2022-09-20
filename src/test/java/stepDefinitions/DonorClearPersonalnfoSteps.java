package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.ClearDonorInfo;
import utilities.TestContext;

public class DonorClearPersonalnfoSteps extends BaseSteps {
    public DonorClearPersonalnfoSteps(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();
    @And("clear optional informations And press save button")
    public void clearOptionalInformationsAndPressSaveButton()throws InterruptedException {
        clearDonorInfo.clearoptionalfields();
        setDonorInfo.presssavebtn();
    }

    @Then("clear success message will appears")
    public void clearSuccessMessageWillAppears() {
        clearDonorInfo.verifyclearprocess();
    }
}
