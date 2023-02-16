package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ExpensePage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;

public class ExpensePageTestClass extends BaseClass
{
	
	LoginPage lp;
	ExpensePage ep;
	
  @Test(priority=1)
  public void verifyTheWxpensePageIsOpenedByClickingTheExpenseTab() throws IOException 
  {
	  lp=new LoginPage(driver);
	  ep=new ExpensePage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  ep.clickOnExpenseTab();
	  String expected="Expence";
	  String actual=ep.getExpensetext();
	  Assert.assertEquals(expected,actual);
}
  
  @Test(priority=1)
  public void verifyTheAddExpenseButtonIsVisibleOrNot() throws IOException 
  {
	  lp=new LoginPage(driver);
	  ep=new ExpensePage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  ep.clickOnExpenseTab();
	  
	  boolean actual=ep.isAddExpenceBtnIsDisplayed();
	  Assert.assertTrue(actual);
}
}
