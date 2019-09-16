package com.test.automation.OM_Automation.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class wordDocGeneric {
	public void genericWordDocUpdateCommentsandScreenshots(String TestCaseName , String TestStepName,String TestCaseStatus,String comments,WebDriver driver,String Path) throws IOException, InvalidFormatException{
		String newFolderPath=getLatestFilefromDir(Path);
	    XWPFDocument document = new XWPFDocument( new FileInputStream(Path+newFolderPath+"\\"+TestCaseName+".docx"));
	    List<XWPFParagraph>  paragraphs = document.getParagraphs();
	    XWPFParagraph paragraph =  paragraphs.get(paragraphs.size()-1);   
	    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    XWPFRun runText = paragraph.createRun();
	    runText.setText("Test Step : " +TestStepName);
	    runText.addBreak();
	    runText.setText("Test Case Status : " +TestCaseStatus);
	    runText.addBreak();
	    runText.setText("Comments : " +comments);
		runText.addBreak();
		runText.addPicture(new FileInputStream(scrFile), XWPFDocument.PICTURE_TYPE_PNG, "", Units.toEMU(500), Units.toEMU(350));
		runText.addBreak(BreakType.PAGE);
		FileOutputStream out = new FileOutputStream(Path+newFolderPath+"\\"+TestCaseName+".docx");
		document.write(out);
		out.close();
		document.close();
	}	
	public void genericNewWordDocCreate(String TestCaseName,String Path) throws IOException{
		String newFolderPath=getLatestFilefromDir(Path);
	    XWPFDocument document = new XWPFDocument(); 
	    FileOutputStream out = new FileOutputStream( new File(Path+newFolderPath+"\\"+TestCaseName+".docx"));
	    XWPFParagraph paragraph = document.createParagraph();
	    XWPFRun run = paragraph.createRun();
	    run.setText("");
	    document.write(out);
	    out.close();
	    document.close();
	}	
	public String getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    Arrays.sort(files, new Comparator<File>() {
	        public int compare(File f1, File f2) {
	            return Long.valueOf(f2.lastModified()).compareTo(
	                    f1.lastModified());
	        }
	    });
	    String tempfoldername=files[0].getName();
	    return tempfoldername;
	 }	
	public void createNewFolder(String path){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String folderName=formater.format(calendar.getTime());
	    File file = new File(path+folderName);
	    if (!file.exists()) {
	    	file.mkdirs();
	      }
	}
	
}
