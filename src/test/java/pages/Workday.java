package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Workday {
	private WebDriver driver;

	public Workday(WebDriver driver) {
		this.driver = driver;
	}

	// web elements
	final String URL = "https://www.myworkday.com/northeastern/d/inst/13102!CK5mGhIKBggDEMenAhIICgYI1A0Q5wE~*AmKOdsyb7NU~/cacheable-task/23748$4.htmld#backheader=true&TABINDEX=1";
	By login = By.xpath("//*[@id=\"bySelection\"]/div[2]/div/span");
	By btnSkip = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div/div[2]/a");
	By btnOfcStuEmp = By.xpath("/html/body/div[2]/div/div[2]/div[1]/section/div/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[4]/div[1]/div/div/div[2]/div/div[3]/ul/li/div/div/div");
	By btnStudent = By.xpath("/html/body/div[3]/div[6]/form/span/div/div/div[4]/div[1]/a");
	By btnMyJobMail = By.xpath("/html/body/div[3]/div[6]/form/span/div/div[2]/div[3]/div/ul/li[2]/strong/a");
	By btnLogin = By.xpath("/html/body/div[3]/div[6]/form/table[1]/tbody/tr[4]/td[2]/input");

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
   
	{
	        System.out.println( "Before Student Login" );
	}
	
	public void btnStudent() {
		driver.findElement(btnStudent).click();
	}
	
	public void main( String[] args )
	   {
		        System.out.println( "After student login" );
	    } 
	
	public void btnMyJobMail() {
		driver.findElement(btnMyJobMail).click();
	}
	
	public void btnLogin() {
		driver.findElement(btnLogin).click();
	}
	
	
	
}
