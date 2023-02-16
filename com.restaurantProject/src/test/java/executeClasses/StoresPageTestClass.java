package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ProductPage;
import elementRepository.StoresPage;

public class StoresPageTestClass extends BaseClass
{
	LoginPage lp;
	StoresPage sp;
	
  @Test(priority=1)
  public void verifyTheStorePageIsVisibleByClickingOnStoresTab() throws IOException 
  {
	  lp=new LoginPage(driver);
	  sp=new StoresPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  sp.storesTabClick();
	  Boolean actual=sp.isStoreNameDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(priority=3)
  public void verifyToCreateANewStore() throws IOException, InterruptedException 
  {
	  lp=new LoginPage(driver);
	  sp=new StoresPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  sp.storesTabClick();
	  sp.clickAddStore();
	  sp.enterStoreName(sp.readStoreName(5, 1));
	  sp.enterStoreEmail(sp.readStoreEmail(6, 1));
	  sp.enterStorePhone("8899556647");
	  sp.enterStoreCountry("India");
	  sp.enterStorecity("Kochi");
	  sp.enterStoreAddress("Eroor");
	  sp.clickOnSubmit();
	   	  
  }
  @Test(priority=4)
  public void verifyStoreNameSearchByUsingStoreName() throws IOException, InterruptedException 
  {
	  lp=new LoginPage(driver);
	  sp=new StoresPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  sp.storesTabClick();
	  sp.enterValueToSearch("SMStore");
	  
	  boolean actual=sp.isStoreNameSearchDisplayed();
	  Assert.assertTrue(actual);
	  
	  
  }
  @Test(priority=2)
  public void verifyTheAddStoreButtonIsVisibleOrNot() throws IOException, InterruptedException 
  {
	  lp=new LoginPage(driver);
	  sp=new StoresPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  sp.storesTabClick();
	  Boolean actual=sp.isAddStorebuttonDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  
}
