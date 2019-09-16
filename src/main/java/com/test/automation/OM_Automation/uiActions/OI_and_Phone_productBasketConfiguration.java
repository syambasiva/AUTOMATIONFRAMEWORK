package com.test.automation.OM_Automation.uiActions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class OI_and_Phone_productBasketConfiguration extends TestBase {
	
public static final Logger log = Logger.getLogger(CF_ProductBasketConfiguration.class.getName());
	
	WebDriver driver;
	public final String StateName 								= "NRW";
	
	

	
	@FindBy(xpath = ".//*[@id='bodyCell']/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li/div/div/div/div[1]/div/div[1]/button[2]")
	WebElement Editbasketbutton;
	
	@FindBy(xpath = ".//*[@id='ngdialog2']/div[2]/div/div[1]/header/div/button")
	WebElement productbasketclosebutton;
	
	@FindBy(xpath = "//select[@name='Product_Type_0']")
	WebElement ProductDropdownSelection;
	
	@FindBy(xpath = ".//*[@id='Allgemeine_Informationen:State_0']")
	WebElement Statedropdown;
	
	@FindBy(xpath = ".//*[@id='j_id0:j_id2:0:j_id3:0:j_id6:2:j_id8:5:j_id15']/div/div[2]/span[1]/a")
	WebElement phoneAddButton;
	
	//@FindBy(xpath = ".//*[@id='j_id0:j_id2:0:j_id3:0:j_id6:1:j_id8:0:j_id15']/div/div[2]/label/span/span[2]")
	//WebElement NewNumbercheckbox;
	
	@FindBy(xpath = ".//*[@id='j_id0:j_id2:0:j_id3:0:j_id6:1:j_id8:0:j_id15']/div/div[2]/label/span/span[2]")
	WebElement NewNumbercheckbox;
		
	@FindBy(xpath = ".//*[@id='Allgemeine_Informationen:Number_Of_New_Phone_Numbers_0']")
	WebElement CountOfNumbers;
	
	@FindBy(xpath = ".//*[@id='configurationContainer']/div/div/div/div/div[3]/div/button[2]")
	WebElement ContinueButton;
	
	@FindBy(xpath = ".//*[@id='Allgemeine_Informationen:Product_Description_0']")
	WebElement VerifyAddedPhone;
	
	@FindBy(xpath = ".//*[@id='configurationContainer']/div/div[1]/div/div/div[3]/div/button[2]")
	WebElement Finishbutton;
	
	@FindBy(xpath="//*[@id=\"Allgemeine_Informationen:Market_Segment_0\"]")
	WebElement MarketSegment;
	
	
	public OI_and_Phone_productBasketConfiguration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

public void genericOIPhoneProductConfiguration(Map<String, String> dataSets) throws Exception {
	    String uploadspeedvalue=(String) dataSets.get("OI_Phone_Productuploadspeedvalue");
	    String segment=(String) dataSets.get("segment");
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
		Thread.sleep(10000);
		/*
		waitForElement(driver, 200, MarketSegment);
		dropdownselectionbyvalue(driver, MarketSegment, segment);
		Thread.sleep(5000);
		scrollTo(driver, ProductDropdownSelection);
		//waitForElement(driver, 200, ProductDropdownSelection);
		dropdownselectionbyvalue(driver, ProductDropdownSelection, uploadspeedvalue);
		log("Office Internet with"+uploadspeedvalue+" Product selected");
		*/
		scrollTo(driver, ProductDropdownSelection);
		//waitForElement(driver, 200, ProductDropdownSelection);
		dropdownselectionbyvalue(driver, ProductDropdownSelection, uploadspeedvalue);
		log("Office Internet with "+uploadspeedvalue+" Product selected");
		ProductDropdownSelection.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		waitForElement(driver, 200, MarketSegment);
		dropdownselectionbyvalue(driver, MarketSegment, segment);
		Thread.sleep(3000);
		//waitForElement(driver, 200, Finishbutton);
		waitForElement(driver, 200, phoneAddButton);
		scrollTo(driver, phoneAddButton);
		phoneAddButton.click();
		log("Phone add button clicked");
		Thread.sleep(15000);
		//waitForElement(driver, 200, NewNumbercheckbox);
		scrollTo(driver, NewNumbercheckbox);
		NewNumbercheckbox.click();
		try{
			System.out.println("inside try block");
			                if (!NewNumbercheckbox.isSelected())
			                {                    
			                	System.out.println("inside if block");
			                	NewNumbercheckbox.sendKeys(Keys.SPACE);
			                }
			            }
			            catch (Exception e)
			            {

			            }
		log("New number add check box clicked");
		Thread.sleep(3000);
		waitForElement(driver, 200, CountOfNumbers);
		CountOfNumbers.sendKeys("8");
		log("Count of numbers entered");
		waitForElement(driver, 200, ContinueButton);
		ContinueButton.click();
		log("Continue button clicke in phone configuration page");
		Thread.sleep(3000);
		waitForElement(driver, 200, VerifyAddedPhone);
		log("Added phone configuration successfully verified");
		Thread.sleep(3000);
		scrollTo(driver, Finishbutton);
		Finishbutton.click();
		log("Finish button clicked");
		parentwindowreturn(driver);
		log("parent window switched");
		Thread.sleep(5000);	
}
}
