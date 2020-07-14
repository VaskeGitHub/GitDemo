package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {

	public WebDriver driver;
	
	private By searchbox = By.name("query");
	
	
	public WebElement getSearchbox()
	{
		return driver.findElement(searchbox);
	}
	
	
	public PortalHomePage(WebDriver driver)
	{
		this.driver = driver;
	}

}
