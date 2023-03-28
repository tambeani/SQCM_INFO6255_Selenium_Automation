package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Screenshot;

public abstract class BasePOM {
	
	private WebDriver driver;
	private Screenshot SS;
	private String TS_NAME;
	
	public BasePOM(WebDriver driver) {
		this.driver = driver;
		SS = new Screenshot(driver);
		this.TS_NAME = "undefined";
	}
	
	public BasePOM(WebDriver driver,String TS_NAME) {
		this.driver = driver;
		SS = new Screenshot(driver);
		this.TS_NAME = TS_NAME;
	}
	
	public void setTsName(String TS_NAME) {
		this.TS_NAME = TS_NAME;
	}
	
	public String executeAction(String method,WebElement ele, String action, String text) throws IOException {
		String ret = "";
		SS.capture("\\before\\"+TS_NAME+"\\"+method);
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
		case "clear":
			ele.clear();
			break;
		}
		SS.capture("\\after\\"+TS_NAME+"\\"+method);
		return ret;
	}
	
	public void closeWindow() throws IOException, InterruptedException {
		Thread.sleep(5000);
		SS.capture("\\after\\"+TS_NAME+"\\"+"WINDOW_CLOSE");
		driver.quit();
	}
	
}
