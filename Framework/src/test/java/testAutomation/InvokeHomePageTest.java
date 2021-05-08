package testAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mainAutomation.FrameworkBase;
import pageObjectRepository.RepositoryHome;

public class InvokeHomePageTest extends FrameworkBase {
	
	public WebDriver driver;

	public static Logger logObject = LogManager.getLogger(InvokeHomePageTest.class.getName());	

	@Test(dataProvider = "LoginTestData")
	public void invokeHomePageTest(String username, String password) throws IOException {
		driver = initalizeDriver();
		driver.get("https://rahulshettyacademy.com/sign_in/");
		logObject.info("URL invoked successfully");
		RepositoryHome rh = new RepositoryHome(driver);
		rh.getEmail().sendKeys(username);
		rh.getPassword().sendKeys(password);
		rh.getLogin().click();
		driver.close();
		logObject.info("executed successfully");

	}

	

	@DataProvider(name = "LoginTestData")
	public Object[][] getData() {
		logObject.info("Data provider is reached successfully");
		Object[][] loginTestData = new Object[2][2];
		// Set 1
		loginTestData[0][0] = "Ganesh";
		loginTestData[0][1] = "password1";

		// Set 2
		loginTestData[1][0] = "Ramesh";
		loginTestData[1][1] = "password1";

		return loginTestData;
	
	}

}
