package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WebLoginSteps {

    private static final Logger _log = Logger.getLogger(WebLoginSteps.class.getName());
    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
      _log.log(Level.INFO, "the user is on login page");
    }
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        _log.log(Level.INFO, "the user enters valid credentials");
    }
    @When("hits submit")
    public void hits_submit() {
        _log.log(Level.INFO, "the user hits submit");
    }
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        _log.log(Level.INFO, "the user should be logged in successfully");
    }
}
