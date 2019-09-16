package com.test.automation.OM_Automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.automation.OM_Automation.testBase.TestBase;

public class LoginPage extends TestBase {
	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	WebDriver driver;
	
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement userpassword;

	@FindBy(id = "Login")
	WebElement loginbutton;
	
		
	@FindBy(id="error")
	WebElement authenticationFailed;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		//testBase = new TestBase();
		PageFactory.initElements(driver, this);
	}
	
	public void logintoSalesforce(String userName, String password){
		try {
			System.out.println("Hi the test name "+ userName);
			System.out.println("Hi the test name "+ password);
		Thread.sleep(1000);
		System.out.println("Hi the test name "+ userName);
		System.out.println("Hi the test name "+ password);
		username.sendKeys(userName);
		System.out.println("Hi the test name "+ userName);
		System.out.println("Hi the test name "+ password);
		log("entered email address:-"+userName+" and object is "+username.toString());
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
	
	public void verifyloginsuccesssmessage() {
		waitForElement(driver, 200, driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a")));
		driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a")).isDisplayed();
		//System.out.println(text);
		
	}
	
	public String getInvalidLoginText(){
		authenticationFailed.getText();
		return authenticationFailed.getText();
	}

	
	

}
