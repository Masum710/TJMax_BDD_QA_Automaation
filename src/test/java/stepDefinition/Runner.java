package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions (features="src/test/resources/Features", glue={"stepDefinition"} , plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} , publish = true)

public class Runner {

}
