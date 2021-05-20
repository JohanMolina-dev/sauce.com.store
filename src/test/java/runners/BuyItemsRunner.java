package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/BuyItems.feature", glue = {"com/saucedemo/step_definitions"})

public class BuyItemsRunner {
}
