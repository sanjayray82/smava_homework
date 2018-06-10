package com.smava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.smava.base.PageObject;

public class ResultPage extends PageObject {
	
	// Page factory-- Object Repository
	@FindBy(xpath = "//select[@id='applicant0.loan.selection.category']")
	private WebElement use;
	
	@FindBy(xpath = "//select[@id='applicant0.loan.selection.amount']")
	private WebElement loanAmount;
	
	@FindBy(xpath = "//select[@id='applicant0.loan.selection.duration']")
	private WebElement loanTerm;
	
	@FindBy(xpath = "//div[@class='inner']/h5")
	private WebElement errorMessage;
	
	
	public ResultPage(WebDriver driver) {
		super(driver);
		
	}

	public String get_selected_LoanUse_value(){
        
		Select lnUse= new Select(use);  
		lnUse.selectByVisibleText("Wohnen");
		String selectedLoanUse = lnUse.getFirstSelectedOption().getText();
		return selectedLoanUse; 
		
	}
	public String get_selected_LoanAmount_value(){
		Select lnamnt= new Select(loanAmount); 
		lnamnt.selectByVisibleText("2.750 €");
		String selectedLoanAmount = lnamnt.getFirstSelectedOption().getText();
		return selectedLoanAmount; 
				       
	}
	public String get_selected_LoanTerms_value(){
		Select lnTerm= new Select(loanTerm);  
		lnTerm.selectByVisibleText("24 Monate");
		String selectedLoanTerm = lnTerm.getFirstSelectedOption().getText();
		return selectedLoanTerm; 
		
	}

	public String logon_error_page_title(){
		String title= driver.getTitle();
		return title; 
		
	}
	public String logon_error_message(){
		String errorMsg=this.errorMessage.getText();
		
		return errorMsg; 
		
	}
}
