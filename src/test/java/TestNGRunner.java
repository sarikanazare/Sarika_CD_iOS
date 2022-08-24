import com.appium.utility.TestNGCucumberExecutable;
//import com.utility.LogCapture;
//import com.utility.SendMail;
//import org.testng.annotations.AfterSuite;
import cucumber.api.CucumberOptions;

@CucumberOptions(

		// features = { "@target/rerun.txt" }, //To run failed features scenario

		features = { "src/Feature/" },

		glue = { "com.cucumber.stepdefinition" }, strict = false, dryRun =false,


		 tags = { "@PAD-3388_TC2" },


		plugin = { "pretty", "html:target/site/cucumber-pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Extentreport.html",
				"rerun:target/rerun.txt" }, monochrome = false)

public class TestNGRunner extends TestNGCucumberExecutable {

}