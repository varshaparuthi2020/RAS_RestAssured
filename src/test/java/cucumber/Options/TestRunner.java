package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/",glue= {"StepDefinitions"},
plugin = {"pretty","html:target/html/Cucumber-report.html"},
tags="@Product or @Account or @Transaction"
        )

public class TestRunner {

}
