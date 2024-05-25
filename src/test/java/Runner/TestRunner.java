package Runner;


import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// features => ot locate features file in the project
// glue => It helps cucumber to locate the step definition file
// monochrome =>if it set to true, it means that the console output for the cucumber test are readable
// plugin -> specify different formatting options for report
// dryRun => checks if all steps have step definition
// tags => what tags in the feature file will be executed
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",
        glue = {"Steps"},
        monochrome = true,
        plugin = {"html:Reports/HTMLReports/index.html",
        "json:Reports/JsonReports/Cucumber.json",
        "junit:Reports/JUnitReports/Cucumber.xml"},

        dryRun = false,
        tags = "@FunctionalTest and not @SanityTest"
)

public class TestRunner {

}
