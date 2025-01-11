package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SFTPUploadSteps {
    private static final Logger _log = Logger.getLogger(SFTPUploadSteps.class.getName());
    @Given("the user connected to sftp")
    public void the_user_connected_to_sftp() {
        _log.log(Level.INFO, "the user connected to sftp");
    }
    @When("the user select root folder")
    public void the_user_select_root_folder() {
        _log.log(Level.INFO, "the user select root folder");
    }
    @When("the user select file to upload")
    public void the_user_select_file_to_upload() {
        _log.log(Level.INFO, "the user select file to upload");
    }
    @When("the user hits upload")
    public void the_user_hits_upload() {
        _log.log(Level.INFO, "the user hits upload");
    }
    @Then("the user should see uploaded files")
    public void the_user_should_see_uploaded_files() {
        _log.log(Level.INFO, "the user should see uploaded files");
    }
    @Then("the user should see archived files")
    public void the_user_should_see_archived_files() {
        _log.log(Level.INFO, "the user should see archived files");
    }
    @Then("in same folder")
    public void in_same_folder() {
        _log.log(Level.INFO, "in same folder");
    }
    @Then("per each date")
    public void per_each_date() {
        _log.log(Level.INFO, "per each date");
    }
}
