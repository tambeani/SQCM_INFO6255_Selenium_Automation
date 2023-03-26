package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleSignOnPOM {
	
	WebDriver driver;
	public SingleSignOnPOM(WebDriver driver) {
		this.driver = driver;
	}
	
	final String URL = "https://my.northeastern.edu/";
	By username = By.id("username");
	By password = By.id("password");
	By login = By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_7SMCIHKvD44Y\"]/div/div/div/div[2]/div/div[2]/div/a");
	By submit = By.name("_eventId_proceed");
	
	public void setUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	public void setPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void clickOnSubmit(){
		driver.findElement(submit).click();
	}
	public void hitURL() {
		driver.get(URL);
	}
	public void clickOnLogin() {
		this.hitURL();
		driver.findElement(login).click();
	}
	
}
