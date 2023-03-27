package scripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;
import pages.StudentServicesPage;
import utility.PasswordDecoder;
import utility.ReadFromExcel;
import utility.Screenshot;
import utility.WindowSwitching;

public class DownloadTranscriptScenario {

	private WebDriver driver;
	private Screenshot SS;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getenv("DRIVER_PATH"));
		driver = new ChromeDriver();
		SS = new Screenshot(driver);
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
		SS.capture(this.getClass().getSimpleName()+"_BEFORE_LOGIN");
		SSOLogin(user, pass);
		SS.capture(this.getClass().getSimpleName()+"_AFTER_LOGIN");

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
		SS.capture(this.getClass().getSimpleName()+"_BEFORE_SUBMIT");
		srvStd.clickOnSubmit();
		SS.capture(this.getClass().getSimpleName()+"_AFTER_SUBMIT");

		// TS - 7: Print the webpage
		srvStd.print();

		// TS - 8: Close window
		driver.quit();
	}

}
