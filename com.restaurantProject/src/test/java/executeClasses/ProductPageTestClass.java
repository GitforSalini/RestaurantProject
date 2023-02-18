package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;

public class ProductPageTestClass extends BaseClass

{
	LoginPage lp;
	ProductPage pp;
	
  @Test(priority=1,groups = {"group1"})
  public void VerifyTheProductPageIsOpenedByClickingTheProductTab() throws IOException 
  {
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  pp.productTabClick();
	  Boolean actual=pp.isProducttypeTextDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(priority=2,groups = {"add"})
  public void VerifyToAddaNewProduct() throws IOException, InterruptedException 
  
  {
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  pp.productTabClick();
	  pp.clickOnAddProduct();
	  pp.selectType();
	  pp.enterCode(pp.readProductCode(2,1));
	  pp.enterName(pp.readProductName(3,1));
	  pp.selectCategory();
	  pp.enterPrice(pp.readPrice(4, 1));
	  
	//pp.clickChooseFileToUploadImage(System.getProperty("user.dir")+"\\src\\main\\resources\\lime.jfif");
	  pp.clickAddproductSubmit();
	  
  }
  
  @Test(priority=3,groups = {"search"})
  public void  VerifySearchFunctionalityByUsingProductName() throws IOException
  {
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  pp.productTabClick();
	  pp.enterSearchValue("Lemon");
	  
	  String expected="Lemon";
	  String actual=pp.searchByName();
	  Assert.assertEquals(expected,actual);
  }
  
  @Test(priority=4,groups = {"search"})
  public void  VerifySearchFunctionalityByUsingProductCode() throws IOException
  {
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  pp.productTabClick();
	  pp.enterSearchValue("L5550");
	  String expected="L5550";
	  String actual=pp.searchById();
	  Assert.assertEquals(expected,actual);
  }
  @Test(priority=5,groups = {"edit"})
  public void  VerifyEditFunctionality() throws IOException
  {
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  pp.productTabClick();
	  pp.enterSearchValue("L5550");
	  pp.editoptionClick();
	  pp.clearTax();
	  pp.enterTax("3");
	  pp.clickAddproductSubmit();
	  pp.enterSearchValue("L5550");
	  
	  Boolean actual=pp.isTaxDisplayed();
	  Assert.assertTrue(actual);
	  
	  
  }
  @Test(priority=6,groups = {"delete"})
  public void  VerifyDeleteFunctionality() throws IOException
  {
	  lp=new LoginPage(driver);
	  pp=new ProductPage(driver);
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterpassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  pp.productTabClick();
	  pp.enterSearchValue("L5550");
	  pp.clickDelete();
	  
	  
	  pp.enterSearchValue("L5550");
	  String expected="No matching records found";
	  String actual=pp.confirmingDelete();
	  Assert.assertEquals(expected,actual);
	 
  }
}
