package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.CustomersPage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;
import elementRepository.WaitersPage;

public class CustomersPageTestClass extends BaseClass
{
	LoginPage lp;
	CustomersPage cp;
	@Test(priority=1)
	public void verifyThecustomerPageIsVisibleByClickingOncustomersunderPeopleTab() throws IOException 
	{
		lp=new LoginPage(driver);
		cp=new CustomersPage(driver);
		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();

		Boolean actual=cp.isCustomerNameDisplayed();
		Assert.assertTrue(actual);

	}
	@Test(priority=2)
	public void verifyTheAddcustomerButtonIsVisibleOrNot() throws IOException 
	{
		lp=new LoginPage(driver);
		cp=new CustomersPage(driver);
		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();

		boolean actual=cp.isAddcustomerBtnVisible();
		Assert.assertTrue(actual);
	}
	@Test(priority=3)
	public void veriytoAddaNewcustomer() throws IOException 
	{
		lp=new LoginPage(driver);
		cp=new CustomersPage(driver);
		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();
		cp.clickAddcustomer();
		cp.enterCustomerName("Sithara");
		cp.enterCustomerPhone("9847438181");
		cp.enterCustomerEmail("sitara@gmail.com");
		cp.enterCustomerDiscount("10%");
		cp.clickAddcustomerSubmit();

	}
	@Test(priority=4)
	public void verifytoSearchACustomerByUsingName() throws IOException, InterruptedException 
	{
		lp=new LoginPage(driver);
		cp=new CustomersPage(driver);
		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();
		cp.enterSearchValue("Sithara");

		Boolean actual=cp.isSearchedNameDisplayed();
		Assert.assertTrue(actual);

	}
	@Test(priority=5)
	public void verifytoSearchACustomerByUsingMobileNumber() throws IOException, InterruptedException 
	{
		lp=new LoginPage(driver);
		cp=new CustomersPage(driver);
		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();
		cp.enterSearchValue("9847438181");

		Boolean actual=cp.isSearchedNumberDisplayed();
		Assert.assertTrue(actual);


	}
}

