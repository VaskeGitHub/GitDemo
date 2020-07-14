package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.Base;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

    @Given("^Chrome browser is initialized$")
    public void chrome_browser_is_initialized() throws Throwable {
    	driver=InitializeDriver();
    }
    
    @Given("^Nvigate to \"([^\"]*)\" site$")
    public void nvigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(prop.getProperty(strArg1));
    }

    @Given("^Click on Login link in home page to land on Secure signin page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_signin_page() throws Throwable {
    	LandingPage land = new LandingPage(driver);
    	if(land.getPopupSize().size()>0)
    		land.getPopup().click();
    	land.getLogin().click();
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getLoginButton().click();
    }

    @Then("^Verify the user is successfully logged in$")
    public void verify_the_user_is_successfully_logged_in() throws Throwable {
        PortalHomePage port = new PortalHomePage(driver);
        Assert.assertTrue(port.getSearchbox().isDisplayed());
    }

  

}