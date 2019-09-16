package com.test.automation.OM_Automation.uiActions;

import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.OM_Automation.testBase.TestBase;

public class generalRegressionValidations extends TestBase{
	
	public static final Logger log = Logger.getLogger(ValidateOrder.class.getName());
	
	WebDriver driver;
	
    @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[7]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")                                
    WebElement CreatedOrder;
	
    @FindBy(xpath = "//*[@id=\"topButtonRowj_id0_j_id1\"]/input[5]")                                
    WebElement B2BSolutionsbutton;

    @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[14]/div[1]/div/div[2]/table/tbody/tr[2]/td[2]/a")                                
    WebElement notesAttachments;
    
    @FindBy(xpath = "//*[@id=\"ep\"]/div[1]/table/tbody/tr/td[1]/h2")                                
    WebElement notesAttachmentscheck;
    
    @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[6]/div[1]/div/form/div[2]/table/tbody/tr[2]/th/a")                                
    WebElement billingAccount;
    
    @FindBy(name = "deactivate_billing_account")                                
    WebElement billingAccountDeactivateButton;
    
    @FindBy(xpath = "//*[@id=\"opp11_ileinner\"]")
	WebElement stageCustomerApproval;

	@FindBy(xpath = "//*[@id=\"opp12_ileinner\"]")
	WebElement stageCustomerApprovalProbability;
	
	@FindBy(xpath = "//*[@id=\"opp11\"]")
	WebElement customerApprovalDropdownSelection;
	
	@FindBy(xpath = "//*[@id=\"InlineEditDialog_buttons\"]/input[1]")
	WebElement customerApprovalOkButton;
	
	 @FindBy(name = "inlineEditSave")                                
	    WebElement Savebutton;
	 
     @FindBy(xpath = "//*[@id=\"Opportunity_body\"]/table/tbody/tr[2]/th/a")
		WebElement Opportunitybody;
	 
	 @FindBy(xpath = "//*[@id=\"opp1_ileinner\"]/a")
		WebElement Changelink;
	 
	 @FindBy(xpath = "//*[@id=\"newOwn_lkwgt\"]/img")
		WebElement Searchicon;

	 @FindBy(xpath = ".//*[@id='lksrch']")
		WebElement Textbox;
	 
	 @FindBy(xpath = "//*[@id=\"theForm\"]/div/div[2]/input[2]")
		WebElement Gobutton;
	 
	 @FindBy(xpath = "//*[@id=\"User_body\"]/table/tbody/tr[2]/th/a")
		WebElement Userlink;
	 
	 @FindBy(xpath = "//*[@id=\"User_body\"]/table/tbody/tr/th")
		WebElement  PAMUserlink1;
	 
	 @FindBy(xpath = "//*[@id=\"User_body\"]/table/tbody/tr[3]/th/a")
		WebElement  Partner2link; 
	 
	 @FindBy(xpath ="//*[@id='newOwn_mlktp']")
	 WebElement Ownerdropdown;
	 
	 @FindBy(xpath ="//*[@id=\"newOwn_mlktp\"]/option[2]")
	 WebElement Ownerdropdownselection;
	 
	 @FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")                                
	    WebElement PartnerSavebutton;
	 
	 @FindBy(xpath = "//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[11]/td[2]/div/div[2]")                                
	   WebElement ErrorMessege;
	 
	 @FindBy(xpath = ".//*[@id='j_id0:j_id4:j_id6:j_id7:j_id8:0:j_id9:j_id10:j_id13']/h4")                                
	   WebElement BillingErrorMessege;
	 
	 @FindBy(xpath = ".//*[@id='j_id0:j_id4:j_id6:j_id7:j_id8:0:j_id9:j_id10:j_id22']/ul/li[1]")                                
	   WebElement BillingErrorMessege1;
	 
	 @FindBy(xpath = ".//*[@id='j_id0:j_id4:j_id6:j_id7:j_id8:0:j_id9:j_id10:j_id22']/ul/li[2]")                                
	   WebElement BillingErrorMessege2;
	 
