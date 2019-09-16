package com.test.automation.OM_Automation.uiActions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class InstallationInformation extends TestBase {
	
	public static final Logger log = Logger.getLogger(InstallationInformation.class.getName());
	
	WebDriver driver;
	
	public final String Technicalcontactframe = "resultsFrame";

	@FindBy(xpath = "//*[@id=\"bodyCell\"]/div/div/div[3]/div[2]/div[1]/div/header/div[5]/span/button")
	WebElement Installationinformationicon;
	
	@FindBy(xpath = ".//*[@id='LG_InstallationInformation:j_id6:globalTechnicalContact_lkwgt']/img")
	WebElement Technicalcontactlookup;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a")
	WebElement TechnicalContactSelect;

	@FindBy(xpath = "//button[@onclick='setAllTechnicalContactsAsGlobal()']")
	WebElement SetButton;

	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div[3]/div/div[2]/div/div[6]/div[2]/div/input[2]")
	WebElement WishdateID; 
	
		
	@FindBy(xpath = ".//*[@id='planneddate-a0s3E000000QCtOQAW']")
	WebElement PlannedDate; 
	
	@FindBy(xpath = "//button[@class='btn btn-warning']")
	WebElement SaveButton;
	
	@FindBy(name = "LG_InstallationInformation:j_id6:sitePanels:0:consultingId")
	WebElement ConsultingId;
	 
	@FindBy(name = "LG_InstallationInformation:j_id6:sitePanels:0:gnv")
	WebElement GNV;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div[3]/div/div[2]/div/ul/li[4]/a")
	WebElement ProductsButton;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/span/span/button")
	WebElement BGPbutton;
	
	@FindBy(name = "Announced_prefix_0")
	WebElement wellKnownPrefix;
	
	@FindBy(name = "BGP_Password_0")
	WebElement BGPPassword;
	
	@FindBy(name = "IPv4_PI_address_space_0")
	WebElement IPv4Addressspace;
	
	@FindBy(name = "IPv6_PI_address_space_0")
	WebElement IPv6Addressspace;

	@FindBy(xpath = "//*[@id='configurationContainer']/div/div/div/div/div[3]/div/button[2]")
	WebElement FinishButton;
	
	List<WebElement> abcs;
	
	public InstallationInformation(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Installation_Information(Map<String, String> dataSets) throws InterruptedException {
		String CF_AddonsToBeAdded=(String) dataSets.get("CF_AddonsToBeAdded");
		Thread.sleep(3000);		
		waitForclickable(driver, Installationinformationicon, 200);
		scrollTo(driver, Installationinformationicon);
		Installationinformationicon.click();
		log("Installation infomatio icon clicked");
		technicalcontactselect();
		log("Technical contact selected successfully");
		waitForclickable(driver, SetButton, 200);
		SetButton.click();
		log("Set button clicked successfully");
		 Thread.sleep(3000); 
		 ConsultingId.sendKeys("1324156489");
		 log("Consulting ID passed");
		 waitForElement(driver, 100, GNV);
		 dropdownselection(driver, GNV, "Erforderlich");
		 log("Industry classification as "+"Erforderlich"+" selected");
		 if (CF_AddonsToBeAdded.equals("BGP")){
			 log("Inside if loop of Installation");
			 ProductsButton.click();
			 log("ProductsButton is clicked");
			 Thread.sleep(5000);
			 waitForElement(driver, 100, BGPbutton);
			 BGPbutton.click();
			 Thread.sleep(10000);
             abcs = driver.findElements(By.tagName("iframe"));
             int i=0;
             String frameName=null;
             for (WebElement abc : abcs) {
                    i=i+1;
                    System.out.println("Frame Id :" + abc.getAttribute("id"));
                    log("Frame Id :" + abc.getAttribute("id"));
                    log("Value of i = "+i);
                    if (i==1) {
                          frameName=abc.getAttribute("id");
                          log("Frame Id finalized is" + frameName); 
                    }
             }
             driver.switchTo().frame(frameName);
    		 log("New Frame Switched");
    		 waitForElement(driver, 100, wellKnownPrefix);
    		 scrollTo(driver,wellKnownPrefix);
    		 dropdownselection(driver, wellKnownPrefix, "Full Table");
    		 log("wellKnownPrefix selected as " + "Full Table");
    		 waitForElement(driver, 100, BGPPassword);
    		 scrollTo(driver,BGPPassword);
    		 dropdownselection(driver, BGPPassword, "Ja");
    		 log("BGPPassword selected as " + "Ja");
    		 waitForElement(driver, 100, IPv4Addressspace);
    		 scrollTo(driver,IPv4Addressspace);
    		 dropdownselection(driver, IPv4Addressspace, "Ja");
    		 log("IPv4Addressspace selected as " + "Ja");
    		 waitForElement(driver, 100, IPv6Addressspace);
    		 scrollTo(driver,IPv6Addressspace);
    		 dropdownselection(driver, IPv6Addressspace, "Ja");
    		 log("IPv6Addressspace selected as " + "Ja");
    		 waitForElement(driver, 100, FinishButton);
    		 scrollTo(driver,FinishButton);
    		 FinishButton.click();
    		 log("Finish Button clicked");
    		 Thread.sleep(5000);
		 }
		 driver.switchTo().parentFrame();
		 //Thread.sleep(500000);
/*		waitForclickable(driver, WishdateID, 200);
		scrollTo(driver, WishdateID);
		doubleclick(driver, WishdateID);
		wish_planned_date(driver);
		log("Wish data selected");
		
	*/	waitForElement(driver, 200, SaveButton);
		scrollTo(driver, SaveButton);
		SaveButton.click();
		log("Save button clicked");
		Thread.sleep(5000);
	}
	
	public void technicalcontactselect() throws InterruptedException {
		
		waitForElement(driver, 200, Technicalcontactlookup);
		log("Technincal contact lookup selected");
		Technicalcontactlookup.click();// Technical contact lookup select
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> win1 = set1.iterator();
		String parent = win1.next();
		String child = win1.next();
		driver.switchTo().window(child);
		log(" new window switched");
		Thread.sleep(3000);
		//waituntilframeload(driver, TechnicalContactSelect, 200, Technicalcontactframe);
		driver.switchTo().frame("resultsFrame");
		log("resultsFrame switched");
		waitForElement(driver, 200, TechnicalContactSelect);
		TechnicalContactSelect.click();
		log("Technincal contact selected successfully");
		driver.switchTo().window(parent);
		log("parent window switched successfully");
		
		
	}
	
}