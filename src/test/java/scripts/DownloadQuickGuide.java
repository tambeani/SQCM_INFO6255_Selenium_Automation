package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ReadFromExcel;
import pages.ClassroomQuickGuide;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;

public class DownloadQuickGuide {
	
	private WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getenv("DRIVER_PATH"));
				//"C:\\driver\\chromedriver.exe");
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
	public void downloadQuickGuide(String user,String pass) throws InterruptedException {
		
		// Initialize dependencies
		ClassroomQuickGuide clsguide = new ClassroomQuickGuide(driver);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);

		// TS - 1: Load canvas
		clsguide.clickOnLogin();

		// TS - 2: Enter username
		sso.setUsername(user);

		// TS - 2: Enter password
		sso.setPassword(pass);

		// TS - 3: Click submit
		sso.clickOnSubmit();
		
		Thread.sleep(10000);
		
		// TS - 4: Click on Classroom Link
		clsguide.clickOnClassroomLink();
		
		Thread.sleep(10000);
		
		clsguide.openQuickGuidePDF();
		
	}
	
}
