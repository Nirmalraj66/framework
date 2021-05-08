package mainAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FrameworkBase {
	public WebDriver driver;
	
	
	public WebDriver initalizeDriver() throws IOException {

		// Fetching data from config file

//		FileInputStream fis = new FileInputStream("E:\\Eclipse\\Workplace\\Framework\\Config.prop");
//		Properties prop = new Properties();
//		prop.load(fis);
		
		String desiredBrowser = System.getProperty("browser");

		//String desiredBrowser = prop.getProperty("browser");
		System.out.println("test"+ desiredBrowser);
		
		

		if (desiredBrowser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Udemy\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (desiredBrowser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Udemy\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		//Setting implicit wait to the driver
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		File screenshot = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String filePath= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(screenshot, new File(filePath));
		return filePath;
		
		
	}

}
