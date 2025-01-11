package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/webLoginTest.feature",
                "src/test/resources/sftpLoginTest.feature",
                "src/test/resources/sftpUploadTest.feature"},
        glue = {"StepDefinitions"}
)
public class Run extends AbstractTestNGCucumberTests {
}
