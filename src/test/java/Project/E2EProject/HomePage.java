package Project.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends resources.Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver=InitializeDriver();
		log.info("Driver initialized.");
	}
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String username, String password, String userType) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL.");
		LandingPage land = new LandingPage(driver);
		land.getLogin().click();
		LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getLoginButton().click();
		log.info("Email and password entered and login button clicked.");
		log.info(userType);
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3]; //2 stands for number of different users that you want to test the login function for, 3 stands for number of parameters you'll be using (email, password, user type)
		//0th row
		data[0][0]="nonrestricteduser@test.com";
		data[0][1]="test123";
		data[0][2]="Non-Restricted User";
		//1st row
		data[1][0]="restricteduser@test.com";
		data[1][1]="test321";
		data[1][2]="Restricted User";
		
		return data;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
