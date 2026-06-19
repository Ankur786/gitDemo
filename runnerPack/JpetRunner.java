package gitDemo.runnerPack;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/jpetFlow.feature",
        glue = {"gitDemo/steps", "gitDemo/hooks1"},
        plugin = {"pretty","html:target/report.html"},
        monochrome = true
)
public class JpetRunner extends AbstractTestNGCucumberTests {
}