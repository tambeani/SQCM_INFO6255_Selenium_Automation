package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPOM extends BasePOM {
	private WebDriver driver;
	private WebDriverWait wait;

	public CalendarPOM(WebDriver driver,String TS_NAME) {
		super(driver,TS_NAME);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	// web elements
	final String URL = "https://northeastern.instructure.com/calendar"; 
	By calendarBtn = By.xpath("/html/body/div[3]/header[2]/div[1]/ul/li[5]/a"); 
	By addBtn = By.xpath("//*[@id=\"create_new_event_link\"]/i");
	By assName = By.xpath("//*[@id=\"group_user_156921_checkbox_label\"]");
	By toDoBtn = By.id("ui-id-5");
	By submitBtn = By.xpath("/html/body/div[8]/div[3]/div/div[4]/form/div[2]/button");
	By viewToDo = By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div[4]/div/div/table/tbody/tr/td/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a");
	By txtTitle = By.xpath("/html/body/div[8]/div[3]/div/div[4]/form/div[1]/table/tbody/tr[1]/td[2]/input");
	By txtDate = By.xpath("/html/body/div[8]/div[3]/div/div[4]/form/div[1]/table/tbody/tr[2]/td[2]/div/div[1]/input");
	By txtTime = By.xpath("/html/body/div[8]/div[3]/div/div[4]/form/div[1]/table/tbody/tr[3]/td[2]/div/div/input");
	By slCalendar = By.xpath("/html/body/div[8]/div[3]/div/div[4]/form/div[1]/table/tbody/tr[4]/td[2]/select");
	By txtDetails = By.xpath("/html/body/div[8]/div[3]/div/div[4]/form/div[1]/table/tbody/tr[5]/td[2]/textarea");

	public String getURL() {
		return URL;
	}
	
	public void hitURL() {
		this.driver.get(URL);
	}

	public void clickOnLogin() {
		hitURL();
	}

	public String getAssertValue1() {
		wait.until(ExpectedConditions.elementToBeClickable(assName));
		return driver.findElement(assName).getText();
	}
	public void clickOnCalendarButton() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(calendarBtn));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(calendarBtn),"click", "");
	}

	public void clickOnAddButton() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(addBtn),"click", "");
	}

	public void clickOnToDoButton() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(toDoBtn));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(toDoBtn),"click", "");
	}

	public void clickOnSubmitBtn() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(submitBtn),"click", "");
	}

	public void clickToViewToDo() throws InterruptedException, IOException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(viewToDo));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(viewToDo),"click", "");
	}

	public void setTitle(String title) throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(txtTitle));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(txtTitle),"sendKeys",title);
	}

	public void setDate(String date) throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(txtDate));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(txtDate),"clear","");
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(txtDate),"sendKeys",date);
	}

	public void setTime(String time) throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(txtTime));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(txtTime),"sendKeys",time);
	}

	public void setCalendar(String calendar) {
		wait.until(ExpectedConditions.elementToBeClickable(slCalendar));
		Select selCal = new Select(driver.findElement(slCalendar));
		selCal.selectByIndex(0);
	}

	public void setDetails(String details) throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(txtDetails));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(txtDetails),"sendKeys",details);
	}

	public void enterValues(String title, String date, String time, String calender, String details) throws IOException {
		setTitle(title);
		setDate(date);
		setTime(time);
		setCalendar(calender);
		setDetails(details);
	}
}
