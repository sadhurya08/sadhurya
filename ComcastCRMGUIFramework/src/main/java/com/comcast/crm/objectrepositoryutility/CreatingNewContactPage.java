package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	WebDriver driver; 
	public CreatingNewContactPage(WebDriver driver) {
	    this.driver=driver; 
	    PageFactory.initElements(driver,this);
   	}
	
	
	@FindBy(name="lastname")
	private WebElement contactLastNameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement addOrgInContactBtn;
	
	@FindBy(id = "search_txt")
	private WebElement searchFieldinOrgPopup;
	
	@FindBy(name ="search")
	private WebElement searchNowBtn;
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;
	
	public WebElement getAddOrgInContactBtn() {
		return addOrgInContactBtn;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSearchFieldinOrgPopup() {
		return searchFieldinOrgPopup;
	}

	public WebElement getContactLastNameEdit() {
		return contactLastNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public WebElement getAddOrgInContact() {
		return addOrgInContactBtn;
	}

	public void createContact(String lastName)
	{
		contactLastNameEdit.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContactwithOutsaving(String lastName)
	{
		contactLastNameEdit.sendKeys(lastName);
		
	}
	
	
	
	
	
}
