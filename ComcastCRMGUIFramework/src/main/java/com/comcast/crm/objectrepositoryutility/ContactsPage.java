package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactsPage {

	WebDriver driver; 
	public ContactsPage(WebDriver driver) {
	    this.driver=driver; 
	    PageFactory.initElements(driver,this);
   	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contacts;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createNewContactBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEditContact; 
	
	@FindBy(id="bas_searchfield")
	private WebElement searchContactDD;
	
	@FindBy(name = "submit")
	private WebElement searchBtnContact;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastName;
	
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getSearchEditContact() {
		return searchEditContact;
	}

	public WebElement getSearchContactDD() {
		return searchContactDD;
	}

	public WebElement getSearchBtnContact() {
		return searchBtnContact;
	}
	
	
	
}
