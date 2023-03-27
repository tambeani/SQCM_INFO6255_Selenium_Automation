package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ClassroomQuickGuide {

	private WebDriver driver;

	public ClassroomQuickGuide(WebDriver driver) {
		this.driver = driver;
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
	
	public void clickOnClassroomLink() {
		driver.findElement(classroomLink).click();
	}
	
	public void openQuickGuidePDF() {
		driver.findElement(pdfLink).click();
	}
}