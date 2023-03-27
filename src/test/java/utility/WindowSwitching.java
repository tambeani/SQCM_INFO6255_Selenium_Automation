package utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WindowSwitching {

	private WebDriver driver;
	
	public WindowSwitching(WebDriver driver) {
		this.driver = driver;
	}

	public void changeWindow() {
		String currentWindowHandle = driver.getWindowHandle();
		String otherWindowHandle = null;
		for(String windowHandle:driver.getWindowHandles()) {
			if(!windowHandle.equals(currentWindowHandle)) {
				otherWindowHandle = windowHandle;
				break;
			}
		}
		
		driver.switchTo().window(otherWindowHandle);
	}

}
