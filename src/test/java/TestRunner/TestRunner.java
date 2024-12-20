package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"StepDefinitions"},
        plugin = {"pretty","html:target/cucumber","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@test"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
