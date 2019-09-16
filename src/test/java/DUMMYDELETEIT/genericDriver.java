package DUMMYDELETEIT;

//import org.testng.annotations.Test;
//import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;

//import com.test.automation.OM_Automation.excelReader.AutomaticSanityMails;
//import com.test.automation.OM_Automation.excelReader.WritingInExcel;
//import com.test.automation.OM_Automation.excelReader.excelDataGeneric;
import com.test.automation.OM_Automation.testBase.TestBase;
import com.test.automation.OM_Automation.uiActions.LeadCreation;
import com.test.automation.OM_Automation.uiActions.LoginPage;
import com.test.automation.OM_Automation.uiActions.OI_and_Phone_productBasketConfiguration;
import com.test.automation.OM_Automation.uiActions.OI_productBasketConfiguration;
import com.test.automation.OM_Automation.uiActions.OpportunityConversion;
import com.test.automation.OM_Automation.uiActions.AddressValidation;
import com.test.automation.OM_Automation.uiActions.AssignBillingAccount;
import com.test.automation.OM_Automation.uiActions.BasketUpload;
import com.test.automation.OM_Automation.uiActions.InstallationInformation;
import com.test.automation.OM_Automation.uiActions.ProductBasketAddition;
import com.test.automation.OM_Automation.uiActions.CF_ProductBasketConfiguration;
import com.test.automation.OM_Automation.uiActions.CV_ProductBasketConfiguration;
import com.test.automation.OM_Automation.uiActions.CI_ProductBasketConfiguration;
import com.test.automation.OM_Automation.uiActions.SubOrders;
import com.test.automation.OM_Automation.uiActions.ValidateOrder;
import com.test.automation.OM_Automation.uiActions.ExistingAccountSelectMACDOrders;
import com.test.automation.OM_Automation.uiActions.TerminateOrder;
import com.test.automation.OM_Automation.uiActions.generalRegressionValidations;
import com.test.automation.OM_Automation.uiActions.OtherLogins;
import com.test.automation.OM_Automation.uiActions.Logout;
//import com.test.automation.OM_Automation.uiActions.OrderCompletion;

public class genericDriver extends TestBase{
	
	public static final Logger log = Logger.getLogger(genericDriver.class.getName());
	
	LoginPage loginpage;
	LeadCreation leadcreation;
	AddressValidation Addressvalidation;
	OpportunityConversion opportunityconversion;
	ProductBasketAddition productbasketaddition;
	CF_ProductBasketConfiguration productbasketconfiguration_CF;
	CV_ProductBasketConfiguration productbasketconfiguration_CV;
	OI_productBasketConfiguration productbasketconfiguration_OI;
	CI_ProductBasketConfiguration productbasketconfiguration_CI;
	OI_and_Phone_productBasketConfiguration productbasketconfiguration_OI_and_Phone;
	ExistingAccountSelectMACDOrders ExistingAccountSelectMACDOrders;
	InstallationInformation Installationinformation;
	AssignBillingAccount Assingbillingaccount;
	BasketUpload Basketupload;
	ValidateOrder validateorder;
	OtherLogins OtherLogins;
	SubOrders Suborders;
	Logout pageLogout;
	TerminateOrder TerminateOrder;
	generalRegressionValidations generalRegressionValidations;
	//String url;


	//excelDataGeneric eAI=new excelDataGeneric();
	String Resultscache;
	String Resultscachecomments;

	//Map<String, String> dataSets = null;
	

	
	public genericDriver(WebDriver driver){
		this.driver = driver;
		//testBase = new TestBase();
		PageFactory.initElements(driver, this);
	}


	//@Test
	public void verifylogin(String userName, String password, String TestName) {
		loginpage = new LoginPage(driver);
		try{
	    log("============= Strting VerifyLogin Test===========");
		log.info("============= Strting VerifyLogin Test===========");	
		loginpage.logintoSalesforce(userName, password);
		pocUpdates(TestName, "Login Salesforce", "Passed", "Login Successful", driver);
		log.info("============= Finished VerifyLoginTest===========");
	    log("============= Finished VerifyLoginTest===========");
		getScreenShot("verifyLoginRecords");
	} catch (Exception e) {
		pocUpdates(TestName, "Login Salesforce", "Failed", "Login Unsuccessful", driver);
		log("error message"+e+"");
		getScreenShot("failed");
		org.testng.Assert.fail("Loging failed");
		 //driver.quit();
		}
		}

