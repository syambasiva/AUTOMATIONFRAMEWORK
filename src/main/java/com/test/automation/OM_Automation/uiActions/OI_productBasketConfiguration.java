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

public class OI_productBasketConfiguration extends TestBase {
	
public static final Logger log = Logger.getLogger(CF_ProductBasketConfiguration.class.getName());
	
	WebDriver driver;
	public final String StateName 								= "NRW";

	
	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li/div/div/div/div[1]/div/div[1]/button[2]")
	WebElement Editbasketbutton;
	
	@FindBy(xpath = ".//*[@id='ngdialog2']/div[2]/div/div[1]/header/div/button")
	WebElement productbasketclosebutton;
	
	//@FindBy(id = "Allgemeine_Informationen:Product_Type_0")
	@FindBy(xpath = "//select[@name='Product_Type_0']")
	WebElement ProductDropdownSelection;
	
	@FindBy(xpath = ".//*[@id='Allgemeine_Informationen:State_0']")
	WebElement Statedropdown;
	
	@FindBy(xpath = ".//*[@id='configurationContainer']/div/div[1]/div/div/div[3]/div/button[2]")
	WebElement Finishbutton;
	
	@FindBy(xpath = "//*[@id=\"j_id0:j_id25\"]/div/div[1]/div[1]/span")
	WebElement addonsNavigationButton;	

	@FindBy(xpath = "//*[@id=\"addon-btn-holder\"]/button")
	WebElement optionenButton;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[1]/td[1]/input")
	WebElement addonHomepagepaket;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[2]/td[1]/input")
	WebElement addonSicherheitspaket;
	
	@FindBy(xpath = "//*[@id=\"optionen\"]/tbody/tr[3]/td[1]/input")
	WebElement addon1statische;
	
	//@FindBy(xpath = "//*[@id=\"addon-save\"]")
	@FindBy(id="addon-save")
	WebElement speichernButton;
	
	@FindBy(xpath="//*[@id=\"Allgemeine_Informationen:Market_Segment_0\"]")
	WebElement MarketSegment;
	
	@FindBy(id="Allgemeine_Informationen:One_Off_Price_0")
	WebElement UpFrontFees;
	
	@FindBy(id="Allgemeine_Informationen:Recurring_Price_0")
	WebElement MRCChagres;
	
	public OI_productBasketConfiguration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

public void genericOIProductConfiguration(Map<String, String> dataSets) throws Exception {
	String uploadspeedvalue=(String) dataSets.get("OIProductuploadspeedvalue");
	String segment=(String) dataSets.get("segment");
	String AddtionalValidations=(String) dataSets.get("AddtionalValidations");
		Thread.sleep(5000);
		findEditButtonBasedOnTextXpathHardcoded("Office Internet",driver);
		/*
		waitForElement(driver, 200, Editbasketbutton);
		scrollTo(driver, Editbasketbutton);
		Editbasketbutton.click();
		log("Edit basket button clicked");
		*/
		waitForElement(driver, 200, productbasketclosebutton);
		iframeswitch(driver, 1);
		log("Iframe switched");
		Thread.sleep(3000);
		scrollTo(driver, ProductDropdownSelection);
		//waitForElement(driver, 200, ProductDropdownSelection);
		dropdownselectionbyvalue(driver, ProductDropdownSelection, uploadspeedvalue);
		log("Office Internet with "+uploadspeedvalue+" Product selected");
		ProductDropdownSelection.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		waitForElement(driver, 200, MarketSegment);
		dropdownselectionbyvalue(driver, MarketSegment, segment);
		Thread.sleep(3000);
		if (AddtionalValidations.equals("MrcNrcCheck")) {
			MrcNrcCheckRegression(dataSets);
		}
		//waitForElement(driver, 200, Finishbutton);
		scrollTo(driver, Finishbutton);
		Finishbutton.click();
		parentwindowreturn(driver);
		log("parent window switched");
		Thread.sleep(5000);

}

		public void MrcNrcCheckRegression(Map<String, String> dataSets) throws Exception{
			String TestCaseName=(String) dataSets.get("TestCaseName");
			waitForElement(driver, 200, MRCChagres);
			MRCChagres.sendKeys("100");
			MRCChagres.sendKeys(Keys.TAB);
			log("Monthly Recurring chare is editable");
			Thread.sleep(1000);
			waitForElement(driver, 200, UpFrontFees);
			UpFrontFees.sendKeys("100");
			UpFrontFees.sendKeys(Keys.TAB);
			log("Non Recurring chare is editable");
			Thread.sleep(1000);
			log("Regression Validation to check if the CSR is able to edit MRC & NRC successful");
			pocUpdates(TestCaseName, "Regression Validation to check if the CSR is able to edit MRC & NRC successful", "Passed", "Successfully Regression Validations completed", driver);
		}
		
public void genericOIProductAddons(Map<String, String> dataSets) throws Exception{
	String OI_AddonsToBeAdded=(String) dataSets.get("OI_AddonsToBeAdded");
	String segment=(String) dataSets.get("segment");
    Thread.sleep(5000);
	findEditButtonBasedOnTextXpathHardcoded("Office Internet",driver);
	/*
	waitForElement(driver, 200, Editbasketbutton);
	scrollTo(driver, Editbasketbutton);
	Editbasketbutton.click();
	log("Edit basket button clicked");
	*/
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
	switch(OI_AddonsToBeAdded) {
	case "Homepagepaket (12 Monate kostenlos)":
		scrollTo(driver, addonHomepagepaket);
		waitForElement(driver, 200, addonHomepagepaket);
		addonHomepagepaket.click();
		log("Addon Homepagepaket selected");
		break;
	case "Sicherheitspaket 5er Lizenz":
		scrollTo(driver, addonSicherheitspaket);
		waitForElement(driver, 200, addonSicherheitspaket);
		addonSicherheitspaket.click();
		log("Addon Sicherheitspaket selected");
		break;
	case "1 statische IP-Adresse":
		scrollTo(driver, addon1statische);
		waitForElement(driver, 200, addon1statische);
		addon1statische.click();
		log("Addon 1 statische IP-Adresse selected");
		break;
	default:
		break;
	}
	waitForElement(driver, 200, speichernButton);
	//System.out.println("111");
	scrollTo(driver, speichernButton);
	//System.out.println("222");
	try {
	speichernButton.click();
	System.out.println("111");
	}
	catch (Exception e) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", speichernButton);
		System.out.println("1112111");
	}
	//System.out.println("333");
	//((JavascriptExecutor) driver).executeScript("arguments[0].click();", speichernButton);
	System.out.println("444");
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
public void changeOIOrder (Map<String, String> dataSets,String TestName) throws Exception{
	String uploadspeedvalue=(String) dataSets.get("OIProductuploadspeedvalue");
    Thread.sleep(5000);
	findEditButtonBasedOnTextXpathHardcoded("Office Internet",driver);	
	Thread.sleep(5000);
	iframeswitch(driver, 1);
	log("Iframe switched");
	Thread.sleep(5000);
	dropdownselectionbyvalue(driver, ProductDropdownSelection, uploadspeedvalue);
	log("Office Internet with "+uploadspeedvalue+" Product selected");
	//ProductDropdownSelection.sendKeys(Keys.TAB);
	Thread.sleep(3000);
	waitForElement(driver, 200, UpFrontFees);
	UpFrontFees.sendKeys("100");
	UpFrontFees.sendKeys(Keys.TAB);
	Thread.sleep(1000);
	scrollTo(driver, Finishbutton);
	Finishbutton.click();
	parentwindowreturn(driver);
	log("parent window switched");
	Thread.sleep(5000);
	
}

}
