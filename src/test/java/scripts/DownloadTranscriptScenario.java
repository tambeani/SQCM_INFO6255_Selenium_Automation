package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CanvasPOM;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;

public class DownloadTranscriptScenario {

	private WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Test
	public void downloadTranscripts() throws InterruptedException {

		// Initialize dependencies
		StudentHubPOM stdhb = new StudentHubPOM(driver);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);

		// TS - 1: Load canvas
		stdhb.clickOnLogin();

		// TS - 2: Enter username
		sso.setUsername("tambe.ani");

		// TS - 2: Enter password
		sso.setPassword("12121@@ATc.Rtn.");

		// TS - 3: Click submit
		sso.clickOnSubmit();
		
		// Loading StudentHub
		Thread.sleep(10000);sso.setDontShowAgain();
		Thread.sleep(10000);sso.clickOnYes();
		
		// TS - 7: Click on close
		Thread.sleep(10000);stdhb.onClose();
		
		// TS - 8: Click on resources
		stdhb.clickOnResources();
		
		// TS - 9: Click on registration
		stdhb.clickOnAcademicReg();
		
	}
	
}
