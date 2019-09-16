package com.test.automation.OM_Automation.uiActions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.OM_Automation.testBase.TestBase;

public class ValidateOrder extends TestBase {
	
	public static final Logger log = Logger.getLogger(ValidateOrder.class.getName());
	
	WebDriver driver;
	

	@FindBy(xpath = "//div[@class='pbHeader']//input[@value='Validate Order']")
	WebElement ValidateOrderButton;
	
	@FindBy(xpath = "//input[@id='j_id0:j_id4:j_id35:fileToUpload5']")
	WebElement BrowseFiles;

	//@FindBy(xpath = "//input[@id='j_id0:j_id4:j_id35:j_id155']")
	//WebElement BrowseFiles;
	
	//@FindBy(xpath = "//input[@name='j_id0:j_id4:j_id35:j_id151']")
	//WebElement SignedContractUploadFile;

	@FindBy(xpath = "//input[@name='j_id0:j_id4:j_id35:j_id156']")
	WebElement SignedContractUploadFile;
		
	//@FindBy(xpath = ".//*[@id='j_id0:j_id4:j_id35:doc5']")
	//WebElement SignedContractCheckbox;
	
	@FindBy(xpath = ".//*[@id='j_id0:j_id4:j_id35:doc5']")
	WebElement SignedContractCheckbox;
	
	@FindBy(xpath = "//input[@value='Submit Order']")
	WebElement SubmitOrderbutton;
	
	@FindBy(xpath = "//*[@id=\"opp11_ileinner\"]")
	WebElement stageCustomerApproval;
	
	@FindBy(xpath = "//*[@id=\"opp11\"]")
	WebElement customerApprovalDropdownSelection;
	
	@FindBy(xpath = "//*[@id=\"InlineEditDialog_buttons\"]/input[1]")
	WebElement customerApprovalOkButton;
	
	@FindBy(xpath = "//*[@id=\"topButtonRow\"]/input[1]")
	WebElement customerApprovalSaveButton;
	
	@FindBy(xpath = "//*[@id=\"opp5_ilecell\"]")
	WebElement customerTypeDoubleClickSelection;
	
	@FindBy(xpath = "//*[@id=\"opp5\"]")
	WebElement customerTypeDropdownSelection;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/form/div[2]/div/div/div/div[1]/div/div/div/div/a[2]")
	WebElement OpportunityButton;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/form/div[2]/div/div/div/div[1]/div/div/div/div/a[1]")
	WebElement AccountButton;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[10]/div[1]/div/div[1]/table/tbody/tr/td[2]/input")
	WebElement ContactRolesNewButton;
	
	//@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[3]/td[1]/input")
	//@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[6]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr[3]/td[1]/input")
	WebElement RadioButton;
	
