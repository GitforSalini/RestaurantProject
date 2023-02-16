package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class CustomersPage 
{
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();

	public CustomersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()='People']")
	WebElement peopleTab;	
	@FindBy(xpath="//*[text()='Customers']")
	WebElement customersTab;
	@FindBy(xpath="//table[@id='Table']//thead//tr//th[1]")
	WebElement customerNameDisplayed;
	@FindBy(xpath="//button[contains(text(),'Add Customer')]")
	WebElement addcustomerBtn;
	@FindBy(id="CustomerName")
	WebElement customerName;
	@FindBy(id="CustomerPhone")
	WebElement customerPhone;
	@FindBy(id="CustomerEmail")
	WebElement customerEmail;
	@FindBy(id="CustomerDiscount")
	WebElement customerDiscount;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement addcustomerSubmit;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchField;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement searchedName;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[2]")
	WebElement searchedNumber;
		
	public void clickPeopleTab()
	{
		gu.clickElement(peopleTab);
	
	}
	public void clickCustomersTab()
	{
		gu.clickElement(customersTab);
	
	}
	public boolean isCustomerNameDisplayed()
	{
		return gu.isDisplayedMethod(customerNameDisplayed);
	}
	public boolean isAddcustomerBtnVisible()
	{
		gu.scrollToElement(addcustomerBtn, driver);
		return gu.isDisplayedMethod(addcustomerBtn);
	}
	public void clickAddcustomer()
	{
		gu.clickElement(addcustomerBtn);
	}
	public void enterCustomerName(String name)
	{
		gu.typeIntoAnElement(customerName, name);
	}
	public void enterCustomerPhone(String ph)
	{
		gu.typeIntoAnElement(customerPhone, ph);
	}
	public void enterCustomerEmail(String email)
	{
	gu.typeIntoAnElement(customerEmail, email);
	}
	public void enterCustomerDiscount(String discnt)
	{
	gu.typeIntoAnElement(customerDiscount, discnt);
	}
	public void clickAddcustomerSubmit()
	{
		gu.clickElement(addcustomerSubmit);
	}
	public void enterSearchValue(String data) throws InterruptedException
	{
		gu.typeIntoAnElement(searchField, data);
		gu.addThreadSleep();
	}
	public boolean isSearchedNameDisplayed()
	{
		return gu.isDisplayedMethod(searchedName);
	}
	public boolean isSearchedNumberDisplayed()
	{
	return gu.isDisplayedMethod(searchedNumber);
	}
}
