package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RepositoryLandingPage {
    
	WebDriver driver;
	
	public RepositoryLandingPage(WebDriver driver) {
		this.driver = driver;
	}

 
	By navigationBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	
	
	
	public WebElement getNavigationBar()
	{
		WebElement navigation = driver.findElement(navigationBar);
		return navigation;
	}
	
	
	
	
}
