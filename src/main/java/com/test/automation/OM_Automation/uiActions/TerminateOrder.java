package com.test.automation.OM_Automation.uiActions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.testBase.TestBase;

public class TerminateOrder extends TestBase {

	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath = ".//*[@id='ngdialog1']/div[2]/div/div[1]/header/div/button")
	WebElement productbasketclosebutton;
	
	@FindBy(name = "Contract_Termination_Reason_0")
	WebElement VertragsbeendigungGrund;
	
	@FindBy(name = "One_Off_Price_0")
	WebElement Vertragskndigungsgebhr;
	
	@FindBy(xpath = "html/body/div[4]/div/div[1]/div/div/div[1]/div/button[2]")
	WebElement Finishbutton;
	
	
	public TerminateOrder(WebDriver driver){
		this.driver = driver;
		//testBase = new TestBase();
		PageFactory.initElements(driver, this);
	}
	
	
	public void SingleOrderTermination(Map<String, String> dataSets,String TestName) throws Exception{
		try {
			findEditButtonBasedOnTextXpathHardcoded("Terminate Office Internet",driver);			
		}
		catch (Exception e)
		{
			findEditButtonBasedOnTextXpathHardcoded("Terminate Company Internet",driver);
		}
		waitForElement(driver, 200, productbasketclosebutton);
		iframeswitch(driver, 1);
		log("Iframe switched");
		waitForElement(driver, 200, VertragsbeendigungGrund);
		scrollTo(driver, VertragsbeendigungGrund);
		dropdownselectionbyvalue(driver, VertragsbeendigungGrund, "Insolvenz");
		waitForElement(driver, 200, Vertragskndigungsgebhr);
		scrollTo(driver, Vertragskndigungsgebhr);
		Vertragskndigungsgebhr.sendKeys("2");
		Vertragskndigungsgebhr.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		waitForElement(driver, 200, Finishbutton);
		scrollTo(driver, Finishbutton);
		Finishbutton.click();
        log("CF product configuration finsh button clicked");
		parentwindowreturn(driver);
		log("parent window switched");
		Thread.sleep(5000);
	}
	
}
