package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CanvasPOM;
import pages.SingleSignOnPOM;

public class DownloadTranscriptScenario {

	private WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void loadCanvas() throws InterruptedException {

		// Initialize dependencies
		CanvasPOM cnvs = new CanvasPOM(driver);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);

		// TS - 1: Load canvas
		cnvs.clickOnLogin();

		// TS - 2: Enter username
		Thread.sleep(2000);
		sso.setUsername("tambe.ani");

		// TS - 2: Enter password
		sso.setPassword("PSWD");

		// TS - 3: Click submit
		sso.clickOnSubmit();
	}
	
}
