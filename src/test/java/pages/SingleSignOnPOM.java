package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleSignOnPOM extends BasePOM {

	private WebDriver driver;
	private WebDriverWait wait;

	public SingleSignOnPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public SingleSignOnPOM(WebDriver driver,String TS_NAME) {
		super(driver,TS_NAME);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	// ----------------------- Elements -----------------------------------

	final String URL = "https://my.northeastern.edu/";
	By txtUsername = By.id("username");
	By txtPassword = By.id("password");
	By btnLogin = By.xpath(
			"//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_7SMCIHKvD44Y\"]/div/div/div/div[2]/div/div[2]/div/a");
	By btnSubmit = By.name("_eventId_proceed");
	By chkDontShow = By.id("KmsiCheckboxField");
	By btnYes = By.id("idSIButton9");

	// ------------------------- Actions ----------------------------------

	public void setUsername(String user) throws IOException {
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(txtUsername), "sendKeys",
				user);
	}

	public void setPassword(String pass) throws IOException {
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(txtPassword), "sendKeys",
				pass);
	}

	public void clickOnSubmit() throws IOException {
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnSubmit), "click", "");
	}

	public void hitURL() {
		driver.get(URL);
	}

	public void clickOnLogin() throws IOException {
		this.hitURL();
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnLogin), "click", "");
	}

	public void setDontShowAgain() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(chkDontShow));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(chkDontShow), "click", "");
	}

	public void clickOnYes() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnYes));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnYes), "click", "");
	}

}
