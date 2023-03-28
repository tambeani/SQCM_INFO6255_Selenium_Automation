package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM for StudentHub
public class StudentHubPOM extends BasePOM{

	private WebDriver driver;
	private WebDriverWait wait;

	public StudentHubPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	// web elements
	final String URL = "http://me.northeastern.edu";
	By login = By.xpath("//*[@id=\"bySelection\"]/div[2]/div/span");
	By btnClose = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]/span/i");
	By btnResources = By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a/span");
	By btnAcademicReg = By.xpath(
			"/html/body/div[1]/div[2]/div[2]/div[2]/div[3]/section/article/div[1]/div/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/div/p");
	By btnMyTranscripts = By.xpath(
			"/html/body/div[1]/div[2]/div[2]/div[2]/div[3]/section/article/div[1]/div/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div/div/div[1]/div/div[20]/div/div/a");

	// web element actions
	public void hitURL() {
		this.driver.get(URL);
	}

	public void clickOnLogin() throws IOException {
		hitURL();
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(login),"click","");
	}

	public void onClose() throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnClose));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnClose),"click","");
	}

	public void clickOnResources() throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnResources));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnResources),"click","");
	}

	public void clickOnAcademicReg() throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnAcademicReg));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnAcademicReg),"click","");
	}

	public void clickOnTranscripts() throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnMyTranscripts));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnMyTranscripts),"click","");
	}

}
