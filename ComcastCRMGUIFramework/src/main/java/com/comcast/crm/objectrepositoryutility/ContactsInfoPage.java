package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	WebDriver driver; 
	public ContactsInfoPage(WebDriver driver) {
		    this.driver=driver; 
		    PageFactory.initElements(driver,this);
	   	}
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement viewSupportStartDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement viewSupportEndDate;
	
	public WebElement getViewSupportStartDate() {
		return viewSupportStartDate;
	}

	public WebElement getViewSupportEndDate() {
		return viewSupportEndDate;
	}

	@FindBy(className ="dvHeaderText")
	private WebElement contactHeaderMsg;
	
	/*
	 * @FindBy(id = "mouseArea_Organization Name") private WebElement actualOrg
	 */
	
	public WebElement getContactHeaderMsg() {
		return contactHeaderMsg;
	}
	
	
	
	

}
