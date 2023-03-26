package utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WindowSwitching {

	private WebDriver driver;
	private WebDriverWait wait;
	private String mainWindowHandle = null;
	private String currentWindowHandle = null;
	private String previousWindowHandle = null;

	public String getMainWindowHandle() {
		return mainWindowHandle;
	}

	public void setMainWindowHandle(String mainWindowHandle) {
		this.mainWindowHandle = mainWindowHandle;
	}

	public String getCurrentWindowHandle() {
		return currentWindowHandle;
	}

	public void setCurrentWindowHandle(String currentWindowHandle) {
		this.currentWindowHandle = currentWindowHandle;
	}

	public String getPreviousWindowHandle() {
		return previousWindowHandle;
	}

	public void setPreviousWindowHandle(String previousWindowHandle) {
		this.previousWindowHandle = previousWindowHandle;
	}

	public WindowSwitching(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	public void changeWindow(String currentWindowHndl, String mainWindowHndl) {

		Set<String> winHandles = new HashSet<String>();
		List<String> winHandlesList = new ArrayList<String>();
		int tripPoint = 0;

		while (true) {
			winHandles.clear();
			winHandles = driver.getWindowHandles();
			winHandlesList = new ArrayList<String>();
			winHandlesList.addAll(winHandles);
			if (winHandlesList.size() >= 2) {
				if (tripPoint == 100) {
					break;
				}
				try {
					if (!driver.getPageSource().isEmpty()) {
						break;
					}
				} catch (Exception e) {
					tripPoint++;
				}
			} else
				tripPoint++;
		}

		winHandles.clear();
		winHandles = driver.getWindowHandles();

		for (String e : winHandles) {
			if (!e.equals(mainWindowHndl) & !e.equals(currentWindowHndl)) {
				driver.switchTo().window(e);
				break;
			}
		}
		this.setMainWindowHandle(mainWindowHndl);
		this.setPreviousWindowHandle(currentWindowHndl);
		this.setCurrentWindowHandle(driver.getWindowHandle());
	}

	public boolean windowCount(int openWindowCount) throws InterruptedException {
		Thread.sleep(5000);
		if (driver.getWindowHandles().size() != openWindowCount) {
			return true;
		}
		return false;

	}

	public void switchWindowBack(String previousWindowHndl, String currentWindowHndl, String mainWindowHndl) {

		Set<String> winHandles = new HashSet<String>();
		List<String> winHandlesList = new ArrayList<String>();

		int tripPoint = 0;

		while (true) {
			winHandles.clear();
			winHandles = driver.getWindowHandles();
			winHandlesList.addAll(winHandles); // System.out.println(tripPoint);
			if (tripPoint == 300) {
				break;
			}
			if (winHandlesList.size() > 2) {
			} else if (winHandlesList.size() <= 2) {
				break;
			}
			tripPoint++;
		}

		driver.switchTo().window(previousWindowHndl);

		this.setMainWindowHandle(mainWindowHndl);
		this.setPreviousWindowHandle(currentWindowHndl);
		this.setCurrentWindowHandle(driver.getWindowHandle());
	}


	public String setHandle(String handle) {
		driver.switchTo().window(handle);
		return driver.getWindowHandle();
	}

	public int handleCount() {
		return driver.getWindowHandles().size();
	}

}
