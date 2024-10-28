
package practice.test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetProductInfoTest {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String productName)
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//search product
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//capture product info
		//String xpath = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div/div[1]/div[1]/a/span/span[2]/span[2]";
		String xpath = "//span[text() ='"+productName+"']/ancestor::div[@class='puisg-col-inner']//span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(price);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		ExcelUtility eLib = new ExcelUtility();
		int rowcount = eLib.getRowcount("product");
	  	
		Object[][] objArr = new Object[rowcount][2];
		for(int i=0;i<rowcount;i++)
		{
			objArr[i][0] = eLib.getDataFromExcel("product", i+1, 0);
			objArr[i][1] = eLib.getDataFromExcel("product", i+1, 1);
		}
	/*
		objArr[0][0] = "iphone";
		objArr[0][1] = "Apple iPhone 13 (128GB) - Starlight" ;
		
		objArr[1][0] = "iphone";
		objArr[1][1] = "Apple iPhone 13 (128GB) - Midnight";
				
		//objArr[2][0] = "iphone"; objArr[2][1] ="Apple iPhone 13 (128GB) - Pink";
		 objArr[2][0] = "iphone";
		objArr[2][1] = "Apple iPhone 15 (128 GB) - Yellow";
	*/		 
		return objArr;
		
		
	}
}

