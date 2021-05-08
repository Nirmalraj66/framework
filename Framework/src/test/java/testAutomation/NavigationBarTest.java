package testAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import mainAutomation.FrameworkBase;
import pageObjectRepository.RepositoryHome;
import pageObjectRepository.RepositoryLandingPage;

public class NavigationBarTest extends FrameworkBase  {
	
	public WebDriver driver;
	
	public static Logger logObject = LogManager.getLogger(NavigationBarTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver = initalizeDriver();	
		driver.get("http://www.qaclickacademy.com/");
		logObject.info("URL invoked successfully");
		
		
	}
	
	@Test
	public void invokeHomePageTest() throws IOException {
		
	RepositoryLandingPage repLandPage = new RepositoryLandingPage(driver);
	
    boolean navigationBarFlag = repLandPage.getNavigationBar().isDisplayed();
   
    Assert.assertEquals(navigationBarFlag, false);
       
    logObject.info("Navigation bar is found");
	
				
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		
		logObject.info("driver closed");
	}
		

}
