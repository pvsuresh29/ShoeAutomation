/**
 * Created by Suresh Venkata on 9/17/16.
 */
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    format = { "pretty","html:target/cucumber",
            "json:target/cucumber.json",
            "junit:target/cucumber.xml"},
    features = {"src/test/resources/dtc.web/features"},
    glue = {"dtc.web.steps"}
)

public class RunnerTest {
}