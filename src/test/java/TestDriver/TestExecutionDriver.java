package TestDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

//import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.OM_Automation.excelReader.AutomaticSanityMails;
import com.test.automation.OM_Automation.excelReader.WritingInExcel;
//import com.test.automation.OM_Automation.excelReader.excelDataGeneric;
import com.test.automation.OM_Automation.testBase.TestBase;
import com.test.automation.OM_Automation.uiActions.LeadCreation;
import com.test.automation.OM_Automation.uiActions.LoginPage;
import com.test.automation.OM_Automation.uiActions.OpportunityConversion;
import com.test.automation.OM_Automation.uiActions.AddressValidation;
import com.test.automation.OM_Automation.uiActions.AssignBillingAccount;
import com.test.automation.OM_Automation.uiActions.BasketUpload;
import com.test.automation.OM_Automation.uiActions.InstallationInformation;
import com.test.automation.OM_Automation.uiActions.ProductBasketAddition;
import com.test.automation.OM_Automation.uiActions.CF_ProductBasketConfiguration;
import com.test.automation.OM_Automation.uiActions.SubOrders;
import com.test.automation.OM_Automation.uiActions.ValidateOrder;

import DUMMYDELETEIT.genericDriver;

import com.test.automation.OM_Automation.uiActions.OrderCompletion;

public class TestExecutionDriver extends TestBase{

	LoginPage loginpage;
	LeadCreation leadcreation;
	AddressValidation Addressvalidation;
	OpportunityConversion opportunityconversion;
	ProductBasketAddition productbasketaddition;
	CF_ProductBasketConfiguration productbasketconfiguration;
	InstallationInformation Installationinformation;
	AssignBillingAccount Assingbillingaccount;
	BasketUpload Basketupload;
	ValidateOrder validateorder;
	SubOrders Suborders;
	WritingInExcel wr=new WritingInExcel();
	AutomaticSanityMails am=new AutomaticSanityMails();
	//excelDataGeneric eAI=new excelDataGeneric();
	String Resultscache;
	String Resultscachecomments;
	OrderCompletion OrderCompletion;
	Map<String, String> dataSets = null;
	String[][] driverSets=null;
	String tempResult="";
	String[] tempResult1;
	String AccountName;
	String orderStatus;
	String TestName;

    @BeforeSuite
    public void beforeSuite() throws Exception {
    	pocInitilizations();
    }
    
	@BeforeClass
	public void setUp() throws Exception {
     init();
	}
	
