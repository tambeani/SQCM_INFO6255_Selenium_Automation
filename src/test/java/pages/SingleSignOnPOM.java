package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleSignOnPOM {
	
	WebDriver driver;
	public SingleSignOnPOM(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------------------- Elements -----------------------------------
	
	final String URL = "https://my.northeastern.edu/";
	By txtUsername = By.id("username");
	By txtPassword = By.id("password");
	By btnLogin = By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_7SMCIHKvD44Y\"]/div/div/div/div[2]/div/div[2]/div/a");
	By btnSubmit = By.name("_eventId_proceed");
	By selectDevice = By.xpath("//*[@id=\"login-form\"]/fieldset/div/select");
	By chkRememberMe = By.name("dampen_choice");
	By btnSendPush = By.xpath("//*[@id=\"auth_methods\"]/fieldset[1]/div[1]/button");
	By chkDontShow = By.id("KmsiCheckboxField");
	By btnYes = By.id("idSIButton9");
	
	// ------------------------- Actions ----------------------------------
	
	public void setUsername(String user) {
		driver.findElement(txtUsername).sendKeys(user);
	}
	public void setPassword(String pass) {
		driver.findElement(txtPassword).sendKeys(pass);
	}
	public void clickOnSubmit(){
		driver.findElement(btnSubmit).click();
	}
	public void hitURL() {
		driver.get(URL);
	}
	public void clickOnLogin() {
		this.hitURL();
		driver.findElement(btnLogin).click();
	}
	public void setDevice(String device) {
		Select obj = new Select(driver.findElement(selectDevice));
		obj.selectByValue(device);
	}
	public void setRememberMe() {
		driver.findElement(chkRememberMe).click();
	}
	public void setDontShowAgain() {
		driver.findElement(chkDontShow).click();
	}
	public void clickOnSendPush() {
		driver.findElement(btnSendPush).click();
	}
	public void clickOnYes() {
		driver.findElement(btnYes).click();
	}

	
}
