package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;
import extendReport.TestListener;
@Listeners(TestListener.class)
public class ProductPageTestClass extends BaseClass

{
	LoginPage lp;
	ProductPage pp;
	String uniqCode;
	
	
	
  @Test(priority=1,groups = {"group1"})
  public void VerifyTheProductPageIsOpenedByClickingTheProductTab() throws IOException 
  {
	 
	 TestListener.getTestInstance().get().assignCategory("Smoke");
	  
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	
	  lp.login();
	  
	  pp.productTabClick();
	  Boolean actual=pp.isProducttypeTextDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(enabled=false,priority=2,groups = {"add"})
  public void VerifyToAddaNewProduct() throws IOException, InterruptedException 
  
  {
	  TestListener.getTestInstance().get().assignCategory("Smoke");
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	 
	  lp.login();
	  uniqCode=pp.addProduct();
	//  System.out.println("New Product Added");
	  
	 /* pp.productTabClick();
	  pp.clickOnAddProduct();
	  pp.selectType();
	 
	  pp.clearfield();
	  uniqCode=pp.enterCode();
	  System.out.println(uniqCode);
	  pp.enterName(pp.readProductName(3,1));
	  pp.selectCategory();
	  pp.enterPrice(pp.readPrice(4, 1));
	  pp.clickAddproductSubmit();*/
	  
	  pp.refreshPage();
	  pp.enterSearchValue(uniqCode);
	  String expected=uniqCode;
	  String actual=pp.searchById();
	  Assert.assertEquals(expected,actual);
	  
	  
  }
  
  @Test(enabled=false,priority=3,groups = {"search"})
  public void  VerifySearchFunctionalityByUsingProductName() throws IOException
  {
	  TestListener.getTestInstance().get().assignCategory("Sanity");
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	
	  lp.login();
	  
	  pp.productTabClick();
	  pp.enterSearchValue("Lemon");
	  
	  String expected="Lemon";
	  String actual=pp.searchByName();
	  Assert.assertEquals(expected,actual);
  }
  
  @Test(enabled=false,priority=4,groups = {"search"})
  public void  VerifySearchFunctionalityByUsingProductCode() throws IOException
  {
	  TestListener.getTestInstance().get().assignCategory("Sanity");
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	
	  lp.login();
	  
	  pp.productTabClick();
	  pp.enterSearchValue(uniqCode);
	  String expected=uniqCode;
	  String actual=pp.searchById();
	  Assert.assertEquals(expected,actual);
  }
  @Test(enabled=false,priority=5,groups = {"edit"})
  public void  VerifyEditFunctionality() throws IOException, InterruptedException
  {
	 TestListener.getTestInstance().get().assignCategory("Regression");
	 lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	  
	  lp.login();
	  uniqCode=pp.addProduct();
	  
	//  pp.productTabClick();
	  
	  pp.refreshPage();
	  pp.enterSearchValue(uniqCode);
	  pp.editoptionClick();
	  pp.clearTax();
	  pp.enterTax("3");
	  pp.clickAddproductSubmit();
	  pp.enterSearchValue(uniqCode);
	  
	  Boolean actual=pp.isTaxDisplayed();
	  Assert.assertTrue(actual);
	  
	  
  }
  @Test(enabled=false,priority=6,groups = {"delete"})
  public void  VerifyDeleteFunctionality() throws IOException
  {
	  TestListener.getTestInstance().get().assignCategory("Regression");
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	
	  lp.login();
	  
	  pp.productTabClick();
	  pp.enterSearchValue(uniqCode);
	  pp.clickDelete();
	  
	  
	  pp.enterSearchValue(uniqCode);
	  String expected="No matching records found";
	  String actual=pp.confirmingDelete();
	  Assert.assertEquals(expected,actual);
	 
  }
}
