package com.test.automation.OM_Automation.uiActions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.OM_Automation.excelReader.WritingInExcel;
import com.test.automation.OM_Automation.testBase.TestBase;

public class ExistingAccountSelectMACDOrders extends TestBase {

	@FindBy(xpath = "//*[@id=\"tsidLabel\"]")
	WebElement verifySalesPage;	
	
	@FindBy(id = "phSearchInput")
	WebElement searchContentBox;
	
	@FindBy(xpath = "//*[@id=\"Account_body\"]/table/tbody/tr[2]/th/a")
	WebElement accountName;	
	
	@FindBy(xpath = "//*[@id=\"topButtonRow\"]/input[6]")
	WebElement changeSubscription;	
	
	@FindBy(xpath = "//*[@id=\"UM_MACDConfiguration:j_id8\"]/div[1]/div/h2")
	WebElement MACDConfiguration;	
	
	@FindBy(xpath = "//*[@id=\"macdTypeSelect\"]")
	WebElement selectMACDType;	

	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div[2]/div/div[4]/div[2]/div/input[1]")
	WebElement MACDTypeCheckBox;	

	@FindBy(xpath = "//*[@id=\"btnNext\"]")
	WebElement MACDNextButton;	
	
	@FindBy(xpath = ".//*[@id='Account_body']/table/tbody/tr[2]/th/a")
	WebElement accountname;	


	@FindBy(xpath = "//*[@id=\"searchResultsWarningMessageBox\"]/table/tbody/tr/td[2]/div")
	WebElement warningMessage;	
	
	//*[@id="0064E000005yqvf_00N58000005xYmh_body"]/table/tbody/tr[2]/th/a

	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[5]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	                 //html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[5]/div[1]/div/div[2]/table/tbody/tr[2]/th/a
	WebElement openExistingProductBasket;
	
	public ExistingAccountSelectMACDOrders(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openExistingAccount(Map<String, String> dataSets,String TestName) throws Exception{
		String accountname=(String) dataSets.get("accountname");
		String DependantTestCase=(String) dataSets.get("DependantTestCase");
		String pageStatus = verifySalesPage.getText();
		System.out.println("page logged in is "+pageStatus);
		if(!pageStatus.equals("Unitymedia Business"))
		{
            verifySalesPage.click();
            Thread.sleep(2000);
            Outer:for (int i = 0;i<25;i++) {
                   String a=String.valueOf(i);
                   try {
                   String abc=driver.findElement(By.xpath("//*[@id=\"tsid-menuItems\"]/a["+a+"]")).getText();
                   if (abc.equals("Unitymedia Business")) {
                         driver.findElement(By.xpath("//*[@id=\"tsid-menuItems\"]/a["+a+"]")).click();
                         break Outer;
                   }
                   System.out.println(abc);
                   }
                   catch (Exception e){
                   }
            }
            Thread.sleep(5000);
		}
		searchContentBox.click();
		WritingInExcel Wr=new WritingInExcel();
		String accountnameruntime=Wr.GetDependancyData(DependantTestCase);
		//String accountnameruntime="dIPvoZIJ";
		System.out.println("thehsskjhsd " +DependantTestCase);
        searchContentBox.sendKeys(accountnameruntime);
		//searchContentBox.sendKeys("IDkHatHh");
		searchContentBox.sendKeys(Keys.ENTER);
		log("Searched Account name successfully");
		}
	
public void MACDNavigation(Map<String, String> dataSets,String TestName,String MacdActivity) throws Exception{
	waitForElement(driver, 200, accountName);
	accountName.click();
	log("Account Name Selected");
	waitForElement(driver, 200, changeSubscription);
	changeSubscription.click();
	log("changeSubscription button clicked");
	waitForElement(driver, 200, MACDConfiguration);
	String tempValidation=MACDConfiguration.getText();
	if (tempValidation.equals("MACD Configuration")){
		log("MACD Configuration text found in screen");	
	}
	else {
		log("MACD Configuration text  NOT found in screen");
	}
	scrollTo(driver, selectMACDType);
	waitForElement(driver, 100, selectMACDType);
	dropdownselection(driver, selectMACDType, MacdActivity);
	log("MACD change selected");	
	scrollTo(driver, MACDTypeCheckBox);
	waitForElement(driver, 100, MACDTypeCheckBox);
	MACDTypeCheckBox.click();
	log("MACD Subscriptions selected");
	scrollTo(driver, MACDNextButton);
	waitForElement(driver, 100, MACDNextButton);
	MACDNextButton.click();
	Thread.sleep(25000);
	log("MACD Next button selected");
	//Thread.sleep(50000);
	scrollTo(driver, openExistingProductBasket);
	waitForElement(driver, 100, openExistingProductBasket);
	openExistingProductBasket.click();
	log("Product basket opened");
	Thread.sleep(5000);
}

public void PartnerAccountOpen(String accountnameruntime,String positNegtivValidation) throws InterruptedException {
    searchContentBox.sendKeys(accountnameruntime);
	//searchContentBox.sendKeys("IDkHatHh");
	searchContentBox.sendKeys(Keys.ENTER);
	log("Searched Account name successfully");
	
	if (positNegtivValidation.equals("Positive")) {
		String temp=accountname.getText();
		Assert.assertEquals(temp, accountnameruntime);
	
	}
	else if (positNegtivValidation.equals("Negative")) {
		String temp=warningMessage.getText();
		Assert.assertEquals(temp, "No matches found");	
	}
	log("Searched Account name and Created accname are equal");
	Thread.sleep(2000);
}

public void DirectorAccountOpen(String accountnameruntime,String positNegtivValidation) throws InterruptedException {
    searchContentBox.sendKeys(accountnameruntime);
	//searchContentBox.sendKeys("IDkHatHh");
	searchContentBox.sendKeys(Keys.ENTER);
	log("Searched Account name successfully");
	
	if (positNegtivValidation.equals("Positive")) {
		String temp=accountname.getText();
		Assert.assertEquals(temp, accountnameruntime);	
			}
	else if (positNegtivValidation.equals("Negative")) {
		String temp=warningMessage.getText();
		Assert.assertEquals(temp, "No matches found");	
	}
	log("Searched Account name and Created accname are equal");
	Thread.sleep(2000);
}
}


