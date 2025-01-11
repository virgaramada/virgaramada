package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SFTPLoginSteps {
    private static final Logger _log = Logger.getLogger(SFTPLoginSteps.class.getName());
    @Given("the user open sftp")
    public void the_user_open_sftp() {
        _log.log(Level.INFO, "the user open sftp");
    }
    @When("hits connect")
    public void hits_connect() {
        _log.log(Level.INFO, "the user hits connect");
    }
    @Then("the user logged in to sftp")
    public void the_user_logged_in_to_sftp() {
        _log.log(Level.INFO, "the user logged in to sftp");
    }
}
