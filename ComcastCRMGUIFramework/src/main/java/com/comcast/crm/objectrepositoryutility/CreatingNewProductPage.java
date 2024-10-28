package com.comcast.crm.objectrepositoryutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreatingNewProductPage {
	
	WebDriver driver;
	public CreatingNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(name = "productname")
	private WebElement productNameField;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement addvendorButton;
	
	
	public WebElement getAddvendorButton() {
		return addvendorButton;
	}
	@FindBy(id = "my_file_element")
	private WebElement productImage;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerMsg;
	
	@FindBy(name = "start_date")
	private WebElement salesStartDate;
	
	@FindBy(name = "sales_end_date")
	private WebElement salesEndDate;
	
	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement secondSaveBtn;
	
	
	public WebElement getSecondSaveBtn() {
		return secondSaveBtn;
	}

	public WebElement getSalesStartDate(String salesstartDate2) {
		return salesStartDate;
	}

	public WebElement getSalesEndDate() {
		return salesEndDate;
	}

	public WebElement getHeaderMsgOfProduct() {
		return headerMsg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getProductNameField() {
		return productNameField;
	}

	public WebElement getProductImage() {
		return productImage;
	}

	public void scrollToSecondSaveButton(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(secondSaveBtn).perform();
	}
	
	public WebElement getProductImage(WebDriver driver) {
		Actions act=new Actions(driver);
		act.scrollToElement(productImage).perform();;
		//act.click(ppic).perform();
		return productImage;
	}
	
	public void selectvendorNameFromList() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		String vendorName =  eLib.getDataFromExcel("Vendor", 1, 2) + jLib.getRandomNumber();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		
	}
	

	
	

}
