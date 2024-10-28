package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {
	
    WebDriver driver;
	
	public CreatingNewCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignname")
	private WebElement campaignNameField;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement addProductBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getCampaignNameField() {
		return campaignNameField;
	}
	
	
	
	
}
