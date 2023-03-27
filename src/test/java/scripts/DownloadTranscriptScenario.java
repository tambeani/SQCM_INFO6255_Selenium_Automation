package scripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import pages.CanvasPOM;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;
import pages.StudentServicesPage;
import utility.PasswordDecoder;
import utility.ReadFromExcel;
import utility.WindowSwitching;

public class DownloadTranscriptScenario {

	private WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getenv("DRIVER_PATH"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider(name = "DP1")
	public Object[][] createData() throws IOException {
		ReadFromExcel readFromeExcel = new ReadFromExcel();
		Object[][] retObjArr = readFromeExcel.getExcelData(System.getenv("EXCEL_PATH") + "data.xls", "login");
		return retObjArr;
	}

	public void SSOLogin(String user, String pass) throws InterruptedException {
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);

		// Enter username
		sso.setUsername(user);

		// Enter password
		sso.setPassword(PasswordDecoder.decode(pass));

		// Click submit
		sso.clickOnSubmit();

		// Loading StudentHub
		sso.setDontShowAgain();
		sso.clickOnYes();

	}

	@Test(dataProvider = "DP1")
	public void downloadTranscripts(String user, String pass) throws InterruptedException, AWTException, IOException {

		// -------------- Initialize dependencies ---------------------
		StudentHubPOM stdhb = new StudentHubPOM(driver);
		WindowSwitching windowSwitching = new WindowSwitching(driver);
		StudentServicesPage srvStd = new StudentServicesPage(driver);

		// -------------------- Begin TC -------------------------------
		// TS - 1: Load studenthub
		stdhb.clickOnLogin();
		SSOLogin(user, pass);

		// TS - 2: Click on close
		stdhb.onClose();

		// TS - 3: Click on resources
		stdhb.clickOnResources();

		// TS - 4: Click on registration
		stdhb.clickOnAcademicReg();

		// TS - 5: Click on My Transcripts
		stdhb.clickOnTranscripts();

		// TS - 6: Switch to new window and click on submit
		windowSwitching.changeWindow();
		srvStd.clickOnSubmit();

		// TS - 7: Print the webpage
		srvStd.print();

		// TS - 8: Close window
		driver.close();
	}

}
