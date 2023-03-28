package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Workday {
	private WebDriver driver;

	public Workday(WebDriver driver) {
		this.driver = driver;
	}

	// web elements
	final String URL = "https://www.myworkday.com/northeastern/d/inst/13102!CK5mGhIKBggDEMenAhIICgYI1A0Q5wE~*AmKOdsyb7NU~/cacheable-task/23748$4.htmld#backheader=true&TABINDEX=1";
	By login = By.xpath("//*[@id=\"bySelection\"]/div[2]/div/span");
	//By btnSkip = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div/div[2]/a");
	By btnSkip = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div/div[2]/a");
	By btnOfcStuEmp = By.xpath("/html/body/div[2]/div/div[2]/div[1]/section/div/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[4]/div[1]/div/div/div[2]/div/div[3]/ul/li/div/div/div");
	By btnStudent = By.xpath("/html/body/div[3]/div[6]/form/span/div/div/div[4]/div[1]/a");
	By btnMyJobMail = By.xpath("/html/body/div[3]/div[6]/form/span/div/div[2]/div[3]/div/ul/li[2]/strong/a");
	By btnAddEmp = By.xpath("/html/body/div[3]/div[6]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[5]/button");
	By btnEmpName = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[1]");
	By btnAdd = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/a");
	By btnSave = By.xpath("/html/body/div[2]/div/div/div/div[4]/button");
	By btnClose = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/button");
	By btnAddCat = By.xpath("/html/body/div[3]/div[6]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td[5]/button");
	By btnCatName = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[1]");
	By btnAddCat1 = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/a");
	By btnSaveCat = By.xpath("/html/body/div[2]/div/div/div/div[4]/button");
	By btnCloseCat = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/button");
	By btnAddTF = By.xpath("/html/body/div[3]/div[6]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/button");
	By btnTFName = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[3]/div[1]");
	By btnAddTF1 = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/a");
	By btnSaveTF = By.xpath("/html/body/div[2]/div/div/div/div[4]/button");
	By btnCloseTF = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/button");
	
	By btnSaveSubs = By.xpath("/html/body/div[3]/div[6]/form/div[5]/input");
	
	// web element actions
	public void hitURL() {
		this.driver.get(URL);
	}

	public void clickOnLogin() {
		hitURL();
	}
	
	public void btnSkip() {
		driver.findElement(btnSkip).click();
	}
	
	public void btnOfcStuEmp() {
		driver.findElement(btnOfcStuEmp).click();
	}
		
	public void btnStudent(){
			driver.findElement(btnStudent).click();
			
		}
	
	public void btnMyJobMail() {
		driver.findElement(btnMyJobMail).click();
	}
	
	public void btnAddEmp() {
		driver.findElement(btnAddEmp).click();
	}
	
	public void btnEmpName() {
		driver.findElement(btnEmpName).click();
	}
	
	public void btnAdd() {
		driver.findElement(btnAdd).click();
	}
	
	public void btnSave() {
		driver.findElement(btnSave).click();
	}
	
	public void btnClose() {
		driver.findElement(btnClose).click();
	}
	
	public void btnAddCat() {
		driver.findElement(btnAddCat).click();
	}
	
	public void btnCatName() {
		driver.findElement(btnCatName).click();
	}
	
	public void btnAddCat1() {
		driver.findElement(btnAddCat1).click();
	}
	
	public void btnSaveCat() {
		driver.findElement(btnSaveCat).click();
	}
	
	public void btnCloseCat() {
		driver.findElement(btnCloseCat).click();
	}
	
	public void btnAddTF() {
		driver.findElement(btnAddTF).click();
	}
	
	public void btnTFName() {
		driver.findElement(btnTFName).click();
	}
	
	public void btnAddTF1() {
		driver.findElement(btnAddTF1).click();
	}
	
	public void btnSaveTF() {
		driver.findElement(btnSaveTF).click();
	}
	
	public void btnCloseTF() {
		driver.findElement(btnCloseTF).click();
	}
	
	public void btnSaveSubs() {
		driver.findElement(btnSaveSubs).click();
	}
	
}
