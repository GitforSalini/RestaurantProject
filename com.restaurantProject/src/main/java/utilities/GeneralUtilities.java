package utilities;

import java.io.FileInputStream;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities 
{
	public void clickElement(WebElement element)
	{
		element.click();
	}
	
	public void typeIntoAnElement(WebElement element,String data)
	{
		element.sendKeys(data);
	}
	
	public String getTextOfAnElement(WebElement element)
	{
		return(element.getText());
	}
	public Boolean isDisplayedMethod(WebElement element)
	{
		return(element.isDisplayed());
	}
	public Boolean isSelectedMethod(WebElement element)
	{
		return(element.isSelected());
	}
	public Boolean isEnabledMethod(WebElement element)
	{
		return(element.isEnabled());
	}
	public void addThreadSleep() throws InterruptedException
	{
		Thread.sleep(5000);
	}
	public void scrollToElement(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public void clickToAnElement(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String alertGetText(WebDriver driver)
	{
		return(driver.switchTo().alert().getText());
	}
	
	public void selectByIndexFromDropDown(WebElement element,int i)
	{
		Select select=new Select(element);
		select.selectByIndex(i);
	}
	
	public void selectByValueFromDropDown(WebElement element,String s)
	{
		Select select=new Select(element);
		select.selectByValue(s);;
	}
	public void selectByvisbleTextFromDropDown(WebElement element,String s)
	{
		Select select=new Select(element);
		select.selectByVisibleText(s);;
	}
	
	public String gettingCurrentUrl(WebDriver driver)
	{
		return(driver.getCurrentUrl());
	}
	public void clearElement(WebElement element)
	{
		element.clear();
	}
	public void uploadImageUsingSendKeys(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	public void pageRefresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
}
