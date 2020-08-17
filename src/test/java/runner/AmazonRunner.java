package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json","junit:target/cucumber.xml","rerun:reports/rerun.txt"},
        features ={"src/test/resources/amazon.feature","src/test/resources/Google.feature"},
        glue = "steps",
        dryRun = false


        // to rerun->  mvn test -Dcucumber.options="@target/rerun.txt"
)
public class AmazonRunner {

}
