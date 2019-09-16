package com.test.automation.OM_Automation.uiActions;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class OpportunityConversion extends TestBase
{
	public static final Logger log = Logger.getLogger(OpportunityConversion.class.getName());	
	
	WebDriver driver;
	
	@FindBy(name = "convert")
	WebElement Convertbutton;
	
	@FindBy(name = "save")
	WebElement Convertlead;

	//@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[7]/div[1]/div/form/div[2]/table/tbody/tr[2]/th/a")
	//@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[8]/div[1]/div/form/div[2]/table/tbody/tr[2]/th/a")
	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[9]/div[1]/div/form/div[2]/table/tbody/tr[2]/th/a")
	//@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[9]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	//@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[9]/div[1]/div/form/div[2]/table/tbody/tr[2]/th/a")
	////*[@id="0014E00000hAKEJ_RelatedOpportunityList_body"]/table/tbody/tr[2]/th/a
	WebElement CreatedOpportunity;
	
	
	@FindBy(xpath = "//*[@id=\"Account_body\"]/table/tbody/tr[2]/th/a")
	WebElement accountName;	
	
	@FindBy(name = "lg_createnewopportunity")
	WebElement NewOpprtunityButton;	

	@FindBy(xpath = "//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div/span/span/a")
	WebElement CloseDate;	
	
	@FindBy(name = "opp11")
	WebElement OpportunityStage;	

	@FindBy(xpath =".//*[@id='CF00N5800000BQyo8_lkwgt']/img")
	WebElement partneraccountlookup;
	
	@FindBy(xpath = ".//*[@id='Account_body']/table/tbody/tr[2]/th/a")
	WebElement PartnerAccount;
	
	@FindBy(xpath = ".//*[@id='bottomButtonRow']/input[@title='Save']")
	WebElement leadsave;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[7]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	WebElement CreatedOpportunity_Partner;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[7]/div[1]/div/form/div[2]/table/tbody/tr[2]/th/a ")
	WebElement CreatedOpportunity_Director;
	
	public OpportunityConversion(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void opportunityconversion() throws Exception {
			waitForElement(driver, 200, Convertbutton);
			Convertbutton.click();
			log("clicked convert button in leads page");
			waitForElement(driver, 200, Convertlead);
			Convertlead.click();
			log("clicked convert button in convert lead page");
			Thread.sleep(3000);
			waitForclickable(driver, CreatedOpportunity, 200);
			scrollTo(driver, CreatedOpportunity);
			Thread.sleep(2000);
			CreatedOpportunity.click();
			log("clicked on opportunity created in accounts page");
	}
	
	public void existingAccountOpportunityCreation() throws Exception {
		waitForElement(driver, 200, accountName);
		accountName.click();
		log("Account Name Selected");
		waitForclickable(driver, NewOpprtunityButton, 200);
		scrollTo(driver, NewOpprtunityButton);
		NewOpprtunityButton.click();
		log("NewOpprtunityButton clicked");	
		waitForclickable(driver, CloseDate, 200);
		scrollTo(driver, CloseDate);
		CloseDate.click();
		log("CloseDate button clicked");	
		scrollTo(driver, OpportunityStage);
		waitForElement(driver, 100, OpportunityStage);
		dropdownselection(driver, OpportunityStage, "Awareness of interest");
		log("OpportunityStage selected as Awareness of interest");
		partneraccountselection();
		Thread.sleep(2000);
		scrollTo(driver, leadsave);
		waitForElement(driver, 200, leadsave);
		leadsave.click();
	}
	public void partneraccountselection() throws Exception{
		waitForElement(driver, 200, partneraccountlookup);
		partneraccountlookup.click();// partner accaountlookup lookup select
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> win1 = set1.iterator();
		String parent = win1.next();
		String child = win1.next();
		driver.switchTo().window(child);
		System.out.println("window switched");
		Thread.sleep(2000);
		driver.switchTo().frame("resultsFrame");
		System.out.println("resultsFrame switched");
		waitForElement(driver, 200, PartnerAccount);
		PartnerAccount.click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		System.out.println("parent window switched");
		Thread.sleep(2000);
	}
	public void opportunityconversion(Map<String, String> dataSets) throws Exception {
		String OverallType=(String) dataSets.get("OverallType");
			waitForElement(driver, 200, Convertbutton);
			Convertbutton.click();
			log("clicked convert button in leads page");
			waitForElement(driver, 200, Convertlead);
			Convertlead.click();
			log("clicked convert button in convert lead page");
			Thread.sleep(3000);
			if(OverallType.equals("PartnerAccount")) {
				waitForElement(driver,200,CreatedOpportunity_Partner);
				scrollTo(driver, CreatedOpportunity_Partner);
				Thread.sleep(2000);
				CreatedOpportunity_Partner.click();
				log("clicked on opportunity created partner in accounts page");
			}
			else if(OverallType.equals("DirectorAccount")) {
				waitForElement(driver,200,CreatedOpportunity_Director);
				scrollTo(driver, CreatedOpportunity_Director);
				Thread.sleep(2000);
				CreatedOpportunity_Director.click();
				log("clicked on opportunity created director in accounts page");
			}
			else {
				waitForclickable(driver, CreatedOpportunity, 200);
			scrollTo(driver, CreatedOpportunity);
			Thread.sleep(2000);
			CreatedOpportunity.click();
			log("clicked on opportunity created in accounts page");
			}


}
}



