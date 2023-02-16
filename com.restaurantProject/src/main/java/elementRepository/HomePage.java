package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage 
{
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//*[text()='Product'])[1]")
	WebElement productTab;

	public boolean isProductTabDisplayed()
	{
		return gu.isDisplayedMethod(productTab);
	}
	
	
	@FindBy(xpath="(//*[text()='D4'])[1]")
	WebElement d4Store;
	public boolean isD4StoreDisplayedOrNot()
	{
		return(gu.isDisplayedMethod(d4Store));
	}
	
	@FindBy(xpath="//i[@class='fa fa-sign-out fa-lg']")
	WebElement logoutbtn;
	public void logoutButtonWorking()
	{
		gu.clickElement(logoutbtn);
	}
}
