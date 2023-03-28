package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DatasetPOM extends BasePOM{
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public DatasetPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	// web elements
	final String URL = "https://onesearch.library.northeastern.edu/discovery/search?vid=01NEU_INST:NU&l ang=en";
	By btnDrs = By.xpath("/html/body/primo-explore/div/prm-explore-main/div/prm-topbar/div/prm-main-menu/div/div/div[5]/a/span");
	By btnDataset = By.xpath("/html/body/div[1]/main/div[1]/section/div[1]/a[5]");
	By btnDownload = By.xpath("/html/body/div[1]/main/div[2]/main/section/ul/article[1]/div/div/div/div/div[1]/a[1]");

	// web element actions
	public void hitURL() {
		this.driver.get(URL);
	}

	public void loadPage() {
		hitURL();
	}
	
	
	public static void scrollToBottom(WebDriver driver) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");
	}

	
	public void btnDrs() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnDrs));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnDrs),"click","");
	}

	public void btnDataset() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnDataset));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnDataset),"click","");
        
	}
	
	public void btnDownload() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnDownload));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnDownload),"click","");
	}
	
}
