package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By sectionTitle = By.cssSelector(".text-center>h2");
	private By navigationBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getSectionTitle()
	{
		return driver.findElement(sectionTitle);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
	
	public List<WebElement> getPopupSize()
	{
		return driver.findElements(popup);
	}
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	

}
