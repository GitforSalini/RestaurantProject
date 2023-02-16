package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ExpensePage
{
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();

	public ExpensePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//*[text()='Expense'])[1]")
	WebElement expenseTab;
	@FindBy(xpath="//div[@class='container']//h3[text()='Expence']")
	WebElement expensetext;
	@FindBy(xpath="//button[contains(text(),'Add Expence')]")
	WebElement addExpenseBtn;
	
	public void clickOnExpenseTab()
	{
		gu.clickElement(expenseTab);
	}
	public String getExpensetext()
	{
		return gu.getTextOfAnElement(expensetext);
	}
	public boolean isAddExpenceBtnIsDisplayed()
	{
		gu.scrollToElement(addExpenseBtn, driver);
		return gu.isDisplayedMethod(addExpenseBtn);
	}
}
