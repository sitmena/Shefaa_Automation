


package stepDefinitions;

        import org.openqa.selenium.WebDriver;
        import pageObjects.*;
        import utilities.TestContext;

public class BaseSteps {

    public WebDriver webDriver;
    public TestContext testContext;

    public RegisterVolunteer registerVolunteer;
    public LoginVolunteer loginVolunteer;
    public BaseSteps(TestContext context) {
        testContext = context;
        webDriver = testContext.getDriverManager().getDriver();
        registerVolunteer=new RegisterVolunteer(webDriver);
        loginVolunteer=new LoginVolunteer(webDriver);
    }

}
