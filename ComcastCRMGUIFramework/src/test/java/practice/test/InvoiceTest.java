package practice.test;

import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;



//@Listeners(com.comcast.crm.listenerutility.ListImpclass.class)
public class InvoiceTest  extends BaseClass{

	@Test
	public void createInvoiceTest() {
	  System.out.println("execute createInvoiceTest");	
	  String actTitle = driver.getTitle();
	  System.out.println(actTitle);
	  Assert.assertEquals(actTitle, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	  System.out.println("Step-1");
	  System.out.println("Step-2");
	  System.out.println("Step-3");
	  System.out.println("Step-4");
	}
	
	@Test
	public void createInvoiceWithContactTest()
	{
		System.out.println("execute createInvoiceWithContactTest");
		System.out.println("Step-1");
	    System.out.println("Step-2");
	    System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
