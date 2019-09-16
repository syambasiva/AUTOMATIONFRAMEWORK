package com.test.automation.OM_Automation.uiActions;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.OM_Automation.testBase.TestBase;

public class FinalValidationOfOrderCompletion extends TestBase {

       public static final Logger log = Logger.getLogger(ValidateOrder.class.getName());
       
       List<WebElement> abcs;
       
       //@FindBy(xpath = "//*[@id=\"CF00N58000005xcm2_ileinner\"]")
       @FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/a")
       WebElement accountNameLink;
       
       @FindBy(xpath = "//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr/td[2]/a")
       WebElement statusTableCheck;
       
       @FindBy(xpath = "//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr/td[3]/span")
       WebElement statusTableCheck2;
       
       @FindBy(xpath = "//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr[1]/td[2]/a")
       WebElement statusTableCheckRow;
       
       @FindBy(xpath = "//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr[1]/td[3]/span")
       WebElement statusTableCheckRow2;
       
       @FindBy(xpath = "//*[@id=\"j_id0:j_id2\"]/div/div/ul[2]/li[4]/div/div/button/span")
       WebElement filterOutAllOrders;

       @FindBy(xpath = "//*[@id=\"j_id0:j_id2\"]/div/div/ul[2]/li[4]/div/div/div/ul/li[1]/a")
       WebElement selectAllOption;

       //@FindBy(xpath = "//*[@id=\"head_01B0E000000sDdM_ep\"]")
       @FindBy(xpath = "//*[@id=\"head_01B0E000000sDdM_ep\"]")
       WebElement scroolbelowCloudSenseIFrame;
       //*[@id="head_01B4E000001eu5R_ep"]/h3
       
       public FinalValidationOfOrderCompletion(WebDriver driver) {
              this.driver = driver;
              PageFactory.initElements(driver, this);
       }
       
