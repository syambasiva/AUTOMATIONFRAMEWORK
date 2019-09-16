package com.test.automation.OM_Automation.excelReader;

import java.io.IOException;

public class AutomaticSanityMails {

	//public static void main(String[] args) throws Exception  {
		//AutomaticSanityMails ASM=new AutomaticSanityMails();
	  //  ASM.AutomaticMails();
	//	wr.updateExcel_Sanity("Lead creation","Finished Lead creation usuccessful","Fail","");
    //}
	public void AutomaticMails() throws IOException{
		Runtime.getRuntime().exec( "wscript C:\\Users\\ramsuratkumar.mk\\myVBS.vbs" );
		System.out.println("The mail has been sent successfully");
    }
}
