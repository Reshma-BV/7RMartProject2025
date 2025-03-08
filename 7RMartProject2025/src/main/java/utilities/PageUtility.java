package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	public String SelectValueWithVisibleText(WebElement element, String VisibleText) {
		Select object = new Select(element);
		object.selectByVisibleText(VisibleText);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();	
	}
	public String SelectByVisbleValue(WebElement element, String Visiblevalue) {
		Select object = new Select(element);
		object.selectByVisibleText(Visiblevalue);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	public static void performDragAndDrop(WebElement source, WebElement target, WebDriver driver) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target);
		act.perform();
	}

	public static void hoverOverElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
		act.perform();
	}

	public static void rightClickElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).contextClick().perform();
	}

	public static void typeWithShiftKeyboardAction(WebDriver driver, WebElement element, String text) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys(text).keyUp(Keys.SHIFT).perform();
	}
	
	public static void clickUsingJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
