package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorListPage {
	WebDriver driver;
	public VendorListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	private WebElement searchField;
	
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	@FindBy(xpath = "//a[.='universalSpares']")
	private WebElement crvend;
	
	
	public WebElement getCrvend() {
		return crvend;
	}


	public WebElement getSearchField() {
		return searchField;
	}
	

}
