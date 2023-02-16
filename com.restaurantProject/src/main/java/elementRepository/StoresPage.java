package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class StoresPage 
{
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();

	public StoresPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//*[text()='Stores']")
	WebElement storesTab;
	@FindBy(xpath="//table[@id='Table']//tr//th[1]")
	WebElement storeName;
	@FindBy(xpath="//button[contains(text(),'Add Store')]")
	WebElement addStore;
	@FindBy(id="StoreName")
	WebElement addStoreName;
	@FindBy(id="email")
	WebElement storeEmail;
	@FindBy(id="StorePhone")
	WebElement storePhone;
	@FindBy(id="Country")
	WebElement country;
	@FindBy(id="City")
	WebElement city;
	@FindBy(id="Adresse")
	WebElement address;
	@FindBy(xpath="//button[text()=\"Submit\"]")
	WebElement submit;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement storeSearch;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement storeNameSearch;
	
	public void storesTabClick()
	{
		gu.clickElement(storesTab);
	}
	 public boolean isStoreNameDisplayed()
	 {
		 return gu.isDisplayedMethod(storeName);
	 }
	 public void clickAddStore()
	 {
		 gu.scrollToElement(addStore, driver);
		 gu.clickElement(addStore);
	 }
	 public void enterStoreName(String sname)
	 {
		 gu.typeIntoAnElement(addStoreName, sname);
	 }
	 public void enterStoreEmail(String semail)
	 {
		 gu.typeIntoAnElement(storeEmail, semail);
	 }
	 public String readStoreName(int row,int col) throws IOException
		{
			return(ExcelReadClass.readStringData(row, col));
		}
	 public String readStoreEmail(int row,int col) throws IOException
		{
			return(ExcelReadClass.readStringData(row, col));
		}
	 public void enterStorePhone(String sph)
	 {
		 gu.typeIntoAnElement(storePhone, sph);
	 }
	 public void enterStoreCountry(String scontry)
	 {
		 gu.typeIntoAnElement(country, scontry);
	 }
	 public void enterStorecity(String scty)
	 {
		 gu.typeIntoAnElement(city, scty);
	 }
	 public void enterStoreAddress(String sadd)
	 {
		 gu.typeIntoAnElement(address, sadd);
	 }
	 public void clickOnSubmit() throws InterruptedException
	 {
		 gu.addThreadSleep();
		 ew.elementToBeClickableWait(submit, driver);
		 gu.clickElement(submit);
	 }
	 public void enterValueToSearch(String data) throws InterruptedException
	 {
		 gu.typeIntoAnElement(storeSearch,data);
		 gu.addThreadSleep();
	 }
	 public boolean isStoreNameSearchDisplayed()
	 {
		 return gu.isDisplayedMethod(storeNameSearch);
	 }
	 public boolean isAddStorebuttonDisplayed()
	 {
		 gu.scrollToElement(addStore, driver);
		 return gu.isDisplayedMethod(addStore);
	 }
}
	
