package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty ","json:target/cucumber.json"},
		features = {"src/cucumber.features/"}
	
		
		)

public class CucumberRunner {

}
