package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ProductPage;
import elementRepository.WaitersPage;

public class WaitersPageTestClass extends BaseClass
{
	LoginPage lp;
	WaitersPage wp;
	
  @Test(priority=1)
  public void verifyTheWaiterPageIsVisibleByClickingOnWaiterunderPeopleTab() throws IOException, InterruptedException
  {
	  lp=new LoginPage(driver);
	  wp=new WaitersPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  wp.clickPeopleTab();
	  wp.clickWaitersTab();
	  Boolean actual=wp.isWaitersNameDisplayed();
	  Assert.assertTrue(actual);
  }
  @Test(priority=2)
  public void verifyTheAddWaiterButtonIsVisibleOrNot() throws IOException, InterruptedException
  {
	  lp=new LoginPage(driver);
	  wp=new WaitersPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  wp.clickPeopleTab();
	  wp.clickWaitersTab();
	  Boolean actual=wp.isAddWaiterBtnDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  
  @Test(priority=3)
  public void veriytoAddaNewWaiter() throws IOException, InterruptedException
  {
	  lp=new LoginPage(driver);
	  wp=new WaitersPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  wp.clickPeopleTab();
	  wp.clickWaitersTab();
	  wp.clickAddWaiter();
	  wp.enterWaiterName("Sanoop");
	  wp.enterWaiterPhone("9744496651");
	  wp.enterWaiterEmail("sanoop@gmail.com");
	  wp.selectWaiterStore("SMStore");
	  wp.clickAddwaiterSubmit();
  }
  @Test(priority=4)
  public void verifytoSearchAWaiterByUsingName() throws IOException, InterruptedException
  {
	  lp=new LoginPage(driver);
	  wp=new WaitersPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  wp.clickPeopleTab();
	  wp.clickWaitersTab();
	  wp.enterSearchValue("Sanoop");
	  
	  Boolean actual=wp.isSearchedNameDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(priority=5)
  public void verifytoSearchAWaiterByUsingMobileNumber() throws IOException, InterruptedException
  {
	  lp=new LoginPage(driver);
	  wp=new WaitersPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  wp.clickPeopleTab();
	  wp.clickWaitersTab();
	  wp.enterSearchValue("9744496651");
	  Boolean actual=wp.isSearchedMobileNumberDisplayed();
	  Assert.assertTrue(actual);
	  
  }
}