	@FindBy(name ="role0")
	WebElement SelectionDropDown;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]")
	WebElement SaveButton;
	
	@FindBy(xpath = "//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1")
	WebElement accountOpportunityPageVerification;
	
	public ValidateOrder(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void customerOrderApproval() throws InterruptedException {
		Thread.sleep(5000);
		/*
		try{
		waitForclickable(driver, stageCustomerApproval, 200);
		}
		catch(Exception e){
			Thread.sleep(5000);
			waitForclickable(driver, stageCustomerApproval, 200);	
		}
		*/
		doubleclick(driver,stageCustomerApproval);
		Thread.sleep(1000);
		waitForclickable(driver, customerApprovalDropdownSelection, 200);
		dropdownselectionbyvalue(driver,customerApprovalDropdownSelection,"Customer Approved");
		waitForclickable(driver, customerApprovalOkButton, 200);
        customerApprovalOkButton.click();
       
        waitForclickable(driver, customerTypeDoubleClickSelection, 200);
		doubleclick(driver, customerTypeDoubleClickSelection);
		Thread.sleep(1000);
		
		waitForclickable(driver, customerTypeDropdownSelection, 200);
		//System.out.println("dsfjlsnbdfhbsdf");
		dropdownselectionbyvalue(driver,customerTypeDropdownSelection,"Existing Business");
		System.out.println("DklfjhgSDfghjdkfnmld,f;dklfkhdsjfg");
		Thread.sleep(1000);
		
		waitForclickable(driver, customerApprovalSaveButton, 200);
		customerApprovalSaveButton.click();
	}
	
	public void OrderValidation(Map<String, String> dataSets) throws Exception {
		    String OverAllType=(String)dataSets.get("OverallType");
		    String AddtionalValidations=(String)dataSets.get("AddtionalValidations");
		    if (OverAllType.equals("MACDTerminate")){
		    	
		    }
		    else{
			customerOrderApproval();
			Thread.sleep(5000);
		    }
			Thread.sleep(5000);
			waitForclickable(driver, ValidateOrderButton, 200);
			ValidateOrderButton.click();
			log("Validate Order button clicekd");
			Thread.sleep(3000);
			/*
			scrollTo(driver, BrowseFiles);
			Thread.sleep(3000);
			waitForclickable(driver, BrowseFiles, 200);
			BrowseFiles.click();
			log("Browse file button clicked");
			//BrowseFiles.sendKeys("C:\\Users\\support\\Desktop\\contract.txt");
			BrowseFiles.sendKeys("C:\\OM_UMSTDEMO_Automation\\genericProjectItems\\Backup-PerfectScriptAfterModification_UAT\\B2B_OM_Automation_23-10-2017\\B2B_OM_Automation\\Uploadfiles\\contract.txt");
			log("Contract file browsed and added successfully");
			Thread.sleep(8000);
			//waitForclickable(driver, SignedContractUploadFile, 200);
			WindowsPopupClose();
			Thread.sleep(8000);
			scrollTo(driver, SignedContractUploadFile);
			Thread.sleep(3000);
			SignedContractUploadFile.click();
			log("Signed contract upload file button clicked");
			*/
			//Thread.sleep(8000);
			//waitForElement(driver, 200, SignedContractCheckbox);
			scrollTo(driver, SignedContractCheckbox);
			SignedContractCheckbox.click();
			log("Signed contract chekbox clicked");
			Thread.sleep(3000);
			if (OverAllType.equals("MACD")||OverAllType.equals("MACDTerminate")||OverAllType.equals("MACDCease")||OverAllType.equals("ExistingCustomer")){
				MACDContactAdd();
			}
			if (AddtionalValidations.equals("SubmitPageValidations")) {
				accountOpprtunityLinkValidations(dataSets);
			}
			scrollTo(driver, SubmitOrderbutton);
			waitForclickable(driver, SubmitOrderbutton, 200);
			scrollTo(driver, SubmitOrderbutton);
			SubmitOrderbutton.click();
			Thread.sleep(8000);
			log("Order submitted successfully");		
			}
    
		public void accountOpprtunityLinkValidations(Map<String, String> dataSets) {
			String TestCaseName=(String)dataSets.get("TestCaseName");
			scrollTo(driver, OpportunityButton);
			waitForclickable(driver, OpportunityButton, 200);
			OpportunityButton.click();
			log("OpportunityButton clicked");
		    BrowserTabSwitch(driver);
		    String Temp = accountOpportunityPageVerification.getText();
		    Assert.assertEquals("Opportunity", Temp);
		    pocUpdates(TestCaseName, "Account button click - Regression Validations is successful", "Passed", "Successfully Regression Validations completed", driver);
		    log("On clicking Opportunity Button its loaded in a new tab");
			driver.close();
			BrowserMainTabSwitchBack(driver);
			scrollTo(driver, AccountButton);
			waitForclickable(driver, AccountButton, 200);
			AccountButton.click();
			log("AccountButton clicked");
			BrowserTabSwitch(driver);
		    String Temp2 = accountOpportunityPageVerification.getText();
		    Assert.assertEquals("Account", Temp2);
		    log("On clicking Account Button its loaded in a new tab");
		    pocUpdates(TestCaseName, "Opportunity button click - Regression Validations is successful", "Passed", "Successfully Regression Validations completed", driver);
			driver.close();
			BrowserMainTabSwitchBack(driver);
		}
	
	public void MACDContactAdd () throws Exception{
	scrollTo(driver, OpportunityButton);
	waitForclickable(driver, OpportunityButton, 200);
	openlinkinnewtab(driver, OpportunityButton);
	log("OpportunityButton clicked");
    Thread.sleep(5000);
    BrowserTabSwitch(driver);
	scrollTo(driver, ContactRolesNewButton);
	waitForclickable(driver, ContactRolesNewButton, 200);
	ContactRolesNewButton.click();
	log("ContactRolesNewButton clicked");
	Thread.sleep(1000);
	scrollTo(driver, RadioButton);
	waitForclickable(driver, RadioButton, 200);
	RadioButton.click();
	log("RadioButton clicked");
	Thread.sleep(1000);
	waitForclickable(driver, SelectionDropDown, 200);
	dropdownselection(driver,SelectionDropDown,"Administrative Contact");
	log("RadioButton selected as Administrative Contact");
	Thread.sleep(1000);
	scrollTo(driver, SaveButton);
	waitForclickable(driver, SaveButton, 200);
	SaveButton.click();
	log("SaveButton clicked");
	Thread.sleep(7000);
	driver.close();
	BrowserMainTabSwitchBack(driver);
}
}
