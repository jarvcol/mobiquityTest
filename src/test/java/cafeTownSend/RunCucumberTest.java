package cafeTownSend;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/site/cucumber-pretty",
                "junit:target/cucumber.xml",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"},
        monochrome=true)
public class RunCucumberTest {
}
