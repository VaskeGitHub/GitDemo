package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException{
		
		prop = new Properties();
		//System.getProperty("user.dir") returns the root C:\\Users\\vlada\\eclipse-workspace\\E2EProject\\
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		//FileInputStream fis = new FileInputStream("C:\\Users\\vlada\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		
		prop.load(fis);
		//mvn test -Dbrowser=Chrome
		String browserName = System.getProperty("browser"); //When using the above Maven console command
		//String browserName = prop.getProperty("browser"); 
		
		
		//Chrome
		if(browserName.contains("Chrome")) //== cannot be used because the browser name is derived from a property
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			
			ChromeOptions opt = new ChromeOptions();
			if(browserName.contains("Headless"))
				opt.addArguments("headless");
			driver = new ChromeDriver(opt);
		}
		//Firefox
		else if(browserName.equals("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//Internet Explorer
		else if(browserName.equals("IE")) 
		{
		//add code
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")  + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	

}
