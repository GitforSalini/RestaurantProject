package executeClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;


public class LoginPageTestClass extends BaseClass
{
	LoginPage lp;
	
  @Test(enabled=false,priority=1,groups = {"group1"})
  public void varifyTheLoginPageIsDisplayedByHittingTheUrl() throws InterruptedException 
  {
	  lp=new LoginPage(driver);
	  
	  Boolean actual=lp.isLoginTextDisplayed();
	  Assert.assertTrue(actual);
  }
  @Test(enabled=false,priority=2,groups = {"group1"})
  public void varifyTheRestaurantLogoIsDisplayed() 
  {
	  lp=new LoginPage(driver);
	  
	  Boolean actual=lp.isLogoDisplayed();
	  Assert.assertTrue(actual);
  }
  @Test(priority=3,dataProvider="SuccessfulLogin",dataProviderClass=DataProviderClass.class,groups = {"login-1"})
  public void varifySuccessfulLogin(String uname,String pwd) 
  {
	  lp=new LoginPage(driver);
	  
	  lp.enterUserName(uname);
	  lp.enterpassword(pwd);
	  lp.clickOnLoginButton();
	  
	  String expected="  admin Doe";
	  String actual=lp.getTextOfAdminName();
	  System.out.println(lp.getTextOfAdminName());
	  Assert.assertEquals(actual,expected);
	  
	  
  }
  
  @Test(enabled=false,priority=4,dataProvider="UnSuccessfulLogin",dataProviderClass=DataProviderClass.class,groups = {"login-2"})
  public void varifyUnSuccessfulLogin(String uname,String pwd) throws InterruptedException 
  {
	  lp=new LoginPage(driver);
	  
	  lp.enterUserName(uname);
	  lp.enterpassword(pwd);
	  lp.clickOnLoginButton();
	  	 
	  Boolean actual=lp.isLoginTextDisplayed();
	  Assert.assertTrue(actual);
	  
	  
  }
 
  
  
}
