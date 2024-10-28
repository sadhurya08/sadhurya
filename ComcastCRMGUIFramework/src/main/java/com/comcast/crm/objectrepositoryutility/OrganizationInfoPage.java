package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	WebDriver driver; 
	public OrganizationInfoPage(WebDriver driver) {
		    this.driver=driver; 
		    PageFactory.initElements(driver,this);
	   	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement headerMsgWithPhone;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industry;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getHeaderMsgWithPhone() {
		return headerMsgWithPhone;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	} 
	
	
}
