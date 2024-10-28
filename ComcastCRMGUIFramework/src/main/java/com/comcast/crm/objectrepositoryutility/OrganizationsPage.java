package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class OrganizationsPage {

    WebDriver driver; 
	public OrganizationsPage(WebDriver driver) {
	    this.driver=driver; 
	    PageFactory.initElements(driver,this);
   	}
	
	@FindBy(xpath ="//IMG[@title=\"Create Organization...\"]")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSearchEdit() {
		return searchEdit;
	}


	public WebElement getSearchDD() {
		return searchDD;
	}


	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
}
