


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
    public AcceptAssociation acceptAssociation;
    public LoginAssociation loginAssociation;
    public SetDonorInfo setDonorInfo;
    

    public BaseSteps(TestContext context) {
        testContext = context;
        webDriver = testContext.getDriverManager().getDriver();
        registerDonor=new RegisterDonor(webDriver);
        loginDonor=new LoginDonor(webDriver);
        registerAssociation=new RegisterAssociation(webDriver);
        acceptAssociation=new AcceptAssociation(webDriver);
      loginAssociation=new LoginAssociation(webDriver);
     setDonorInfo=new SetDonorInfo(webDriver);

    }

}
