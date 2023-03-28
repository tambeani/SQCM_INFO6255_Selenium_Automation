package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkdayPOM extends BasePOM{

	WebDriver driver;
	private WebDriverWait wait;
	public WorkdayPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait= new WebDriverWait(driver, 30);
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