       public void orderStatusCheck(Map<String, String> dataSets,String TestName) throws Exception {
              String CI_OrderType=(String) dataSets.get("CI_OrderType");
              String segment=(String) dataSets.get("segment");
              String WLANType=(String) dataSets.get("WLANType");
              String OverAllType=(String)dataSets.get("OverallType");
              waitForElement(driver, 200, accountNameLink);
              log("Account page wait");
              scrollTo(driver, accountNameLink);
              log("Account page scrool");
              openlinkinnewtab(driver, accountNameLink);
              log("Account page opened");
              BrowserTabSwitch(driver);
              log("Account tab switch");
              abcs = driver.findElements(By.tagName("iframe"));
              int i=0;
              String frameName=null;
              for (WebElement abc : abcs) {
                     i=i+1;
                     System.out.println("Frame Id :" + abc.getAttribute("id"));
                     log("Frame Id :" + abc.getAttribute("id"));
                     log("Value of i = "+i);
                     if (i==2) {
                           frameName=abc.getAttribute("id");
                           log("Frame Id finalized is" + frameName); 
                     }
              }
              scrollTo(driver, scroolbelowCloudSenseIFrame);
              Thread.sleep(2000);
              log("scroolbelowCloudSenseIFrame");
              try {
              driver.switchTo().frame(frameName);
              log("frame switched in try");
              }catch(Exception e) {
                     driver.switchTo().frame("06658000001cRDG");
                     log("frame switched in catch");
              }
              filterOutAllOrders.click();
              log("filterOutAllOrders");
              Thread.sleep(1000);
              selectAllOption.click();
              Thread.sleep(5000);
              log("selectAllOption");
              for (int j=0;j<10;j++) {
                     //*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr/td[2]/a
                     if (j==0) {
                           String Temp=driver.findElement(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr/td[2]/a")).getText();
                           System.out.println("Type of Order "+ Temp );
                           log("Type of Order " + Temp );
                           String TempStatus=driver.findElement(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr/td[3]/span")).getText();
                           System.out.println("Status for Order "+ Temp + " is "+ TempStatus );
                           log("Status for Order "+ Temp + " is "+ TempStatus );                                         
                     }
                     else if (!(j==0)) {
                            if(!driver.findElements(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr["+j+"]/td[2]/a")).isEmpty()){
                     String Temp=driver.findElement(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr["+j+"]/td[2]/a")).getText();
                     System.out.println("Type of Order "+ Temp );
                     log("Type of Order "+ Temp );
                     String TempStatus=driver.findElement(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr["+j+"]/td[3]/span")).getText();
                     System.out.println("Status for Order "+ Temp + " is "+ TempStatus );
                     log("Status for Order "+ Temp + " is "+ TempStatus );                                         
               }
                     }
              }
              
              for (int j=0;j<10;j++) {
                     //*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr/td[2]/a
                     if (j==0) {
                           String Temp=driver.findElement(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr/td[2]/a")).getText();
                           String TempStatus=driver.findElement(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr/td[3]/span")).getText();              
                           if (Temp.equals("Company Voice")&&CI_OrderType.equals("Manual")) {
                                  Assert.assertEquals("Active", TempStatus);
                           }
                           else if(Temp.equals("Company Internet")&&OverAllType.equals("MACDTerminate")) {
                        	   Assert.assertEquals("Inactive", TempStatus);
                           }
                           else if(Temp.equals("Office Internet")&&OverAllType.equals("MACDTerminate")) {
                        	   Assert.assertEquals("Inactive", TempStatus);
                           }
                           else if(Temp.equals("Company Internet")&&CI_OrderType.equals("Manual")) {
                               if (TempStatus.equals("Closed Replaced")||TempStatus.equals("Subscription Termination Requested")){   
                        	   
                               }
                               else {
                            	   Assert.assertEquals("Active", TempStatus);
                               }
                           }
                           else if(Temp.equals("Company Internet")&&!CI_OrderType.equals("Manual")) {
                        	   if (TempStatus.equals("Closed Replaced")||TempStatus.equals("Subscription Termination Requested")){   
                               	   
                               }
                               else {
                                  Assert.assertEquals("Requested", TempStatus);
                           }
                           }
                           else if(Temp.equals("Office Internet")&&segment.equals("SME")) {
                               Assert.assertEquals("Active", TempStatus);
                        }
                           else if(Temp.equals("Office Internet")&&!segment.equals("SME")) {
                               Assert.assertEquals("Requested", TempStatus);
                        }
                           else if(Temp.equals("Company Fiber")) {
                               Assert.assertEquals("Provisioned", TempStatus);
	                        }
	                           else if(Temp.equals("WLAN")&&WLANType.equals("Powerspot")&&CI_OrderType.equals("Manual")) {
	                               Assert.assertEquals("Active", TempStatus);
	                        }
	                           else if(Temp.equals("WLAN")&&WLANType.equals("Powerspot")&&CI_OrderType.equals("Automatic")) {
	                               Assert.assertEquals("Requested", TempStatus);
	                        }
	                           else if(Temp.equals("WLAN")&&WLANType.equals("Wlan")) {
	                               Assert.assertEquals("Active", TempStatus);
	                        }
                    		pocUpdates(TestName, "Orders Final Status", "Information",
               					"Status of the orders placed in order journey ", driver);
                     }
                     else if (!(j==0)) {
                            if(!driver.findElements(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr["+j+"]/td[2]/a")).isEmpty()){
                                         String Temp=driver.findElement(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr["+j+"]/td[2]/a")).getText();
                                         String TempStatus=driver.findElement(By.xpath("//*[@id=\"SubscriptionsTabContent\"]/table/tbody/tr["+j+"]/td[3]/span")).getText();
                                         if (Temp.equals("Company Voice")&&CI_OrderType.equals("Manual")) {
                                             Assert.assertEquals("Active", TempStatus);
                                      }
                                      
                                         else if(Temp.equals("Company Internet")&&OverAllType.equals("MACDTerminate")) {
                                      	   Assert.assertEquals("Inactive", TempStatus);
                                         }
                                         else if(Temp.equals("Office Internet")&&OverAllType.equals("MACDTerminate")) {
                                      	   Assert.assertEquals("Inactive", TempStatus);
                                         }
                                         else if(Temp.equals("Company Internet")&&CI_OrderType.equals("Manual")) {
                                    	  if (TempStatus.equals("Closed Replaced")||TempStatus.equals("Subscription Termination Requested")){   
                                       	   
                                          }
                                          else {
                                       	   Assert.assertEquals("Active", TempStatus);
                                          }
                                    	  }
                                      else if(Temp.equals("Company Internet")&&!CI_OrderType.equals("Manual")) {
                                    	  if (TempStatus.equals("Closed Replaced")||TempStatus.equals("Subscription Termination Requested")){   
                                          	   
                                          }
                                          else {
                                             Assert.assertEquals("Requested", TempStatus);
                                          }
                                      }
                                      else if(Temp.equals("Office Internet")&&segment.equals("SME")) {
                                          Assert.assertEquals("Active", TempStatus);
                                   }
                                      else if(Temp.equals("Office Internet")&&!segment.equals("SME")) {
                                          Assert.assertEquals("Requested", TempStatus);
                                   }
                                      else if(Temp.equals("Company Fiber")) {
                                          Assert.assertEquals("Provisioned", TempStatus);
           	                        }
                                    else if(Temp.equals("WLAN")&&WLANType.equals("Powerspot")&&CI_OrderType.equals("Manual")) {
       	                               Assert.assertEquals("Active", TempStatus);
       	                        }
       	                           else if(Temp.equals("WLAN")&&WLANType.equals("Powerspot")&&CI_OrderType.equals("Automatic")) {
       	                               Assert.assertEquals("Requested", TempStatus);
       	                        }
                                      else if(Temp.equals("WLAN")) {
       	                               Assert.assertEquals("Active", TempStatus);
       	                        }
                                 		pocUpdates(TestName, "Orders Final Status", "Information",
                            					"Status of the orders placed in order journey ", driver);
                            	
                     }
              }
              		
              /*
              String Temp222=statusTableCheck.getText();
              System.out.println("tHE VALUE IS"+ Temp222 );
              log("tHE VALUE IS"+ Temp222 );
              String Temp2222=statusTableCheck2.getText();
              System.out.println("tHE VALUE IS 2 "+ Temp2222 );
              log("tHE VALUE IS 2"+ Temp2222 );
              String TempRow222=statusTableCheckRow.getText();
              System.out.println("tHE VALUE IS row "+ TempRow222 );
              log("tHE VALUE IS row "+ TempRow222 );
              String TempRow2222=statusTableCheckRow2.getText();
              System.out.println("tHE VALUE IS row 2 "+ TempRow2222 );
              log("tHE VALUE IS row 2 "+ TempRow2222 );
              */
              //Thread.sleep(1000000);
       }
              pocUpdates(TestName, "Orders Final Status", "Information",
  					"Status of the orders placed in order journey ", driver);
}
}