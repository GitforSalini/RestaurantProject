package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class WaitersPage 
{
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();

	public WaitersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()='People']")
	WebElement peopleTab;	
	@FindBy(xpath="//*[text()='Waiters']")
	WebElement waitersTab;
	@FindBy(xpath="//table[@id='Table']//thead//tr//th[1]")
	WebElement waitersName;
	@FindBy(xpath="//table[@id='Table']//thead//tr//th[1]")
	WebElement waitersNameText;
	@FindBy(xpath="//button[contains(text(),'Add Waiter')]")
	WebElement addWaiterBtn;
	@FindBy(id="WaiterName")
	WebElement waiterName;
	@FindBy(id="WaiterPhone")
	WebElement waiterPhone;
	@FindBy(id="WaiterEmail")
	WebElement waiterEmail;
	@FindBy(xpath="//select[@id='WaiterStore']")
	WebElement waiterStore;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement addwaiterSubmit;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchoption;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement searchedNameText;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[2]")
	WebElement searchedMobileNumber;
	
	public void clickPeopleTab()
	{
		gu.clickElement(peopleTab);
		//gu.selectByvisbleTextFromDropDown(peopleTab,text);
	}
	public void clickWaitersTab() throws InterruptedException
	{
		//gu.addThreadSleep();
		gu.clickElement(waitersTab);
		//gu.selectByvisbleTextFromDropDown(peopleTab,text);
	}
	public boolean isWaitersNameDisplayed()
	{
		return gu.isDisplayedMethod(waitersName);
	}
	public Boolean isAddWaiterBtnDisplayed()
	{
		gu.scrollToElement(addWaiterBtn, driver);
		return gu.isDisplayedMethod(addWaiterBtn);
	}
    public void clickAddWaiter()
    {
    	gu.scrollToElement(addWaiterBtn, driver);
    	gu.clickElement(addWaiterBtn);
    }
	public void enterWaiterName(String nm)
	{
		gu.typeIntoAnElement(waiterName, nm);
	}
	public void enterWaiterPhone(String ph)
	{
		gu.typeIntoAnElement(waiterPhone, ph);
	}
	public void enterWaiterEmail(String em)
	{
		gu.typeIntoAnElement(waiterEmail, em);
	}
	public void selectWaiterStore(String storenm)
	{
		gu.selectByvisbleTextFromDropDown(waiterStore, storenm);
	}
	public void clickAddwaiterSubmit()
	{
		gu.clickElement(addwaiterSubmit);
	}
	public void enterSearchValue(String data) throws InterruptedException
	{
		gu.typeIntoAnElement(searchoption, data);
		gu.addThreadSleep();
	}
	public boolean isSearchedNameDisplayed()
	{
		return gu.isDisplayedMethod(searchedNameText);
	}
	public boolean isSearchedMobileNumberDisplayed()
	{
		return gu.isDisplayedMethod(searchedMobileNumber);
	}
}
