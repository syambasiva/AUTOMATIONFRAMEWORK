package com.test.automation.OM_Automation.uiActions;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.OM_Automation.excelReader.WritingInExcel;
import com.test.automation.OM_Automation.testBase.TestBase;

public class LeadCreation extends TestBase {
	
	public static final Logger log = Logger.getLogger(LeadCreation.class.getName());
	
	WebDriver driver;
	WritingInExcel wr=new WritingInExcel();
	@FindBy(xpath = "//a[@title='Leads Tab']")
	WebElement Leadstab;
	
	@FindBy(name = "new")
	WebElement Newleadbutton;

	@FindBy(id = "lea3")
	WebElement AccountName;

	//@FindBy(id = "00N3E000000GOgE")
	@FindBy(id = "00N58000009c3Wq")
	WebElement LegalEntityType; //Need to give value
	
		
	//@FindBy(id="name_salutationlea2")
	//*[@id="name_salutationlea2"]
	@FindBy(id="name_salutationlea2")
	WebElement Firstnamesalutaion; //Need to give value
	
	@FindBy(id = "name_firstlea2")
	WebElement Firstname;
	
	@FindBy(id = "name_lastlea2")
	WebElement LastName;
	
	@FindBy(id = "lea11")
	WebElement Email;

	@FindBy(id = "lea8")
	WebElement Phone;
	
	@FindBy(id = "lea9")
	WebElement Mobile;
		
	//@FindBy(xpath =".//*[@id='CF00N5800000BQynr_lkwgt']/img")
	@FindBy(xpath =".//*[@id='CF00N5800000BQynr_lkwgt']/img")
	WebElement partneraccountlookup;
	
	@FindBy(xpath = ".//*[@id='Account_body']/table/tbody/tr[2]/th/a")
	WebElement PartnerAccount;
	
	@FindBy(id = "00N58000007dViz")
	WebElement NationalIdNumber;
	
	//@FindBy(id = "00N3E000000HALM")
	@FindBy(id = "00N58000009c3X5")
	WebElement IndustryClassification; //Need to give value

	//@FindBy(id = "00N3E000000HALK")
	@FindBy(id = "00N58000009c3X2")
	WebElement DetailedIndustry; //Need to give value

	@FindBy(id = "00N58000007dVk7")
	WebElement VisitStreet;
	
		
	@FindBy(id="00N58000007dVjz")
	WebElement VisitHousenumber;
	
	@FindBy(id="00N58000007dVjn")
	WebElement Visitcity;
	
	@FindBy(id = "00N58000007dVk3")
	WebElement Postalcode;
	
	//@FindBy(id = "00N3E000000HaEn")
	@FindBy(id = "00N58000009c3X9")
	WebElement VistitState_provience;

	//@FindBy(id = "00N58000007dVjf")
	@FindBy(id = "00N58000007dVjf")
	WebElement Segment; //Need to give value

	//@FindBy(id = "00N3E000000GOgC")
	@FindBy(id = "00N58000009c3Wo")
	WebElement ConstructualOrganization;//Need to give value
	
	@FindBy(xpath = ".//*[@id='bottomButtonRow']/input[@title='Save']")
	WebElement leadsave;
	
	@FindBy(xpath = "//*[@id=\'tsidLabel\']")
	WebElement verifySalesPage;	
	
    @FindBy(xpath = "//*[@id='tsid-menuItems']/a[5]")
    WebElement saleslink;
    
    @FindBy(xpath = "//*[@id='tsidButton']")
    WebElement webpagesectiontype;
    
    /////////////////////////////////----Vignesh Updates----////////////////////////////////////////////////
    
