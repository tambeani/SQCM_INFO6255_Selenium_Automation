package scripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;
import pages.StudentServicesPOM;
import utility.PasswordDecoder;
import utility.ReadFromExcel;
import utility.Screenshot;
import utility.WindowSwitching;

public class DownloadTranscriptScenario {

	private final String TS_NAME = "TS_DownloadTranscriptScenario";
	private final String ASSERT_VAL1 = "https://neuidmsso.neu.edu/idp/profile/SAML2/Redirect/SSO?execution=e1s2";
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

	public void SSOLogin(String user, String pass) throws InterruptedException, IOException {
		SingleSignOnPOM sso = new SingleSignOnPOM(driver,TS_NAME);

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
		StudentHubPOM stdhb = new StudentHubPOM(driver,TS_NAME);
		WindowSwitching windowSwitching = new WindowSwitching(driver);
		StudentServicesPOM srvStd = new StudentServicesPOM(driver,TS_NAME);

		// -------------------- Begin TC -------------------------------
		// TS - 1: Load studenthub
		stdhb.clickOnLogin();
		
		// ----- Assert 1 -----
		Assert.assertTrue(ASSERT_VAL1.equals(driver.getCurrentUrl()));
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
		srvStd.closeWindow();
	}

}
