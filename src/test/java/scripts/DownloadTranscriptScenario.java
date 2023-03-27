package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CanvasPOM;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;
import utility.PasswordEncoder;
import utility.ReadFromExcel;

public class DownloadTranscriptScenario {

	private WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getenv("DRIVER_PATH"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@DataProvider(name = "DP1")
	public Object[][] createData() throws IOException {
		ReadFromExcel readFromeExcel = new ReadFromExcel();
		Object[][] retObjArr = readFromeExcel.getExcelData(System.getenv("EXCEL_PATH")+ "data.xls", "login");
		return retObjArr;
	}
	
	@Test(dataProvider = "DP1")
	public void downloadTranscripts(String user,String pass) throws InterruptedException {
		
		// Initialize dependencies
		StudentHubPOM stdhb = new StudentHubPOM(driver);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);

		// TS - 1: Load studenthub
		stdhb.clickOnLogin();

		// TS - 2: Enter username
		sso.setUsername(user);

		// TS - 2: Enter password
		sso.setPassword(PasswordEncoder.decode(pass));

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
		
		// TS - 10: Click on My Transcripts
		Thread.sleep(2000);stdhb.clickOnTranscripts();
		
	}
	
}
