package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassroomQuickGuide extends BasePOM{

	private WebDriver driver;
	private WebDriverWait wait;
	public ClassroomQuickGuide(WebDriver driver,String TS_NAME) {
		super(driver,TS_NAME);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	// web elements
	final String URL = "https://service.northeastern.edu/tech?id=classrooms";
	By classroomLink = By.xpath("/html/body/div/section/main/div[2]/div/sp-page-row/div/div/span/div/div/div[2]/span/div/div/div[1]/div/div/div/a");
	By pdfLink = By.xpath("/html/body/div/section/main/div/div/sp-page-row/div/div[1]/span/div/div/div[2]/span/table[1]/tbody/tr[1]/td[2]/a");
	// web element actions
	public void hitURL() {
		this.driver.get(URL);
	}

	public void clickOnLogin() {
		hitURL();
	}	
	
	public void clickOnClassroomLink() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(classroomLink));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(classroomLink),"click","");
	}
	
	public void openQuickGuidePDF() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(pdfLink));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(pdfLink),"click","");
	}
	
}