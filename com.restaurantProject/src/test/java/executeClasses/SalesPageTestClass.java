package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.SalesPage;
import elementRepository.StoresPage;


public class SalesPageTestClass extends BaseClass

{
	LoginPage lp;
    SalesPage sap;
	
  @Test
  public void verifyTheSalesPageIsVisibleByClickingOnSalesTab() throws IOException
  {
	  lp=new LoginPage(driver);
	  sap=new SalesPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  sap.clickOnSalestab();
	  String expected="Sales";
	  String actual=sap.getSalesText();
	  Assert.assertEquals(expected,actual);
  }
}
