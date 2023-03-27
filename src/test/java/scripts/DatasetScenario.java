package scripts;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DatasetPOM;
import utility.WindowSwitching;


public class DownloadDatasetScenario {
	
	private WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getenv("DRIVER_PATH"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	
	@Test
	public void datasetDownload() throws InterruptedException {
		
		// Initialize dependencies
		DatasetPOM dsd = new DatasetPOM(driver);
		WindowSwitching ws = new WindowSwitching(driver);

		// TS - 1: Go to the webpage
		dsd.loadPage();

		
		//TS - 2: Click Digital Repository Service
		Thread.sleep(2000);
		dsd.btnDrs();
		ws.changeWindow();
		DatasetPOM.scrollToBottom(driver);
		Thread.sleep(2000);
		
		//TS - 3: Click Datasets
		dsd.btnDataset();
		
		//TS - 4: Click Zip File
		dsd.btnDownload();
		Thread.sleep(2000);
	}
}
