package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CalendarPOM;
import utility.PasswordDecoder;
import utility.ReadFromExcel;
import pages.ClassroomQuickGuide;
import pages.SingleSignOnPOM;
import pages.StudentHubPOM;
import utility.ReadFromExcel;

public class AddTaskToCalendar {

	private WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getenv("DRIVER_PATH"));
		// "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider(name = "DP1")
	public Object[][] createData() throws IOException {
		ReadFromExcel readFromeExcel = new ReadFromExcel();
		String filePath = System.getenv("EXCEL_PATH") + "data.xls";
		String sheetName = "calendar";
		Object[][] retObjArr = readFromeExcel.getExcelData(filePath, sheetName);
		return retObjArr;
	}

	@Test(dataProvider = "DP1")
	public void addTaskToCalendar(String user, String pass, String title, String date, String time, String calender,
			String details) throws InterruptedException, IOException {

		// Initialize dependencies
		CalendarPOM calendar = new CalendarPOM(driver);
		SingleSignOnPOM sso = new SingleSignOnPOM(driver);
		
		// TS - 1: Load canvas
		calendar.clickOnLogin();
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

		// TS-7: Click on submit btn
		calendar.clickOnSubmitBtn();

		// TS- 8: View the To do that is added
		calendar.clickToViewToDo();
	}

}