	public String OtherLogins(Map<String, String> dataSheetTestDataEnv, String TestName,String LoginAccount) {
		OtherLogins = new OtherLogins(driver);
		try{
	    log("============= Starting VerifyLogin1 "+ LoginAccount +" ===========");
		log.info("============= Starting VerifyLogin1 "+LoginAccount+" ===========");	
		OtherLogins.loginHandlers(dataSheetTestDataEnv, LoginAccount);
		pocUpdates(TestName, "Login Salesforce", "Passed", "Login Successful", driver);
		log.info("============= Finished VerifyLoginTest "+LoginAccount+" ===========");
	    log("============= Finished VerifyLoginTest "+LoginAccount+" ===========");
		//getScreenShot("verifyLoginRecords");
		Resultscache = "Pass";
	} catch (Exception e) {
		Resultscache = "Fail";
		pocUpdates(TestName, "Login Salesforce", "Failed", "Login Unsuccessful", driver);
		log("error message"+e+"");
		getScreenShot("failed");
		org.testng.Assert.fail("Loging failed");
		 //driver.quit();
		}
		return Resultscache;
		}

	public String[] genericNewLeadCreationPartner(Map<String, String> dataSets, String TestName) throws Exception {
		leadcreation = new LeadCreation(driver);
		String[] temp=null;
		temp=new String[2];
		try {
			log.info("=========Lead creation for partner account started========");	
			log("=========Lead creation for partner account started========");
			String accountNumber=leadcreation.NewLeadCreationPartnerGeneric(dataSets);
			temp[1]=accountNumber;
			pocUpdates(TestName, "Lead Creation", "Passed", "Lead Creation Successful for partner account", driver);
			log.info("=========Lead has been Successfully created for partner account======");
			log("=========Lead has been Successfully created for partner account======");
			Resultscache = "Pass";
		} catch (Exception e) {
			pocUpdates(TestName, "Lead Creation", "Failed", "Lead Creation Unsuccessful for partner account", driver);
			Resultscache = "Fail";
			log("<----Error value is " + e + "--->");
			getScreenShot("failed");
			org.testng.Assert.fail(" failed");
		}
		temp[0]=Resultscache;
		return temp;
	}

