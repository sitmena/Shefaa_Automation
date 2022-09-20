package stepDefinitions;

import Helpers.UsersHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SetDonorInfo;
import utilities.TestContext;

import java.io.IOException;

public class DonorSetPersonalInfo extends BaseSteps {
    public DonorSetPersonalInfo(TestContext context) {
        super(context);
    }

    UsersHelper usersHelper = new UsersHelper();
    @And("choose personal information button")
    public void choosePersonalInformationButton() {
        setDonorInfo.choosepersonalinfobtn();

    }

    @And("^fill the required informations And press save button (.*) (.*) (.*) (\\d+) (.*) (\\d+)$")
    public void fillTheRequiredInformationsAndPressSaveButtonFirstnameLastnameEmailYearMonthDay(String firstname,String lastname,String email,int year,String month,int day) throws InterruptedException, IOException {

      setDonorInfo.fillrequiredinformation(firstname,lastname,email,year,month,day);
        setDonorInfo.presssavebtn();
    }

    @Then("success message will appears")
    public void successMessageWillAppears() {
        setDonorInfo.verifytheprocess();
    }


}
