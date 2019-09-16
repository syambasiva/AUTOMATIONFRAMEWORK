package com.test.automation.OM_Automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class BasketUpload extends TestBase{
	
	public static final Logger log = Logger.getLogger(BasketUpload.class.getName());
	
WebDriver driver;
		
@FindBy(xpath = "//*[@id=\"bodyCell\"]/div/div/div[3]/div[2]/div[1]/div/header/div[3]/span/button")
WebElement UploadBasket;
	
	public BasketUpload(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void uploadProduceBasket() throws Exception{
		
			waitForElement(driver, 200, UploadBasket);
			UploadBasket.click();
			log("Product Basket Successfully uploaded");
			Thread.sleep(8000);
	}

}
