package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	private WebDriver driver;

	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}

	public void capture(String filename) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File("screenshot\\"+filename+".png");

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
