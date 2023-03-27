package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class StudentServicesPage {

	private WebDriver driver;

	public StudentServicesPage(WebDriver driver) {
		this.driver = driver;
	}
	// --------------- Elements ----------------
	By btnSubmit = By.xpath("/html/body/div[3]/form/input");
	
	// --------------- Function ---------------
	public void clickOnSubmit() {
		driver.findElement(btnSubmit).click();
	}
	public void print() {
		((JavascriptExecutor)driver).executeScript("window.print()");
		
	}
	
}
