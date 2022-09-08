


package stepDefinitions;

        import org.openqa.selenium.WebDriver;
        import pageObjects.*;
        import utilities.TestContext;

public class BaseSteps {

    public WebDriver webDriver;
    public TestContext testContext;

    public RegisterVolunteer registerVolunteer;
<<<<<<< Updated upstream

=======
    public LoginVolunteer loginVolunteer;
    public RegisterAssociation registerAssociation;
>>>>>>> Stashed changes
    public BaseSteps(TestContext context) {
        testContext = context;
        webDriver = testContext.getDriverManager().getDriver();
        registerVolunteer=new RegisterVolunteer(webDriver);
<<<<<<< Updated upstream
=======
        loginVolunteer=new LoginVolunteer(webDriver);
        registerAssociation=new RegisterAssociation(webDriver);
>>>>>>> Stashed changes
    }

}
