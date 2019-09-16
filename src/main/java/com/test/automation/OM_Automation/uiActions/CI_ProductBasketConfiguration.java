package com.test.automation.OM_Automation.uiActions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class CI_ProductBasketConfiguration extends TestBase {
	
	public static final Logger log = Logger.getLogger(CI_ProductBasketConfiguration.class.getName());
	
	WebDriver driver;
	
	//public final String Productselectionvalue 			= "Company Fiber";
	public final String Monthlychargesvalue 			= "200";
	public final String Upfrontfeevalue 	 			= "100";

	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li/div/div/div/div[1]/div/div[1]/button[2]")
	WebElement Editbasketbutton;

	@FindBy(id = "Allgemeine_Informationen:Additional_Information_0")
	WebElement additionalInformation;
	
	@FindBy(xpath = ".//*[@id='ngdialog2']/div[2]/div/div[1]/header/div/button")
	WebElement productbasketclosebutton;

	//@FindBy(xpath = ".//*[@id='ngdialog2']/div[2]/div/div[1]/header/div/button")
	@FindBy(xpath = "//*[@id=\"ngdialog3\"]/div[2]/div/div[1]/header/div/button")
	WebElement productbasketclosebuttonForAddon;
	
	@FindBy(name = "Product_Type_0")
	WebElement ProductDropdownSelection;

	@FindBy(xpath = ".//*[@id='Allgemeine_Informationen:Product_Description_0'][contains(text(), 'Company Fiber')]")
	WebElement ProductDescription;

	@FindBy(name = "Recurring_Price_0")
	WebElement Monthlycharges; //Need to give value
	
		
	@FindBy(name = "One_Off_Price_0")
	WebElement Upfrontfees; //Need to give value

	
	@FindBy(xpath = "//*[@id=\"Allgemeine_Informationen:Download_Speed_0\"]")
	WebElement downloadspeed;
	
	@FindBy(xpath = "//*[@id=\"s2id_Allgemeine_Informationen:Hardware_0\"]")
	WebElement Hardwareselection;
		
	//@FindBy(xpath = ".//*[@id='select2-drop']/ul[2]/li[1]/div/div/div/div[1]")
	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul[2]/li[1]")
	WebElement CiscoHitronSelection;
	
	//@FindBy(xpath = "html/body/div[4]/div/div[1]/div/div/div[1]/div/button[2]")
	@FindBy(xpath = "//*[@id=\"configurationContainer\"]/div/div[1]/div/div/div[1]/div/button[2]")
	WebElement Finishbutton;
	
	@FindBy(xpath = "//*[@id=\"j_id0:j_id25\"]/div/div[1]/div[1]/span")
	WebElement addonsNavigationButton;	

	@FindBy(xpath = "//*[@id=\"addon-btn-holder\"]/button")
	WebElement optionenButton;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[1]/td[1]/input")
	WebElement addonVPN;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[2]/td[1]/input")
	WebElement OneStatische;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[3]/td[1]/input")
	WebElement ThirteenStatische;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[4]/td[1]/input")
	WebElement FiveStatische;

	@FindBy(xpath = "//*[@id=\"addon-save\"]")
	WebElement speichernButton;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li[2]/div/div/div/div[1]/div/div[1]/button[2]")
	WebElement Editbasketbutton2;
	
	@FindBy(xpath = "//*[@id=\"Allgemeine_Informationen:Product_Type_0\"]")
	WebElement PowerSpotDropDown;
	
	@FindBy(xpath = "//*[@id=\"configurationContainer\"]/div/div[2]/div/div/div/div/div[1]/div/button")
	//*[@id="configurationContainer"]/div/div[2]/div/div/div/div/div[1]/div/button
	WebElement newHardware;
	
	//@FindBy(xpath = "//*[@id=\"relatedListTableID\"]/tbody/tr/td[4]/div/span")
	@FindBy(xpath = "//*[@id=\"relatedListTableID\"]/tbody/tr/td[4]/div/span")
	WebElement selectHardwaredropdownscrool;
	
	@FindBy(xpath = "//*[@id=\"relatedListTableID\"]/tbody/tr/td[4]/div/span")
	WebElement selectHardwaredropdown;
	
	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul[2]/li/div")
	WebElement ruckusIndoor;

	////////////////////////////////////////////////Wlan//////////////////////////
	@FindBy(xpath = "//*[@id=\"Allgemeine_Informationen:Contract_Term_0\"]")
	WebElement VertragslaufzeitWLAN;

	@FindBy(xpath = "//*[@id=\"Allgemeine_Informationen:Renewal_Duration_0\"]")
	WebElement FolgelaufzeitWLAN;

	@FindBy(xpath = "//*[@id=\"Allgemeine_Informationen:Recurring_Unit_Price_0\"]")
	WebElement MonatlicheEntgelteproWLAN;

	@FindBy(xpath = "//*[@id=\"Allgemeine_Informationen:One_Off_Unit_Price_0\"]")
	WebElement BereitstellungsentgelteproStckWLAN;

	@FindBy(xpath="//*[@id=\"Allgemeine_Informationen:Provisioning_Account_No_0\"]")
	WebElement ProvisioningAccountNumber;
	
	@FindBy(xpath="//*[@id=\"Allgemeine_Informationen:Market_Segment_0\"]")
	WebElement MarketSegment;
	
	public CI_ProductBasketConfiguration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

public void genericCIProductConfiguration(Map<String, String> dataSets) throws Exception{
	String Productselectionvalue=(String) dataSets.get("CI_Product_Type");
	String downloadspeedvalue=(String) dataSets.get("CI_Productdownloadspeedvalue");
	String CI_OrderType=(String) dataSets.get("CI_OrderType");

		Thread.sleep(5000);
		/*
		waitForElement(driver, 200, Editbasketbutton);
		scrollTo(driver, Editbasketbutton);
		Editbasketbutton.click();
		*/
		findEditButtonBasedOnTextXpathHardcoded("Company Internet",driver);
		//log("Edit basket button clicked");
		waitForElement(driver, 200, productbasketclosebutton);
		iframeswitch(driver, 1);
		log("Iframe switched");
		Thread.sleep(10000);
		waitForElement(driver, 200, ProductDropdownSelection);
		dropdownselectionbyvalue(driver, ProductDropdownSelection, Productselectionvalue);
		log("Company Internet Product selected");
		Thread.sleep(5000);
		waitForElement(driver, 200, Monthlycharges);
		Monthlycharges.sendKeys(Monthlychargesvalue);
		log("Monthly charges value as "+Monthlychargesvalue+" entered");
		//waitForElement(driver, 200, Upfrontfees);
		Thread.sleep(3000);
		waitForElement(driver, 200, downloadspeed);
		dropdownselection(driver, downloadspeed, downloadspeedvalue);		
		log("download speed value as "+downloadspeedvalue+" selected");
		Thread.sleep(3000);
		waitForElement(driver, 200, Hardwareselection);
		scrollTo(driver, Hardwareselection);
		Hardwareselection.click();
		log("Hardware selection element clicked");
		Thread.sleep(2000);
		waitForElement(driver, 200, CiscoHitronSelection);
		CiscoHitronSelection.click();
		log("Hardware to be successfully selected");
		Thread.sleep(2000);
		waitForElement(driver, 200, additionalInformation);
		additionalInformation.click();
		additionalInformation.sendKeys("Dummy test");
		additionalInformation.sendKeys(Keys.TAB);
		if (CI_OrderType.equals("Manual")) {
			waitForElement(driver, 100, ProvisioningAccountNumber);
			scrollTo(driver,ProvisioningAccountNumber);
			ProvisioningAccountNumber.sendKeys("963258741");
			ProvisioningAccountNumber.sendKeys(Keys.TAB);
		}		
		waitForElement(driver, 200, Finishbutton);
		scrollTo(driver, Finishbutton);
		Finishbutton.click();
		parentwindowreturn(driver);
		log("parent window switched");
		Thread.sleep(5000);
}
public void genericCIProductAddons(Map<String, String> dataSets) throws Exception {
	String CI_AddonsToBeAdded=(String) dataSets.get("CI_AddonsToBeAdded");
		Thread.sleep(5000);
		findEditButtonBasedOnTextXpathHardcoded("Company Internet",driver);
		/*
		waitForElement(driver, 200, Editbasketbutton);
		scrollTo(driver, Editbasketbutton);
		Editbasketbutton.click();
		*/
		log("Edit basket button clicked");
		Thread.sleep(5000);
		iframeswitch(driver, 1);
		log("Iframe switched");
		Thread.sleep(5000);
		waitForElement(driver, 200, addonsNavigationButton);
		addonsNavigationButton.click();
		log("Navigated to Addons Menu");
		Thread.sleep(2000);
		waitForElement(driver, 200, optionenButton);
		optionenButton.click();
		log("Navigated to Addons Menu and clicked on Options menu");
		Thread.sleep(3000);
		if(CI_AddonsToBeAdded.equals("OneStatische"))
		{
			waitForElement(driver, 200, OneStatische);
			//scrollTo(driver, OneStatische);
			OneStatische.click();
			log("Addon 1 statische IP-Adresse selected");
		}
		if(CI_AddonsToBeAdded.equals("ThirteenStatische"))
		{
			waitForElement(driver, 200, ThirteenStatische);
			//scrollTo(driver, ThirteenStatische);
			ThirteenStatische.click();
			log("Addon 13 statische IP-Adressen (NRW/HESS Only) selected");
		}
		if(CI_AddonsToBeAdded.equals("FiveStatische"))
		{
			waitForElement(driver, 200, FiveStatische);
			//scrollTo(driver, FiveStatische);
			FiveStatische.click();
			log("Addon 5 statische IP-Adressen selected");
		}
		if(CI_AddonsToBeAdded.equals("VPN"))
		{
			waitForElement(driver, 200, addonVPN);
			//scrollTo(driver, addonVPN);
			addonVPN.click();
			log("Addon VPN selected");
		}
		waitForElement(driver, 200, speichernButton);
		//scrollTo(driver, speichernButton);
		speichernButton.click();
		waitForElement(driver, 200, addonsNavigationButton);
		addonsNavigationButton.click();
		Thread.sleep(1000);
		waitForElement(driver, 200, Finishbutton);
		scrollTo(driver, Finishbutton);
		Finishbutton.click();
		parentwindowreturn(driver);
		log("parent window switched");
		Thread.sleep(5000);

}
public void genericCIProductPowerSpot(Map<String, String> dataSets) throws Exception {
	String segment=(String) dataSets.get("segment");
	//Thread.sleep(5000);
	/*
	waitForElement(driver, 200, Editbasketbutton2);
	scrollTo(driver, Editbasketbutton2);
	Editbasketbutton2.click();
	log("Edit basket button clicked");
	*/
	findEditButtonBasedOnTextXpathHardcoded("WLAN",driver);
	Thread.sleep(10000);
	iframeswitch(driver, 1);
	log("Iframe switched");
	Thread.sleep(5000);
	waitForElement(driver, 200, MarketSegment);
	dropdownselectionbyvalue(driver, MarketSegment, segment);
	Thread.sleep(5000);
	waitForElement(driver, 200, PowerSpotDropDown);
	dropdownselectionbyvalue(driver, PowerSpotDropDown, "Power Spot");
	log("PowerSpotDropDown Product selected");
	Thread.sleep(2000);
	scrollTo(driver, newHardware);
	newHardware.click();
	Thread.sleep(2000);
	log("new hardware button selected");
	//scrollTo(driver, selectHardwaredropdownscrool);
	//scrollTo(driver, selectHardwaredropdown);
	((JavascriptExecutor) driver)
    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(1000);
	selectHardwaredropdown.click();
	Thread.sleep(2000);
	log("SELECT HARDWARE DROPDOWN");
	((JavascriptExecutor) driver)
    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	scrollTo(driver, ruckusIndoor);
	ruckusIndoor.click();
	log("ruckusIndoor hardware selected");
	Thread.sleep(2000);
	waitForElement(driver, 200, Finishbutton);
	scrollTo(driver, Finishbutton);
	Finishbutton.click();
	parentwindowreturn(driver);
	log("parent window switched");
	Thread.sleep(5000);

}
public void genericCIProductWLan(Map<String, String> dataSets) throws Exception{
	        String segment=(String) dataSets.get("segment");
			Thread.sleep(5000);
			/*
			waitForElement(driver, 200, Editbasketbutton2);
			scrollTo(driver, Editbasketbutton2);
			Editbasketbutton2.click();
			log("Edit basket button clicked");
			*/
			findEditButtonBasedOnTextXpathHardcoded("WLAN",driver);
			Thread.sleep(10000);
			iframeswitch(driver, 1);
			log("Iframe switched");
			Thread.sleep(5000);
			waitForElement(driver, 200, MarketSegment);
			dropdownselectionbyvalue(driver, MarketSegment, segment);
			Thread.sleep(5000);
			waitForElement(driver, 200, PowerSpotDropDown);
			dropdownselectionbyvalue(driver, PowerSpotDropDown, "Managed Wlan Solution");
			log("PowerSpotDropDown Product selected");
			Thread.sleep(2000);
			waitForElement(driver, 200, VertragslaufzeitWLAN);
			scrollTo(driver, VertragslaufzeitWLAN);
			VertragslaufzeitWLAN.click();
			VertragslaufzeitWLAN.sendKeys("24");
			VertragslaufzeitWLAN.sendKeys(Keys.TAB);
			log("Vertragslaufzeit value passed as 24");
			Thread.sleep(2000);
			waitForElement(driver, 200, MonatlicheEntgelteproWLAN);
			scrollTo(driver, MonatlicheEntgelteproWLAN);
			MonatlicheEntgelteproWLAN.click();
			MonatlicheEntgelteproWLAN.sendKeys("100");
			MonatlicheEntgelteproWLAN.sendKeys(Keys.TAB);
			log("MonatlicheEntgeltepro value passed as 100");
			Thread.sleep(2000);
			waitForElement(driver, 200, BereitstellungsentgelteproStckWLAN);
			scrollTo(driver, BereitstellungsentgelteproStckWLAN);
			BereitstellungsentgelteproStckWLAN.click();
			BereitstellungsentgelteproStckWLAN.sendKeys("200");
			BereitstellungsentgelteproStckWLAN.sendKeys(Keys.TAB);
			log("BereitstellungsentgelteproStck value passed as 200");
			Thread.sleep(2000);
			waitForElement(driver, 200, Finishbutton);
			scrollTo(driver, Finishbutton);
			Finishbutton.click();
			parentwindowreturn(driver);
			log("parent window switched");
			Thread.sleep(5000);
}
public void changeCIOrder (Map<String, String> dataSets,String TestName) throws Exception{
    String downloadspeedvalue=(String) dataSets.get("CI_Productdownloadspeedvalue");
    String Productselectionvalue=(String) dataSets.get("CI_Product_Type");
    findEditButtonBasedOnTextXpathHardcoded("Company Internet",driver);
    log("Iframe switched jsaddskjashgsdhjsagdhjsgdghjsgd");
    //waitForElement(driver, 200, productbasketclosebuttonForChange);
    iframeswitch(driver, 1);
    log("Iframe switched");
    Thread.sleep(10000);
    waitForElement(driver, 200, ProductDropdownSelection);
    dropdownselectionbyvalue(driver, ProductDropdownSelection, Productselectionvalue);
    log("Company Internet Product selected");
    Thread.sleep(5000);
    dropdownselection(driver, downloadspeed, downloadspeedvalue);       
    log("download speed value as "+downloadspeedvalue+" selected");
    Thread.sleep(3000);
    waitForElement(driver, 200, Upfrontfees);
    Upfrontfees.sendKeys("100");
    Upfrontfees.sendKeys(Keys.TAB);
    log("Upfront fees entered");
    Thread.sleep(3000);
    waitForElement(driver, 200, Hardwareselection);
    scrollTo(driver, Hardwareselection);
    Hardwareselection.click();
    log("Hardware selection element clicked");
    Thread.sleep(2000);
    waitForElement(driver, 200, CiscoHitronSelection);
    CiscoHitronSelection.click();
    log("Hardware to be successfully selected");
    Thread.sleep(2000);
    waitForElement(driver, 200, Finishbutton);
    scrollTo(driver, Finishbutton);
    Finishbutton.click();
    parentwindowreturn(driver);
    log("parent window switched");
    Thread.sleep(5000);

}
}