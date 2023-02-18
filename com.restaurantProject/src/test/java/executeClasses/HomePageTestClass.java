package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTestClass extends BaseClass
{
	LoginPage lp;
	HomePage hp;
	
  @Test(priority=1,groups = {"group1"})
  public void varifyProductTabIsDisplayedOrNot() throws IOException 
  {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  Boolean actual=hp.isProductTabDisplayed();
	  Assert.assertTrue(actual);
  }
  @Test(priority=2,groups = {"group1"})
    public void varifyD4StoreIsDisplayedOrNot() throws IOException 
  {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  Boolean actual=hp.isD4StoreDisplayedOrNot();
	  Assert.assertTrue(actual);
  }
  @Test(priority=3,groups = {"functional"})
    public void varifyLogoutButtonIsWorkingOrNot() throws IOException 
  {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  hp.logoutButtonWorking();
	  
	  String expected="https://qalegend.com/restaurant/login";
	  String actual=lp.gettingCurrentUrlOfThePage();
	  Assert.assertEquals(expected,actual);
  }
}
