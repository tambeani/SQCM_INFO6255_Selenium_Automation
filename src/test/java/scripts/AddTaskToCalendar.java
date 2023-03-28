package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.CalendarPOM;
import utility.PasswordDecoder;
import utility.ReadFromExcel;
import pages.ClassroomQuickGuide;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;
import utility.ReadFromExcel;

public class AddTaskToCalendar {

	private WebDriver driver;
	final String TS_NAME = "TS_AddTaskToCalendar";
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
		String filePath = System.getenv("EXCEL_PATH") + "data.xls";
		String sheetName = "Sheet1";
		Object[][] retObjArr = readFromeExcel.getExcelData(filePath, sheetName);
		return retObjArr;
	}

	@Test(dataProvider = "DP1")
	public void addTaskToCalendar(String user, String pass, String title, String date, String time, String calender,
			String details) throws InterruptedException, IOException {

		// Initialize dependencies
		CalendarPOM calendar = new CalendarPOM(driver,TS_NAME);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver,TS_NAME);
		
		// TS - 1: Load canvas
		calendar.clickOnLogin();
		
		// ----- Assert 1 -----
		Assert.assertTrue(ASSERT_VAL1.equals(driver.getCurrentUrl()));
		
		// TS - 2: Enter username
		sso.setUsername(user);
		
		// TS - 2: Enter password
		sso.setPassword(PasswordDecoder.decode(pass));
		
		// TS - 3: Click submit
		sso.clickOnSubmit();
		
		// TS - 4: Click on calendarBtn
		calendar.clickOnCalendarButton();

		// TS- 5: Click on addBtn
		calendar.clickOnAddButton();

		// TS- 6: Click on todoBtn
		calendar.clickOnToDoButton();

		// Fill the details from excel sheet
		calendar.enterValues(title,date,time,calender,details);

		// TS-7: Click on submit btn
		calendar.clickOnSubmitBtn();

		// TS - 8: View the To do that is added
		calendar.clickToViewToDo();
		
		// TS - 9: Close window
		calendar.closeWindow();
	}

}