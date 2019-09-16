package com.test.automation.OM_Automation.uiActions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class OtherLogins  extends TestBase{
public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	WebDriver driver;
	
	@FindBy(id = "username")
	WebElement usernameEditBox;

	@FindBy(id = "password")
	WebElement userpassword;

	@FindBy(id = "Login")
	WebElement loginbutton;
	
		
	@FindBy(id="error")
	WebElement authenticationFailed;
	

	@FindBy(xpath=".//*[@id='Lead_Tab']/a")
	WebElement leadbutton;
	
	public OtherLogins(WebDriver driver){
		this.driver = driver;
		//testBase = new TestBase();
		PageFactory.initElements(driver, this);
	}
	
	public void loginHandlers(Map<String, String> dataSheetTestDataEnv,String LoginAccount) throws Exception {
	    if (LoginAccount.equals("Director1PAM1Partner1Login")) {
	    	logintoSalesforce(dataSheetTestDataEnv);
	    }
	    else if(LoginAccount.equals("Director1PAM1Login")) {
	    	logintoSalesforceAsPAM(dataSheetTestDataEnv);
	    }
	    else if(LoginAccount.equals("Director1PAM2Partner1Login")) {
	    	logintoSalesforceasPartner2(dataSheetTestDataEnv);
	    }
	    else if(LoginAccount.equals("Director1PAM1Partner2Login")) {
	    	logintoSalesforcePAM1Partner2(dataSheetTestDataEnv);
	    }
	    else if(LoginAccount.equals("Director1PAM2Login")) {
	    	logintoSalesforceAsPAM2(dataSheetTestDataEnv);
	    }
	    else if(LoginAccount.equals("Director1SME1Login")) {
	    	logintoSalesforceAsDirectorSME1(dataSheetTestDataEnv);
	    }
	    else if(LoginAccount.equals("Director1WholesaleLogin")) {
	    	logintoSalesforceAsDirectorWholesale(dataSheetTestDataEnv);
	    }
	}
	
	public void logintoSalesforce(Map<String, String> dataSheetTestDataEnv){
		String PAM1_partner1_username=(String) dataSheetTestDataEnv.get("PAM1_partner1_username");
		String PAM1_partner1_password=(String) dataSheetTestDataEnv.get("PAM1_partner1_password");
	    String partner_url=(String) dataSheetTestDataEnv.get("partner_url");
		try {
		Thread.sleep(5000);
		openStringlinkinnewtab(driver,partner_url);
		Thread.sleep(5000);
		loginReusableGeneral(PAM1_partner1_username,PAM1_partner1_password);
		}
		catch (Exception e) {
			log("Error occurs during login is "+e+"");
			
		}
			
	}
	public void logintoSalesforcePAM1Partner2(Map<String, String> dataSheetTestDataEnv){
		String PAM1_partner2_username=(String) dataSheetTestDataEnv.get("PAM1_partner2_username");
		String PAM1_partner2_password=(String) dataSheetTestDataEnv.get("PAM1_partner2_password");
	    String partner_url=(String) dataSheetTestDataEnv.get("partner_url");
		try {
		Thread.sleep(5000);
		openStringlinkinnewtab(driver,partner_url);
		Thread.sleep(5000);
		loginReusableGeneral(PAM1_partner2_username,PAM1_partner2_password);
		}
		catch (Exception e) {
			log("Error occurs during login is "+e+"");
			
		}
			
	}

	public void logintoSalesforceasPartner2(Map<String, String> dataSheetTestDataEnv){
		String PAM2_partner1_username=(String) dataSheetTestDataEnv.get("PAM2_partner1_username");
		String PAM2_partner1_password=(String) dataSheetTestDataEnv.get("PAM2_partner1_password");
	    String partner_url=(String) dataSheetTestDataEnv.get("partner_url");
		try {
		Thread.sleep(5000);
		openStringlinkinnewtab(driver,partner_url);
		Thread.sleep(5000);
		loginReusableGeneral(PAM2_partner1_username,PAM2_partner1_password);
		}
		catch (Exception e) {
			log("Error occurs during login is "+e+"");
			
		}
			
	}
	
	public void logintoSalesforceAsPAM(Map<String, String> dataSheetTestDataEnv) {
		String PAM1_username=(String) dataSheetTestDataEnv.get("PAM1_username");
		String PAM1_password=(String) dataSheetTestDataEnv.get("PAM1_password");
		BrowserMainTabSwitchBack(driver);
		loginReusableGeneral(PAM1_username,PAM1_password);
			
		}
	public void logintoSalesforceAsPAM2(Map<String, String> dataSheetTestDataEnv) throws Exception{
		String PAM2_username=(String) dataSheetTestDataEnv.get("PAM2_username");
		String PAM2_password=(String) dataSheetTestDataEnv.get("PAM2_password");
		 Thread.sleep(10000);
		 BrowserMainTabSwitchBack(driver);
		 log("Window is switched");
		loginReusableGeneral(PAM2_username,PAM2_password);
			
		}
	public void logintoSalesforceAsDirectorSME1(Map<String, String> dataSheetTestDataEnv) {
		String Director_SME1_username=(String) dataSheetTestDataEnv.get("Director_SME1_username");
		String Director_SME1_password=(String) dataSheetTestDataEnv.get("Director_SME1_password");
		BrowserMainTabSwitchBack(driver);
		loginReusableGeneral(Director_SME1_username,Director_SME1_password);
			
		}
	public void logintoSalesforceAsDirectorWholesale(Map<String, String> dataSheetTestDataEnv) {
		String DirectorWholesale_username=(String) dataSheetTestDataEnv.get("DirectorWholesale_username");
		String DirectorWholesale_password=(String) dataSheetTestDataEnv.get("DirectorWholesale_password");
		BrowserMainTabSwitchBack(driver);
		loginReusableGeneral(DirectorWholesale_username,DirectorWholesale_password);
			
		}
	
	public void verifyloginsuccesssmessage() {
		waitForElement(driver, 200, driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a")));
		driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a")).isDisplayed();
		//System.out.println(text);
		
	}
	
	public String getInvalidLoginText(){
		authenticationFailed.getText();
		return authenticationFailed.getText();
	}

	
     public void loginReusableGeneral(String username,String password) {
 		try {
			Thread.sleep(5000);
			usernameEditBox.sendKeys(username);
			log("entered email address:-"+username+" and object is "+usernameEditBox.toString());
			userpassword.sendKeys(password);
			log("entered password:-"+password+" and object is "+userpassword.toString());
			loginbutton.click();
			log("clicked on sublit butto and object is:-"+loginbutton.toString());
			Thread.sleep(15000);
			}
			catch (Exception e) {
				log("Error occurs during login is "+e+"");
				
			}
     }
}

