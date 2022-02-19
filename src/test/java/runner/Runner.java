package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "@test",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"json:target/report.json"},
        dryRun = false

)
public class Runner {

}
