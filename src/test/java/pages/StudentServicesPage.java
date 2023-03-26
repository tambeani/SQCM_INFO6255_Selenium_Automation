package pages;

import org.openqa.selenium.By;
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
}
