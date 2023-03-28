package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CalendarPOM {
	private WebDriver driver;
	private WebDriverWait wait;
	public CalendarPOM(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	// web elements
	final String URL = "https://northeastern.instructure.com/calendar"; //calendar URL
	By calendarBtn = By.xpath("/html/body/div[3]/header[2]/div[1]/ul/li[5]/a"); //calendar element
	By addBtn = By.cssSelector("#create_new_event_link");
	By toDoBtn = By.xpath("/html/body/div[8]/div[3]/div/ul/li[2]/a");
	By submitBtn = By.xpath("/html/body/div[9]/div[3]/div/div[3]/form/div[2]/button");
	By viewToDo = By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div[4]/div/div/table/tbody/tr/td/div/div/div[5]/div[2]/table/tbody/tr/td[6]/a");
	
	public void hitURL() {
		this.driver.get(URL);
	}
	public void clickOnLogin() {
		hitURL();
	}	
	public void clickOnCalendarButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(calendarBtn));
		driver.findElement(calendarBtn).click();
	}
	public void clickOnAddButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		driver.findElement(addBtn).click();
	}
	
	public void clickOnToDoButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(toDoBtn));
		driver.findElement(toDoBtn).click();
	}
	public void clickOnSubmitBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		driver.findElement(submitBtn).click();
	}
	public void clickToViewToDo()
	{
		wait.until(ExpectedConditions.elementToBeClickable(viewToDo));
		driver.findElement(viewToDo).click();
	}
}







