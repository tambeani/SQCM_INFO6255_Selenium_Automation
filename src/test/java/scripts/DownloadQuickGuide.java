package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utility.ReadFromExcel;
import utility.WindowSwitching;
import pages.ClassroomQuickGuide;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;
import utility.PasswordDecoder;
import utility.ReadFromExcel;

public class DownloadQuickGuide {

	private WebDriver driver;
	final String TS_NAME = "TS_DownloadQuickGuide";
	private final String ASSERT_VAL1 = "https://neuidmsso.neu.edu/idp/profile/SAML2/Redirect/SSO?execution=e1s2";

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

	@Test(dataProvider = "DP1")
	public void downloadQuickGuide(String user, String pass) throws InterruptedException, IOException {

		// Initialize dependencies
		ClassroomQuickGuide clsguide = new ClassroomQuickGuide(driver, TS_NAME);
		WindowSwitching ws = new WindowSwitching(driver);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver, TS_NAME);

		// TS - 1: Load canvas
		clsguide.clickOnLogin();

		// ----- Assert 1 -----
		Assert.assertTrue(ASSERT_VAL1.equals(driver.getCurrentUrl()));

		// TS - 2: Enter username
		sso.setUsername(user);

		// TS - 2: Enter password
		sso.setPassword(PasswordDecoder.decode(pass));

		// TS - 3: Click submit
		sso.clickOnSubmit();

		// TS - 4: Click on Classroom Link
		clsguide.clickOnClassroomLink();

		// TS - 5 : Click On Quick Guide PDF link
		clsguide.openQuickGuidePDF();
		ws.changeWindow();

		clsguide.closeWindow();

	}

}