	@FindBy(xpath = "//*[@id=\"00N58000007dVjW_unselected\"]/optgroup/option[1]")
	WebElement communicationPreferenceCall;
	@FindBy(xpath = "//*[@id=\"00N58000007dVjW_unselected\"]/optgroup/option[2]")
	WebElement communicationPreferenceEmail;
	@FindBy(xpath = "//*[@id=\"00N58000007dVjW_unselected\"]/optgroup/option[3]")
	WebElement communicationPreferenceFaceToFace;
	@FindBy(xpath = "//*[@id=\"00N58000007dVjW_unselected\"]/optgroup/option[4]")
	WebElement communicationPreferenceLetter;
	@FindBy(xpath = "//*[@id=\"00N58000007dVjW_unselected\"]/optgroup/option[5]")
	WebElement communicationPreferenceSMS;
	@FindBy(xpath = "//*[@id=\"00N58000007dVjW_unselected\"]/optgroup/option[6]")
	WebElement communicationPreferenceOptoutall;
	
	@FindBy(xpath = "//*[@id=\'00N58000007dVjW_right_arrow\']")
	WebElement communicationPreferenceChoosenArrow;	
	
	public LeadCreation(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void NewLeadCreation(String accountname, String legalentitytype, String namesalutation, String lastname, String firstname, String email, String industryclassification, String detailed_industry, String segment, String consorganization, String street, String houseno, String city, String postcode, String state ) throws Exception
	{
		
		String pageStatus = verifySalesPage.getText();
		System.out.println("page logged in is "+pageStatus+"NULL");
		if(!pageStatus.equals("Unitymedia Business"))
		{

			/*
            scrollTo(driver, webpagesectiontype);
            waitForclickable(driver, webpagesectiontype, 200);
            webpagesectiontype.click();
            Thread.sleep(5000);
            saleslink.click();
            */
		}

		waitForElement(driver, 200, Leadstab);
		Leadstab.click();
		log("Leads tab clicked");
		waitForElement(driver, 200, Newleadbutton);
		Newleadbutton.click();
		log("New lead button clicked");
		waitForElement(driver, 200, Firstname);
		Randomalphabets(driver, AccountName, 8);
		//AccountName.sendKeys(accountname);
		log("Account name passed");
		dropdownselection(driver, Firstnamesalutaion, namesalutation);
		log("Salutation selected");
		//Firstname.sendKeys(firstname);
		Randomalphabets(driver, Firstname, 5);
		log("Firstname passed");
		Randomalphabets(driver, LastName, 3);
		//LastName.sendKeys(lastname);
		log("last name passed");
		dropdownselection(driver, LegalEntityType, legalentitytype);
		log("Legal Entity type selected");
		Email.sendKeys(email);
		log("Email value passed");
		Randomnumbers(driver, Phone, 10);
		log("phone value passed");
		//Thread.sleep(50000);
		partneraccountselection();
		Thread.sleep(2000);
		Randomnumbers(driver, NationalIdNumber, 8);
		log("NationalID value Passed");
		scrollTo(driver, IndustryClassification);
		waitForElement(driver, 100, IndustryClassification);
		dropdownselection(driver, IndustryClassification, industryclassification);
		log("Industry classification as"+industryclassification+"selected");
		scrollTo(driver, DetailedIndustry);
		waitForElement(driver, 100, DetailedIndustry);
		dropdownselectionbyvalue(driver, DetailedIndustry, detailed_industry);
		log("Detailed Industry as "+detailed_industry+" selected>");
		waitForElement(driver, 100, Segment);
		dropdownselection(driver, Segment, segment);
		log("segment as "+segment+" selected");
		waitForElement(driver, 100, ConstructualOrganization);
		dropdownselection(driver, ConstructualOrganization, consorganization);
		log("constructional Organization as "+consorganization+" selected");
		scrollTo(driver,VistitState_provience);
		VisitStreet.sendKeys(street);
		log("visit street as "+street+" selected");
		VisitHousenumber.sendKeys(houseno);
		log("visit house number as "+houseno+" selected");
		Visitcity.sendKeys(city);
		log("visit city as "+city+" selected");
		Postalcode.sendKeys(postcode);
		log("postal code as "+postcode+"   selected>");
		waitForElement(driver, 100, VistitState_provience);
		dropdownselection(driver, VistitState_provience, state);
		log("visit state/provience as "+state+"   selected");
		scrollTo(driver, leadsave);
		waitForElement(driver, 200, leadsave);
		leadsave.click();
		log("<-----------Lead was successfully created------>");
			
	}
	public void partnerRegressionValidationleadHandler(Map<String, String> dataSheetTestDataEn,String Partnerselection) throws Exception {
		if (Partnerselection.equals("PartnerAccount")) {
		}
		else if (Partnerselection.equals("PartnerAccountNotSelected"));
		{
			
		}
		}	
	public void partneraccountselection() throws Exception{
		waitForElement(driver, 200, partneraccountlookup);
		partneraccountlookup.click();// partner accaountlookup lookup select
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> win1 = set1.iterator();
		String parent = win1.next();
		String child = win1.next();
		driver.switchTo().window(child);
		System.out.println("window switched");
		Thread.sleep(2000);
		driver.switchTo().frame("resultsFrame");
		System.out.println("resultsFrame switched");
		waitForElement(driver, 200, PartnerAccount);
		PartnerAccount.click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		System.out.println("parent window switched");
		Thread.sleep(2000);
	}
	public String NewLeadCreationGeneric(Map<String, String> dataSets) throws Exception
	{
		String RegressionValidation=(String) dataSets.get("RegressionValidation");
		String pageStatus = verifySalesPage.getText();
		System.out.println("page logged in is "+pageStatus);
		if(!pageStatus.equals("Unitymedia Business"))
		{
			log("New lead jhgjhkjhbnjbnb clicked");
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
                         //break;
                   }
                   
            }

            /*
            scrollTo(driver, webpagesectiontype);
            waitForclickable(driver, webpagesectiontype, 200);
            webpagesectiontype.click();
            Thread.sleep(5000);
            saleslink.click();
            */
		}
        Thread.sleep(5000);
		waitForElement(driver, 200, Leadstab);
		Leadstab.click();
		log("Leads tab clicked");
		Thread.sleep(3000);
		waitForElement(driver, 200, Newleadbutton);
		Newleadbutton.click();
		log("New lead button clicked");
		if (RegressionValidation.equals("PartnerAccountNotSelected")) {
		}
		else
		{
			partneraccountselection();
		}
		
