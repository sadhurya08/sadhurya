package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOpportunityPage {
	
	WebDriver driver;
	public CreatingNewOpportunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "detailedViewTextBox")
	private WebElement opportunityNameField;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement addOrganisationNameBtn;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[2]")
	private WebElement addCampaigninOpportunityBtn;
	
	@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAddCampaigninOpportunityBtn() {
		return addCampaigninOpportunityBtn;
	}

	public WebElement getAddOrganisationNameBtn() {
		return addOrganisationNameBtn;
	}

	public WebElement getOpportunityNameField() {
		return opportunityNameField;
	}
	
	

}
