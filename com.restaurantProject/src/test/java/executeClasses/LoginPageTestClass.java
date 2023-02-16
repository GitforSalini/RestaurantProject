package executeClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;


public class LoginPageTestClass extends BaseClass
{
	LoginPage lp;
	
  @Test(priority=1)
  public void varifyTheLoginPageIsDisplayedByHittingTheUrl() throws InterruptedException 
  {
	  lp=new LoginPage(driver);
	  
	  Boolean actual=lp.isLoginTextDisplayed();
	  Assert.assertTrue(actual);
  }
  @Test(priority=3)
  public void varifyTheRestaurantLogoIsDisplayed() 
  {
	  lp=new LoginPage(driver);
	  
	  Boolean actual=lp.isLogoDisplayed();
	  Assert.assertTrue(actual);
  }
  @Test(priority=2,dataProvider="SuccessfulLogin",dataProviderClass=DataProviderClass.class)
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
  
  @Test(priority=4,dataProvider="UnSuccessfulLogin",dataProviderClass=DataProviderClass.class)
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