	 @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[5]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")                                
	   WebElement  EntitlementFirstLinkText;
	 
	 @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[5]/div[1]/div/div[2]/table/tbody/tr[3]/th/a")                                
	   WebElement  EntitlementSecondLinkText;
	 
	 @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[5]/div[1]/div/div[2]/table/tbody/tr[4]/th/a")                                
	   WebElement  EntitlementThirdLinkText;
	 
	 @FindBy(xpath = "//*[@id='SubscriptionsTabContent']/table/tbody/tr/td[1]/img[1]")                                
	   WebElement  SLAvalidationArrow;
	 
	 @FindBy(xpath = "//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr[2]/td[2]/a")                                
	   WebElement  SLAvalidationLink;
	 
	 @FindBy(xpath= "//*[@id='ep_j_id0_j_id1']/div[2]/div[2]/table/tbody/tr[7]/td[4]")
	 WebElement  SLAvalue;
    
    @FindBy(xpath = "//*[@id=\"ep_j_id0_j_id1\"]/div[2]/div[2]/table/tbody/tr[8]/td[2]") 
    					//*[@id="ep_j_id0_j_id1"]/div[2]/div[2]/table/tbody/tr[8]/td[2]
    WebElement provisioningCode;

    @FindBy(xpath = "//*[@id=\"ep_j_id0_j_id1\"]/div[2]/div[4]/table/tbody/tr[3]/td[4]")                                
    WebElement recurringCharges;

    @FindBy(xpath = "//*[@id=\"ep_j_id0_j_id1\"]/div[2]/div[4]/table/tbody/tr[4]/td[4]")                                
    WebElement TotalOneOffCharges;
    
    @FindBy(xpath = "//*[@id=\"ep_j_id0_j_id1\"]/div[2]/div[6]/table/tbody/tr[2]/td[2]")                                
    WebElement ContractTerm;
        
    @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/a")                                
    WebElement Opprtunities;

    @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[19]/td[2]/div")                                
    WebElement TotalContractValue;
    
    String suborderLinkOpeningTag="html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[6]/div[1]/div/div[2]/table/tbody/tr[";
	String suborderLinkClosingTag="]/th/a";
	public static String[] stringArray = {"Awareness of interest","Follow-Up","Demand Analysis","Offer Phase","Decision Phase","Ready for Order","Pre-Installation-Cancellation","Closed Lost"}; 
	public static String[] stringArrayPercentage = {"10%","30","40","60","90","100","0","0"};
	
