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
import utility.ReadFromExcel;

public class WorkdayScenario {
	
	private WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajatrao/Downloads/chromedriver_mac64/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@DataProvider(name = "DP1")
	public Object[][] createData() throws IOException {
		ReadFromExcel readFromeExcel = new ReadFromExcel();
		Object[][] retObjArr = readFromeExcel.getExcelData("src/test/resources/" + "data.xls", "login");
		return retObjArr;
	}
	
	@Test(dataProvider = "DP1")
	public void workdaylogin(String user,String pass) throws InterruptedException {
		
		// Initialize dependencies
		Workday stdwd = new Workday(driver);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);

		// TS - 1: Load canvas
		stdwd.clickOnLogin();

		// TS - 2: Enter username
		sso.setUsername(user);

		// TS - 2: Enter password
		sso.setPassword(pass);

		// TS - 3: Click submit
		sso.clickOnSubmit();
		
		//TS - 4: Click Skip
		Thread.sleep(2000);
		stdwd.btnSkip();
		
		//TS - 5: Click Office Student Employment
		stdwd.btnOfcStuEmp();
		
		//TS - 6: Click Students
		stdwd.btnStudent();
		Thread.sleep(2000);
		
		//TS - 7: Click My Job Mail
		stdwd.btnMyJobMail();
	}
}
