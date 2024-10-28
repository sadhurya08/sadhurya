package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	    //rule-1 create a separate java class
		//rule-2 object creation
	
	    WebDriver driver; //global variable
	    //constructor for loginPage
	    public LoginPage(WebDriver driver) {
	    	this.driver=driver; 
	    	//since global variable and local variable have same name to avaoid confusion we are using this.driver=driver
	    	PageFactory.initElements(driver,this);
      	}

		//this - current class object - we are using this instead of loginPage.class
	    
		@FindBy(name="user_name")
		private WebElement usernameEdit;
		
		@FindBy(name="user_password")
		private WebElement passwordEdit;
		
		@FindBy(id="submitButton")
		private WebElement loginBtn;
		//rule-3 Object Initialization

		//rule-4 object Encapsulation
		public WebElement getUsernameEdit() {
			return usernameEdit;
		}

		//getter methods
		public WebElement getPasswordEdit() {
			return passwordEdit;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//rule5 provide action
		public void loginToApp(String username,String password)
		{
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			usernameEdit.sendKeys(username);
			passwordEdit.sendKeys(password);
			loginBtn.click();
		}
		
		public void LoginToApp(String url,String username,String password) {
			waitForPageToLoad(driver);
			driver.get(url);
			driver.manage().window().maximize();
			usernameEdit.sendKeys(username);
			passwordEdit.sendKeys(password);
			loginBtn.click();
		
}	
}
