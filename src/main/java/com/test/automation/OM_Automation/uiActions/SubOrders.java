package com.test.automation.OM_Automation.uiActions;

//import java.awt.List;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.OM_Automation.testBase.TestBase;

public class SubOrders extends TestBase {

	public static final Logger log = Logger.getLogger(ValidateOrder.class.getName());
	WebDriver driver;
	String caseID;
	String stagevalue;
	String frameOne;
	String frameTwo;
	String frameNew;
	String DummyFramename;
	String orderSavemessage;
	String url;
	String srtCompletedOrderStatus;
	
    @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[7]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
    WebElement CreatedOrder;

	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[6]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	WebElement CreatedSubOrder;

	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[7]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	WebElement OrchestrationProcesslink;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@value='Process Visualiser']")
	WebElement ProcessVisualizerButton;

	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[6]/div[1]/div/div[2]/table/tbody/tr[2]/td[5]")
	WebElement CreatedCaseStatus;
	
    //@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[8]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
    @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[6]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
    WebElement CreatedCaseID;
	

	@FindBy(xpath = "//*[@id='tsidButton']")
	WebElement webpagesectiontype;

	@FindBy(xpath = "//*[@id=\"tsid-menuItems\"]/a[1]")
	WebElement Fulfilmentlink;

	@FindBy(xpath = "//*[@id='tsid-menuItems']/a[1]")
	WebElement saleslink;

	@FindBy(xpath = "//*[@id='phSearchInput']")
	WebElement FulfilmentSearchBox;

	@FindBy(xpath = "//*[@id='Case_body']/table/tbody/tr[2]/th/a")
	WebElement caseIdClickableLink;

    //@FindBy(name = "j_id0:Form:pb1:j_id100:j_id101")
	@FindBy(name = "j_id0:Form:pb1:j_id126:j_id127")
    WebElement caseIdEditDetailsButton;

    @FindBy(name = "j_id0:Form:pb1:j_id126:bottom:j_id129")
    WebElement caseIdSaveDetailsButton;

	@FindBy(xpath = "//*[@id='phSearchInput:group0:option0']/strong")
	WebElement searchAutosuggestionCaseId;

	@FindBy(name = "j_id0:Form:pb1:servicedetailssection:servicedetailstable:0:activationdate")
	WebElement addActivationDate;

	@FindBy(name = "j_id0:Form:pb1:servicedetailssection:servicedetailstable:1:activationdate")
	WebElement addActivationDateNew;
	
	@FindBy(name = "j_id0:Form:pb1:servicedetailssection:servicedetailstable:2:activationdate")
	WebElement addActivationDate3;
	
    @FindBy(name = "j_id0:j_id5:j_id32:j_id44:j_id45")
    WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"j_id0:j_id5:j_id6:j_id7:j_id8:0:j_id9\"]/div")
    WebElement saveSuccessMsg;

	@FindBy(xpath = "//*[@id=\"00N58000005xcnG_ileinner\"]")
	WebElement completedOrderStatus;

	@FindBy(xpath = "//*[@id='j_id0:Form:pb1:j_id54:j_id65']")
	WebElement phoneAccountNumer;

	@FindBy(xpath = "//*[@id=\'tsidLabel\']")
	WebElement verifySalesPage;

	@FindBy(xpath = "//*[@id=\"Case_body\"]/table/tbody/tr[2]/th/a")
	WebElement caseIdSearchOutputInConsoleTable;
	
	@FindBy(xpath = "//*[@id=\'secondSearchButton\']")
	WebElement caseIdSearchButton222;

	@FindBy(xpath = "//*[@id=\"topButtonRow\"]/input[3]")
	WebElement ReconfigureWelcomePackButton;

	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div")
	WebElement MACAddressEnabler;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]/input")
	WebElement MACAddressField;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[5]/td[2]/div")
	WebElement NetworkIPAddressEnabler;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[5]/td[2]/div[2]/input")
	WebElement NetworkIPAddressField;
	
	@FindBy(xpath = "html/body/div/div[2]/table/tbody/tr/td[2]/div[4]/div[1]/table/tbody/tr/td[2]/input[1]")
	WebElement SaveButton;

	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/div[6]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	WebElement HardwareOptionButton;

	@FindBy(xpath = ".//*[@id='opp11_ileinner']")
	WebElement OrderStageValidation;
	
	//@FindBy(name = "j_id0:Form:pb1:servicedetailssection:servicedetailstable:0:deactivationdate")
		@FindBy(xpath = "//*[@id=\"j_id0:Form:pb1:servicedetailssection:servicedetailstable:0:j_id123\"]/span/span/a")
		WebElement addDeAtivationDate;
		
	    @FindBy(name = "j_id0:Form:pb1:j_id125:bottom:j_id128")
	    WebElement saveButton2;
	
    String suborderLinkOpeningTag="html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[6]/div[1]/div/div[2]/table/tbody/tr[";
	String suborderLinkClosingTag="]/th/a";
	String pageNavigationDropDownOpeningTag="//*[@id=\"tsid-menuItems\"]/a[";
	String pageNavigationDropDownClosingTag="]";
	List<WebElement> abcs;
	
	public SubOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CreatedOrderValidationGeneric(Map<String, String> dataSets,String TestName) throws InterruptedException {
		String tempDecisionMaker=null;
		String CI_OrderType=(String) dataSets.get("CI_OrderType");
		String OverallType=(String) dataSets.get("OverallType");
		WebElement tempSuborder = null;
		waitForclickable(driver, OrderStageValidation, 200);
		OrderStageValidation();
		log("Order stage is validated ");
		waitForclickable(driver, CreatedOrder, 200);
		scrollTo(driver, CreatedOrder);
		Thread.sleep(2000);
		CreatedOrder.click();
		log("Sub order page opened");
        outer: for (int i = 2; i < 6; i++) {
            try {
                            tempSuborder = driver.findElement(
                                                            By.xpath("html/body/div/div[2]/table/tbody/tr/td[2]/div[8]/div[1]/div/div[2]/table/tbody/tr["
                                                                                            + i + "]/th/a"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tempSuborder);
                            waitForElement(driver, 200, tempSuborder);
                            String abc=tempSuborder.getText();
                            if (abc.equals("Company Internet")&&CI_OrderType.equals("Manual")) {
                                            scrollTo(driver, tempSuborder);
                                            //tempSuborder.click();
                                            openlinkinnewtab(driver, tempSuborder);
                                            log("Suborder opened in new tab");
                                            log("tempSuborder Company Internet clicked");
                                            Thread.sleep(3000);
                                            BrowserTabSwitch(driver);
                                            waitForElement(driver, 200, HardwareOptionButton);
                                            scrollTo(driver, HardwareOptionButton);
                                            HardwareOptionButton.click();
                                            log("HardwareOptionButton clicked");
                                            Thread.sleep(2500);
                                            waitForElement(driver, 200, MACAddressEnabler);
                                            scrollTo(driver,MACAddressEnabler);
                                            doubleclick(driver,MACAddressEnabler);
                                            //MACAddressEnabler.click();
                                            log("MACAddressEnabler clicked");
                                                            MACAddressField.sendKeys("1.2.3.4");
                                                            log("MACAddressField passed");                                                                                              
                                            waitForElement(driver, 200, NetworkIPAddressEnabler);
                                            scrollTo(driver,NetworkIPAddressEnabler);
                                            //NetworkIPAddressEnabler.click();
                                            doubleclick(driver,NetworkIPAddressEnabler);
                                            log("NetworkIPAddressEnabler clicked");
                                            NetworkIPAddressField.click();
                                            log("NetworkIPAddressField clicked");
                                            NetworkIPAddressField.sendKeys("U8:l5-P7:J2");
                                            log("MACAddressField passed");                              
                                            SaveButton.click();
                                            log("SaveButton clicked");           
                                            Thread.sleep(5000);
                                            driver.close();
                                            BrowserMainTabSwitchBack(driver);
                                            log("Successfully completed the hardware ip feeding");
                                            //Thread.sleep(50000);
                            }
            } catch (Exception e) {
                            //log("The error is " + e );
                            break outer;
            }
}

		Thread.sleep(2000);
		url = driver.getCurrentUrl();
		log("The URL is "+ url);
		System.out.println("The URL is "+ url);
		outer: for (int i = 2; i < 6; i++) {
			try {
				String OverAllType=(String)dataSets.get("OverallType");
				if (OverAllType.equals("MACD")){
					int j=i+1;
					tempSuborder = driver.findElement(
							By.xpath(suborderLinkOpeningTag
									+ j + suborderLinkClosingTag));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tempSuborder);			    	
			    }
				else{
					tempSuborder = driver.findElement(
							By.xpath(suborderLinkOpeningTag
									+ i + suborderLinkClosingTag));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tempSuborder);			    	
			    }
			} catch (Exception e) {
				break outer;
				
			}
			waitForElement(driver, 200, tempSuborder);
			
			try{
			//tempDecisionMaker=driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[5]/div[1]/div/div[2]/table/tbody/tr["+ i +"]/th/a")).getText();
				tempDecisionMaker=driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[8]/div[1]/div/div[2]/table/tbody/tr["+ i +"]/th/a")).getText();
			} catch (Exception e) {
               if (i==2){
					
				}
				else{
				break outer;
				}
			}
			openlinkinnewtab(driver, tempSuborder);
			//// html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[3]/td[2]/div/a
			log("tempDecisionMaker "+ tempDecisionMaker);
			log("Suborder opened in new tab");
			BrowserTabSwitch(driver);
			log("control switched to new tab");
			PageRefresh(driver);
			log("SubOrder page refreshed to check whether case created or not");
			Thread.sleep(3000);
			CaseStatus();
			String tempcaseID = caseID();
			//String tempDecisionMaker=driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[3]/td[2]/div/a")).getText();
            if (OverallType.equals("MACDTerminate")){
            	CompleteOrderValidationGeneric(dataSets,tempcaseID,TestName);
            }else{
			if (tempDecisionMaker.equals("Company Internet")) {
				if (tempDecisionMaker.equals("Company Internet")&&CI_OrderType.equals("Manual")) {
					CompleteOrderValidationGeneric(dataSets,tempcaseID,TestName);		
				}
				if (tempDecisionMaker.equals("Company Fiber")) {
					System.out.println(" ");	
				}
			}
			if (!tempDecisionMaker.equals("Company Internet")) {
				if (!tempDecisionMaker.equals("Company Fiber")) {
					if (!tempDecisionMaker.equals("BGP 50 Gold")) {
						if (!tempDecisionMaker.equals("Access 50 Gold")) {
						CompleteOrderValidationGeneric(dataSets,tempcaseID,TestName);
					}
					}
				}	
			}
            }
			//CompleteOrderValidationGeneric(dataSets,tempcaseID);
			driver.close();
			BrowserMainTabSwitchBack(driver);
		}
		outer2: for (int i = 2; i < 6; i++) {
			try {
				tempSuborder = driver.findElement(
						By.xpath(suborderLinkOpeningTag
								+ i + suborderLinkClosingTag));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tempSuborder);
			} catch (Exception e) {
				break outer2;
			}
			waitForElement(driver, 200, tempSuborder);
			openlinkinnewtab(driver, tempSuborder);
			log("Suborder opened in new tab");
			BrowserTabSwitch(driver);
			log("control switched to new tab");
			pocUpdates(TestName, "CaseID and Case Status Screenshot", "Information",
					"CaseID and Case Status Screenshot ", driver);
			driver.close();
			BrowserMainTabSwitchBack(driver);
            FinalValidationOfOrderCompletion abcxyz=new FinalValidationOfOrderCompletion(driver);
            try {
                   abcxyz.orderStatusCheck(dataSets,TestName);
            } catch (Exception e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
            }
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	public void CompleteOrderValidationGeneric(Map<String, String> dataSets, String caseID,String TestName)
			throws InterruptedException {
		String typeOfOrderCompleteion = (String) dataSets.get("TypeOfOrder");
		String orderActivationDate = (String) dataSets.get("orderActivationDate");
		String orderDeactivationDate = (String) dataSets.get("orderDeactivationDate");	
		String OverallType = (String) dataSets.get("OverallType");
		scrollTo(driver, webpagesectiontype);
		waitForclickable(driver, webpagesectiontype, 200);
		webpagesectiontype.click();
		Thread.sleep(5000);
		Fulfilmentlink.click();
		System.out.println("Outside CompleteOrderValidation");
		Thread.sleep(15000);
		String pageStatus = verifySalesPage.getText();
		System.out.println("page logged in is " + pageStatus + "null");
		if (!pageStatus.equals("")) {
			verifySalesPage.click();
			Thread.sleep(2000);
			Outer: for (int i = 0; i < 25; i++) {
				String a = String.valueOf(i);
				try {
					String abc = driver.findElement(By.xpath( pageNavigationDropDownOpeningTag+ a + pageNavigationDropDownClosingTag)).getText();
					if (abc.equals("Fulfilment Console")) {
						driver.findElement(By.xpath(pageNavigationDropDownOpeningTag+ a + pageNavigationDropDownClosingTag)).click();
						break Outer;
					}
					System.out.println(abc);
				} catch (Exception e) {
				}
			}
			Thread.sleep(5000);
		}
		String pageStatusAfterSelection = verifySalesPage.getText();
		if (!pageStatusAfterSelection.equals("")) {
			verifySalesPage.click();
			Thread.sleep(2000);
			Outer: for (int i = 0; i < 25; i++) {
				String a = String.valueOf(i);
				try {
					String abc = driver.findElement(By.xpath( pageNavigationDropDownOpeningTag+ a + pageNavigationDropDownClosingTag)).getText();
					if (abc.equals("Unitymedia Business")) {
						driver.findElement(By.xpath(pageNavigationDropDownOpeningTag+ a + pageNavigationDropDownClosingTag)).click();
						Thread.sleep(5000);
						Inner: for (int j = 0; j < 25; j++) {
							String b = String.valueOf(j);
							try {
								String abcd = driver.findElement(By.xpath( pageNavigationDropDownOpeningTag+ b + pageNavigationDropDownClosingTag)).getText();
								if (abc.equals("Fulfilment Console")) {
									driver.findElement(By.xpath(pageNavigationDropDownOpeningTag+ b + pageNavigationDropDownClosingTag)).click();
									break Inner;
								}
								System.out.println(abcd);
							} catch (Exception e) {
								// break;
							}
						}

						break Outer;
					}
					System.out.println(abc);
				} catch (Exception e) {
					// break;
				}
			}
			Thread.sleep(5000);
		}
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in a page :" + iframes.size());
		for (WebElement iframe : iframes) {
			System.out.println("Frame Id :" + iframe.getAttribute("id"));
		}
		System.out.println("the case id is " + caseID);
	
		try {
			log("inside try loop");
		FulfilmentSearchBox.click();
		FulfilmentSearchBox.sendKeys(caseID);
		FulfilmentSearchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
        //List<WebElement> abcs = driver.findElements(By.tagName("iframe"));
		abcs = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in a page :" + abcs.size());
		for (WebElement abc : abcs) {
			System.out.println("Frame Id :" + abc.getAttribute("id"));
		}
		for (WebElement abc : abcs) {
			System.out.println("inside for frames loop");
			boolean found = false;
			System.out.println("inside for frames loop boolean");
			for (WebElement iframe : iframes) {
				System.out.println("inside for ele loop");
				if ((iframe.getAttribute("id").equals(abc.getAttribute("id")))) {
					found = true;
					System.out.println("inside if ele loop");
					break;
				}
			}
			System.out.println("before not found loop");
			if (!found) {
				DummyFramename = abc.getAttribute("id");
				System.out.println("Frame Id newly added is :" + abc.getAttribute("id"));
				frameNew = DummyFramename;
			}
		}
		driver.switchTo().frame(frameNew);
		try{
			waitForclickable(driver, caseIdSearchOutputInConsoleTable, 60);
		}catch (Exception e){
			Thread.sleep(100000);
			caseIdSearchButton222.click();
			Thread.sleep(5000);
		}
		scrollTo(driver, caseIdSearchOutputInConsoleTable);
		waitForclickable(driver, caseIdSearchOutputInConsoleTable, 200);
		caseIdSearchOutputInConsoleTable.click();
		System.out.println("caseid clicked");
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		}
		catch (Exception e) {
			log("inside catch loop");
			Thread.sleep(100000);
			FulfilmentSearchBox.click();
			FulfilmentSearchBox.sendKeys(caseID);
			FulfilmentSearchBox.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
	        //List<WebElement> abcs = driver.findElements(By.tagName("iframe"));
			abcs = driver.findElements(By.tagName("iframe"));
			System.out.println("Number of frames in a page :" + abcs.size());
			for (WebElement abc : abcs) {
				System.out.println("Frame Id :" + abc.getAttribute("id"));
			}
			for (WebElement abc : abcs) {
				System.out.println("inside for frames loop");
				boolean found = false;
				System.out.println("inside for frames loop boolean");
				for (WebElement iframe : iframes) {
					System.out.println("inside for ele loop");
					if ((iframe.getAttribute("id").equals(abc.getAttribute("id")))) {
						found = true;
						System.out.println("inside if ele loop");
						break;
					}
				}
				System.out.println("before not found loop");
				if (!found) {
					DummyFramename = abc.getAttribute("id");
					System.out.println("Frame Id newly added is :" + abc.getAttribute("id"));
					frameNew = DummyFramename;
				}
			}
			driver.switchTo().frame(frameNew);
			scrollTo(driver, caseIdSearchOutputInConsoleTable);
			waitForclickable(driver, caseIdSearchOutputInConsoleTable, 200);
			caseIdSearchOutputInConsoleTable.click();
			System.out.println("caseid clicked");
			Thread.sleep(5000);
			driver.switchTo().parentFrame();
		}
	
		List<WebElement> ele = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in a page :" + ele.size());
		for (WebElement el : ele) {
			System.out.println("Frame Id :" + el.getAttribute("id"));
		}

		int j = 0;
		for (WebElement el : ele) {
			int i = 0;
			System.out.println("inside for frames loop");
			boolean found = false;
			System.out.println("inside for frames loop boolean");
			for (WebElement abc : abcs) {
				System.out.println("inside for ele loop");
				if ((abc.getAttribute("id").equals(el.getAttribute("id")))) {
					found = true;
					System.out.println("inside if ele loop");
					break;
				}
			}
			System.out.println("before not found loop");
			if (!found) {
				i = i + j;
				DummyFramename = el.getAttribute("id");
				System.out.println("Frame Id newly added is :" + el.getAttribute("id"));
				if (i == 0) {
					System.out.println("inside frameOne" + DummyFramename);
					frameOne = DummyFramename;
					System.out.println("frameOne id is " + frameOne);
				}
				if (i == 1) {
					System.out.println("inside frameTwo" + DummyFramename);
					frameTwo = DummyFramename;
					System.out.println("frameTwo id is " + frameTwo);
				}
				j = 1;
			}
		}
		driver.switchTo().frame(frameTwo);
		System.out.println("switched frameTwo");
		scrollTo(driver, caseIdEditDetailsButton);
		System.out.println("scrolled caseIdEditDetailsButton");
		caseIdEditDetailsButton.click();
		System.out.println("clicked caseIdEditDetailsButton");
		if (typeOfOrderCompleteion.equals("PhoneOrder")) {
			Thread.sleep(5000);
			scrollTo(driver, phoneAccountNumer);
			System.out.println("scrolled phoneAccountNumer");
			phoneAccountNumer.click();
			phoneAccountNumer.sendKeys("288774451");
			Thread.sleep(1000);
		}
		int abc = orderActivationDate.length();
		int cde = orderDeactivationDate.length();
		if (OverallType.equals("MACDTerminate")){
			System.out.println("scrolled check delete log");
			scrollTo(driver, addDeAtivationDate);
			System.out.println("scrolled addDeAtivationDate");
			addDeAtivationDate.click();
			Thread.sleep(2000);
			System.out.println("clicked addDeAtivationDate");
			scrollTo(driver, saveButton2);
			System.out.println("scrolled SaveButton");
			saveButton2.click();
			System.out.println("clicked SaveButton");
			Thread.sleep(5000);
			//addDeAtivationDate.sendKeys(Keys.ENTER);
			//addDeAtivationDate.sendKeys(Keys.ENTER);
			/*
			if (cde > 9) {
				addDeAtivationDate.sendKeys(orderDeactivationDate);
				addDeAtivationDate.sendKeys(Keys.TAB);
				System.out.println("valueposted to addDeAtivationDate");
			}
			if (cde < 9) {
				addDeAtivationDate.sendKeys("31.10.2017");
				addDeAtivationDate.sendKeys(Keys.TAB);
				System.out.println("valueposted to addDeAtivationDate");
			}
			*/
		}
		else{
	    try{	
			scrollTo(driver, addActivationDate);
			System.out.println("scrolled addActivationDate");
			addActivationDate.click();
			System.out.println("clicked addActivationDate");
			if (abc > 9) {
				addActivationDate.sendKeys(orderActivationDate);
				addActivationDate.sendKeys(Keys.TAB);
				System.out.println("valueposted to addActivationDate");
			}
			if (abc < 9) {
				addActivationDate.sendKeys("31.10.2017");
				addActivationDate.sendKeys(Keys.TAB);
				System.out.println("valueposted to addActivationDate");
			}
			}catch (Exception e){
				System.out.println("unable to add activation to 2 ");
			}
		}	
		try{
			scrollTo(driver, addActivationDateNew);
			System.out.println("scrolled addActivationDate2");
			Thread.sleep(2000);
			addActivationDateNew.click();
			Thread.sleep(2000);
			System.out.println("clicked addActivationDate2");
			//int abc = orderActivationDate.length();
			if (abc > 9) {
				addActivationDateNew.sendKeys(orderActivationDate);
				addActivationDateNew.sendKeys(Keys.TAB);
				System.out.println("valueposted to addActivationDate2");
			}
			if (abc < 9) {
				addActivationDateNew.sendKeys("31.10.2017");
				addActivationDateNew.sendKeys(Keys.TAB);
				System.out.println("valueposted to addActivationDate2");
			}
		}catch (Exception e){
			System.out.println("unable to add activation to 2 ");
		}
		try{
			scrollTo(driver, addActivationDate3);
			System.out.println("scrolled addActivationDate3");
			Thread.sleep(2000);
			addActivationDate3.click();
			Thread.sleep(2000);
			System.out.println("clicked addActivationDate3");
			//int abc = orderActivationDate.length();
			if (abc > 9) {
				addActivationDate3.sendKeys(orderActivationDate);
				addActivationDate3.sendKeys(Keys.TAB);
				System.out.println("valueposted to addActivationDate3");
			}
			if (abc < 9) {
				addActivationDate3.sendKeys("31.10.2017");
				addActivationDate3.sendKeys(Keys.TAB);
				System.out.println("valueposted to addActivationDate3");
			}
		}catch (Exception e){
			System.out.println("unable to add activation to 3 ");
		}
		System.out.println("Date Entered");
		if (OverallType.equals("MACDTerminate")){
			//addDeAtivationDate.sendKeys(Keys.ENTER);
		}
		else
		{
			addActivationDate.sendKeys(Keys.ENTER);	
		}
		System.out.println("valueposted added to addActivationDate");
		Thread.sleep(5000);
		System.out.println("test switch");
		driver.switchTo().parentFrame();
		System.out.println("test switch");
		driver.switchTo().frame(frameOne);
		System.out.println("frameOne is switched " + frameOne);
		Thread.sleep(5000);
		scrollTo(driver, closeButton);
		System.out.println("scrolled closeButton");
		closeButton.click();
		System.out.println("clicked closeButton");
		log("Close button and the case closed in console");
		Thread.sleep(5000);
        pocUpdates(TestName, "Orders Final Status", "Information",
				"Status of the orders placed in order journey ", driver);

	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	public boolean OrderStageValidation() {
		try {
			stagevalue = OrderStageValidation.getText();
			Thread.sleep(3000);
			log("stage value is " + stagevalue + "");
			Assert.assertEquals(stagevalue, "Ready for Order");
			return true;
		} catch (Exception e) {
			log("Stage status differs " + e + "");
			return false;
		}
	}

	public boolean CaseStatus() {
		try {
			scrollTo(driver, CreatedCaseStatus);
			String casestatus = CreatedCaseStatus.getText();
			Thread.sleep(3000);
			log("CASE STATUS:---> " + casestatus + "");
			Assert.assertEquals(casestatus, "New");
			return true;
		} catch (Exception e) {
			log("case status differs " + e + "");
			return false;
		}
	}

	public String caseID() throws InterruptedException {

		try {
			scrollTo(driver, CreatedCaseID);
			caseID = CreatedCaseID.getText();
			Thread.sleep(2000);
			log("CASE ID:---> " + caseID + "");
		} catch (Exception e) {
			log("No case id was created due to " + e + "");
		}
		return caseID;

	}
}
