package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitClass 
{
	
	
	public void elementToBeClickableWait(WebElement element,WebDriver driver)
	{
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(30))		
				.pollingEvery(Duration.ofSeconds(5))		
				.ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void elementToBeSelectedWait(WebElement element,WebDriver driver)
	{
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(30))		
				.pollingEvery(Duration.ofSeconds(5))		
				.ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
}
