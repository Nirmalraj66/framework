package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RepositoryHome {
    
	WebDriver driver;
	
	public RepositoryHome(WebDriver driver) {
		this.driver = driver;
	}

 
	By user_email = By.id("user_email");
	By user_password = By.id("user_password");
	By login = By.name("commit");
	
	
	public WebElement getEmail()
	{
		WebElement email = driver.findElement(user_email);
		return email;
	}
	
	public WebElement getPassword()
	{
		WebElement password = driver.findElement(user_password);
		return password;
	}

	public WebElement getLogin()
	{
		WebElement signin = driver.findElement(login);
		return signin;
	}
	
	
}
