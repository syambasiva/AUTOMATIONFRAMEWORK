package com.test.automation.OM_Automation.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;
import com.sun.jna.platform.win32.WinBase.SYSTEM_INFO;

public class WritingInExcel {
/*
	public static void main(String[] args) throws Exception {
		WritingInExcel wr = new WritingInExcel();
		String abc=wr.GetDependancyData("MACDTerminate");
		if (abc==null){
		}
		else{
			System.out.println("sajdnaskd is "+ abc);
		}
		//wr.autoAlignExcel();
	}
	*/
	@SuppressWarnings("resource")
	public void createNewExcel() throws Exception {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String folderName = formater.format(calendar.getTime());
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Sheet1");
		FileOutputStream out = new FileOutputStream(
				new File("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\ExcelReports" + folderName + ".xlsx"));
		workbook.write(out);
		out.close();
		initilizeSheet("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\ExcelReports" + folderName + ".xlsx");
	}
	public void initilizeSheet(String Path) throws Exception {
		File src = new File(Path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		sheet1.createRow(0);
		sheet1.getRow(0).setHeight((short) 400);
		sheet1.getRow(0).createCell(0).setCellValue("S NO");
		sheet1.getRow(0).createCell(1).setCellValue("Senarion Name");
		sheet1.getRow(0).createCell(2).setCellValue("Description");
		sheet1.getRow(0).createCell(3).setCellValue("Test Results");
		sheet1.getRow(0).createCell(4).setCellValue("AccountName");
		sheet1.getRow(0).createCell(5).setCellValue("Comments");
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 1000; i++) {
				sheet1.createRow(i);
				sheet1.getRow(i).createCell(j);
			}
		}
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
	}
	@SuppressWarnings("resource")
	public void autoAlignExcel() throws Exception {
		String tempFileName = getLatestFilefromDir("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\");
		System.out.println(tempFileName);
		File src = new File("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\" + tempFileName);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		for(int i = 0; i < 250; i++){
			sheet1.autoSizeColumn(i);
		}
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
	}
	public String getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File f1, File f2) {
				return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
			}
		});
		String tempfoldername = files[0].getName();
		return tempfoldername;
	}

	public void updateExcel(String testCaseName, String testDescription, String testResults, String testComments,
			String testDefect) throws Exception {
		String tempFileName = getLatestFilefromDir("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\");
		File src = new File("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\"+tempFileName);
		//File src = new File("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\NewMicrosoftExcelWorksheet.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		for (int i = 1; i < 200; i = i + 1) {
			try {
				String temptestCaseName = sheet1.getRow(i).getCell(1).getStringCellValue();
				int temptestCaseNameLength = temptestCaseName.length();
				if (temptestCaseName.equals(testCaseName)) {
					sheet1.getRow(i).getCell(0).setCellValue(i);
					sheet1.getRow(i).getCell(2).setCellValue(testDescription);
					sheet1.getRow(i).getCell(3).setCellValue(testResults);
					sheet1.getRow(i).getCell(4).setCellValue(testComments);
					sheet1.getRow(i).getCell(5).setCellValue(testDefect);
					break;
				} else if (temptestCaseNameLength == 0) {
					sheet1.getRow(i).getCell(0).setCellValue(i);
					sheet1.getRow(i).getCell(1).setCellValue(testCaseName);
					sheet1.getRow(i).getCell(2).setCellValue(testDescription);
					sheet1.getRow(i).getCell(3).setCellValue(testResults);
					sheet1.getRow(i).getCell(4).setCellValue(testComments);
					sheet1.getRow(i).getCell(5).setCellValue(testDefect);
					break;
				}
			} catch (Exception e) {
				sheet1.createRow(i).createCell(0).setCellValue(i);
				sheet1.getRow(i).createCell(1).setCellValue(testCaseName);
				sheet1.getRow(i).createCell(2).setCellValue(testDescription);
				sheet1.getRow(i).createCell(3).setCellValue(testResults);
				sheet1.getRow(i).createCell(4).setCellValue(testComments);
				sheet1.getRow(i).createCell(5).setCellValue(testDefect);
				break;
			}
		}
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
		try {
			wb = new XSSFWorkbook(new FileInputStream(src));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateExcel_Sanity(String testStepName, String testDescription, String testResults, String testComments)
			throws Exception {
		File srcsan = new File("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\NewMicrosoftExcelWorksheet.xlsx");
		FileInputStream fisan = new FileInputStream(srcsan);
		XSSFWorkbook wbsan = new XSSFWorkbook(fisan);
		XSSFSheet sheetsan1 = wbsan.getSheet("Sheet2");
		for (int i = 3; i < 200; i = i + 1) {
			try {
				String temptestCaseName = sheetsan1.getRow(i).getCell(1).getStringCellValue();
				int temptestCaseNameLength = temptestCaseName.length();
				if (temptestCaseName.equals(testStepName)) {
					sheetsan1.getRow(i).getCell(0).setCellValue(i - 2);
					sheetsan1.getRow(i).getCell(2).setCellValue(testDescription);
					sheetsan1.getRow(i).getCell(3).setCellValue(testResults);
					sheetsan1.getRow(i).getCell(4).setCellValue(testComments);
					break;
				} else if (temptestCaseNameLength == 0) {
					sheetsan1.getRow(i).getCell(0).setCellValue(i - 2);
					sheetsan1.getRow(i).getCell(1).setCellValue(testStepName);
					sheetsan1.getRow(i).getCell(2).setCellValue(testDescription);
					sheetsan1.getRow(i).getCell(3).setCellValue(testResults);
					sheetsan1.getRow(i).getCell(4).setCellValue(testComments);
					break;
				}

			} catch (Exception e) {
				sheetsan1.createRow(i).createCell(0).setCellValue(i - 2);
				sheetsan1.getRow(i).createCell(1).setCellValue(testStepName);
				sheetsan1.getRow(i).createCell(2).setCellValue(testDescription);
				sheetsan1.getRow(i).createCell(3).setCellValue(testResults);
				sheetsan1.getRow(i).createCell(4).setCellValue(testComments);
				break;
			}
		}
		FileOutputStream foutsan = new FileOutputStream(srcsan);
		wbsan.write(foutsan);
		wbsan.close();
		try {
			wbsan = new XSSFWorkbook(new FileInputStream(srcsan));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String GetDependancyData(String testCaseName) throws Exception {
		String accountNumber=null;
		String tempFileName = getLatestFilefromDir("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\");
		File src = new File("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\"+tempFileName);
		//File src = new File("C:\\OM_UMSTDEMO_Automation\\TestResults\\Excel\\NewMicrosoftExcelWorksheet.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		for (int i = 1; i < 200; i = i + 1) {
			try {
				String temptestCaseName = sheet1.getRow(i).getCell(1).getStringCellValue();
				int temptestCaseNameLength = temptestCaseName.length();
				if (temptestCaseName.equals(testCaseName)) {
					//When the test case exists as the test is completed
					System.out.println("khfgejdfjhasgdsa");
					String temptestCaseStatus = sheet1.getRow(i).getCell(3).getStringCellValue();
					if (temptestCaseStatus.equals("Pass")) {
						accountNumber = sheet1.getRow(i).getCell(4).getStringCellValue();
						break;
					}
					if (temptestCaseStatus.equals("Fail")) {
						accountNumber = "Dependant Test Case Failed";
						break;
					}
				}
			} catch (Exception e) {
			System.out.println("khfgejdfjhasgdsaassjhdfsagdvnmasdfasmndnsadvmhsagd");
				break;
			}
		}
		return accountNumber;
	}
	
}
