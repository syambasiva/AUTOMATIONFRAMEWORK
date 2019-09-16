package com.test.automation.OM_Automation.uiActions;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class Logout  extends TestBase {  
	@FindBy(xpath=".//*[@id='userNavLabel']")
	WebElement userlabel;
	
	@FindBy(xpath=".//*[@id='userNav-menuItems']/a[2]")
	WebElement logout;
	
	@FindBy(xpath=".//*[@id='userNavLabel']")
	WebElement userlabel1;
	
	@FindBy(xpath=".//*[@id='userNav-menuItems']/a[4]")
	WebElement logout1;
	
	
	
	public Logout(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginHandlers(Map<String, String> dataSheetTestDataEnv,String LogoutHandler) throws Exception{
	    if (LogoutHandler.equals("Logout")) {
	    	logOutGeneric();
	    }
	    else if(LogoutHandler.equals("LogoutDualTabs")) {
	    	Logout();
	    }

	}
		   public void Logout() throws Exception {
			 Thread.sleep(3000);
			 logOutGeneric();
			 Thread.sleep(10000);
			 BrowserTabSwitch(driver);
				driver.close();
			//BrowserMainTabSwitchBack(driver);
			 BrowserMainTabSwitchBack(driver);
			 log("Window is switched");
			 Thread.sleep(3000);
			 logOutGeneric();
			 Thread.sleep(3000);		 
			 
	}
		   public void logOutGeneric() throws Exception {
				 waitForElement(driver, 200, userlabel);
				 userlabel.click();
				 log("Partner window userlabel is clicked");
				 Thread.sleep(3000);
				 logOutSelection("Logout",driver);
				 Thread.sleep(3000);
		   }
		   
}
