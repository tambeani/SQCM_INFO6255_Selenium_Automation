package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import utility.ToPDF;

public class StudentServicesPOM extends BasePOM{

	private WebDriver driver;
	private WebDriverWait wait;
	public StudentServicesPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	// --------------- Elements ----------------
	By btnSubmit = By.xpath("/html/body/div[3]/form/input");
	By btnPrint = By.xpath("//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[1]");
	By eleBody = By.xpath("/html/body");
	
	// --------------- Function ---------------
	public void clickOnSubmit() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnSubmit),"click","");
	}
	public void print() throws AWTException, InterruptedException, IOException {
		String html = executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(eleBody),"getAttribute","innerHTML");
		ToPDF.saveToPdf(html,"myTranscript");
	}
	
}
