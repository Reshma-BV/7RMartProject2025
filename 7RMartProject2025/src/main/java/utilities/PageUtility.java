package utilities;

import org.openqa.selenium.WebElement;
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
}
