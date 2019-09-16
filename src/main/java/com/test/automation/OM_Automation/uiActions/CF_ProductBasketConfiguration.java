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

public class CF_ProductBasketConfiguration extends TestBase {
	
	public static final Logger log = Logger.getLogger(CF_ProductBasketConfiguration.class.getName());
	
	WebDriver driver;
	
	public final String Productselectionvalue 			= "Company Fiber";
	public final String Monthlychargesvalue 			= "200";
	public final String Upfrontfeevalue 	 			= "100";


	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li/div/div/div/div[1]/div/div[1]/button[2]")
                    	//*[@id=\"bodyCell\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li["+i+"]/div/div/div/div[1]/div/div[4]"
	WebElement Editbasketbutton;
	
	@FindBy(xpath = ".//*[@id='ngdialog2']/div[2]/div/div[1]/header/div/button")
	WebElement productbasketclosebutton;
	
	@FindBy(name = "Product_Type_0")
	WebElement ProductDropdownSelection;

	@FindBy(xpath = ".//*[@id='Allgemeine_Informationen:Product_Description_0'][contains(text(), 'Company Fiber')]")
	WebElement ProductDescription;

	@FindBy(name = "Recurring_Price_0")
	WebElement Monthlycharges; //Need to give value
	
		
	@FindBy(name = "One_Off_Price_0")
	WebElement Upfrontfees; //Need to give value
	
	@FindBy(name = "Company_Fiber_Service_Configuration_0:Bandwidth_0")
	WebElement UploadSpeedDropdown;
	
	@FindBy(xpath = ".//*[@id='Allgemeine_Informationen:Download_Speed_0']")
	WebElement downloadspeed;
	
	@FindBy(xpath = ".//*[@id='s2id_Allgemeine_Informationen:Hardware_0']/a")
	WebElement Hardwareselection;
		
	@FindBy(xpath = ".//*[@id='select2-drop']/ul[2]/li[1]/div/div/div/div[1]")
	WebElement CiscoFiberSelection;
	
	@FindBy(xpath = "html/body/div[4]/div/div[1]/div/div/div[1]/div/button[2]")
	WebElement Finishbutton;

	@FindBy(xpath = "//*[@id=\"j_id0:j_id25\"]/div/div[1]/div[1]/span")
	WebElement addonsNavigationButton;	

	@FindBy(xpath = "//*[@id=\"addon-btn-holder\"]/button")
	WebElement optionenButton;
	
	//@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[1]/td[1]/input")
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[1]/td[1]/input")
	WebElement addonBGP;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[2]/td[1]/input")
	WebElement addonMP2MPAccess;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[3]/td[1]/input")
	WebElement addonPM2MP;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[4]/td[1]/input")
	WebElement addonP2MP;

	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[5]/td[1]/input")
	WebElement addonP2MPAccess;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[6]/td[1]/input")
	WebElement addonP2P;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[7]/td[1]/input")
	WebElement addonP2PAccess;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[8]/td[1]/input")
	WebElement addonP2PInternational;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[9]/td[1]/input")
	WebElement addonP2PInternationalAccess;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[10]/td[1]/input")
	WebElement addon26statischeIPAdressen;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[11]/td[1]/input")
	WebElement addon27statischeIPAdressen;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[12]/td[1]/input")
	WebElement addon28statischeIPAdressen;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[13]/td[1]/input")
	WebElement addon29statischeIPAdressen;
	
	@FindBy(xpath = "//*[@id=\"addon-save\"]")
	WebElement speichernButton;

	@FindBy(xpath = "//*[@id='configurationContainer']/div/div[2]/div/div/div/div/div[1]/div/button")
	WebElement UploadSpeedSelectionPrerequsiteButton;

	@FindBy(name = "Company_Fiber_Service_Configuration_0:Service_0")
	WebElement ServiceDropdownSelection;
	
	@FindBy(name = "Company_Fiber_Service_Configuration_0:Active_Network_IPv4_0")
	WebElement WirknetzIPv4;
	
	@FindBy(name = "Company_Fiber_Service_Configuration_0:Active_Network_IPv6_0")
	WebElement WirknetzIPv6;
	
	@FindBy(name = "Company_Fiber_Service_Configuration_0:Transfer_Network_IPv4_0")
	WebElement TransfernetzIPv4;
	
	@FindBy(name = "Company_Fiber_Service_Configuration_0:Transfer_Network_IPv6_0")
	WebElement TransfernetzIPv6;
	
	@FindBy(xpath = "//*[@id='configurationContainer']/div/div/div/div/div[1]/div/button[2]")
	WebElement continueButton;
		
