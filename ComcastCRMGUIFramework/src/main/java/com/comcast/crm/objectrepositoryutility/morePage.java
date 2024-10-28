package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class morePage {
	
	WebDriver driver;
	public morePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[.='Vendors']")
	private WebElement vendor;
	
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

    public WebElement getVendor() {
		return vendor;
	}
	

}
