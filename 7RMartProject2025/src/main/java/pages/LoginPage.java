package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;

	public LoginPage enterUsernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement signinbuttonclick;

	public HomePage clickOnSigninButton() {
		signinbuttonclick.click();
		return new HomePage(driver);
	}
}
