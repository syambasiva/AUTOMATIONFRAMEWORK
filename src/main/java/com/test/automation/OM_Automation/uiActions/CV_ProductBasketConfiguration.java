package com.test.automation.OM_Automation.uiActions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class CV_ProductBasketConfiguration extends TestBase {
	
public static final Logger log = Logger.getLogger(CV_ProductBasketConfiguration.class.getName());
	
	WebDriver driver;
	
	public String Areacode 					= "1";
	public String Mainnumber 					= "1";
	public String ExtensionStartnumeber 	 	= "1";
	public String ExtensionEndnumber			= "1";
	public String AmountofNumbers				= "1";
	

	
	
	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li[2]/div/div/div/div[1]/div/div[1]/button[2]")
	WebElement Editbasketbutton;
	
	@FindBy(xpath = "html/body/div[2]/div[2]/div/div[1]/header/div/button")
	WebElement productbasketclosebutton;
	
	@FindBy(name = "Product_Subtype_0")
	WebElement productSubType;
	
	@FindBy(name = "Number_Of_Channels_0")
	WebElement productKanale;
	
	@FindBy(xpath = "html/body/div[4]/div/div[1]/div/div/div[1]/div/button[1]")
	WebElement CVProductNextButton;
	
	@FindBy(xpath = "//button[@data-cs-ref='Number_Range_0']")
	WebElement CV_NewNumberRangeButton;
	
	@FindBy(xpath = ".//*[@id='Telefonnummern:Area_Codes_0']")
	WebElement CV_number_Areacode;
	
	@FindBy(xpath = ".//*[@id='Telefonnummern:Main_Number_0']")
	WebElement CV_Mainnumber;
	
	@FindBy(xpath = ".//*[@id='Telefonnummern:Extension_Start_0']")
	WebElement CV_ExtensionStartnumber;
	
	@FindBy(xpath = ".//*[@id='Telefonnummern:Extension_End_0']")
	WebElement CV_ExtensionEndnumber;
	
	@FindBy(xpath = ".//*[@id='Telefonnummern:Amount_Of_Numbers_0']")
	WebElement CV_AmountofNumbers;
	
	@FindBy(xpath = ".//*[@id='Telefonnummern:Number_Range_0']")
	WebElement CV_NumberRangeEntered;
	
	@FindBy(xpath = ".//*[@id='configurationContainer']/div/div/div/div/div[3]/div/button[2]")
	WebElement CV_NumbersContinue;
	
	@FindBy(xpath = ".//*[@id='relatedListTableID']/tbody/tr/td[2]")
	WebElement CV_NumberRangeStatus;
	
	@FindBy(xpath = ".//*[@id='configurationContainer']/div/div[1]/div/div/div[3]/div/button[3]")
	WebElement CV_Finishbutton;	
	
	@FindBy(xpath = "//*[@id='relatedListTableID']/tbody/tr[1]/td[1]/span[2]")
	WebElement CV_NumberRangeStatus_delete;
	
	//@FindBy(xpath = ".//*[@id='configurationContainer']/div/div[1]/div/div/div[3]/div/button[3]")
	//WebElement CV_Finishbutton;
	

	@FindBy(xpath = ".//*[@id='configurationContainer']/div/div[1]/div/div/div[3]/div/button[3]")
	WebElement CV_Finishbutton_cease;
	
	
	public CV_ProductBasketConfiguration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CV_CeaseOrder(Map<String, String> dataSets) throws Exception{
		/*
	    Thread.sleep(5000);
	    findEditButtonBasedOnTextXpathHardcoded("Company Voice",driver);
		waitForElement(driver, 200, productbasketclosebutton);
		iframeswitch(driver, 1);
		log("Iframe switched");
		Thread.sleep(5000);
		waitForElement(driver, 200, CVProductNextButton);
		scrollTo(driver, CVProductNextButton);
		CVProductNextButton.click();
		log("CV product configureation NEXT button clicked");
		*/
		CVChange(dataSets);
		try{
		waitForElement(driver, 200, CV_NumberRangeStatus_delete);
		}
		catch (Exception e){
			System.out.println("dfdsf    " + e);
		}
		scrollTo(driver, CV_NumberRangeStatus_delete);
		Thread.sleep(20000);
		CV_NumberRangeStatus_delete.click();
		log("CV_NumberRangeStatus_delete clicked");
		Thread.sleep(5000);
		scrollTo(driver, CV_Finishbutton_cease);
		CV_Finishbutton_cease.click();
		log("Fininsh button clicked");
		Thread.sleep(5000);
		parentwindowreturn(driver);
		log("parent window switched");
		Thread.sleep(5000);
		
	}
	
	public void CV_ProductConfiguration(Map<String, String> dataSets,String typeOfCVOrder) throws Exception{
		    String CVKanale=(String) dataSets.get("CVKanale");    
	        Thread.sleep(5000);
		    findEditButtonBasedOnTextXpathHardcoded("Company Voice",driver);
			waitForElement(driver, 200, productbasketclosebutton);
			iframeswitch(driver, 1);
			log("Iframe switched");
			Thread.sleep(5000);
			if (typeOfCVOrder.equals("ISDN")) {
				//postProductSelectionProcess();
				postProductSelectionProcessUpdated(dataSets);
			}
			else if (typeOfCVOrder.equals("SIPTrunk")) {
				waitForElement(driver, 200, productSubType);
				scrollTo(driver, productSubType);
				dropdownselectionbyvalue(driver, productSubType, "SipTrunk");
				log("Company Voice SipTrunk Product selected");
				waitForElement(driver, 200, productKanale);
				scrollTo(driver, productKanale);
				dropdownselectionbyvalue(driver, productKanale, CVKanale);
				log("Company Voice SipTrunk product selected as" + CVKanale);
	//			postProductSelectionProcess();
				postProductSelectionProcessUpdated(dataSets);
			}
	
	}

	
	public void postProductSelectionProcessUpdated(Map<String, String> dataSets) throws Exception {
		String OverallType=(String) dataSets.get("OverallType");    
		waitForElement(driver, 200, CVProductNextButton);
		scrollTo(driver, CVProductNextButton);
		CVProductNextButton.click();
		log("CV product configureation NEXT button clicked");

		numberRangeConfiguration();
		log("CV product configureation NEXT button clicked");
		if (OverallType.equals("CVAdd")) {
			//postProductSelectionProcess();
			numberRangeConfiguration();	
		}
		waitForclickable(driver, CV_NumberRangeStatus, 200);
		scrollTo(driver, CV_NumberRangeStatus);
		log("CV_numberrange status is visible ");
		Thread.sleep(5000);
		scrollTo(driver, CV_Finishbutton);
		CV_Finishbutton.click();
		log("Fininsh button clicked");
		Thread.sleep(5000);
		parentwindowreturn(driver);
		log("parent window switched");
		Thread.sleep(5000);
	}

	public void CVChange(Map<String, String> dataSets) throws Exception {
        Thread.sleep(5000);
	    findEditButtonBasedOnTextXpathHardcoded("Company Voice",driver);
		waitForElement(driver, 200, productbasketclosebutton);
		iframeswitch(driver, 1);
		log("Iframe switched");
		Thread.sleep(5000);
		waitForElement(driver, 200, CVProductNextButton);
		scrollTo(driver, CVProductNextButton);
		CVProductNextButton.click();
		log("CV product configureation NEXT button clicked");


	
	}
	
	public void numberRangeConfiguration() throws Exception {
		waitForElement(driver, 200, CV_NewNumberRangeButton);
		scrollTo(driver, CV_NewNumberRangeButton);
		CV_NewNumberRangeButton.click();
		log("CV NewNumberRange button clicked");
		Thread.sleep(6000);
		//waitForElement(driver, 200, CV_number_Areacode);
		CV_number_Areacode.clear();
		Areacode=Randomnumbers(3);
		Areacode="0"+ Areacode;
		CV_number_Areacode.sendKeys(Areacode);
		CV_number_Areacode.sendKeys(Keys.TAB);
        Thread.sleep(3000);
		log("Areacode value as "+Areacode+" entered");
		waitForElement(driver, 200, CV_Mainnumber);
		//scrollTo(driver, CV_Mainnumber);
		Mainnumber=Randomnumbers(3);
		CV_Mainnumber.sendKeys(Mainnumber);
		CV_Mainnumber.sendKeys(Keys.TAB);
		Thread.sleep(8000);
		log("MainNumber value as "+Mainnumber+" entered");
		ExtensionStartnumeber=Randomnumbers(3);
		CV_ExtensionStartnumber.sendKeys(ExtensionStartnumeber);
		CV_ExtensionStartnumber.sendKeys(Keys.TAB);
		Thread.sleep(8000);
		log("Extension start number as "+ExtensionStartnumeber+" Entered");
		ExtensionEndnumber=ExtensionStartnumeber;
		CV_ExtensionEndnumber.sendKeys(ExtensionEndnumber);
		CV_ExtensionEndnumber.sendKeys(Keys.TAB);
		Thread.sleep(8000);
		log("Extension End number as "+ExtensionEndnumber+" Entered");
		CV_AmountofNumbers.sendKeys(AmountofNumbers);
		Thread.sleep(8000);
		waitForElement(driver, 200, CV_NumberRangeEntered);
		log("CV number ranges are successfully configured");
		scrollTo(driver, CV_NumbersContinue);
		waitForclickable(driver, CV_NumbersContinue, 200);
		CV_NumbersContinue.click();
		log("CV Numbers continue button clicked");
		//Thread.sleep(500000);
	}
	
}