	public generalRegressionValidations(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void regressionValidationDesctionHandler(String desctionHandler,Map<String, String> dataSets,String TestName) throws Exception {
		if (desctionHandler.equals("InstallationActivationFieldValidations")) {
			NeedsInstallationNeedsActivationfield();
		}
		else if (desctionHandler.equals("StagePercentageValidationPartnerPortal")) {
			stageValidationPartnerPortal(TestName);
		}
		else if (desctionHandler.equals("B2BsolutionsButtonValidation")) {
			SendemailtoB2BSolutions();
		}
		else if (desctionHandler.equals("emailConfirmation")) {
			emailConfirmation();
		}	
		else if (desctionHandler.equals("DeactivationReqested")) {
			DeactivationReqested();
		}
		else if (desctionHandler.equals("ProvisioningAccountValidation")) {
			ProvisioningAccountValidation(dataSets);
		}
		else if (desctionHandler.equals("TCVCalculations")) {
			TCVCalculations(dataSets);
		}
		else if (desctionHandler.equals("opportunityOwnerChangePAM1")) {
			opportunityOwnerChange();
		}
		else if (desctionHandler.equals("opportunityOwnerChangePAM2")) {
			opportunityanotherOwnerChange();
	    }
		else if (desctionHandler.equals("PAM_Assigns_leadtoPartner")) {
			PAMLeadAssigned();
		}
		else if (desctionHandler.equals("ErrorMgsValidation")) {
			 ErrormgsValidation(); 
		}
		else if (desctionHandler.equals("EntitlementRecordValidation")) {
			EntitlementValidation(); 
		}	
		else if (desctionHandler.equals("BillingAccErrorMgsValidation")) {
			ErrormgsValidationforBilling(); 
		}	
		else if (desctionHandler.equals("SLAValidationforProducts")) {
			SLAValidationforProducts(); 
		}
	}

	public void stageValidationPartnerPortal(String TestName) throws Exception {
		for (int i=0;i<=7;i++)
		{
			doubleclick(driver,stageCustomerApproval);
			Thread.sleep(1000);
			waitForclickable(driver, customerApprovalDropdownSelection, 200);
			dropdownselectionbyvalue(driver,customerApprovalDropdownSelection,stringArray[i]);
			waitForclickable(driver, customerApprovalOkButton, 200);
	        customerApprovalOkButton.click();
	        Thread.sleep(2000);
	        //Savebutton.click();
	        log("customer Approval Dropdown selected as "+stringArray[i]);
	        Thread.sleep(2000);
	        waitForclickable(driver, stageCustomerApprovalProbability, 20);
	        String temp=stageCustomerApprovalProbability.getText();
	        Assert.assertEquals(stringArrayPercentage[i], temp);
	        log("customer Approval stage is  "+stringArray[i] + " and the value is " + temp);
	        pocUpdates(TestName, "Regression Validations is successful", "Passed", "Successfully Regression Validations completed", driver);
	        
		}
	}
	public void  ErrormgsValidation() throws Exception{
		waitForElement(driver, 200, ErrorMessege);
		String temp=ErrorMessege.getText();
		System.out.println("The Error Mgs "+ temp);
		Thread.sleep(5000);
		Assert.assertEquals(temp, "Error: You must enter a value");
		Thread.sleep(2000);
		
	}
	public void TCVCalculations(Map<String, String> dataSets) {
		driver.close();
		BrowserMainTabSwitchBack(driver);		
		WebElement tempDecisionMaker=driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[8]/div[1]/div/div[2]/table/tbody/tr["+ 2 +"]/th/a"));
		scrollTo(driver, tempDecisionMaker);
		openlinkinnewtab(driver, tempDecisionMaker);
		log("Services Page Opened");
		BrowserTabSwitch(driver);
		scrollTo(driver, recurringCharges);
		waitForElement(driver, 20, recurringCharges);
		String recurringCharges=this.recurringCharges.getText();
		recurringCharges=recurringCharges.replace(",", ".");
		recurringCharges = recurringCharges.substring(1, recurringCharges.length() - 2);
		log("recurring Charges is "+recurringCharges);
		scrollTo(driver, TotalOneOffCharges);
		waitForElement(driver, 20, TotalOneOffCharges);
		String TotalOneOffCharges=this.TotalOneOffCharges.getText();
		TotalOneOffCharges=TotalOneOffCharges.replace(",", ".");
		TotalOneOffCharges = TotalOneOffCharges.substring(1, TotalOneOffCharges.length() - 2);
		log("Total One Off Charges is "+TotalOneOffCharges);
		scrollTo(driver, ContractTerm);
		waitForElement(driver, 20, ContractTerm);
		String ContractTerm=this.ContractTerm.getText();
		log("ContractTerm is "+ContractTerm);
		driver.close();
		BrowserMainTabSwitchBack(driver);
		scrollTo(driver, Opprtunities);
		openlinkinnewtab(driver, Opprtunities);
		BrowserTabSwitch(driver);
		scrollTo(driver, TotalContractValue);
		waitForElement(driver, 20, TotalContractValue);
		String TotalContractValue=this.TotalContractValue.getText();
		TotalContractValue=TotalContractValue.replace(",", ".");
		TotalContractValue = TotalContractValue.substring(1, TotalContractValue.length() - 2);
		log("TotalContractValue is "+TotalContractValue);	
		double recurringCharge = Double.parseDouble(recurringCharges);
		log("recurring Charges is "+recurringCharges);
		double TotalOneOffCharge = Double.parseDouble(TotalOneOffCharges);
		log("Total One Off Charges is "+TotalOneOffCharges);
		double TotalContractVal = Double.parseDouble(TotalContractValue);
		log("TotalContractValue is "+TotalContractValue);	
		double ContractTm = Double.parseDouble(ContractTerm);
		log("ContractTerm is "+ContractTerm);
		double Temp=ContractTm * recurringCharge;
		log("ContractTm  * recurringCharge is  "+Temp);
		double TempFinal=Temp+TotalOneOffCharge;
		log("ContractTm  * recurringCharge +  TotalOneOffCharge is "+TempFinal);
		Assert.assertEquals(TempFinal, TotalContractValue);
	}
	
	public void ProvisioningAccountValidation(Map<String, String> dataSets) {
		//WebElement tempDecisionMaker = null;
		String AddtionalValidations=(String) dataSets.get("AddtionalValidations");
		driver.close();
		BrowserMainTabSwitchBack(driver);
		WebElement tempDecisionMaker=driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[8]/div[1]/div/div[2]/table/tbody/tr["+ 2 +"]/th/a"));
		scrollTo(driver, tempDecisionMaker);
		openlinkinnewtab(driver, tempDecisionMaker);
		log("Services Page Opened");
		BrowserTabSwitch(driver);
		String Temp=provisioningCode.getText();
		log("provisioning Code is "+Temp);
		Assert.assertEquals(AddtionalValidations, Temp);
	}
	public void DeactivationReqested() {
		waitForclickable(driver, billingAccount, 200);
		scrollTo(driver, billingAccount);
		billingAccount.click();
	}
	
	public void emailConfirmation() throws Exception {
		Thread.sleep(10000);
		PageRefresh(driver);
		try {
			waitForclickable(driver, notesAttachments, 60);	
		}
		catch(Exception e) {
			PageRefresh(driver);
			try {
				waitForclickable(driver, notesAttachments, 60);	
			}
			catch(Exception x) {
				PageRefresh(driver);
			}
		}
		waitForclickable(driver, notesAttachments, 200);
		scrollTo(driver, notesAttachments);
		notesAttachments.click();
		waitForElement(driver, 20, notesAttachmentscheck);
		String temp=notesAttachmentscheck.getText();
		Assert.assertEquals("Attachment Detail", temp);
		log("Order confirmation email is send");
	}
	
	public void NeedsInstallationNeedsActivationfield() throws Exception {
		WebElement tempSuborder = null;
		waitForclickable(driver, CreatedOrder, 200);
		scrollTo(driver, CreatedOrder);
		Thread.sleep(2000);
		CreatedOrder.click();
		log("Sub order page opened");
		tempSuborder = driver.findElement(
				By.xpath(suborderLinkOpeningTag
						+ 2 + suborderLinkClosingTag));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tempSuborder);
		openlinkinnewtab(driver, tempSuborder);
		Thread.sleep(2000);
		BrowserTabSwitch(driver);
		System.out.println("fghsfdhgb");
		WebElement btn = driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[3]/td[4]/div"));
		String imgColor = btn.findElement(By.tagName("img")).getAttribute("alt");
		Assert.assertEquals("Checked", imgColor);
		log("Installation Needed is "+imgColor);
		WebElement btn2 = driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[3]/td[4]/div"));
		String imgColor2 = btn2.findElement(By.tagName("img")).getAttribute("alt");
		Assert.assertEquals("Checked", imgColor2);
		log("Activation Needed is "+imgColor2);
	}
	public void SendemailtoB2BSolutions() throws Exception {
		WebElement tempServices = null;
		waitForclickable(driver, CreatedOrder, 200);
		scrollTo(driver, CreatedOrder);
		Thread.sleep(2000);
		CreatedOrder.click();
		log("Sub order page opened");
		tempServices=driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[8]/div[1]/div/div[2]/table/tbody/tr["+ 2 +"]/th/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tempServices);
		openlinkinnewtab(driver, tempServices);
		Thread.sleep(2000);
		BrowserTabSwitch(driver);
		Thread.sleep(2000);
		//String temp=B2BSolutionsbutton.getText();
		String temp=B2BSolutionsbutton.getAttribute("title");
		//log("name of the button expected is  "+temp);
		log("name of the button expected is  "+temp);
		Assert.assertEquals("Send email to B2BSolutions", temp);
		log("name of the button expected is  "+temp);
	}

	public void opportunityOwnerChange() throws Exception{
		BrowserMainTabSwitchBack(driver);
		driver.close();
        BrowserMainTabSwitchBack(driver);
		waitForElement(driver, 200, Changelink);
		Changelink.click();
		log("Change link is clicked");
		Thread.sleep(2000);
		waitForElement(driver, 200, Searchicon);
		Searchicon.click();
		log("Search icon is clicked");
		Thread.sleep(10000);
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> win1 = set1.iterator();
		String parent = win1.next();
		String child = win1.next();
		driver.switchTo().window(child);
		System.out.println("window switched");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		System.out.println("SearchFrame switched");
		Thread.sleep(5000);
		waitForElement(driver, 200, Textbox);
		Textbox.sendKeys("Sathish PAM");
		log("Sathish PAM is passed");
		Thread.sleep(2000);
		Gobutton.click();
		log("Gobutton  is clicked");
		Thread.sleep(3000);
		//driver.switchTo().frame(0);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("resultsFrame");
		System.out.println("resultsFrame switched");
		waitForElement(driver, 200, Userlink);
		Userlink.click();
		log("Userlink  is clicked");
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		System.out.println("parent window switched");
		Thread.sleep(2000);
	}
	public void opportunityanotherOwnerChange() throws Exception{
		BrowserMainTabSwitchBack(driver);
		driver.close();
        BrowserMainTabSwitchBack(driver);
        waitForElement(driver, 200, Changelink);
		Changelink.click();
		log("Change link is clicked");
		Thread.sleep(2000);
		waitForElement(driver, 200, Searchicon);
		Searchicon.click();
		log("Search icon is clicked");
		Thread.sleep(10000);
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> win1 = set1.iterator();
		String parent = win1.next();
		String child = win1.next();
		driver.switchTo().window(child);
		System.out.println("window switched");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		System.out.println("SearchFrame switched");
		Thread.sleep(5000);
		waitForElement(driver, 200, Textbox);
		Textbox.sendKeys("haritha pam");
		log("haritha pam is passed");
		Thread.sleep(2000);
		Gobutton.click();
		log("Gobutton  is clicked");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	    driver.switchTo().frame("resultsFrame");
	    System.out.println("resultsFrame switched");
		waitForElement(driver, 200, PAMUserlink1);
		PAMUserlink1.click();
		log("Userlink1  is clicked");
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		System.out.println("parent window switched");
		Thread.sleep(2000);
	}
	public void  PAMLeadAssigned() throws Exception{
		//BrowserMainTabSwitchBack(driver);
		//driver.close();
        //BrowserMainTabSwitchBack(driver);
		BrowserTabSwitch(driver);
		driver.close();
		BrowserMainTabSwitchBack(driver);
		waitForElement(driver, 200, Opportunitybody);
		Opportunitybody.click();
		log("Opportunitybody link is clicked");
		Thread.sleep(2000);
		waitForElement(driver, 200, Changelink);
		Changelink.click();
		log("Change link is clicked");
		Thread.sleep(2000);
		waitForclickable(driver, Ownerdropdown, 200);
		dropdownselectionbyvalue(driver,Ownerdropdown,"005");
		waitForclickable(driver, Ownerdropdownselection, 200);
		Ownerdropdownselection.click();
		Thread.sleep(1000);
		waitForElement(driver, 200, Searchicon);
		Searchicon.click();
		log("Search icon is clicked");
		Thread.sleep(10000);
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> win1 = set1.iterator();
		String parent = win1.next();
		String child = win1.next();
		driver.switchTo().window(child);
		System.out.println("window switched");
		Thread.sleep(2000);
		//driver.switchTo().frame(0);
		//System.out.println("SearchFrame switched");
		//Thread.sleep(5000);
		//driver.switchTo().defaultContent();
		//Thread.sleep(3000);
		driver.switchTo().frame("resultsFrame");
		Thread.sleep(3000);
		System.out.println("resultsFrame switched");
		waitForElement(driver, 200, Partner2link);
		Partner2link.click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		System.out.println("parent window switched");
		Thread.sleep(2000);
		waitForElement(driver, 200, PartnerSavebutton);
		PartnerSavebutton.click();
		Thread.sleep(5000);
	}	
	public void  EntitlementValidation() throws Exception{
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		waitForElement(driver, 200,  EntitlementFirstLinkText);
		String temp= EntitlementFirstLinkText.getText();
		System.out.println("The  EntitlementFirst Link SLA Text  "+ temp);
		Thread.sleep(2000);
		waitForElement(driver, 200,  EntitlementSecondLinkText);
		String temp1= EntitlementSecondLinkText.getText();
		System.out.println("The  EntitlementSecond Link Text  "+ temp1);
		Thread.sleep(2000);
		waitForElement(driver, 200,  EntitlementThirdLinkText);
		String temp2= EntitlementThirdLinkText.getText();
		System.out.println("The  EntitlementThird Link Text  "+ temp2);
		Thread.sleep(2000);
	}
	public void  ErrormgsValidationforBilling() throws Exception{
		waitForElement(driver, 200, BillingErrorMessege);
		String temp=BillingErrorMessege.getText();
		System.out.println("The Error Mgs : "+ temp);
		Thread.sleep(3000);
		Assert.assertEquals(temp,"Errors");
		Thread.sleep(2000);
		waitForElement(driver, 200, BillingErrorMessege1);
		String temp1=BillingErrorMessege1.getText();
		System.out.println("The Error Mgs1 : "+ temp1);
		Thread.sleep(3000);
		Assert.assertEquals(temp1,"Billing Account has not been assigned to the Line Items");
		Thread.sleep(2000);
		waitForElement(driver, 200, BillingErrorMessege2);
		String temp2=BillingErrorMessege2.getText();
		System.out.println("The Error Mgs2 : "+ temp2);
		Thread.sleep(3000);
		Assert.assertEquals(temp2,"Please add a billing account record");
		Thread.sleep(2000);
		
	}
	
public void  SLAValidationforProducts() throws Exception{
    driver.close();
    BrowserMainTabSwitchBack(driver);        
    WebElement tempDecisionMaker=driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[8]/div[1]/div/div[2]/table/tbody/tr["+ 2 +"]/th/a"));
    scrollTo(driver, tempDecisionMaker);
    openlinkinnewtab(driver, tempDecisionMaker);
    log("Services Page Opened");
    BrowserTabSwitch(driver);
	
//	waitForElement(driver, 200, SLAvalidationArrow);
//	SLAvalidationArrow.click();
//	log("Arrow is clicked");
//	Thread.sleep(2000);
//	waitForElement(driver, 200, SLAvalidationLink);
//	SLAvalidationLink.click();
//	log("Link is clicked");
//	Thread.sleep(3000);
//	driver.switchTo().defaultContent();
//	Thread.sleep(2000);
	waitForElement(driver, 200, SLAvalue);
	String temp=SLAvalue.getText();
	Assert.assertEquals(temp,"Bronze");
	System.out.println("The SLA value  : "+ temp);
	Thread.sleep(3000);
	
}
}
