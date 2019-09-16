package com.test.automation.OM_Automation.uiActions;

import javax.swing.Scrollable;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class AssignBillingAccount extends TestBase{
	
	
public static final Logger log = Logger.getLogger(AssignBillingAccount.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='ng-binding ng-isolate-scope icon IconAssignBillingAccount']")
	WebElement AssignBillingAccountButton;
	
	@FindBy(xpath = ".//*[@id='mainSelectList']/option[2]")
	WebElement AccountSelection;
	
	@FindBy(xpath = ".//*[@id='headerCheckBox']")
	WebElement AllSelectCheckbox;
	
	@FindBy(xpath = ".//*[@id='btnSetBillAccounts']")
	WebElement SetAccount;
	
	@FindBy(xpath = "//button[@onclick='save()']")
	WebElement SaveBillingAccount; 
	
	public AssignBillingAccount(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void BillingAccoutnAssignment() {
		
		try {
			waitForElement(driver, 200, AssignBillingAccountButton);
			scrollTo(driver, AssignBillingAccountButton);
			AssignBillingAccountButton.click();
			log("Assign Billing Account button clicked");
			waitForclickable(driver, AccountSelection, 200);
			AccountSelection.click();
			log("Account selected successfully");
			waitForElement(driver, 200, AllSelectCheckbox);
			AllSelectCheckbox.click();
			log("All account successfully checked in to set billing account");
			waitForElement(driver, 200, SetAccount);
			SetAccount.click();
			log("Account to be set successfully");
			waitForElement(driver, 200, SaveBillingAccount);
			scrollTo(driver, SaveBillingAccount);
			SaveBillingAccount.click();
			log("Billing Account Successfully saved");
			Thread.sleep(5000);
		} catch (Exception e) {
			log("Billing account creation failed due to "+e+"");
		}
		
		
	}

}
