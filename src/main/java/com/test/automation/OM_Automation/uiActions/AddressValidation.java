package com.test.automation.OM_Automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class AddressValidation extends TestBase {
	
	public static final Logger log = Logger.getLogger(AddressValidation.class.getName());
	
	WebDriver driver;
	@FindBy(name = "validate_address")
	WebElement ValidateAddress;
	
	@FindBy(id = "j_id0:j_id1:UM_ValidateAddressComponent:j_id20:j_id21:btnFindAddress")
	WebElement FindAddress;

	@FindBy(id = "j_id0:j_id1:UM_ValidateAddressComponent:j_id54:suggection:j_id60:0:j_id62")
	WebElement AddressSelect;
	
	@FindBy(id = "0663E0000004GDJ")
	WebElement iframe;

	@FindBy(xpath = ".//*[@id='j_id0:j_id2:j_id3:serviceAvailabilityDisplay']")
	WebElement ServiceAvailabilty;
		
	public AddressValidation(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Addressvalidation() throws Exception
	{
		waitForElement(driver, 200, ValidateAddress);
		ValidateAddress.click();
		log("Validate Address clicked");
		waitForElement(driver, 200, FindAddress);
		FindAddress.click();
		log("FindAddress clicked");
		Thread.sleep(3000);
		//waitForElement(driver, 200, AddressSelect);
		AddressSelect.click();
		log("Address selected");
		//Serviceavailabilitycheck();
		//getScreenShot("AddressValidation");
		log("Available to provide service");
}

	private void Serviceavailabilitycheck() {
		waitForElement(driver, 200, iframe);
		driver.switchTo().frame("0663E0000004GDJ");
		scrollTo(driver, ServiceAvailabilty);
		getScreenShot("AddressValidation");
		serviceavailablityconfirmation();
		log("Service available confirmation");
		driver.switchTo().defaultContent();
		log("parent window switched");
		
		
	}
	
	public boolean serviceavailablityconfirmation(){
		try {
			ServiceAvailabilty.isDisplayed();
			return true;
		} catch (Exception e) {
		   return false;
		}
	}

}
