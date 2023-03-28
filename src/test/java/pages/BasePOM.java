package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Screenshot;

public abstract class BasePOM {
	
	private WebDriver driver;
	private Screenshot SS;
	
	public BasePOM(WebDriver driver) {
		this.driver = driver;
		SS = new Screenshot(driver);
	}
	
	public String executeAction(String method,WebElement ele, String action, String text) throws IOException {
		String ret = "";
		SS.capture("\\before\\"+method);
		switch(action) {
		case "click":
			ele.click();
			break;
		case "sendKeys":
			ele.sendKeys(text);
			break;
		case "getAttribute":
			ret = ele.getAttribute(text);
			break;
		}
		SS.capture("\\after\\"+method);
		return ret;
	}
	
}
