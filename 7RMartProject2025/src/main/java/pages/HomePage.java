package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Admin")
	private WebElement adminclick;
	@FindBy(linkText = "Logout")
	private WebElement logoutclick;
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement signinbuttonclick;
	

	public HomePage clickOnadminButton() {
		adminclick.click();
		return this;
	}
	public LoginPage clickOnLogoutButton()
	{
		logoutclick.click();
		return new LoginPage(driver);
	}
	public boolean isSignInButtonDisplayed()
	{
		return signinbuttonclick.isDisplayed();
	}
	
	
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageuser;
	public AdminUserPage clickManageUser() {
		manageuser.click();
		return new AdminUserPage(driver);
	}
	
	
}
