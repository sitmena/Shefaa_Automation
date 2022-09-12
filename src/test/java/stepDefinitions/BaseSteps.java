


package stepDefinitions;

        import org.openqa.selenium.WebDriver;
        import pageObjects.*;
        import utilities.TestContext;

public class BaseSteps {

    public WebDriver webDriver;
    public TestContext testContext;

    public RegisterDonor registerDonor;
    public LoginDonor loginDonor;
    public RegisterAssociation registerAssociation;
    public DeclineAssociation declineAssociation;
    

    public BaseSteps(TestContext context) {
        testContext = context;
        webDriver = testContext.getDriverManager().getDriver();
        registerDonor=new RegisterDonor(webDriver);
        loginDonor=new LoginDonor(webDriver);
        registerAssociation=new RegisterAssociation(webDriver);
        declineAssociation=new DeclineAssociation(webDriver);
     

    }

}
