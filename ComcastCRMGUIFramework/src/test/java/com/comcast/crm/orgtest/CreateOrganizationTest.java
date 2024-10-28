package com.comcast.crm.orgtest;

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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws EncryptedDocumentException, IOException {

		// Read testScriptdata from excel file
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

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

	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithIndustriesTest() throws EncryptedDocumentException, IOException {
		// Read testScriptdata from excel file
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		// step 2: navigate to organisations module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// driver.findElement(By.linkText("Organizations")).click();

		// step 3: click on create organisation
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: enter all the details and create new organisation
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustries = oip.getIndustry().getText();

		if (actIndustries.equals(industry)) {
			System.out.println(industry + " information is verified==PASS");
		} else {
			System.out.println(industry + " information is not verified==FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNumberTest() throws EncryptedDocumentException, IOException {
		// Read testScriptdata from excel file

		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
		// while storing the numeric data in excel convert it to string dont convert it
		// in code

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on create organisation
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: enter all the details and create new organisation
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		// cnop.createOrg(orgName);
		cnop.createOrgWithPhoneNumber(orgName, phoneNumber);

		// verify header msg expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String headerInfo = oip.getHeaderMsg().getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "header is verified==PASS");
		} else {
			System.out.println(orgName + "header is not verified==FAIL");
		}

		// verify header phonenumber info expected result
		String actPhoneNumber = oip.getHeaderMsgWithPhone().getText();
		if (actPhoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber + " information is created==PASS");
		} else {
			System.out.println(phoneNumber + "information is created==FAIL");
		}

	}

}
