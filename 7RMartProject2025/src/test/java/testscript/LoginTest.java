package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority = 4, description = "Verification of user login with valid credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		String expected = "Dashboard | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, Messages.LOGINFAILED);
	}

	@Test(priority = 1, description = "Verification of user login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", Messages.INVAILDPASSWORDLOGIN);

	}

	@Test(priority = 2, description = "Verification of user login with invalid username and valid password",groups= {"smoke"})
	public void verifyUserLoginWithInValidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", Messages.INVALIDUSERNAME);

	}

	@Test(priority = 3, description = "Verification of user login with invalid username and password",dataProvider="loginprovider")
	public void verifyUserLoginWithInValidUsernameAndInValidPassword(String username,String password) throws IOException {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket",Messages.INVALIDUSERNAMEANDPASSWORD);

	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin123","admin123"},
			new Object[] {"123","123"},
			//new Object[] {ExcelUtility.readStringData(3, 0,"Login"),ExcelUtility.readStringData(3,1 ,"Login")}
		};
	}
}
