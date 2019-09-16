package com.test.automation.OM_Automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.test.automation.OM_Automation.testBase.TestBase;

public class OrderCompletion extends TestBase {
	public static final Logger log = Logger.getLogger(OrderCompletion.class.getName());	
	WebDriver driver;	
	public OrderCompletion(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@Test(priority = 1, dataProvider="loginData", testName = "Login validation")
	public void dummyremaneit() throws InterruptedException {
		//driver.navigate().back();
		

		//PageBack(driver);
		Thread.sleep(5000);
		String yourtext= driver.findElement(By.xpath("//*[@id=\"ep\"]/div[1]/table/tbody/tr/td[1]/h2")).getText() ;
		System.out.println("yourtext is"+ yourtext);
	}
}
