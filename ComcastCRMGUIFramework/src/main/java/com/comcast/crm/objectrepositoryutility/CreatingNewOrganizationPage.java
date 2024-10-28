package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
    WebDriver driver; 
	public CreatingNewOrganizationPage(WebDriver driver) {
		    this.driver=driver; 
		    PageFactory.initElements(driver,this);
	   	}

	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(id ="phone")
	private WebElement phoneNum;

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public void createOrg(String orgName)
	{
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName,String industry)
	{
		orgNameEdit.sendKeys(orgName);
		Select sel = new Select(industryDD);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	
	public void createOrg(String orgName,String industry,String type )
	{
		orgNameEdit.sendKeys(orgName);
		Select sel = new Select(industryDD);
		sel.selectByVisibleText(industry);
		Select sel1 = new Select(typeDD);
		saveBtn.click();
	}
	public void createOrgWithPhoneNumber(String orgName,String phoneNo)
	{
		orgNameEdit.sendKeys(orgName);
	    phoneNum.sendKeys(phoneNo);
		saveBtn.click();
	}
	
	
	
}
