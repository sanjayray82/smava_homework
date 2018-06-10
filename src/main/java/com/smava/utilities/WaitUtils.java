package com.smava.utilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

@SuppressWarnings("unused")
public class WaitUtils {
	public WebDriverWait wait;
	static int waitTime;

	/**
	 * Wait for element to load
	 * 
	 * @param cssUse
	 * @return
	 */
	public  WebElement waitForElementToBeVisible(WebElement cssUse) {

		return wait.until(ExpectedConditions.visibilityOf((WebElement) cssUse));
	}

	/**
	 * Hard Wait
	 * 
	 * @param waitInSeconds
	 */
	public  void hardWait(int timeToWaitInSeconds) {
		try {
			Thread.sleep(timeToWaitInSeconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  void waitToHandleStaleElementRefrenceException(WebElement locatorName, int timeToWaitInSeconds) {
		int count = 0;
		System.out.println("locator"+locatorName + "Time is "+timeToWaitInSeconds);
		while (wait.until(ExpectedConditions.stalenessOf(locatorName))) {
			hardWait(1);
			count++;
			if (count > waitTime) {
				break;
			}
		}
	}
}