		String AccountName=LeadInitilizations(dataSets);
		return AccountName;

	}	

	public String NewLeadCreationPartnerGeneric(Map<String, String> dataSets) throws Exception
	{
		waitForElement(driver, 200, Newleadbutton);
		Newleadbutton.click();
		log("New lead button clicked");
		String AccountName=LeadInitilizations(dataSets);
		return AccountName;

	}	
	public String LeadInitilizations(Map<String, String> dataSets) throws Exception
	{
			//String hello=(String) dataSets.get("ceedata");
			String namesalutation=(String) dataSets.get("namesalutation");
			String legalentitytype=(String) dataSets.get("legalentitytype");
			String email=(String) dataSets.get("email");
			String industryclassification=(String) dataSets.get("industryclassification");
			String detailed_industry=(String) dataSets.get("detailed_industry");
			String segment=(String) dataSets.get("segment");
			String consorganization=(String) dataSets.get("consorganization");
			//////////////////////////////////
			String street=(String) dataSets.get("street");
			String houseno=(String) dataSets.get("houseno");
			String housenoextension=(String) dataSets.get("housenoextension");
			String city=(String) dataSets.get("city");
			String postcode=(String) dataSets.get("postcode");
			String state=(String) dataSets.get("state");
			String communicationPreference=(String) dataSets.get("communicationPreference");
			

			waitForElement(driver, 200, Firstname);
			String Temp1=Randomalphabets(driver, AccountName, 8);
			//AccountName.sendKeys(accountname);
			log("Account name passed as  "+Temp1);
			dropdownselection(driver, Firstnamesalutaion, namesalutation);
			log("Salutation selected");
			//Firstname.sendKeys(firstname);
			String Temp2=Randomalphabets(driver, Firstname, 5);
			log("Firstname passed as "+ Temp2);
			String Temp3=Randomalphabets(driver, LastName, 3);
			//LastName.sendKeys(lastname);
			log("last name passed as "+Temp3);
			dropdownselection(driver, LegalEntityType, legalentitytype);
			log("Legal Entity type selected");
			Email.sendKeys(email);
			log("Email value passed");
			Randomnumbers(driver, Phone, 10);
			log("phone value passed");
			//partneraccountselection();
			Thread.sleep(2000);
			scrollTo(driver,NationalIdNumber);
			Randomnumbers(driver, NationalIdNumber, 8);
			log("NationalID value Passed");
			scrollTo(driver, IndustryClassification);
			waitForElement(driver, 100, IndustryClassification);
			dropdownselection(driver, IndustryClassification, industryclassification);
			log("Industry classification as"+industryclassification+"selected");
			scrollTo(driver, DetailedIndustry);
			waitForElement(driver, 100, DetailedIndustry);
			dropdownselectionbyvalue(driver, DetailedIndustry, detailed_industry);
			log("Detailed Industry as "+detailed_industry+" selected>");
			waitForElement(driver, 100, Segment);
			dropdownselection(driver, Segment, segment);
			log("segment as "+segment+" selected");
			waitForElement(driver, 100, ConstructualOrganization);
			dropdownselection(driver, ConstructualOrganization, consorganization);
			log("constructional Organization as "+consorganization+" selected");
			scrollTo(driver,VistitState_provience);
			VisitStreet.sendKeys(street);
			log("visit street as "+street+" selected");
			VisitHousenumber.sendKeys(houseno);
			log("visit house number as "+houseno+" selected");
			/*
			if(!housenoextension.equals("false")) {
				VisitHousenumberExtension.sendKeys(housenoextension);
				log("visit house number Extension as "+housenoextension+" selected");
			}
			*/
			Visitcity.sendKeys(city);
			log("visit city as "+city+" selected");
			Postalcode.sendKeys(postcode);
			log("postal code as "+postcode+"   selected>");
			waitForElement(driver, 100, VistitState_provience);
			dropdownselection(driver, VistitState_provience, state);
			log("visit state/provience as "+state+"   selected");
			switch(communicationPreference) {
			case "Call":
				waitForElement(driver, 100, communicationPreferenceCall);
			    scrollTo(driver,communicationPreferenceCall);
			    communicationPreferenceCall.click();
				break;
			case "Email":
				waitForElement(driver, 100, communicationPreferenceEmail);
			    scrollTo(driver,communicationPreferenceEmail);
			    communicationPreferenceEmail.click();
				break;
			case "Face to Face":
				waitForElement(driver, 100, communicationPreferenceFaceToFace);
			    scrollTo(driver,communicationPreferenceFaceToFace);
			    communicationPreferenceFaceToFace.click();
				break;
			case "Letter":
				waitForElement(driver, 100, communicationPreferenceLetter);
			    scrollTo(driver,communicationPreferenceLetter);
			    communicationPreferenceLetter.click();
				break;
			case "Sms":
				waitForElement(driver, 100, communicationPreferenceSMS);
			    scrollTo(driver,communicationPreferenceSMS);
			    communicationPreferenceSMS.click();
				break;
			case "Opt out all":
				waitForElement(driver, 100, communicationPreferenceOptoutall);
			    scrollTo(driver,communicationPreferenceOptoutall);
			    communicationPreferenceOptoutall.click();
				break;
	        default:
			}
			log("communication preference is selected as "+communicationPreference);
			Thread.sleep(1000);
			waitForElement(driver, 100, communicationPreferenceChoosenArrow);
		    scrollTo(driver,communicationPreferenceChoosenArrow);
			communicationPreferenceChoosenArrow.click();	
			scrollTo(driver, leadsave);
			waitForElement(driver, 200, leadsave);
			leadsave.click();
			log("<-----------Lead was successfully created------>");		
			String AccountName=Temp1;
			return AccountName;
	}

	
}
