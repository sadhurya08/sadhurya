package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationListPage {
	
    WebDriver driver; 
	public OrganisationListPage(WebDriver driver) {
	    this.driver=driver; 
	    PageFactory.initElements(driver,this);
   	}

	@FindBy(name = "search_text")
	private WebElement searcField;
	
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	
	@FindBy(xpath = "//a[text()='SanthoshKumar']")
	//@FindBy(id = "1")
	private WebElement selectOrgNameFromList;
	
	public WebElement getSelectOrgNameFromList() {
		return selectOrgNameFromList;
	}

	public WebElement getSearcField() {
		return searcField;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	
}
