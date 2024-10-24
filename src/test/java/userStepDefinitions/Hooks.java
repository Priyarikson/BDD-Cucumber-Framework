package userStepDefinitions;



import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.Dependency;

public class Hooks {

Dependency dependencyInjection;

	
	public Hooks(Dependency dependencyInjection) {
		this.dependencyInjection = dependencyInjection;
	}
	
	//@After - after each scenario
	
	@After
	public void closeDriver() {
		
		dependencyInjection.driver.quit();
	}
	//code to capture a screenshot and attach the same to the report, only if the scenario is Fail.
	//In case of Pass, no screenshot would be taken.
	//@AfterStep - Do something after executing the step 
	
	
	@AfterStep
	public void addScreenShot(Scenario scenario) throws Exception {
		
	
		if(scenario.isFailed()) {
			
			//This takes a screenshot from the driver and save it to the specified location
			//TakesScreenshot(interface in selenium) - casting >>(TakesScreenshot)driver
			//getScreenshotAs(OutputType.FILE) - method
			
			 File screenshotFile = ((TakesScreenshot) dependencyInjection.driver).getScreenshotAs(OutputType.FILE);
			 //apache commonio >>to convert File to byte[]
			 
			 byte[]fileContent=FileUtils.readFileToByteArray(screenshotFile);
			 //Parameters:
			 //data what to attach, for example an image.
			 //mediaType what is the data?
			 //name attachment name
			 scenario.attach(fileContent, "image/png", "image");
			
			
			
		}
	
	}

}
