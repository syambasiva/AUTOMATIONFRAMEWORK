package com.test.automation.OM_Automation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.OM_Automation.customListner.WebEventListener;
import com.test.automation.OM_Automation.excelReader.Excel_Reader;
import com.test.automation.OM_Automation.excelReader.WritingInExcel;
import com.test.automation.OM_Automation.excelReader.excelDataGeneric;
import com.test.automation.OM_Automation.excelReader.wordDocGeneric;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * 
 * @author Shambukameshwar.B
 *
 */
public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	

	public WebDriver driver;
	Excel_Reader excel;
	public WebEventListener eventListener;
	public Properties OR = new Properties();
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	public Map<String, String> dataSheetTestDataEnv;

	public WebDriver getDriver() {
		return driver;
	}

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports("C:\\OM_UMSTDEMO_Automation\\TestResults\\HtmlReports\\test" + formater.format(calendar.getTime()) + ".html", false);
	}

	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/test/automation/OM_Automation/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);

	}

	public void setDriver(EventFiringWebDriver driver) {
		this.driver = driver;
	}

	public void init() throws Exception {
		loadData();
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		System.out.println(OR.getProperty("browser"));
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
		dataSheetTestDataEnv = dataSheetTestDataEnviroinment();
	}

	public void selectBrowser(String browser) {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("disable-popup-blocking");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver();
				// driver = new EventFiringWebDriver(dr);
				   eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				// driver = new EventFiringWebDriver(dr);
     			eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
				// driver = new EventFiringWebDriver(dr);
				 eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
				// driver = new EventFiringWebDriver(dr);
				eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			}
		}
	}
	 
	 public void logOutSelection(String TextToFind,WebDriver driver) {
			Outer:for (int i=20;i>=1;i--) {
				try {
					Thread.sleep(1000);
					if(!driver.findElements(By.xpath(".//*[@id='userNav-menuItems']/a["+i+"]")).isEmpty()){
						String Temp=driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a["+i+"]")).getText();
						log("Edit basket button clicked "+Temp);
						if (Temp.equals(TextToFind)) {
							driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a["+i+"]")).click();
							log("Edit basket button clicked");
							Thread.sleep(10000);
							break Outer;
						}
					}else{
					    System.out.println(" ");
					}
					}
					catch (Exception e){
						System.out.println("Hi exception is "+ e);
					}
				}
	 }
	public void getUrl(String url) {
		log.info("navigating to :-" + url);
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 public void openStringlinkinnewtab(WebDriver driver,String newUrl) {
		 System.out.println("one");
		 ((JavascriptExecutor)driver).executeScript("window.open()");
		 //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		 System.out.println("teo");
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 System.out.println("three");
		    driver.switchTo().window(tabs.get(1)); //switches to new tab
		    System.out.println("four");
		    driver.get(newUrl);
		    System.out.println("five");
		 
	 }

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/test/automation/OM_Automation/data/" + excelName;
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}
	

	Map<String, String> dataSets;
	String[][] driverSets;
	Map<String, String> dataSetsEnviroinment;
	excelDataGeneric eAI=new excelDataGeneric();
	  public Map<String, String> dataSheetTestDataEnviroinment() throws Exception {
          dataSetsEnviroinment = eAI.newenvsetups();
          return dataSetsEnviroinment;
   }
	public Map<String, String> dataSheetTestData(String TestName,String excelName, String sheetName) throws Exception {
		String path = "C:\\OM_UMSTDEMO_Automation\\DataSheet\\" + excelName;
		excelDataGeneric eAI=new excelDataGeneric();
		dataSets = eAI.dataSheetTestData(TestName,path,sheetName);
		return dataSets;
	}

	public String[][] getDataDriver(String TestName,String excelName, String sheetName) throws Exception {
		String path = "C:\\OM_UMSTDEMO_Automation\\DataSheet\\" + excelName;
		excelDataGeneric eAI=new excelDataGeneric();
		driverSets = eAI.dataSheetDriver(TestName,path,sheetName);
		return driverSets;
	}

	wordDocGeneric abc=new wordDocGeneric();
	WritingInExcel abcd=new WritingInExcel();
	public void pocInitilizations() throws Exception {
		abc.createNewFolder("C:\\OM_UMSTDEMO_Automation\\TestResults\\WordDocuments\\WordDocuments");
		abcd.createNewExcel();
	}
	
	public void pocCreations(String TestName) throws IOException {
		abc.genericNewWordDocCreate(TestName,"C:\\OM_UMSTDEMO_Automation\\TestResults\\WordDocuments\\");
	}
	
	public void pocUpdates(String TestCaseName , String TestStepName,String TestCaseStatus,String comments,WebDriver driver)  {
		try {
			abc.genericWordDocUpdateCommentsandScreenshots(TestCaseName, TestStepName, TestCaseStatus, comments, driver,"C:\\OM_UMSTDEMO_Automation\\TestResults\\WordDocuments\\");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	 public void findEditButtonBasedOnTextXpathHardcoded(String TextToFind,WebDriver driver) {
			Outer:for (int i=5;i>=1;i--) {
				try {
					((JavascriptExecutor) driver)
				     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
					Thread.sleep(1000);
					if(!driver.findElements(By.xpath("//*[@id=\"bodyCell\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li["+i+"]/div/div/div/div[1]/div/div[4]")).isEmpty()){
						String Temp=driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li["+i+"]/div/div/div/div[1]/div/div[4]")).getText();
						log("Edit basket button clicked "+Temp);
						if (Temp.equals(TextToFind)) {
							driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li["+i+"]/div/div/div/div[1]/div/div[1]/button[2]")).click();
							log("Edit basket button clicked");
							Thread.sleep(10000);
							break Outer;
						}
					}else{
					    System.out.println(" ");
					}
					}
					catch (Exception e){
						System.out.println("Hi exception is "+ e);
					}
				}
	 }

	public void getScreenShot(String name) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/OM_Automation/screenshot/";
			File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void highlightMe(WebDriver driver, WebElement element) throws InterruptedException {
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute javascript
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(3000);
		js.executeScript("arguments[0].style.border=''", element);
	}

	public Iterator<String> getAllWindows() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}

	public void getScreenShot(WebDriver driver, ITestResult result, String folderName) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String methodName = result.getName();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/OM_Automation/";
			File destFile = new File((String) reportDirectory + "/" + folderName + "/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");

			FileUtils.copyFile(scrFile, destFile);

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getScreenShotOnSucess(WebDriver driver, ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String methodName = result.getName();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/OM_Automation/";
			File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");

			FileUtils.copyFile(scrFile, destFile);

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/OM_Automation/screenshot/";
			destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
		test.log(LogStatus.INFO, data);
	}

	public void getresult(ITestResult result,String TestName) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			//test.log(LogStatus.PASS, result.getName() + " test is pass");
			test.log(LogStatus.PASS, TestName + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			//test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			test.log(LogStatus.ERROR,  TestName + " test is failed" + result.getThrowable());
			String screen = captureScreen("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			//test.log(LogStatus.INFO, result.getName() + " test is started");
			test.log(LogStatus.INFO, TestName  + " test is started");
		}
	}

	public void updateResultinExcel(ITestResult result,String TestName,String url,String orderStatus) throws Exception {
		WritingInExcel wr=new WritingInExcel();
		System.out.println("the meathod updateResultinExcel is called");
		if (result.getStatus() == ITestResult.SUCCESS) {
			wr.updateExcel(TestName,"Installing "+ TestName +" is completed","Pass",url ,orderStatus+" for/in this test case");
		} else if (result.getStatus() == ITestResult.SKIP) {
			wr.updateExcel(TestName,"Installing "+ TestName +" is skipped","Skip","The test case execution is skipped suddenly","Please check the results of the test and kindly reexecute");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			wr.updateExcel(TestName,"Installing "+ TestName +" is not completed","Fail",url ,orderStatus+" for/in this test case");
		}
	}
	public void closeBrowser() {
		//driver.quit();
	    log.info("browser closed");
		extent.endTest(test);
		extent.flush();
		//driver.close();
		//driver.quit();
	}

	public WebElement waitForclickable(WebDriver driver, WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void dropdownselection(WebDriver driver, WebElement Element , String Value){
		WebElement mySelectElement = Element;
		Select dropdown= new Select(mySelectElement);	
		dropdown.selectByVisibleText(Value);
		
	}
	public void dropdownselectionbyvalue(WebDriver driver, WebElement Element , String Value){
		WebElement mySelectElement = Element;
		Select dropdown= new Select(mySelectElement);	
		dropdown.selectByValue(Value);
		
	}
	 public static void scrollTo(WebDriver driver, WebElement element) {
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView();", element);
	    }
	 public void Randomnumbers(WebDriver driver, WebElement element, int numbercount ) {
		 
		 String randomNumbers = RandomStringUtils.randomNumeric(numbercount);
			String generatednumber = randomNumbers;
		     element.sendKeys(generatednumber);
	 }
	 public String Randomnumbers(int numbercount ) {
		 String randomNumbers = RandomStringUtils.randomNumeric(numbercount);
			String generatednumber = randomNumbers;
		     return generatednumber;
	 }	 
public String Randomalphabets(WebDriver driver, WebElement element, int numbercount ) {
		 String randomNumbers = RandomStringUtils.randomAlphabetic(numbercount);
			String generatedalphabets = randomNumbers;
		     element.sendKeys(generatedalphabets);
		     return generatedalphabets;
	 }

public void WindowsPopupClose() throws AWTException {
	
    Robot r = new Robot();
	
		r.keyPress(java.awt.event.KeyEvent.VK_ESCAPE);
		r.keyRelease(java.awt.event.KeyEvent.VK_ESCAPE);
}


public void wish_planned_date(WebDriver driver){
	WebElement c = driver.findElement(By
			.className("table-condensed"));
	List<WebElement> days = c.findElements(By.tagName("td"));

	int date = 0;
	for (WebElement da : days) {
		if (da.getAttribute("class").contentEquals("day")) {
			// System.out.println(da.getText());
			String cla = da.getAttribute("class");

			if (cla.contentEquals("day")) {
				da.click();
				date++;
				break;
			}

		}
	}

	if (date == 0) {
		driver.findElement(By.xpath("//th[@class='next']")).click();
		@SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement ca = driver.findElement(By
				.className("table-condensed"));
		List<WebElement> days1 = ca.findElements(By.tagName("td"));

		@SuppressWarnings("unused")
		WebDriverWait wait37 = new WebDriverWait(driver, 5);

		for (WebElement da1 : days1) {

			if (da1.getAttribute("class").contentEquals("day")) {
				// System.out.println(da1.getText());
				String cla1 = da1.getAttribute("class");

				if (cla1.contentEquals("day")) {
					da1.click();

					break;
				}

			}
		}

	}

	
}
	
	public void doubleclick(WebDriver driver, WebElement element) {
	
	Actions action = new Actions(driver);
	action.moveToElement(element)
			.doubleClick().perform();
	}
	
	public WebElement waituntilframeload(WebDriver driver, WebElement element, long timeOutInSeconds, String frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		return element;
		
	}
	 public void iframeswitch(WebDriver driver, int i) {
		 
		 driver.switchTo().frame(i);
	 }
	 
	 public void parentwindowreturn(WebDriver driver) {
		 
		 driver.switchTo().defaultContent();
	 }
	 
	 public void openlinkinnewtab(WebDriver driver, WebElement element) {
		 String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		 element.sendKeys(selectLinkOpeninNewTab);
	 }
	 
	 public void PageRefresh(WebDriver driver) {
		
		 driver.navigate().refresh();
	 }
	 public void PageBack(WebDriver driver) {
			
		 driver.navigate().back();
	 }	 
	 
	 public void BrowserTabSwitch(WebDriver driver) {
		 
		  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("window.focus();");
		    js = null;						//switches to new tab
	 }
	 
	 public void BrowserMainTabSwitchBack(WebDriver driver) {
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(0)); // switch back to main screen        
		    JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("window.focus();");
		    js = null;	
	 }
	 
	
	
	//@Parameters("browser")
	//@BeforeTest
	public void launchapp(String browser) throws IOException {

		if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equals("chrome")) {
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				System.out.println(" Executing on CHROME");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				String Node = "http://localhost:5001/wd/hub";
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Launch website
				loadData();
				getUrl(OR.getProperty("url"));
			} else if (browser.equals("firefox")) {
				//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				System.out.println(" Executing on FireFox");
				String Node = "http://172.16.123.130:5000/wd/hub";
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				driver = new RemoteWebDriver(new URL(Node), cap);
				loadData();
				getUrl(OR.getProperty("url"));
			} else if (browser.equalsIgnoreCase("ie")) {
				System.out.println(" Executing on IE");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("ie");
				String Node = "http://192.168.0.101:5555/wd/hub";
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Launch website
				loadData();
				getUrl(OR.getProperty("url"));
			} else {
				throw new IllegalArgumentException("The Browser Type is Undefined");
			}
		}
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				System.out.println(" Executing on CHROME");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("disable-popup-blocking");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				String Node = "http://localhost:5555/wd/hub";
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Launch website
				loadData();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("cookies cleared");
				
				getUrl(OR.getProperty("url"));
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				System.out.println(" Executing on FireFox");
				String Node = "http://172.16.123.130:5554/wd/hub";
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				driver = new RemoteWebDriver(new URL(Node), cap);
				loadData();
				getUrl(OR.getProperty("url"));
			} else if (browser.equalsIgnoreCase("ie")) {
				System.out.println(" Executing on IE");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("ie");
				String Node = "http://192.168.0.101:5555/wd/hub";
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Launch website
				getUrl(OR.getProperty("url"));
			} else {
				throw new IllegalArgumentException("The Browser Type is Undefined");
			}
		}
	}

}
