package executeClasses;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass
{
	WebDriver driver;
	ScreenShotClass ssh;
	public static Properties property;
	
	public static void readProperty() throws IOException
	{
		property=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");
		property.load(file);
		
	}
  
	@BeforeSuite(alwaysRun=true)
	public void createReport(final ITestContext testContext) 
	{
		  extendReport.ExtentManager.createInstance().createTest(testContext.getName(), "message");
	}
	
  @BeforeMethod(groups = {"open"})
  @Parameters({"browser"})
  public void beforeMethod(String browserValue) throws IOException
  {
	  readProperty();
	  
	  if(browserValue.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  else if(browserValue.equalsIgnoreCase("edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
	  }
	  driver.get(property.getProperty("url"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  @AfterMethod(groups = {"close"})
  public void afterMethod(ITestResult itr) throws IOException
  {
	  if(itr.getStatus()==ITestResult.FAILURE)
	  {
		  ssh=new ScreenShotClass();
		  ssh.takeScreenShot(driver,itr.getName());
	  }
	  driver.close();
	  driver.quit();
  }

}
