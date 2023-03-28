package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.SingleSignOnPOM;
import pages.Workday;
import utility.*;
import pages.WorkdayPOM;

public class WorkdayScenario {

	private WebDriver driver;
	private final String TS_NAME = "TS_WorkdayScenario";
	private final String ASSERT_VAL1 = "https://neuidmsso.neu.edu/idp/profile/SAML2/Unsolicited/SSO?execution=e1s2";

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
	public void workdaylogin(String user, String pass) throws InterruptedException, IOException {

		// Initialize dependencies
		Workday stdwd = new Workday(driver, TS_NAME);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver, TS_NAME);
		WorkdayPOM id = new WorkdayPOM(driver, TS_NAME);

		WindowSwitching ws = new WindowSwitching(driver);

		// TS - 1: Load canvas
		stdwd.hitURL();

		// ----- Assert 1 -----
		Assert.assertTrue(ASSERT_VAL1.equals(driver.getCurrentUrl()));

		// TS - 2: Enter username
		sso.setUsername(user);

		// TS - 2: Enter password
		sso.setPassword(PasswordDecoder.decode(pass));

		// TS - 3: Click submit
		sso.clickOnSubmit();

		// TS - 4: Click Skip
		Thread.sleep(2000);stdwd.btnSkip();

		// TS - 5: Click Office Student Employment
		stdwd.btnOfcStuEmp();

		// TS - 6: Click Students
		Thread.sleep(3000);ws.changeWindow();
		stdwd.btnStudent();

		// TS - 7: Click My Job Mail
		stdwd.btnMyJobMail();

		// TS - 8: Enter UserName
		id.setUsername(user);

		// TS -9: Enter Password
		id.setPassword(PasswordDecoder.decode(pass));

		// TS -10 : Click Login
		id.btnLogin();

		// TS -11 : Click Add Employee
		stdwd.btnAddEmp();
		stdwd.btnEmpName();
		stdwd.btnAdd();
		stdwd.btnSave();

		// TS -12 : Click Add Category
		stdwd.btnAddCat();
		stdwd.btnCatName();
		stdwd.btnAddCat1();
		stdwd.btnSaveCat();

		// TS -13 : Click Add Time Frame
		stdwd.btnAddTF();
		stdwd.btnTFName();
		stdwd.btnAddTF1();
		stdwd.btnSaveTF();

		// TS -14 : Click Save Subscription
		stdwd.btnSaveSubs();

		// Close window
		stdwd.closeWindow();
	}
}
