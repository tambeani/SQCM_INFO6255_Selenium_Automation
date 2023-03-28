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
	By txtUsername = By.id("Skin_ctl11_LoginNameText");
	By txtPassword = By.id("Skin_ctl11_LoginPasswordText");
	By btnLogin = By.xpath("/html/body/div[3]/div[6]/form/table[1]/tbody/tr[4]/td[2]/input");
	
	public void setUsername(String user) {
		driver.findElement(txtUsername).sendKeys(user);
	}
	public void setPassword(String pass) {
		driver.findElement(txtPassword).sendKeys(pass);
	}
	
	public void btnLogin() {
		driver.findElement(btnLogin).click();
	}
}
