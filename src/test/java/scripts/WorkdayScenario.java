package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SingleSignOnPOM;
import pages.Workday;
import utility.*;
import pages.WorkdayPOM;
public class WorkdayScenario {
	
	private WebDriver driver;
	private Screenshot SS;
	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getenv("DRIVER_PATH"));
		driver = new ChromeDriver();
		SS = new Screenshot(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@DataProvider(name = "DP1")
	public Object[][] createData() throws IOException {
		ReadFromExcel readFromeExcel = new ReadFromExcel();
		Object[][] retObjArr = readFromeExcel.getExcelData(System.getenv("EXCEL_PATH") + "data.xls", "login");
		return retObjArr;
	}
	
	public void SSOLogin(String user, String pass) throws InterruptedException, IOException {
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);

		// Enter username
		sso.setUsername(user);

		// Enter password
		sso.setPassword(PasswordDecoder.decode(pass));

		// Click submit
		sso.clickOnSubmit();

		// Loading StudentHub
		//sso.setDontShowAgain();
		sso.clickOnYes();

	}
	
	@Test(dataProvider = "DP1")
	public void workdaylogin(String user,String pass) throws InterruptedException, IOException {
		
		// Initialize dependencies
		Workday stdwd = new Workday(driver);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);
		WorkdayPOM id = new WorkdayPOM(driver);
		
		WindowSwitching ws =new WindowSwitching(driver);

		// TS - 1: Load canvas
		stdwd.clickOnLogin();

		// TS - 2: Enter username
		//sso.setUsername(user);

		// TS - 2: Enter password
		//sso.setPassword(pass);

		// TS - 3: Click submit
		//sso.clickOnSubmit();
		
		//TS - 4: Click Skip
		Thread.sleep(2000);
		stdwd.btnSkip();
		
		//TS - 5: Click Office Student Employment
		stdwd.btnOfcStuEmp();
	
		
		//TS - 6: Click Students
		Thread.sleep(3000);
		ws.changeWindow();
		stdwd.btnStudent();
		
		//TS - 7: Click My Job Mail
		stdwd.btnMyJobMail();
		
		//TS - 8: Enter UserName
		id.setUsername(user);
		
		//TS -9: Enter Password
		id.setPassword(pass);
		
		//TS -10 : Click Login
		id.btnLogin();
		
		//TS -11 : Click Add Employee
		stdwd.btnAddEmp();
		stdwd.btnEmpName();
		stdwd.btnAdd();
		stdwd.btnSave();
		stdwd.btnClose();
		
		//TS -12 : Click Add Category
		stdwd.btnAddCat();
		stdwd.btnCatName();
		stdwd.btnAddCat1();
		stdwd.btnSaveCat();
		stdwd.btnCloseCat();
		
		//TS -13 : Click Add  Time Frame
		stdwd.btnAddTF();
		stdwd.btnTFName();
		stdwd.btnAddTF1();
		stdwd.btnSaveTF();
		stdwd.btnCloseTF();
		
		//TS -14 : Click Save Subscription
		stdwd.btnSaveSubs();
		
		
	}
}
