package Project.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class NavigationBarPresence  extends resources.Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(NavigationBarPresence.class.getName());

	@BeforeTest
	public void initialization() throws IOException
	{
		driver=InitializeDriver();
		log.info("Driver initialized.");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL.");
	}
	
	@Test
	public void validateNavBar() throws IOException
	{
			LandingPage land = new LandingPage(driver);
			Assert.assertTrue(land.getNavigationBar().isDisplayed());
			log.info("Navigation bar is present.");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}


}