	public CF_ProductBasketConfiguration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addonsTypeSelection(Map<String, String> dataSets) throws Exception{
		String uploadspeedvalue=(String) dataSets.get("CFProductuploadspeedvalue");
		String CF_AddonsToBeAdded=(String) dataSets.get("CF_AddonsToBeAdded");
        waitForElement(driver, 200, ServiceDropdownSelection);
        scrollTo(driver, ServiceDropdownSelection);
        log("CF_AddonsToBeAdded " +CF_AddonsToBeAdded);
		dropdownselectionbyvalue(driver, ServiceDropdownSelection, CF_AddonsToBeAdded);
        log("Company fiber Service selected as "+CF_AddonsToBeAdded);                        
        Thread.sleep(2000);        	
        waitForElement(driver, 200, UploadSpeedDropdown);
        scrollTo(driver, UploadSpeedDropdown);
        dropdownselectionbyvalue(driver, UploadSpeedDropdown, uploadspeedvalue);
        log("upload speed value as "+uploadspeedvalue+" selected");
        Thread.sleep(3000);      
        if (CF_AddonsToBeAdded.equals("Access")){
        	AccesTypeNavigations(dataSets);
        }
	}
	
	public void AccesTypeNavigations(Map<String, String> dataSets) throws Exception{
		waitForElement(driver, 200, WirknetzIPv4);
        scrollTo(driver, WirknetzIPv4);
        dropdownselectionbyvalue(driver, WirknetzIPv4, "/30 - 1 nutzbare IP-Adresse");
        log("WirknetzIPv4 Service selected as "+"30 - 1 nutzbare IP-Adresse");                         
        Thread.sleep(500);               
        waitForElement(driver, 200, WirknetzIPv4);
        scrollTo(driver, WirknetzIPv4);
        dropdownselectionbyvalue(driver, WirknetzIPv4, "/30 - 1 nutzbare IP-Adresse");
        log("WirknetzIPv4 Service selected as "+"30 - 1 nutzbare IP-Adresse");                         
        Thread.sleep(500);            
        waitForElement(driver, 200, WirknetzIPv6);
        scrollTo(driver, WirknetzIPv6);
        dropdownselectionbyvalue(driver, WirknetzIPv6, "/56 - 256 nutzbare Subnetze");
        log("WirknetzIPv6 Service selected as "+"56 - 256 nutzbare Subnetze");                         
        Thread.sleep(500);        
        waitForElement(driver, 200, TransfernetzIPv4);
        scrollTo(driver, TransfernetzIPv4);
        dropdownselectionbyvalue(driver, TransfernetzIPv4, "Wird bereitgestellt von Unitymedia");
        log("TransfernetzIPv4 Service selected as "+"Wird bereitgestellt von Unitymedia");                    
        Thread.sleep(500);        
        waitForElement(driver, 200, TransfernetzIPv6);
        scrollTo(driver, TransfernetzIPv6);
        dropdownselectionbyvalue(driver, TransfernetzIPv6, "Wird bereitgestellt von Unitymedia");
        log("TransfernetzIPv6 Service selected as "+"Wird bereitgestellt von Unitymedia");                    
        Thread.sleep(500);        
	}
    public void genericCFProductConfiguration(Map<String, String> dataSets) throws Exception {
	String uploadspeedvalue=(String) dataSets.get("CFProductuploadspeedvalue");
	String CF_AddonsToBeAdded=(String) dataSets.get("CF_AddonsToBeAdded");
	Thread.sleep(5000);
		findEditButtonBasedOnTextXpathHardcoded("Company Fiber",driver);
		waitForElement(driver, 200, productbasketclosebutton);
		iframeswitch(driver, 1);
		log("Iframe switched");
		waitForElement(driver, 200, ProductDropdownSelection);
		dropdownselectionbyvalue(driver, ProductDropdownSelection, Productselectionvalue);
		log("Company fiber Product selected");
        waitForElement(driver, 200, Upfrontfees);
        scrollTo(driver, Upfrontfees);
        Upfrontfees.sendKeys(Upfrontfeevalue);
        Upfrontfees.sendKeys(Keys.TAB);
        log("Upfront fee chargees value as "+Upfrontfeevalue+" entered");
        Thread.sleep(1000);
        waitForElement(driver, 200, Monthlycharges);
        scrollTo(driver, Monthlycharges);
        Monthlycharges.sendKeys(Monthlychargesvalue);
        Monthlycharges.sendKeys(Keys.TAB);
        log("Monthly charges value as "+Monthlychargesvalue+" entered");
        Thread.sleep(3000);
        waitForElement(driver, 200, UploadSpeedSelectionPrerequsiteButton);
        scrollTo(driver, UploadSpeedSelectionPrerequsiteButton);
        Thread.sleep(1000);
        UploadSpeedSelectionPrerequsiteButton.click();
        log("Company fiber Upload Speed Selection Prerequsite Button is clicked");
        Thread.sleep(3000);              
        addonsTypeSelection(dataSets);
    	waitForElement(driver, 200, continueButton);
        scrollTo(driver, continueButton);
        continueButton.click();
        log("CF product configuration continue button clicked");
		waitForElement(driver, 200, Finishbutton);
		scrollTo(driver, Finishbutton);
		Finishbutton.click();
        log("CF product configuration finsh button clicked");
		parentwindowreturn(driver);
		log("parent window switched");
		Thread.sleep(5000);
}
public void genericCFProductAddons(Map<String, String> dataSets) throws Exception {
String CF_AddonsToBeAdded=(String) dataSets.get("CF_AddonsToBeAdded");

	Thread.sleep(5000);
	/*waitForElement(driver, 200, Editbasketbutton);
	scrollTo(driver, Editbasketbutton);
	Editbasketbutton.click();
	*/
	findEditButtonBasedOnTextXpathHardcoded("Company Fiber",driver);
	log("Edit basket button clicked");
	//waitForElement(driver, 200, productbasketclosebutton);
	Thread.sleep(5000);
	iframeswitch(driver, 1);
	log("Iframe switched");
	Thread.sleep(5000);
	waitForElement(driver, 200, addonsNavigationButton);
	addonsNavigationButton.click();
	log("Navigated to Addons Menu sdfldslfd;slf");
	Thread.sleep(2000);
	waitForElement(driver, 200, optionenButton);
	optionenButton.click();
	log("Navigated to Addons Menu and clicked on Options menu");
	Thread.sleep(3000);
	System.out.println("CF_AddonsToBeAdded is " +CF_AddonsToBeAdded);
	switch(CF_AddonsToBeAdded) {
	case "BGP":		
		//scrollTo(driver, addonBGP);
		waitForElement(driver, 200, addonBGP);
		addonBGP.click();
		log("Addon BGP selected");
		break;
	case "MP2MP Access":
		//scrollTo(driver, addonMP2MPAccess);
		waitForElement(driver, 200, addonMP2MPAccess);
		addonMP2MPAccess.click();
		log("Addon MP2MP Access selected");
		break;
	case "PM2MP":
		//scrollTo(driver, addonPM2MP);
		waitForElement(driver, 200, addonPM2MP);
		addonPM2MP.click();
		log("Addon PM2MP selected");
		break;
	case "P2MP":
		//scrollTo(driver, addonP2MP);
		waitForElement(driver, 200, addonP2MP);
		addonP2MP.click();
		log("Addon P2MP selected");
		break;
	case "P2MP Access":
		//scrollTo(driver, addonP2MPAccess);
		waitForElement(driver, 200, addonP2MPAccess);
		addonP2MPAccess.click();
		log("Addon P2MP Access selected");
		break;
	case "P2P":
		//scrollTo(driver, addonP2P);
		waitForElement(driver, 200, addonP2P);
		addonP2P.click();
		log("Addon P2P selected");
		break;
	case "P2P Access":
		scrollTo(driver, addonP2PAccess);
		waitForElement(driver, 200, addonP2PAccess);
		addonP2PAccess.click();
		log("Addon P2P Access selected");
		break;
	case "P2P International":
		scrollTo(driver, addonP2PInternational);
		waitForElement(driver, 200, addonP2PInternational);
		addonP2PInternational.click();
		log("Addon P2P International selected");
		break;
	case "P2P International Access":
		scrollTo(driver, addonP2PInternationalAccess);
		waitForElement(driver, 200, addonP2PInternationalAccess);
		addonP2PInternationalAccess.click();
		log("Addon P2P International Access selected");
		break;
	case "26 statische IP-Adressen":
		scrollTo(driver, addon26statischeIPAdressen);
		waitForElement(driver, 200, addon26statischeIPAdressen);
		addon26statischeIPAdressen.click();
		log("Addon 26 statische IP-Adressen selected");
		break;
	case "27 statische IP-Adressen":
		scrollTo(driver, addon27statischeIPAdressen);
		waitForElement(driver, 200, addon27statischeIPAdressen);
		addon27statischeIPAdressen.click();
		log("Addon 27 statische IP-Adressen selected");
		break;
	case "28 statische IP-Adressen":
		scrollTo(driver, addon28statischeIPAdressen);
		waitForElement(driver, 200, addon28statischeIPAdressen);
		addon28statischeIPAdressen.click();
		log("Addon 28 statische IP-Adressen selected");
		break;
	case "29 statische IP-Adressen":
		scrollTo(driver, addon29statischeIPAdressen);
		waitForElement(driver, 200, addon29statischeIPAdressen);
		addon29statischeIPAdressen.click();
		log("Addon 29 statische IP-Adressen selected");
		break;
	default:
	}
	Thread.sleep(2000);
	waitForElement(driver, 200, speichernButton);
	scrollTo(driver, speichernButton);
	speichernButton.sendKeys(Keys.UP);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", speichernButton);
	Thread.sleep(3000);
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
}
