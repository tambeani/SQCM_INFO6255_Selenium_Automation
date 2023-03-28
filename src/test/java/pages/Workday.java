package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Workday extends BasePOM {
	private WebDriver driver;
	private WebDriverWait wait;

	public Workday(WebDriver driver,String TS_NAME) {
		super(driver,TS_NAME);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	// web elements
	final String URL = "https://www.myworkday.com/northeastern/d/inst/13102!CK5mGhIKBggDEMenAhIICgYI1A0Q5wE~*AmKOdsyb7NU~/cacheable-task/23748$4.htmld#backheader=true&TABINDEX=1";
	By login = By.xpath("//*[@id=\\\"bySelection\\\"]/div[2]/div/span");
	By btnSkip = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div/div[2]/a");
	By btnOfcStuEmp = By.xpath("/html/body/div[2]/div/div[2]/div[1]/section/div/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[4]/div[1]/div/div/div[2]/div/div[3]/ul/li/div/div/div");
	By btnStudent = By.xpath("/html/body/div[3]/div[6]/form/span/div/div/div[4]/div[1]/a");
	By btnMyJobMail = By.xpath("/html/body/div[3]/div[6]/form/span/div/div[2]/div[3]/div/ul/li[2]/strong/a");
	By btnAddEmp = By.xpath("/html/body/div[3]/div[6]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[5]/button");
	By btnEmpName = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[1]");
	By btnAdd = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/a");
	By btnSave = By.xpath("/html/body/div[2]/div/div/div/div[4]/button");
	//By btnClose = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/button");
	By btnAddCat = By.xpath("/html/body/div[3]/div[6]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td[5]/button");
	By btnCatName = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[1]");
	By btnAddCat1 = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/a");
	By btnSaveCat = By.xpath("/html/body/div[2]/div/div/div/div[4]/button");
	//By btnCloseCat = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/button");
	By btnAddTF = By.xpath("/html/body/div[3]/div[6]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/button");
	By btnTFName = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[3]/div[1]");
	By btnAddTF1 = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/a");
	By btnSaveTF = By.xpath("/html/body/div[2]/div/div/div/div[4]/button");
	//By btnCloseTF = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/button");

	By btnSaveSubs = By.xpath("/html/body/div[3]/div[6]/form/div[5]/input");

	// web element actions
	public void hitURL() {
		this.driver.get(URL);
	}

	public void clickOnLogin() throws IOException {
		// hitURL();
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(login), "click",
				"");
	}

	public void btnSkip() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnSkip));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnSkip), "click",
				"");

		// driver.findElement(btnSkip).click();
	}

	public void btnOfcStuEmp() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnOfcStuEmp));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnOfcStuEmp),
				"click", "");

		// driver.findElement(btnOfcStuEmp).click();
	}

	public void btnStudent() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnStudent));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnStudent),
				"click", "");

		// driver.findElement(btnStudent).click();

	}

	public void btnMyJobMail() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnMyJobMail));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnMyJobMail),
				"click", "");

		// driver.findElement(btnMyJobMail).click();
	}

	public void btnAddEmp() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnAddEmp));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnAddEmp), "click",
				"");
	}

	public void btnEmpName() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnEmpName));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnEmpName),
				"click", "");
	}

	public void btnAdd() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnAdd),"click","");
	}

	public void btnSave() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnSave));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnSave), "click","");
	}

//	public void btnClose() throws IOException {
//		wait.until(ExpectedConditions.elementToBeClickable(btnClose));
//		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnClose), "click","");
//	}

	public void btnAddCat() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnAddCat));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnAddCat), "click","");
	}

	public void btnCatName() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnCatName));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnCatName), "click","");
	}

	public void btnAddCat1() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnAddCat1));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnAddCat1),"click", "");
	}

	public void btnSaveCat() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnSaveCat));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnSaveCat),"click", "");
	}

//	public void btnCloseCat() throws IOException {
//		wait.until(ExpectedConditions.elementToBeClickable(btnCloseCat));
//		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnCloseCat), "click","");
//	}

	public void btnAddTF() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnAddTF));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnAddTF), "click","");
	}

	public void btnTFName() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnTFName));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnTFName), "click","");
	}

	public void btnAddTF1() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnAddTF1));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnAddTF1), "click","");
	}

	public void btnSaveTF() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnSaveTF));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnSaveTF), "click","");
	}

	public void btnSaveSubs() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(btnSaveSubs));
		executeAction(Thread.currentThread().getStackTrace()[1].getMethodName(), driver.findElement(btnSaveSubs),"click","");
	}

}
