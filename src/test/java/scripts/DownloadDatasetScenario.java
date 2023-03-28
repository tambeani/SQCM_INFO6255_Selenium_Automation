package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.DatasetPOM;
import utility.WindowSwitching;

public class DownloadDatasetScenario {

	private WebDriver driver;
	private final String TS_NAME = "TS_DownloadDatasetScenario";
	private final String ASSERT_VAL1 = "https://onesearch.library.northeastern.edu/discovery/search?vid=01NEU_INST:NU&l%20ang=en";

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getenv("DRIVER_PATH"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void datasetDownload() throws InterruptedException, IOException {

		// Initialize dependencies
		DatasetPOM dsd = new DatasetPOM(driver, TS_NAME);
		WindowSwitching ws = new WindowSwitching(driver);

		// TS - 1: Go to the webpage
		dsd.loadPage();

		// ----- Assert 1 -----
		Assert.assertTrue(ASSERT_VAL1.equals(driver.getCurrentUrl()));

		// TS - 2: Click Digital Repository Service
		dsd.btnDrs();
		ws.changeWindow();
		DatasetPOM.scrollToBottom(driver);

		// TS - 3: Click Datasets
		dsd.btnDataset();

		// TS - 4: Click Zip File
		dsd.btnDownload();

		// Close Window
		dsd.closeWindow();

	}
}
