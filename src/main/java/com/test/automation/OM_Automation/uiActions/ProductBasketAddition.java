package com.test.automation.OM_Automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class ProductBasketAddition extends TestBase {
	
	public static final Logger log = Logger.getLogger(ProductBasketAddition.class.getName());
	
WebDriver driver;
	
	@FindBy(xpath = "//input[@value='New Product Basket']")
	WebElement NewProductBasketButton;
	
	//@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[1]/header/div[4]/div[3]/span/button")
	//@FindBy(xpath = "//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[1]/header/div[4]/div[4]/span/button")
	@FindBy(xpath = "//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[1]/header/div[4]/div[6]/span/button")
	WebElement AddProductbutton;
	

	//@FindBy(xpath = ".//*[@id='a0F0E000001pwlZUAQ~a0Z0E000000FBmlUAG_anchor'][contains(text(), 'Company Fiber')]")
	@FindBy(xpath = "//*[@id=\'a0F0E000001pwlZUAQ~a0Z0E000000FBmlUAG_anchor\'][contains(text(), 'Company Fiber')]")
	WebElement CF_ProductSelection;

	//@FindBy(xpath = "//*[@id='a0F0E000001pwlWUAQ~a0Z0E000000FBmlUAG_anchor'][contains(text(), 'Company Internet')]")
	@FindBy(xpath = "//*[@id='a0F0E000001pwlWUAQ~a0Z0E000000FBmlUAG_anchor'][contains(text(), 'Company Internet')]")
	WebElement CI_ProductSelection;

	//@FindBy(xpath = "//*[@id='a0F0E000001pwlYUAQ~a0Z0E000000FBmiUAG_anchor'][contains(text(), 'WLAN')]")
	@FindBy(xpath = "//*[@id='a0F0E000001pwlYUAQ~a0Z0E000000FBmiUAG_anchor'][contains(text(), 'WLAN')]")
	WebElement CI_PowerspotProductSelection;
		
	@FindBy(xpath = "//li[@class='ng-binding ng-scope'][contains(text(), 'Address')]")
	WebElement Addressbarselection;
	
	@FindBy(xpath = "//button[@class='btn lookup icon icon-search']")
	WebElement CustomerAddressSearchbutton;
	
	@FindBy(xpath = "html/body/div[2]/div[2]/div/div[3]/div[1]/div/div[2]/div/md-content/md-virtual-repeat-container/div/div[2]/div/div/div[1]")
	WebElement SearchedAddressSelection;

	@FindBy(xpath = "//button[@class='btn label icon-add']")
	WebElement AddtoBasketbutton;

	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li/div/div/div/div[1]/div/div[4]/div/a")
	WebElement Added_CF_ProductConfirmation;
	
	@FindBy(xpath = "//*[@id=\'a0F0E000001pwlaUAA~a0Z0E000000FBmkUAG_anchor\'][contains(text(), 'Company Voice')]")
	WebElement CV_ProductSelection;
	
	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li[2]/div/div/div/div[1]/div/div[4]/div/a")
	WebElement Added_CV_ProductConfirmation;
	
	@FindBy(xpath = "//*[@id=\'a0F0E000001pwlbUAA~a0Z0E000000FBmpUAG_anchor\'][contains(text(), 'Office')]")
	WebElement OI_ProductSelection;
	
	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li/div/div/div/div[1]/div/div[4]/div/a")
	WebElement Added_OI_ProductConfirmation;
	
	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li/div/div/div/div[1]/div/div[4]/div/a")
	WebElement Added_CI_ProductConfirmation;
	
	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li[2]/div/div/div/div[1]/div/div[4]/div/a")
	WebElement Added_CI_PowerSpot_ProductConfirmation;
	
	public ProductBasketAddition(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void CF_ProductbasketAddition(WebDriver driver) throws InterruptedException {
		try{
		waitForElement(driver, 20, NewProductBasketButton);
		scrollTo(driver, NewProductBasketButton);
		NewProductBasketButton.click();
		log("New product basket button clicked in opportunity page");
		}
		catch (Exception e){
			
		}
		
		Thread.sleep(4000);
		scrollTo(driver, AddProductbutton);
		//waitForElement(driver, 200, AddProductbutton);
		AddProductbutton.click();
		log("Addproduct button clicked in product configuration page");
		waitForclickable(driver, CF_ProductSelection, 200);
		CF_ProductSelection.click();
		log("CF product selected");
		Thread.sleep(2000);
		waitForElement(driver, 200, Addressbarselection);
		//scrollTo(driver, Addressbarselection);
		Addressbarselection.click();
		log("Address bar clicked");
		waitForElement(driver, 200, CustomerAddressSearchbutton);
		CustomerAddressSearchbutton.click();
		log("Customer Address search button clicked successfully");
		//waitForElement(driver, 200, SearchedAddressSelection);
		//SearchedAddressSelection.click();
		Thread.sleep(10000);
		waitForElement(driver, 200, AddtoBasketbutton);
		AddtoBasketbutton.click();
		log("Customer Address successfully selected");
		Thread.sleep(10000);
		waitForElement(driver, 200, Added_CF_ProductConfirmation);
		scrollTo(driver, Added_CF_ProductConfirmation);
		CF_Added_productConfirmation();
		log("Successfully added product to the basket and also confirmed");
		Thread.sleep(5000);
				
	}
	
	public boolean CF_Added_productConfirmation(){
		try {
			Added_CF_ProductConfirmation.isDisplayed();
			return true;
		} catch (Exception e) {
		   return false;
		}
	}

	
	public void CV_ProductbasketAddition(WebDriver driver) throws InterruptedException {
		
		/*waitForElement(driver, 200, NewProductBasketButton);
		NewProductBasketButton.click();
		log("New product basket button clicked in opportunity page");*/
		Thread.sleep(5000);
		scrollTo(driver, AddProductbutton);
		waitForElement(driver, 200, AddProductbutton);
		AddProductbutton.click();
		log("Addproduct button clicked in product configuration page");
		waitForElement(driver, 200, CV_ProductSelection);
		scrollTo(driver, CF_ProductSelection);
		CV_ProductSelection.click();
		log("CV product selected");
		waitForElement(driver, 200, Addressbarselection);
		//scrollTo(driver, Addressbarselection);
		Thread.sleep(2000);
		Addressbarselection.click();
		
		log("Address bar clicked");
		waitForElement(driver, 200, CustomerAddressSearchbutton);
		CustomerAddressSearchbutton.click();
		log("Customer Address search button clicked successfully");
		//waitForElement(driver, 200, SearchedAddressSelection);
		//SearchedAddressSelection.click();
		Thread.sleep(10000);
		waitForElement(driver, 200, AddtoBasketbutton);
/*	log("Address bar clicked");
		waitForElement(driver, 200, CustomerAddressSearchbutton);
		CustomerAddressSearchbutton.click();
		log("Customer Address search button clicked successfully");
		waitForElement(driver, 200, SearchedAddressSelection);
		//SearchedAddressSelection.click();
		Thread.sleep(2000);
		waitForElement(driver, 200, AddtoBasketbutton);*/
		AddtoBasketbutton.click();
		log("Customer Address successfully selected");
		waitForElement(driver, 200, Added_CV_ProductConfirmation);
		CV_Added_productConfirmation();
		log("Successfully added product to the basket and also confirmed");
		Thread.sleep(5000);
					
	}
	
	public boolean CV_Added_productConfirmation(){
		try {
			Added_CV_ProductConfirmation.isDisplayed();
			return true;
		} catch (Exception e) {
		   return false;
		}
	}

	
public void OI_ProductbasketAddition(WebDriver driver) throws InterruptedException {
		try{		
				waitForElement(driver, 200, NewProductBasketButton);
				scrollTo(driver, NewProductBasketButton);
				NewProductBasketButton.click();
				log("New product basket button clicked in opportunity page");
		}
		catch (Exception e){
		}
		Thread.sleep(5000);
		waitForElement(driver, 200, AddProductbutton);
		scrollTo(driver, AddProductbutton);
		AddProductbutton.click();
		log("Addproduct button clicked in product configuration page");
		waitForElement(driver, 200, OI_ProductSelection);
		scrollTo(driver, OI_ProductSelection);
		OI_ProductSelection.click();
		log("OI product selected");
		waitForElement(driver, 200, Addressbarselection);
		//scrollTo(driver, Addressbarselection);
		Thread.sleep(2000);
		Addressbarselection.click();
		log("Address bar clicked");
		
		log("Address bar clicked");
		waitForElement(driver, 200, CustomerAddressSearchbutton);
		CustomerAddressSearchbutton.click();
		log("Customer Address search button clicked successfully");
		//waitForElement(driver, 200, SearchedAddressSelection);
		//SearchedAddressSelection.click();
		Thread.sleep(10000);
		waitForElement(driver, 200, AddtoBasketbutton);
		
		/*waitForElement(driver, 200, CustomerAddressSearchbutton);
		CustomerAddressSearchbutton.click();
		log("Customer Address search button clicked successfully");
		waitForElement(driver, 200, SearchedAddressSelection);
		//SearchedAddressSelection.click();
		Thread.sleep(2000);
		waitForElement(driver, 200, AddtoBasketbutton);*/
		AddtoBasketbutton.click();
		log("Customer Address successfully selected");
		waitForElement(driver, 200, Added_OI_ProductConfirmation);
		OI_Added_productConfirmation();
		log("Successfully added product to the basket and also confirmed");
		Thread.sleep(5000);
					
	}
	
	public boolean OI_Added_productConfirmation(){
		try {
			Added_OI_ProductConfirmation.isDisplayed();
			return true;
		} catch (Exception e) {
		   return false;
		}
	}
	
	public void genericCI_ProductbasketAddition(WebDriver driver) throws InterruptedException {
		try{
		waitForElement(driver, 20, NewProductBasketButton);
		scrollTo(driver, NewProductBasketButton);
		NewProductBasketButton.click();
		}
		catch (Exception e){
			
		}
		log("New product basket button clicked in opportunity page");
		Thread.sleep(2000);
		scrollTo(driver, AddProductbutton);
		waitForElement(driver, 200, AddProductbutton);
		AddProductbutton.click();
		log("Addproduct button clicked in product configuration page");
		waitForclickable(driver, CI_ProductSelection, 200);
		CI_ProductSelection.click();
		log("CI product selected");
		Thread.sleep(2000);
		waitForElement(driver, 200, Addressbarselection);
		//scrollTo(driver, Addressbarselection);
		Addressbarselection.click();
		log("Address bar clicked");
		waitForElement(driver, 200, CustomerAddressSearchbutton);
		CustomerAddressSearchbutton.click();
		log("Customer Address search button clicked successfully");
		//waitForElement(driver, 200, SearchedAddressSelection);
		//SearchedAddressSelection.click();
		Thread.sleep(10000);
		waitForElement(driver, 200, AddtoBasketbutton);
		AddtoBasketbutton.click();
		log("Customer Address successfully selected");
		Thread.sleep(10000);
		waitForElement(driver, 200, Added_CI_ProductConfirmation);
		scrollTo(driver, Added_CI_ProductConfirmation);
		CI_Added_productConfirmation();
		log("Successfully added product to the basket and also confirmed");
		Thread.sleep(5000);
	}
	
	public boolean CI_Added_productConfirmation(){
		try {
			Added_CI_ProductConfirmation.isDisplayed();
			return true;
		} catch (Exception e) {
		   return false;
		}
	}
	public void genericCI_Powerspot(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		//waitForElement(driver, 200, NewProductBasketButton);
		//scrollTo(driver, NewProductBasketButton);
		//NewProductBasketButton.click();
		scrollTo(driver, AddProductbutton);
		waitForElement(driver, 200, AddProductbutton);
		AddProductbutton.click();
		log("Addproduct button clicked in product configuration page");
		Thread.sleep(2000);
		scrollTo(driver, CI_PowerspotProductSelection);
		waitForclickable(driver, CI_PowerspotProductSelection, 200);
		CI_PowerspotProductSelection.click();
		log("CI Powerspot  selected");
		Thread.sleep(2000);
		waitForElement(driver, 200, Addressbarselection);
		Addressbarselection.click();
		log("Address bar clicked");
		waitForElement(driver, 200, CustomerAddressSearchbutton);
		CustomerAddressSearchbutton.click();
		log("Customer Address search button clicked successfully");
		//waitForElement(driver, 200, SearchedAddressSelection);
		//SearchedAddressSelection.click();
		Thread.sleep(10000);
		waitForElement(driver, 200, AddtoBasketbutton);
		AddtoBasketbutton.click();
		log("Customer Address successfully selected");
		Thread.sleep(10000);
		waitForElement(driver, 200, Added_CI_PowerSpot_ProductConfirmation);
		CI_Powerspot_Added_productConfirmation();
		log("Successfully added product to the basket and also confirmed");
		Thread.sleep(5000);
	}
	public boolean CI_Powerspot_Added_productConfirmation(){
		try {
			Added_CI_PowerSpot_ProductConfirmation.isDisplayed();
			return true;
		} catch (Exception e) {
		   return false;
		}
	}
}
