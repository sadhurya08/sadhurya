package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.comcast.crm.basetest.BaseClass;

public class ListImpclass implements ITestListener, ISuiteListener{

	public void onStart(ISuite suite)
	{
		System.out.println("Report configuration");
	}
	
	public void OnFinish(ISuite suite)
	{
		System.out.println("Report BackUP");
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("===== =====>"+result.getMethod().getMethodName()+">=====START====");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("===== =====>"+result.getMethod().getMethodName()+">====END=====");
	}
	
	public void onTestFailure(ITestResult result)
	{
		String testName = result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");  
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File("./screenshot/"+testName+" + "+time+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		
	}
}
