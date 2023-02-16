package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPage 
{
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h1[text()='Login']")
	WebElement loginText;
	@FindBy(name="username")
	WebElement userName;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="submit")
	WebElement loginBtn;
	@FindBy(xpath="//*[contains(text(),'admin Doe')]")
	WebElement adminName;
	@FindBy(xpath="//img[@alt=\"logo\"]")
	WebElement logo;
	
	public boolean isLoginTextDisplayed() throws InterruptedException
	{
		//ew.presenceOfElementLocatedWaitByXpath(driver,"//h1[text()='Login']");
		gu.addThreadSleep();
		return gu.isDisplayedMethod(loginText);
	}
	public void enterUserName(String uname)
	{
		gu.typeIntoAnElement(userName, uname);
	}
	
	public void enterpassword(String pwd)
	{
		gu.typeIntoAnElement(password, pwd);
	}
	
	public void clickOnLoginButton()
	{
		ew.elementToBeClickableWait(loginBtn, driver);
		gu.clickElement(loginBtn);
	}

	public String getTextOfAdminName()
	{
		return gu.getTextOfAnElement(adminName);
	}
	public boolean isLogoDisplayed()
	{
		return gu.isDisplayedMethod(logo);
	}
	public boolean isAdminTextDisplayed()
	{
		return gu.isDisplayedMethod(adminName);
	}
	public String gettingCurrentUrlOfThePage()
	{
		return gu.gettingCurrentUrl(driver);
	}
	public String readUserName(int row,int col) throws IOException
	{
		return(ExcelReadClass.readStringData(row, col));
	}
	public String readPassword(int row,int col) throws IOException
	{
		return(ExcelReadClass.readStringData(row, col));
	}
	
}
