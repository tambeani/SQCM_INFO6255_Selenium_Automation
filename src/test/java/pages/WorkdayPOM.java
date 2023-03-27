package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkdayPOM {

	WebDriver driver;
	public WorkdayPOM(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------------------- Elements -----------------------------------
	
	final String URL = "https://neu.studentemployment.ngwebsolutions.com/jobx_myjobmail.aspx";
	By txtUsername = By.id("username");
	By txtPassword = By.id("password");
	
	
	public void setUsername(String user) {
		driver.findElement(txtUsername).sendKeys(user);
	}
	public void setPassword(String pass) {
		driver.findElement(txtPassword).sendKeys(pass);
	}
	
}
