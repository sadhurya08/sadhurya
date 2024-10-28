package com.comcast.crm.contacttest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {

		// Read testScriptdata from excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step 2: navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step 3: click on create contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// step 4: enter all the details and create new contact
		// driver.findElement(By.name("lastname")).sendKeys(lastName);
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(lastName);

		// verify header orgname info expected result

		
		String actHeader = cp.getHeaderMsg().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		
		String actLastName = cp.getLastName().getText();
		SoftAssert soft = new SoftAssert();
		Assert.assertEquals(actLastName, lastName);

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
		// step 2: navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step 3: click on create contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		// step 4: enter all the details and create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContactwithOutsaving(lastName);

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);

		cncp.getSupportStartDate().clear();
		cncp.getSupportStartDate().sendKeys(startDate);

		cncp.getSupportEndDate().clear();
		cncp.getSupportEndDate().sendKeys(endDate);

		cncp.getSaveBtn().click();
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actStartDate = cip.getViewSupportStartDate().getText();
		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + " Information is verified==PASS");
		} else {
			System.out.println(startDate + " Information is not verified==FAIL");
		}

		String actEndDate = cip.getViewSupportEndDate().getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " Information is verified==PASS");
		} else {
			System.out.println(endDate + " Information is not verified==FAIL");
		}
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {

		// Read testScriptdata from excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3);

		// step 2: navigate to organisations module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on create organisation
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: enter all the details and create new organisation
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// verify header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " name is verified == PASS");
		} else {
			System.out.println(orgName + " name is not verified == FAIL");
		}

		ContactsPage cp = new ContactsPage(driver);
		cp.getContacts().click();
		cp.getCreateNewContactBtn().click();

		// step 4: enter all the details and create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContactwithOutsaving(contactLastName);

		// this xpath is for +button for orgname in contacts module
		cncp.getAddOrgInContactBtn().click();

		// switch to child window
		wLib.switchToTabOnURL(driver, "module=Accounts");

		// Thread.sleep(2000);

		cncp.getSearchFieldinOrgPopup().sendKeys(orgName);
		cncp.getSearchNowBtn().click();

		// dynamic xpath for opening the organisation in the create contact page
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		wLib.switchToTabOnURL(driver, "Contacts&action");

		// click on save button
		cncp.getSaveBtn().click();

		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String headerInfo = cip.getContactHeaderMsg().getText();
		if (headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName + "is created=pass");
		} else {
			System.out.println(contactLastName + "is created= fail");
		}

	}
}
