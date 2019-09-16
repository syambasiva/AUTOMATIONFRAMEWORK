package com.test.automation.OM_Automation.uiActions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.test.automation.OM_Automation.testBase.TestBase;
//import com.test.automation.OM_Automation.uiActions.SubOrders;

public class CloseSubOrder extends TestBase{
	
	public static final Logger log = Logger.getLogger(CloseSubOrder.class.getName());
	
	WebDriver driver;

	
	@FindBy(xpath = ".//*[@id='tsidButton']")
	WebElement Menulist;
	
	@FindBy(xpath = ".//*[@id='tsid-menuItems']/a[18]")
	WebElement FulfilmentConsole;

	@FindBy(xpath = ".//*[@id='phSearchInput']")
	WebElement SearchConsole;
	
	//Iframe need to perform
	
	@FindBy(xpath = ".//*[@id='Case_body']/table/tbody/tr[2]/th/a")
	WebElement SearchedCaseId;
	
	@FindBy(xpath = ".//*[@id='j_id0:Form:pb1:j_id87:bottom']/input[1]")
	WebElement EditButton;
	
	
	@FindBy(xpath = ".//*[@id='j_id0:Form:pb1:servicedetailssection:servicedetailstable:0:j_id83']/span/span/a")
	WebElement ActivationDateSelection;
	
	/*@FindBy(xpath = ".//*[@id='j_id0:Form:pb1:servicedetailssection:servicedetailstable:0:j_id85']/span/span/a")
	WebElemet Deactivationdate*/
	
	@FindBy(xpath = ".//*[@id='j_id0:j_id5:j_id32:j_id43:bottom']/input")
	WebElement CaseCloseButton;
	
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement userpassword;

	@FindBy(id = "Login")
	WebElement loginbutton;
		
		
		public void caseclosure() throws Exception, InterruptedException {
			
		init();
		waitForclickable(driver, username, 200);
		username.sendKeys("pprabakaran@lg.com.jit");
		waitForclickable(driver, userpassword, 200);
		userpassword.sendKeys("Prodapt@!4");
		waitForclickable(driver, loginbutton, 200);
		loginbutton.click();
		waitForElement(driver, 200, Menulist);
		Menulist.click();
		log("Menu list clicked");
		scrollTo(driver, FulfilmentConsole);
		waitForclickable(driver, FulfilmentConsole, 200);
		log("Fulfilment console selected");
		Thread.sleep(5000);
		waitForclickable(driver, SearchConsole, 200);
		SearchConsole.sendKeys("CASEID");
		log("caseID entered");
		Actions builder = new Actions(driver);
        Action enter= builder
                .keyDown(Keys.ENTER)
                .build();
        enter.perform();

        Action releaseEnter= builder
                .keyUp(Keys.ENTER)
                .build();
        releaseEnter.perform();	
        log("caseID searched in the search console");
        
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
