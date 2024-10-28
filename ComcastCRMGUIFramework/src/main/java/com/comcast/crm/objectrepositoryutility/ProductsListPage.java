package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {
	
	WebDriver driver;
	public ProductsListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	private WebElement searchFieldinProducts;
	
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	
	@FindBy(xpath = "//a[text()='Reynolds']")
	private WebElement selectProductFromList;
	
	public WebElement getSearchFieldinProducts() {
		return searchFieldinProducts;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSelectProductFromList() {
		return selectProductFromList;
	}
	
	

}
