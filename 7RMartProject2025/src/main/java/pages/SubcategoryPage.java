package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import utilities.PageUtility;

public class SubcategoryPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	
	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//p[text()='Sub Category'])[1]")
	private WebElement subcategoryclick;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbuttonclick;
	@FindBy(id = "cat_id")
	private WebElement category;
	@FindBy(id = "subcategory")
	private WebElement txt_subcategory;
	@FindBy(id = "main_img")
	private WebElement choosefile;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement buttonsave;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement subcategorysearch;
	@FindBy(id = "un")
	private WebElement searchcategory;
	@FindBy(name = "ut")
	private WebElement txt_searchsubcategory;
	@FindBy(name = "Search")
	private WebElement searchbuttonclick;
	@FindBy(xpath="//*[text()=' Reset']")
	private WebElement btn_Reset;
	@FindBy(xpath="//*[text()=' Alert!']")
	private WebElement alertSubCategory;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")
	private WebElement resultTable;
	@FindBy(xpath="(//div[@class='row'])[2]")
	private WebElement resetAssert;
	
	public SubcategoryPage selectSubCategory() {
		subcategoryclick.click();
		return this;

	}

	public SubcategoryPage clickOnNewBtnOnTheSubCategoryPage() {
		newbuttonclick.click();
		return this;
	}

	public SubcategoryPage selectCategoryFromDropdown() {
		pageutility.SelectValueWithVisibleText(category, "Vegetables");
		return this;
	}

	public SubcategoryPage enterSubCategoryName(String subcategory) {
		txt_subcategory.sendKeys(subcategory);
		return this;
	}

	public SubcategoryPage uploadImage() {
		choosefile.sendKeys(Constants.IMAGEFILE);
		return this;

	}

	public SubcategoryPage clickOnSaveBtnInTheSubCategoryPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(buttonsave));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", buttonsave);
		return this;
		
	}
	public  boolean AlertIsDisplayedSubCategoryCreation()
	{
		return alertSubCategory.isDisplayed();
	}

	public SubcategoryPage clickOnSearchBtnInTheSubCategoryPage() {
		subcategorysearch.click();
		return this;
	}

	public SubcategoryPage selectSubCategoryFromTheDropdown() {
		pageutility.SelectValueWithVisibleText(searchcategory, "Toys");
		return this;
	}

	public SubcategoryPage enterTheSubCategoryName(String searchsubcategory) {
		txt_searchsubcategory.sendKeys(searchsubcategory);
		return this;
	}

	public SubcategoryPage clickSearchBtnAfterFillingTheDetails() {
		searchbuttonclick.click();
		return this;

	}
	public boolean isTableDisplayed()
	{
		return resultTable.isDisplayed();
	}
	
	public SubcategoryPage clickOnTheResetButton()
	{
		btn_Reset.click();
		return this;
	}
	public boolean isRestWorking()
	{
		return resetAssert.isDisplayed();
	}
}
