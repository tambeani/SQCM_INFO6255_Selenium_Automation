package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CanvasPOM {
	
	WebDriver driver;
	public CanvasPOM(WebDriver driver) {
		this.driver = driver;
	}
	
	final String URL = "https://canvas.northeastern.edu/";
	By login = By.xpath("//*[@id=\"menu-item-menu-main-desktop-4343\"]/a/span");

	public void hitURL() {
		driver.get(URL);
	}
	public void clickOnLogin() {
		this.hitURL();
		driver.findElement(login).click();
	}


}
