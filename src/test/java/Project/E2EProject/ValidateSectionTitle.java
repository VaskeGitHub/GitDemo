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


public class ValidateSectionTitle extends resources.Base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(ValidateSectionTitle.class.getName());

	LandingPage land;
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver=InitializeDriver();
		log.info("Driver initialized.");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL.");
	}
	@Test
	public void validateSectionTitle() throws IOException
	{
		land = new LandingPage(driver);
		Assert.assertEquals(land.getSectionTitle().getText(), "FEATURED COURSES111");
		log.info("Title matches.");
	}
	
	@Test
	public void validateHeader()
	{
		Assert.assertEquals(land.getSectionTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Header title matches.");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