	@Parameters({ "TestName" })
	@Test(priority = 1)
	public void TestCaseExecution(String TestName) throws Exception {
		String userName=(String) dataSheetTestDataEnv.get("userName");
		String password=(String) dataSheetTestDataEnv.get("password");
		pocCreations(TestName);
		this.TestName=TestName;
		System.out.println(this.TestName);
		genericDriver gD=new genericDriver(driver);
		//gD.verifylogin("vigneshkannan.v@prodapt.com.umuat", "Password#008", TestName);
		gD.verifylogin(userName, password, TestName);
		System.out.println("Hi the test name "+ TestName);
		try {
			dataSets = dataSheetTestData(TestName,"TestData.xlsx", "GenericDataSheet");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			driverSets = getDataDriver(TestName,"TestData.xlsx", "GenericDriverSheet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println(driverSets.length);
	    int numberOfMeathods=driverSets.length;
	    System.out.println("The lenght of the array is " + numberOfMeathods);
	    String caseID = null;
	    for (int i=1 ;i<numberOfMeathods ;i++) {
	    	if(tempResult.equals("Fail")) {
	    		//System.out.println("the test is skkiped as the status is " +tempResult);
	    		break;
	    	}
	    	//System.out.println("Hi count is " + i +" " + driverSets[i][1]);
	    	String tempDriverVariable=driverSets[i][1];
	    	System.out.println("Hi count is " + i +" " + driverSets[i][1]);
	        switch(tempDriverVariable){
	        case "LeadCreationPartner":
	        	tempResult1=gD.genericNewLeadCreationPartner(dataSets,TestName);
	        	tempResult=tempResult1[0];
	        	AccountName=tempResult1[1];
	        break;
	        case "LogoutDualTabs":
                tempResult=gD.Logout(dataSets,TestName,"LogoutDualTabs");
            break;
	        case "Logout":
                tempResult=gD.Logout(dataSets,TestName,"Logout");
            break;
	        case "StagePercentageValidationPartnerPortal":
	             tempResult=gD.generalRegressionValiadations(dataSets,TestName,"StagePercentageValidationPartnerPortal");
	            break;
	        case "Director1PAM1Partner1Login":
                tempResult=gD.OtherLogins(dataSheetTestDataEnv,TestName,"Director1PAM1Partner1Login");
            break;
	        case "Director1PAM1Login":
                tempResult=gD.OtherLogins(dataSheetTestDataEnv,TestName,"Director1PAM1Login");
            break;
	        case "Director1PAM2Partner1Login":
                tempResult=gD.OtherLogins(dataSheetTestDataEnv,TestName,"Director1PAM2Partner1Login");
            break;
	        case "Director1PAM1Partner2Login":
                tempResult=gD.OtherLogins(dataSheetTestDataEnv,TestName,"Director1PAM1Partner2Login");
            break;
	        case "Director1SME1Login":
                tempResult=gD.OtherLogins(dataSheetTestDataEnv,TestName,"Director1SME1Login");
            break;
	        case "Director1WholesaleLogin":
                tempResult=gD.OtherLogins(dataSheetTestDataEnv,TestName,"Director1WholesaleLogin");
            break;
	        case "Director_Negative_OpenleadExistingAccount":
                tempResult=gD.DirectorAccountOpen(AccountName,TestName,"Negative");
            break;
	        case "OpenExistingAccount":
                tempResult=gD.ExistingAccountOpen(dataSets,TestName);
            break;
	        case "Positive_OpenleadExistingAccount":
                tempResult=gD.PartnerAccountOpen(AccountName,TestName,"Positive");
            break;
	        case "Negative_OpenleadExistingAccount":
                tempResult=gD.PartnerAccountOpen(AccountName,TestName,"Negative");
            break;
	        case "opportunityOwnerChangePAM1":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"opportunityOwnerChangePAM1");
            break;
	        case "opportunityOwnerChangePAM2":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"opportunityOwnerChangePAM2");
            break;
	        case "PAM_Assigns_leadtoPartner":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"PAM_Assigns_leadtoPartner");
               break;
	        case "ErrorMgsValidation":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"ErrorMgsValidation");
               break;
	        case "EntitlementRecordValidation":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"EntitlementRecordValidation");
               break;
	        case "BillingAccErrorMgsValidation":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"BillingAccErrorMgsValidation");
               break;
	        case "InstallationActivationFieldValidations":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"InstallationActivationFieldValidations");
            break;
	        case "B2BsolutionsButtonValidation":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"B2BsolutionsButtonValidation");
            break;
	        case "emailConfirmation":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"emailConfirmation");
            break;
	        case "ProvisioningAccountValidation":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"ProvisioningAccountValidation");
            break;
	        case "TCVCalculations":
                tempResult=gD.generalRegressionValiadations(dataSets,TestName,"TCVCalculations");
            break;
	        case "MACDChange":
                tempResult=gD.MACDNavigation(dataSets,TestName,"Change");
            break;
	        case "MACDUpgrade":
                tempResult=gD.MACDNavigation(dataSets,TestName,"Upgrade");
            break;
	        case "MACDowngrade":
                tempResult=gD.MACDNavigation(dataSets,TestName,"Downgrade");
            break;
	        case "MACDTerminate":
                tempResult=gD.MACDNavigation(dataSets,TestName,"Terminate");
            break;
	        case "TerminationBaskedConfigurations":
                tempResult=gD.MACDTermination(dataSets, TestName);
            break;
	        case "CIChange":
                tempResult=gD.CIChangeOrder(dataSets, TestName);
            break;
	        case "CVChange": 
	        	//tempResult=gD.genericAddressValidation(TestName);
	        break;  
	        case "OIChange":
                tempResult=gD.OI_Change(dataSets, TestName);
            break;
	        case "LeadCreation":
	        	tempResult1=gD.genericNewLeadCreation(dataSets,TestName);
	        	tempResult=tempResult1[0];
	        	AccountName=tempResult1[1];
	        break;  
	        case "AddressValidation": 
	        	tempResult=gD.genericAddressValidation(TestName);
	        break;  
	        case "OpportunityConverssion":
	        	tempResult=gD.genericOpportunityconversion(dataSets,TestName);
	        break;
	        case "OpportunityCreationExistingAccount":
	        	tempResult=gD.genericExistingAccountOpportunityCreation(TestName);
	        break;
	        case "CF_ProductBasketAddition": 
	        	tempResult=gD.CF_ProductBasketAddition(TestName);
	        break;
	        case "CV_ProductBasketAddition": 
	        	tempResult=gD.CV_ProductBasketAddition(TestName);
	        break;
	        case "OI_ProductBasketAddition": 
	        	tempResult=gD.OI_ProductBasketAddition(TestName);
	        break;
	        case "OI_Phone_ProductBasketAddition": 
	        	tempResult=gD.OI_Phone_ProductBasketAddition(TestName);
	        break;
	        case "CI_ProductBasketAddition": 
	        	tempResult=gD.CI_ProductBasketAddition(TestName);
	        break;
	        case "CI_PowerSpot_ProductBasketAddition": 
	        	tempResult=gD.CI_PowerSpot_ProductBasketAddition(TestName);
	        break;
	        case "CI_WLan_ProductBasketAddition": 
	        	tempResult=gD.CI_PowerSpot_ProductBasketAddition(TestName);
	        break;	        
	        case "CF_ProductBasketConfiguration": 
	        	tempResult=gD.CF_ProductBasketConfiguration(dataSets,TestName);
	        break; 
	        case "CV_ISDN_ProductBasketConfiguration":
	        	tempResult=gD.CV_ProductBasketConfiguration(dataSets,TestName,"ISDN");
	        break;
	        case "CV_SipTrunk_ProductBasketConfiguration":
	        	tempResult=gD.CV_ProductBasketConfiguration(dataSets,TestName,"SIPTrunk");
	        break;
	        case "OI_ProductBasketConfiguration": 
	        	tempResult=gD.OI_ProductBasketConfiguration(dataSets,TestName);
	        break; 
	        case "OI_Phone_ProductBasketConfiguration": 
	        	tempResult=gD.OI_Phone_ProductBasketConfiguration(dataSets,TestName);
	        break;
	        case "CI_ProductBasketConfiguration": 
	        	tempResult=gD.CI_ProductBasketConfiguration(dataSets,TestName);
	        break; 
	        case "CI_ProductBasketAddonsAddtion": 
	        	tempResult=gD.CI_ProductBasketAddonsAddtion(dataSets,TestName);
	        break; 
	        case "CF_ProductBasketAddonsAddtion": 
	        	//tempResult=gD.CF_ProductBasketAddonsAddtion(dataSets,TestName);
	        break;
	        case "OI_ProductBasketAddonsAddtion": 
	        	tempResult=gD.OI_ProductBasketAddonsAddtion(dataSets,TestName);
	        break;
	        case "CI_PowerSpot_ProductBasketConfiguration": 
	        	tempResult=gD.CI_PowerSpot_ProductBasketConfiguration(dataSets,TestName);
	        break; 	        
	        case "CI_WLan_ProductBasketConfiguration": 
	        	tempResult=gD.CI_WLan_ProductBasketConfiguration(dataSets,TestName);
	        break; 		        
	        case "Installation_Information":
	        	tempResult=gD.installationInformation(dataSets,TestName);
	        break;
	        case "Billing_Account": 
	        	tempResult=gD.billingAccountAssignment(TestName);
	        break;
	        case "Product_Basket": 
	        	tempResult=gD.productBasketUpload(TestName);
	        break; 	
	        case "Validate_Order": 
	        	tempResult=gD.validateOrder(dataSets,TestName);
	        break; 	
	        case "SubOrders_Validation_And_completeOrderInConsole":
	        	gD.subOrdersValidationAndCompleteOrderInConsole(dataSets,TestName);	
	        	break;
	        case "SubOrders_Validation_And_Closure": 
	        	tempResult1=gD.subOrdersValidationAndClosure(TestName);
	        	AccountName=tempResult1[0];
	        	caseID = tempResult1[1];
	        	tempResult=tempResult1[2];
	        	tempResult1=null;
	        break; 	
	        case "completeOrderInConsole": 
	        	tempResult1=gD.completeOrder(dataSets,caseID,AccountName,TestName);
	        	orderStatus=tempResult1[0];
	        	tempResult=tempResult1[1];
	        	tempResult1=null;
	        break; 	
	        default:
	             //System.out.println("Not in 10, 20 or 30");  
	        }  
	        String OrderScope=(String) dataSets.get("OrderScope");
	        orderStatus=OrderScope;
	    }
	}

	@AfterMethod()
	@Parameters({ "TestName" })
	public void afterMethod(ITestResult result, String TestName) {
		getresult(result,TestName);
		try {
			updateResultinExcel(result,TestName,AccountName,orderStatus);
		} catch (Exception e) {
		}
	}

	@BeforeMethod()
	@Parameters({ "TestName" })
	public void beforeMethod(Method result,String TestName) {
		test = extent.startTest(TestName);
		test.log(LogStatus.INFO, TestName + " test Started");
	}
	
	@AfterClass
	public void testEnd() throws Exception {
		closeBrowser();
	}

	@AfterSuite
	public void cleanupSuite() throws Exception {
		wr.autoAlignExcel();
		AutomaticSanityMails ASM=new AutomaticSanityMails();
		  ASM.AutomaticMails();
	}
	}