	public String Logout(Map<String, String> dataSets,String TestName,String LogoutHandler) {
		pageLogout = new Logout(driver);
	try {
		log("===========pageLogout starts========");
		log.info("===========pageLogout starts========");
		pageLogout.loginHandlers(dataSets,LogoutHandler);
		pocUpdates(TestName, "pageLogout", "Passed", "pageLogout successful",
				driver);
		log("===========pageLogout========");
		log.info("===========pageLogout========");		
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "pageLogout", "Failed",
				"pageLogoutUnsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while pageLogout due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	public String PartnerAccountOpen(String AccountName,String TestName,String positNegtivValidation) {
        ExistingAccountSelectMACDOrders = new ExistingAccountSelectMACDOrders(driver);
        try{
     log("============= Open Existing account ===========");
        log.info("============= Open Existing account ==========="); 
        ExistingAccountSelectMACDOrders.PartnerAccountOpen(AccountName,positNegtivValidation);
        pocUpdates(TestName, "Existing account opened successfully", "Passed", "Successfully opened existing account", driver);
        log.info("============= Existing account opened successfully===========");
     log("=============  Existing account opened successfully===========");
        //getScreenShot("verifyLoginRecords");
        Resultscache = "Pass";
 } catch (Exception e) {
        pocUpdates(TestName, "Existing account could not be opened", "Failed", "unable opened existing account", driver);
        Resultscache = "Fail";
        log("error message"+e+"");
        getScreenShot("failed");
        org.testng.Assert.fail("Loging failed");
        //driver.quit();
        }
        return Resultscache;
        }
	public String DirectorAccountOpen(String AccountName,String TestName,String positNegtivValidation) {
        ExistingAccountSelectMACDOrders = new ExistingAccountSelectMACDOrders(driver);
        try{
     log("============= Open Existing account ===========");
        log.info("============= Open Existing account ==========="); 
        ExistingAccountSelectMACDOrders.DirectorAccountOpen(AccountName,positNegtivValidation);
        pocUpdates(TestName, "Existing account opened successfully", "Passed", "Successfully opened existing account", driver);
        log.info("============= Existing account opened successfully===========");
     log("=============  Existing account opened successfully===========");
        //getScreenShot("verifyLoginRecords");
        Resultscache = "Pass";
 } catch (Exception e) {
        pocUpdates(TestName, "Existing account could not be opened", "Failed", "unable opened existing account", driver);
        Resultscache = "Fail";
        log("error message"+e+"");
        getScreenShot("failed");
        org.testng.Assert.fail("Loging failed");
        //driver.quit();
        }
        return Resultscache;
        }
	public String ExistingAccountOpen(Map<String, String> dataSets, String TestName) {
        ExistingAccountSelectMACDOrders = new ExistingAccountSelectMACDOrders(driver);
        try{
     log("============= Open Existing account ===========");
        log.info("============= Open Existing account ==========="); 
        ExistingAccountSelectMACDOrders.openExistingAccount(dataSets, TestName);
        pocUpdates(TestName, "Existing account opened successfully", "Passed", "Successfully opened existing account", driver);
        log.info("============= Existing account opened successfully===========");
     log("=============  Existing account opened successfully===========");
        //getScreenShot("verifyLoginRecords");
        Resultscache = "Pass";
 } catch (Exception e) {
        pocUpdates(TestName, "Existing account could not be opened", "Failed", "unable opened existing account", driver);
        Resultscache = "Fail";
        log("error message"+e+"");
        getScreenShot("failed");
        org.testng.Assert.fail("Loging failed");
        //driver.quit();
        }
        return Resultscache;
        }
	
	public String MACDNavigation(Map<String, String> dataSets, String TestName,String MacdActivity) {
        ExistingAccountSelectMACDOrders = new ExistingAccountSelectMACDOrders(driver);
        productbasketconfiguration_CV = new CV_ProductBasketConfiguration(driver);
        try{
     log("============= Macd Navigated and selection for "+MacdActivity+" ===========");
        log.info("====== Macd Navigated and selection for "+MacdActivity+" ======="); 
        ExistingAccountSelectMACDOrders.MACDNavigation(dataSets, TestName,MacdActivity);
        //productbasketconfiguration_CV.CV_CeaseOrder(dataSets);
        
        pocUpdates(TestName, "Macd Navigated and selection for "+MacdActivity+" is successful", "Passed", "Successfully navigated and selected macd", driver);
        log.info("==========Macd Navigated and selection for "+MacdActivity+" is completed===========");
     log("=========Macd Navigated and selection for "+MacdActivity+" is completed===========");
        //getScreenShot("verifyLoginRecords");
        Resultscache = "Pass";
 } catch (Exception e) {
        pocUpdates(TestName, "Macd Navigated and selection for "+MacdActivity+" is NOT successful", "Failed", "Navigation to MACD is unsuccessful", driver);
        Resultscache = "Fail";
        log("error message"+e+"");
        getScreenShot("failed");
        org.testng.Assert.fail("Loging failed");
        //driver.quit();
        }
        return Resultscache;
        }
	
	
	public String MACDTermination(Map<String, String> dataSets, String TestName) {
		TerminateOrder = new TerminateOrder(driver);
        try{
     log("============= Started with macd termination========");
        log.info("======== Started with macd termination======"); 
        TerminateOrder.SingleOrderTermination(dataSets, TestName);
        pocUpdates(TestName, "Macd Termination is successful", "Passed", "Successfully terminated macd", driver);
        log.info("============ completed with macd termination ========");
     log("============ completed with macd termination======");
        //getScreenShot("verifyLoginRecords");
        Resultscache = "Pass";
 } catch (Exception e) {
        pocUpdates(TestName, "Macd Termination is NOT successful", "Failed", "Termination of MACD is unsuccessful", driver);
        Resultscache = "Fail";
        log("error message"+e+"");
        getScreenShot("failed");
        org.testng.Assert.fail("Loging failed");
        //driver.quit();
        }
        return Resultscache;
        }
	
	public String generalRegressionValiadations(Map<String, String> dataSets, String TestName,String desctionHandler) {
		generalRegressionValidations = new generalRegressionValidations(driver);
        try{
        log("============= Regression Validations starts========");
        log.info("======== Regression Validations starts======"); 
        log("test hi one");
        generalRegressionValidations.regressionValidationDesctionHandler(desctionHandler,dataSets,TestName);
        pocUpdates(TestName, "Regression Validations is successful", "Passed", "Successfully Regression Validations completed", driver);
        log.info("============ completed with Regression Validations ========");
        log("============ completed with Regression Validations ======");
        //getScreenShot("verifyLoginRecords");
        Resultscache = "Pass";
 } catch (Exception e) {
        pocUpdates(TestName, "Regression Validations is NOT successful", "Failed", "Regression Validations is unsuccessful", driver);
        Resultscache = "Fail";
        log("error message"+e+"");
        getScreenShot("failed");
        org.testng.Assert.fail("Loging failed");
        //driver.quit();
        }
        return Resultscache;
        }
	
	public String CIChangeOrder(Map<String, String> dataSets, String TestName) {
        productbasketconfiguration_CI =new CI_ProductBasketConfiguration(driver);
        try{
        log("============= Change CI order started ===========");
        log.info("============= Change CI order started ==========="); 
        productbasketconfiguration_CI.changeCIOrder(dataSets,TestName);
        log.info("============= Change CI order completed===========");
        log("=============  Change CI order started completed===========");
        //getScreenShot("verifyLoginRecords");
        Resultscache = "Pass";
 } catch (Exception e) {
        pocUpdates(TestName, "CI change order is not successful", "Failed", "CI change order is Unsuccessful ", driver);
        Resultscache = "Fail";
        log("error message"+e+"");
        getScreenShot("failed");
        org.testng.Assert.fail("Loging failed");
        //driver.quit();
        }
        return Resultscache;
        }
	
	public String[] genericNewLeadCreation(Map<String, String> dataSets, String TestName) throws Exception {
		leadcreation = new LeadCreation(driver);
		String[] temp=null;
		temp=new String[2];
		try {
			log.info("=========Lead creation started========");
			log("=========Lead creation started========");
			String accountNumber=leadcreation.NewLeadCreationGeneric(dataSets);
			temp[1]=accountNumber;
			pocUpdates(TestName, "Lead Creation", "Passed", "Lead Creation Successful", driver);
			log.info("=========Lead has been Successfully created======");
			log("=========Lead has been Successfully created======");
			Resultscache = "Pass";
		} catch (Exception e) {
			pocUpdates(TestName, "Lead Creation", "Failed", "Lead Creation Unsuccessful", driver);
			Resultscache = "Fail";
			log("<----Error value is " + e + "--->");
			getScreenShot("failed");
			org.testng.Assert.fail(" failed");
		}
		temp[0]=Resultscache;
		return temp;
	}
	public String genericAddressValidation(String TestName) throws Exception {
		Addressvalidation = new AddressValidation(driver);
		try {
			log.info("========Address Validation Starts========");
			log("========Address Validation Starts========");
			Addressvalidation.Addressvalidation();
			pocUpdates(TestName, "Address Validation", "Passed", "Address Validation Successful", driver);
			log.info("========Address Validation Completed========");
			log("========Address Validation Completed========");
			Resultscache = "Pass";
		} catch (Exception e) {
			pocUpdates(TestName, "Address Validation", "Failed", "Address Validation Unsuccessful", driver);
			Resultscache = "Fail";
			log("Error occurs in Address validation due to " + e + "");
			org.testng.Assert.fail(" failed");
		}
		return Resultscache;
	}
	
	public String genericOpportunityconversion(Map<String, String> dataSets,String TestName) {
		opportunityconversion = new OpportunityConversion(driver);
		try {
			log.info("=========Opportunity conversion starts=======");
			log("=========Opportunity conversion starts=======");
			opportunityconversion.opportunityconversion(dataSets);
			pocUpdates(TestName, "Opportunity conversion", "Passed", "Opportunity conversion Successful", driver);
			log.info("=========Opportunity successfully converted======");
			log("=========Opportunity successfully converted======");
			Resultscache = "Pass";
		} catch (Exception e) {
			pocUpdates(TestName, "Opportunity conversion", "Failed", "Opportunity conversion Unsuccessful", driver);
			Resultscache = "Fail";
			log("Error occurs in opportunity converson due to " + e + "");
			org.testng.Assert.fail(" failed");
		}
		return Resultscache;
	}
	
	public String genericExistingAccountOpportunityCreation(String TestName) {
		opportunityconversion = new OpportunityConversion(driver);
		try {
			log.info("=========Opportunity creation for existing account starts=======");
			log("=========Opportunity creation for existing account starts=======");
			opportunityconversion.existingAccountOpportunityCreation();
			pocUpdates(TestName, "Opportunity creation", "Passed", "Opportunity creation for existing account Successful", driver);
			log.info("=========Opportunity creation for existing account is successfull======");
			log("=========Opportunity creation for existing account is successfull======");
			Resultscache = "Pass";
		} catch (Exception e) {
			pocUpdates(TestName, "Opportunity creation", "Failed", "Opportunity creation for existing account Unsuccessful", driver);
			Resultscache = "Fail";
			log("Error occurs in opportunity creation in existing account due to " + e + "");
			org.testng.Assert.fail(" failed");
		}
		return Resultscache;
	}
	
	public String CF_ProductBasketAddition(String TestName) {
	productbasketaddition = new ProductBasketAddition(driver);
	try {
		log.info("===========New CF Product Additoin starts========");
		log("===========New CF Product Additoin starts========");
		productbasketaddition.CF_ProductbasketAddition(driver);
		pocUpdates(TestName, "CF Product Basket Addition", "Passed", "Product Basket Addition Successful", driver);
		log.info("===========CF Product successfully added to cart========");
		log("===========CF Product successfully added to cart========");	
		   Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CF Product Basket Addition", "Failed", "Product Basket Addition Unsuccessful",
				driver);
		Resultscache="Fail";
		log("Error occurs in product basket addition due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		 //driver.quit();
	}
	return Resultscache;
	}
			
	public String CV_ProductBasketAddition(String TestName) {
	productbasketaddition = new ProductBasketAddition(driver);
	try {
		log.info("===========New CV Product Additoin starts========");
		log("===========New CV Product Additoin starts========");
		productbasketaddition.CV_ProductbasketAddition(driver);
		pocUpdates(TestName, "CV Product Basket Addition", "Passed", "Product Basket Addition Successful", driver);
		log.info("===========CV Product successfully added to cart===========");
		log("===========CV Product successfully added to cart===========");
		   Resultscache="Pass";
	} catch (Exception e) {		
		pocUpdates(TestName, "CV Product Basket Addition", "Failed", "Product Basket Addition Unsuccessful",
				driver);
		Resultscache="Fail";
		log("Error occurs in CV product basket addition due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		 //driver.quit();
	}
	return Resultscache;
	}
	

	public String OI_ProductBasketAddition(String TestName) {
	productbasketaddition = new ProductBasketAddition(driver);
	try {
		log.info("===========OI New Product Additoin starts========");
		log("===========OI New Product Additoin starts========");
		productbasketaddition.OI_ProductbasketAddition(driver);
		pocUpdates(TestName, "OI Product Basket Addition", "Passed", "Product Basket Addition Successful", driver);
		log.info("===========OI Product successfully added to cart========");
		log("===========OI Product successfully added to cart========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "OI Product Basket Addition", "Failed", "Product Basket Addition Unsuccessful",
				driver);
		Resultscache="Fail";
		log("Error occurs in product basket addition due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	
	public String OI_Phone_ProductBasketAddition(String TestName) {
	productbasketaddition = new ProductBasketAddition(driver);
	try {
		log.info("===========OI and phone Product Additoin starts========");
		log("===========OI and phoneNew Product Additoin starts========");
		productbasketaddition.OI_ProductbasketAddition(driver);
		pocUpdates(TestName, "OI and Phone Product Basket Addition", "Passed", "Product Basket Addition Successful",
				driver);
		log.info("===========OI and phone Product Additoin completed========");
		log("===========OI and phone Product Additoin completed========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "OI and Phone Product Basket Addition", "Failed",
				"Product Basket Addition Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs in product basket addition due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}

	public String CI_ProductBasketAddition(String TestName) {
	productbasketaddition = new ProductBasketAddition(driver);
	try {
		log.info("===========CI New Product Additoin starts========");
		log("===========CI New Product Additoin starts========");
		productbasketaddition.genericCI_ProductbasketAddition(driver);
		pocUpdates(TestName, "CI Product Basket Addition", "Passed", "Product Basket Addition successful", driver);
		log.info("===========CI Product successfully added to cart========");
		log("===========CI Product successfully added to cart========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CI Product Basket Addition", "Failed", "Product Basket Addition Unsuccessful",
				driver);
		Resultscache="Fail";
		log("Error occurs in product basket addition due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		 //driver.quit();
	}
	return Resultscache;
	}
	
	public String CI_PowerSpot_ProductBasketAddition(String TestName) {
	productbasketaddition = new ProductBasketAddition(driver);
	try {
		log.info("===========CI Powerspot Additoin starts========");
		log("===========CI Powerspot Additoin starts========");
		productbasketaddition.genericCI_Powerspot(driver);
		pocUpdates(TestName, "CI Powerspot Product Basket Addition", "Passed", "Product Basket Addition successful",
				driver);
		log.info("===========CI Powerspot successfully added to cart========");
		log("===========CI Powerspot successfully added to cart========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CI Powerspot Product Basket Addition", "Failed",
				"Product Basket Addition Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs in product basket addition due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	
	public String CF_ProductBasketConfiguration(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_CF = new CF_ProductBasketConfiguration(driver);
	try {
		log.info("===========CF Product Configuration starts========");
		log("===========CF Product Configuration starts========");
		productbasketconfiguration_CF.genericCFProductConfiguration(dataSets);
		pocUpdates(TestName, "CF Product Basket Configuration", "Passed", "Product Basket Configuration successful",
				driver);
		log("===========CF Product successfully configured===========");
		log.info("===========CF Product successfully configured===========");	
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CF Product Basket Configuration", "Failed",
				"Product Basket Configuration Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring CF product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	
	public String CV_ProductBasketConfiguration(Map<String, String> dataSets,String TestName,String typeOfCVOrder) {
	productbasketconfiguration_CV = new CV_ProductBasketConfiguration(driver);
	try {
		log("===========CV Product Configuration starts========");
		log.info("===========CV Product Configuration starts========");
		productbasketconfiguration_CV.CV_ProductConfiguration(dataSets,typeOfCVOrder);
		pocUpdates(TestName, "CV Product Basket Configuration", "Passed", "Product Basket Configuration successful",
				driver);
		log("===========CV Product successfully configured========");
		log.info("===========CV Product successfully configured========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CV Product Basket Configuration", "Failed",
				"Product Basket Configuration Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring CF product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}

	public String CV_Change(Map<String, String> dataSets,String TestName,String typeOfCVOrder) {
	productbasketconfiguration_CV = new CV_ProductBasketConfiguration(driver);
	try {
		log("===========CV  Change Product Configuration starts========");
		log.info("===========CV Change Product Configuration starts========");
		productbasketconfiguration_CV.CV_ProductConfiguration(dataSets,typeOfCVOrder);
		pocUpdates(TestName, "CV change Product Basket Configuration", "Passed", "Change Product Basket Configuration successful",
				driver);
		log("===========CV change Product successfully configured========");
		log.info("===========CV change Product successfully configured========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CV change Product Basket Configuration", "Failed",
				"Product Basket Configuration Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring CF product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	
	public String OI_Change(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_OI = new OI_productBasketConfiguration(driver);
	try {
		log("===========OI Change Product Configuration starts========");
		log.info("===========OI Change Product Configuration starts========");
		productbasketconfiguration_OI.changeOIOrder(dataSets, TestName);
		pocUpdates(TestName, "OI change Product Basket Configuration", "Passed", "Change Product Basket Configuration successful",
				driver);
		log("===========OI change Product successfully configured========");
		log.info("===========OI change Product successfully configured========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "OI change Product Basket Configuration", "Failed",
				"Product Basket Configuration Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring OI product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	
	public String OI_ProductBasketConfiguration(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_OI = new OI_productBasketConfiguration(driver);
	try {
		log("===========OI Product Configuration starts========");
		log.info("===========OI Product Configuration starts========");
		productbasketconfiguration_OI.genericOIProductConfiguration(dataSets);
		pocUpdates(TestName, "OI Product Basket Configuration", "Passed", "Product Basket Configuration successful",
				driver);
		log("===========OI Product successfully configured========");
		log.info("===========OI Product successfully configured========");		
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "OI Product Basket Configuration", "Failed",
				"Product Basket Configuration Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring OI product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	
	public String OI_Phone_ProductBasketConfiguration(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_OI_and_Phone = new OI_and_Phone_productBasketConfiguration(driver);
	try {
		log("===========OI and phone Product Configuration starts========");
		log.info("===========OI and phone Product Configuration starts========");
		productbasketconfiguration_OI_and_Phone.genericOIPhoneProductConfiguration(dataSets);
		pocUpdates(TestName, "OI and phone Product Basket Configuration", "Passed",
				"Product Basket Configuration successful", driver);
		log("===========OI and phone Product successfully configured========");
		log.info("===========OI and phone Product successfully configured========");		
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "OI and phone Product Basket Configuration", "Failed",
				"Product Basket Configuration Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring OI product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	

	
	public String CI_ProductBasketConfiguration(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_CI = new CI_ProductBasketConfiguration(driver);
	try {
		log("===========CI Product Configuration starts========");
		log.info("===========CI Product Configuration starts========");
		productbasketconfiguration_CI.genericCIProductConfiguration(dataSets);
		pocUpdates(TestName, "CI Product Basket Configuration", "Passed", "Product Basket Configuration successful",
				driver);
		log("===========CI Product Configuration completed========");
		log.info("===========CI Product Configuration completed========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CI Product Basket Configuration", "Failed",
				"Product Basket Configuration Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring OI product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	
	public String CI_ProductBasketAddonsAddtion(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_CI = new CI_ProductBasketConfiguration(driver);
	try {
		log("===========CI addons Configuration starts========");
		log.info("===========CI addons Configuration starts========");
		productbasketconfiguration_CI.genericCIProductAddons(dataSets);
		pocUpdates(TestName, "CI Product Basket Addons Addtion", "Passed",
				"Addons Addtion Product Basket successful", driver);
		log("===========CI addons Configuration completed========");
		log.info("===========CI addons Configuration completed========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CI Product Basket Addons Addtion", "Failed",
				"Addons Addtion Product Basket Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring OI product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}	
	return Resultscache;
	}
	
	public String CF_ProductBasketAddonsAddtion(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_CF = new CF_ProductBasketConfiguration(driver);
	try {
		log("===========CF addons Configuration starts========");
		log.info("===========CF addons Configuration starts========");
		productbasketconfiguration_CF.genericCFProductAddons(dataSets);
		pocUpdates(TestName, "CF Product Basket Addons Addtion", "Passed",
				"Addons Addtion Product Basket successful", driver);
		log("===========CF addons Configuration completed========");
		log.info("===========CF addons Configuration completed========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CF Product Basket Addons Addtion", "Failed",
				"Addons Addtion Product Basket Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring OI product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}	
	return Resultscache;
	}

	public String OI_ProductBasketAddonsAddtion(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_OI = new OI_productBasketConfiguration(driver);
	try {
		log("===========CF addons Configuration starts========");
		log.info("===========CF addons Configuration starts========");
		productbasketconfiguration_OI.genericOIProductAddons(dataSets);
		pocUpdates(TestName, "OI Product Basket Addons Addtion", "Passed",
				"Addons Addtion Product Basket successful", driver);
		log("===========CF addons Configuration completed========");
		log.info("===========CF addons Configuration completed========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "OI Product Basket Addons Addtion", "Failed",
				"Addons Addtion Product Basket Unsuccessful", driver);
		Resultscache="Fail";
		log("Error occurs while configuring OI product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}	
	return Resultscache;
	}
	
	public String CI_PowerSpot_ProductBasketConfiguration(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_CI = new CI_ProductBasketConfiguration(driver);
	try {
		log("===========CI PowerSpot Product Configuration starts========");
		log.info("===========CI PowerSpot Product Configuration starts========");
		productbasketconfiguration_CI.genericCIProductPowerSpot(dataSets);
		pocUpdates(TestName, "CI PowerSpot Product Basket Configuration", "Passed",
				" Product Basket Configuration successful ", driver);
		log("===========CI PowerSpot Product successfully configured========");
		log.info("===========CI PowerSpot Product successfully configured========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CI PowerSpot Product Basket Configuration", "Failed",
				" Product Basket Configuration Unsuccessful ", driver);
		Resultscache="Fail";
		log("Error occurs while configuring CF product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}

	public String CI_WLan_ProductBasketConfiguration(Map<String, String> dataSets,String TestName) {
		productbasketconfiguration_CI = new CI_ProductBasketConfiguration(driver);
	try {
		log("===========CI Wlan Product Configuration starts========");
		log.info("===========CI Wlan Product Configuration starts========");
		productbasketconfiguration_CI.genericCIProductWLan(dataSets);
		pocUpdates(TestName, "CI Wlan Product Basket Configuration", "Passed",
				" Product Basket Configuration successful ", driver);
		log("===========CI Wlan Product successfully configured========");
		log.info("===========CI Wlan Product successfully configured========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "CI Wlan Product Basket Configuration", "Failed",
				" Product Basket Configuration Unsuccessful ", driver);
		Resultscache="Fail";
		log("Error occurs while configuring CF product due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	public String installationInformation(Map<String, String> dataSets,String TestName) {
		Installationinformation = new InstallationInformation(driver);
	try {
		log.info("===========Installation Information performs========");
		log("===========Installation Information performs========");
		Installationinformation.Installation_Information(dataSets);
		pocUpdates(TestName, "Installation Information", "Passed", "Installation Information successful ", driver);
		log("========Installation Information successfully configured============");
		log.info("========Installation Information successfully configured============");	
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "Installation Information", "Failed", "Installation Information Unsuccessful ",
				driver);
		Resultscache="Fail";
		log("Error occurs while configuring Installation information due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
		
	public String billingAccountAssignment(String TestName) {
		Assingbillingaccount = new AssignBillingAccount(driver);
	try {
		log.info("===========Billing Account Assignment start performing========");
		log("===========Billing Account Assignment start performing========");
		Assingbillingaccount.BillingAccoutnAssignment();
		pocUpdates(TestName, "Billing Account Assignment", "Passed", "Billing Account Assignment successful ",
				driver);
		log("========Billing Account Assignment was successfully configured============");
		log.info("========Billing Account Assignment was successfully configured============");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "Billing Account Assignment", "Failed", "Billing Account Assignment Unsuccessful ",
				driver);
		Resultscache="Fail";
		log("Error occurs while configuring Billing Account due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}
	return Resultscache;
	}
	
	
	public String productBasketUpload(String TestName) {
		Basketupload = new BasketUpload(driver);
	try {
		log.info("===========Product Basket upload start performing========");
		log("===========Product Basket upload start performing========");
		Basketupload.uploadProduceBasket();
		pocUpdates(TestName, "Product Basket Upload", "Passed", "Product Basket Upload successful ", driver);
		log("========Billing Account Assignment was successfully configured============");
		log.info("========Billing Account Assignment was successfully configured============");	
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "Product Basket Upload", "Failed", "Product Basket Upload Unsuccessful ", driver);
		Resultscache="Fail";
		log("Error occurs while configuring Billing Account due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
		
	}
	return Resultscache;
	}
	
	public String validateOrder(Map<String, String> dataSets,String TestName) {
		validateorder = new ValidateOrder(driver);
	try {
		log.info("===========Order Validation start performing========");
		log("===========Order Validation start performing========");
		validateorder.OrderValidation(dataSets);
		pocUpdates(TestName, "Validate Order", "Passed", "Validate Order successful ", driver);
		log("========Order validation was successfully performed============");
		log.info("========Order validation was successfully performed============");				
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "Validate Order", "Failed", "Validate Order successful ", driver);
		Resultscache="Fail";
		log("Error occurs while Validating order due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
		// driver.quit();
	}		
	return Resultscache;
	}
	
	public String[] completeOrder(Map<String, String> dataSets,String caseID,String url,String TestName) {
		Suborders = new SubOrders(driver);
		String[] tempResult1 = null;
		tempResult1 = new String[2];
	try {
		log.info("===========SUB-Order completion starts========");
		log("===========SUB-Order completion starts========");
		//String orderStatus=Suborders.CompleteOrderValidation(dataSets,caseID,url);
		pocUpdates(TestName, "Complete Order", "Passed", "Complete Order successful ", driver);
		//tempResult1[0]=orderStatus;
		log.info("===========SUB-Order completion is successfully completed========");
		log("===========SUB-Order completion is successfully completed========");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "Complete Order", "Failed", "Complete Order Unsuccessful ", driver);
		Resultscache="Fail";			
	log("Error occurs while Validating Sub-orders due to "+e+"");
	org.testng.Assert.fail(" failed");
	e.printStackTrace();
	 //driver.quit();
	}	
	tempResult1[1]=Resultscache;
	return tempResult1;
	}
		
	public String[] subOrdersValidationAndClosure(String TestName) {
		Suborders = new SubOrders(driver);
		String[] tempResulttemp = null;
		tempResulttemp = new String[2];
		String[] tempResult1 = null;
		tempResult1 = new String[3];
	try {		
		log.info("===========SUB-Order Validation start performing========");
		log("===========SUB-Order Validation start performing========");
		//tempResulttemp=Suborders.CreatedOrderValidation();
		pocUpdates(TestName, "Sub-Orders Validation And Closure", "Passed",
				"Sub-Orders Validation And Closure successful ", driver);
		tempResult1[0]=tempResulttemp[0];
		tempResult1[1]=tempResulttemp[1];
		System.out.println("The Url is before excel update "+tempResulttemp[0]);
		log("========SUB-Order validation was successfully performed============");
		log.info("========SUB-Order validation was successfully performed============");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "Sub-Orders Validation And Closure", "Failed",
				"Sub-Orders Validation And Closure Unsuccessful ", driver);
		Resultscache="Fail";	
		log("Error occurs while Validating Sub-orders due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
	}
	tempResult1[2]=Resultscache;
	return tempResult1;
	}
	
	public void subOrdersValidationAndCompleteOrderInConsole(Map<String, String> dataSets,String TestName) {
		Suborders = new SubOrders(driver);

	try {		
		log.info("===========SUB-Order and complete Order in console start performing========");
		log("===========SUB-Order and complete Order in console start performing========");
		//tempResulttemp=Suborders.CreatedOrderValidation();
		Suborders.CreatedOrderValidationGeneric(dataSets,TestName);
		pocUpdates(TestName, "Sub-Orders Validation And complete Order in console", "Passed",
				"Sub-Orders Validation And complete Order in console successful ", driver);

		System.out.println("The Url is before excel update ");
		log("========SUB-Order and complete Order in console was successfully performed============");
		log.info("========SUB-Order and complete Order in console was successfully performed============");
		Resultscache="Pass";
	} catch (Exception e) {
		pocUpdates(TestName, "Sub-Orders Validation And complete Order in console", "Failed",
				"Sub-Orders Validation And complete Order in console Unsuccessful ", driver);
		Resultscache="Fail";	
		log("Error occurs while Validating Sub-orders due to "+e+"");
		org.testng.Assert.fail(" failed");
		e.printStackTrace();
	}

	//return tempResult1;
	}

}
