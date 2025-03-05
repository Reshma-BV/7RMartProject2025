package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
	
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid Browser");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult itestresult) throws IOException {// ITestResult interface manage all the test results
																		
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, itestresult.getName());
		}
		driver.quit();
	}
}
