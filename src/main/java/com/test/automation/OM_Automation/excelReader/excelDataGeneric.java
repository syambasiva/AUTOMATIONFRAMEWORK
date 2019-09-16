package com.test.automation.OM_Automation.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
//import java.io.FileOutputStream;
//import java.util.Map.Entry;
//import java.util.HashMap;
//import com.gargoylesoftware.htmlunit.javascript.host.Map;
//import org.apache.poi.xssf.usermodel.XSSFCell;
public class excelDataGeneric {
                //public static void main(String[] args) throws Exception  {
                //	excelDataGeneric wr=new excelDataGeneric();
               //     wr.address_ValidationDriver("TC02");
                    //Map<String, String> dataHashDataMap=wr.address_Validation("TC02");
                    //String value = (String) dataHashDataMap.get("Column3");
                    //System.out.println("dfjkghdshkafghdgfhdsgfshdgfshdgxcvbcxzvbvnvbxcvbxmcvbxmnbczvf"+value);
                    //String value1 = (String) dataHashDataMap.get("TestCaseName");
                  //  System.out.println("dfjkghdshkafghdzcnxbzcmnvbxzmncvbxmnzvbcxzczgfhdsgfshdgfshdgf"+value1);      
                //}

	@SuppressWarnings("deprecation")
	public Map<String, String> newenvsetups() throws Exception{
//		String abc;
		String dataSets[][] = null;
		File srcsan = new File("C:\\OM_UMSTDEMO_Automation\\DataSheet\\TestData.xlsx");
		FileInputStream fisan = new FileInputStream(srcsan);
		XSSFWorkbook wbsan = new XSSFWorkbook(fisan);
		XSSFSheet sheetsan1 = wbsan.getSheet("LoginTestData");
		//String abc=sheetsan1.getRow(0).getCell(0).getStringCellValue();
		int rownum=sheetsan1.getLastRowNum();
		dataSets=new String[rownum+1][2];
		for (int j=0;j<=1;j++){
	    for (int i=0;i<rownum+1;i++){
		if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_STRING) {
			dataSets[i][j] = sheetsan1.getRow(i).getCell(j).getStringCellValue();
		} else if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
			String cellText = String.valueOf(sheetsan1.getRow(i).getCell(j).getNumericCellValue());
			dataSets[i][j] = cellText;
		} else {
			dataSets[i][j] = String.valueOf(sheetsan1.getRow(i).getCell(j).getBooleanCellValue());
		}
	    }
		}
		for (int i=0;i<rownum-1;i++){
			//System.out.println("I zero is "+i+" "+dataSets[i][0]);
		}
		for (int i=0;i<rownum-1;i++){
			//System.out.println("I One is "+dataSets[i][1]);
		}
		String[][] dataHashDataOne = dataSets;
		Map<String, String> dataHashDataMap = Arrays.stream(dataHashDataOne)
				.collect(Collectors.toMap(e -> e[0], e -> e[1]));
		wbsan.close();
		return dataHashDataMap;	
	}
	
            @SuppressWarnings({ "deprecation" })
    public Map<String, String> dataSheetTestData(String testStepName,String excelName, String sheetName) throws Exception {
                String temptestCaseName = null;
                String temptestCaseNameIdentifier=null;
                int rownum = 0;
                int columnNumber=0;
                String dataSets[][] = null;
        File srcsan=new File(excelName);
        FileInputStream fisan=new FileInputStream(srcsan);
        XSSFWorkbook wbsan=new XSSFWorkbook(fisan);
        XSSFSheet sheetsan1=wbsan.getSheet(sheetName);
        int totalColumn = sheetsan1.getRow(0).getLastCellNum();
        int totalRow = sheetsan1.getLastRowNum() + 1;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        for(int i = 0; i < totalColumn; i = i + 1) {
            temptestCaseNameIdentifier=sheetsan1.getRow(0).getCell(i).getStringCellValue();
        if (temptestCaseNameIdentifier.equals("TestCaseName"))
                           {
            //System.out.println(i);
              columnNumber=i;
              //System.out.println("the temptestCaseNameIdentifier is"+ columnNumber);
                           }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
        for(int i = 1; i < totalRow; i = i + 1) {
                 temptestCaseName=sheetsan1.getRow(i).getCell(columnNumber).getStringCellValue();
             if (temptestCaseName.equals(testStepName))
                                {
                 //System.out.println(i);
                 //String Dummy=sheetsan1.getRow(i).getCell(columnNumber).getStringCellValue();
                   //System.out.println("Check the dummy number "+Dummy);
                   rownum=i;
                                }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //System.out.println("Total colum is "+totalColumn);
        dataSets = new String[totalColumn][2];
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 1; i++) {
        //System.out.println("Inside for loop ");
		        for (int j = 0; j < totalColumn; j++) {
		        	//System.out.println("loop count is "+ j);
						if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_STRING){
						dataSets[j][0] = sheetsan1.getRow(i).getCell(j).getStringCellValue();
						}
						else if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
						String cellText = String.valueOf(sheetsan1.getRow(i).getCell(j).getNumericCellValue());
						dataSets[j][0] = cellText;
						} else{
						dataSets[j][0] = String.valueOf(sheetsan1.getRow(i).getCell(j).getBooleanCellValue());
						}
				}
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = rownum; i < rownum+1; i++) {
        //System.out.println("Inside for loop ");
			        for (int j = 0; j < totalColumn; j++) {
			        	//System.out.println("loop count is "+ j);
					if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_STRING){
					dataSets[j][1] = sheetsan1.getRow(i).getCell(j).getStringCellValue();
					}
					else if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					String cellText = String.valueOf(sheetsan1.getRow(i).getCell(j).getNumericCellValue());
					dataSets[j][1] = cellText;
					} else{
					dataSets[j][1] = String.valueOf(sheetsan1.getRow(i).getCell(j).getBooleanCellValue());
					}
					}
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                String[][] dataHashData = dataSets;
                Map<String, String> dataHashDataMap = Arrays.stream(dataHashData).collect(Collectors.toMap(e -> e[0], e -> e[1]));
                		//for (Entry<String, String> e : dataHashDataMap.entrySet()) {
                		//    System.out.println(e.getKey() + " : " + e.getValue());
                		//}        
        wbsan.close();
        return dataHashDataMap;
    }   
            @SuppressWarnings({ "deprecation" })
            public String[][] dataSheetDriver(String testStepName,String excelName, String sheetName) throws Exception {
                        String temptestCaseName = null;
                        String temptestCaseNameIdentifier=null;
                        int rownum = 0;
                        int columnNumber=0;
                        String dataSets[][] = null;
                File srcsan=new File(excelName);
                FileInputStream fisan=new FileInputStream(srcsan);
                XSSFWorkbook wbsan=new XSSFWorkbook(fisan);
                XSSFSheet sheetsan1=wbsan.getSheet(sheetName);
                int totalColumn = sheetsan1.getRow(0).getLastCellNum();
                int totalRow = sheetsan1.getLastRowNum() + 1;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                
                for(int i = 0; i < totalColumn; i = i + 1) {
                    temptestCaseNameIdentifier=sheetsan1.getRow(0).getCell(i).getStringCellValue();
                if (temptestCaseNameIdentifier.equals("TestCaseName"))
                                   {
                    //System.out.println(i);
                      columnNumber=i;
                      //System.out.println("the temptestCaseNameIdentifier is"+ columnNumber);
                                   }
                }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                for(int i = 1; i < totalRow; i = i + 1) {
                         temptestCaseName=sheetsan1.getRow(i).getCell(columnNumber).getStringCellValue();
                     if (temptestCaseName.equals(testStepName))
                                        {
                         //System.out.println(i);
                         //String Dummy=sheetsan1.getRow(i).getCell(columnNumber).getStringCellValue();
                           //System.out.println("Check the dummy number "+Dummy);
                           rownum=i;
                                        }
                }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //System.out.println("Total colum is "+totalColumn);
                dataSets = new String[totalColumn][2];
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                for (int i = 0; i < 1; i++) {
                //System.out.println("Inside for loop ");
        		        for (int j = 0; j < totalColumn; j++) {
        		        	//System.out.println("loop count is "+ j);
        						if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_STRING){
        						dataSets[j][0] = sheetsan1.getRow(i).getCell(j).getStringCellValue();
        						}
        						else if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
        						String cellText = String.valueOf(sheetsan1.getRow(i).getCell(j).getNumericCellValue());
        						dataSets[j][0] = cellText;
        						} else{
        						dataSets[j][0] = String.valueOf(sheetsan1.getRow(i).getCell(j).getBooleanCellValue());
        						}
        				}
                }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                for (int i = rownum; i < rownum+1; i++) {
                //System.out.println("Inside for loop ");
        			        for (int j = 0; j < totalColumn; j++) {
        			        	//System.out.println("loop count is "+ j);
        					if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_STRING){
        					dataSets[j][1] = sheetsan1.getRow(i).getCell(j).getStringCellValue();
        					}
        					else if (sheetsan1.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
        					String cellText = String.valueOf(sheetsan1.getRow(i).getCell(j).getNumericCellValue());
        					dataSets[j][1] = cellText;
        					} else{
        					dataSets[j][1] = String.valueOf(sheetsan1.getRow(i).getCell(j).getBooleanCellValue());
        					}
        					}
                }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //System.out.println("sjldhsajdghshkagdshkagdshagdshagdshagdshagd");
                        String[][] dataHashDataMap = dataSets;
                        //for (int i=0; i < 2 ; i++){
                        //System.out.println("Hi");
                        //for (int j = 0; j < totalColumn; j++) {
                        //	System.out.println(dataHashDataMap[j][i]);
                        //}
                        //}

                wbsan.close();
                return dataHashDataMap;
            }   
}
