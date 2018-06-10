package com.smava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.smava.base.PageObject;


public class LandingPage extends PageObject {

	// Page factory-- Object Repository
	@FindBy(xpath = "//div[@id='myselect']/div/input")
	private WebElement loan_amount;

	@FindBy(xpath = "//div[@id='myselect2']/div/input")
	private WebElement loan_term;

	@FindBy(css = "#myselect2")
	private WebElement cssMonth;

	@FindBy(xpath = "//div[@id='myselect3']")
	private WebElement use_field;

	@FindBy(xpath = "//a[@class='item login-popup uppercase']")
	private WebElement my_account;

	@FindBy(xpath = "//input[@id='signonForm.email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='signonForm.password']")
	private WebElement password;

	@FindBy(xpath = "//a[@id='forwardButtonkredit2day']/button")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@id='cta-label']")
	private WebElement logonButton;
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public void selectAmount(String amount) {
		this.loan_amount.click();
		driver.findElement(By.xpath("//div[text()='" + amount + "']")).click();

	}

	public void selectMonths(String month) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// waitForElement.waitForElementToBeVisible(cssMonth);
		this.cssMonth.click();
		driver.findElement(By.xpath("//div[text()='" + month + "']")).click();

	}

	public void selectUse(String use) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// WaitUtils.waitForElementToBeVisible(use_field);
		this.use_field.click();
		driver.findElement(By.xpath("//div[text()='" + use + "' and @data-value='886']")).click();
	}

	public ResultPage submit() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// WaitUtils.waitForElementToBeVisible(continueButton);
		continueButton.click();
		return new ResultPage(driver);
	}
	
	public void clickAnmelden(String email, String password) {
		this.my_account.click();
		this.email.clear();
		this.email.sendKeys(email);
		this.password.clear();
		this.password.sendKeys(password);
		//this.logonButton.click();
		
		}
	
	public ResultPage clickLogonButton() {
		this.logonButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResultPage(driver);
	}
}
