package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsListPage {

	 WebDriver driver; 
		public CampaignsListPage(WebDriver driver) {
		    this.driver=driver; 
		    PageFactory.initElements(driver,this);
	   	}
		
		@FindBy(id = "search_txt")
		private WebElement searcFieldInCampaigns;
		
		@FindBy(name ="search")
		private WebElement searchNowBtn;
		
		@FindBy(linkText = "InkTheFutureWithReynolds")
		private WebElement selectCampaignFromList;
		
		public WebElement getSelectCampaignFromList() {
			return selectCampaignFromList;
		}

		public WebElement getSearcFieldInCampaigns() {
			return searcFieldInCampaigns;
		}

		public WebElement getSearchNowBtn() {
			return searchNowBtn;
		}
		
		

}
