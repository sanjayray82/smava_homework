package com.smava.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.smava.base.SmavaTestBase;
import com.smava.pages.LandingPage;
import com.smava.pages.ResultPage;

public class LandingPageTest extends SmavaTestBase {

	@Test(priority=1)
	public void verifyloanSelectionStory() {
		LandingPage landingPage = new LandingPage(driver);
		driver.get(prop.getProperty("url"));
		landingPage.selectAmount("2.750 €");
		landingPage.selectMonths("24 Monate");
		landingPage.selectUse("Wohnen");
		ResultPage resultPage = landingPage.submit();
		// Verify selected value is loaded in Result page
		if (!resultPage.get_selected_LoanAmount_value().equals("2.750 €")) {
			System.out.println("Loan Amount selection is differnet in result page");
			assertEquals("2.750 €", resultPage.get_selected_LoanAmount_value());
		} else {
			System.out.println("Loan Amount selection is correct in result page");
		}

		if (!resultPage.get_selected_LoanTerms_value().equals("24 Monate")) {
			System.out.println("Loan Terms selection is differnet in result page");
			assertEquals("24 Monate", resultPage.get_selected_LoanAmount_value());
		} else {
			System.out.println("Loan Terms selection is correct in result page");
		}
		if (!resultPage.get_selected_LoanUse_value().equals("Wohnen")) {
			System.out.println("Loan Use selection is differnet in result page");
			assertEquals("Wohnen", resultPage.get_selected_LoanUse_value());

		} else {
			System.out.println("Loan Use selection is correct in result page");
		}
	}

	@Test(priority=2)
	public void verifyAnmeldenLogIn() {
		LandingPage landingPage = new LandingPage(driver);
		driver.get(prop.getProperty("url"));
		landingPage.clickAnmelden("sanjay.ray@outlook.com", "smava123");
		ResultPage resultPage = landingPage.clickLogonButton();
		if(resultPage.logon_error_page_title().equals("Sicheres Einloggen mit Zugangsdaten - smava.de"));
		{
			System.out.println("User login is failed");
			Assert.assertEquals(resultPage.logon_error_message(), "Fehler");
		}
		
	}
}