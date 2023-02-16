package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ProductPage 
{
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();

	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="(//*[text()='Product'])[1]")
	WebElement productTab;
	@FindBy(xpath="//label[text()='Product type']")
	WebElement productTypetext;
	@FindBy(xpath="//button[text()='Add Product']")
	WebElement addProductBtn;
	@FindBy(id="Type")
	WebElement type;
	@FindBy(id="ProductCode")
	WebElement code;
	@FindBy(id="ProductName")
	WebElement name;
	@FindBy(id="Category")
	WebElement category;
	@FindBy(id="Price")
	WebElement price;
	@FindBy(xpath="(//button[text()='Submit'])[1]")
	WebElement addProductSubmit;
	@FindBy(id="ImageInput")
	WebElement chooseFile;
	@FindBy(xpath="//label[text()='Search:']")
	WebElement search;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[2]")
	WebElement searchNameText;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement searchIdText;
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	WebElement editOption;
	@FindBy(id="Tax")
	WebElement taxField;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[5]")
	WebElement editedTax;
	@FindBy(xpath="(//div[@class='btn-group']//a[@class='btn btn-default']//i[@class='fa fa-times'])[1]")
	WebElement deleteOption;
	@FindBy(xpath="//a[text()='Yes, delete it!']")
	WebElement deleteconfirmation;
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td")
	WebElement noMatchMsg;
	public void productTabClick()
	{
		gu.clickElement(productTab);
	}
	public boolean isProducttypeTextDisplayed()
	{
		return gu.isDisplayedMethod(productTypetext);
	}
	public void clickOnAddProduct()
	{
		gu.scrollToElement(addProductBtn, driver);
		gu.clickElement(addProductBtn);
	}
	public void selectType() 
	{
		gu.selectByIndexFromDropDown(type, 1);
	}
	public void enterCode(String cc)
	{
		gu.typeIntoAnElement(code,cc);
	}
	public void enterName(String nm)
	{
		gu.typeIntoAnElement(name,nm);
	}
	public String readProductCode(int row,int col) throws IOException
	{
		return(ExcelReadClass.readStringData(row, col));
	}
	public String readProductName(int row,int col) throws IOException
	{
		return(ExcelReadClass.readStringData(row, col));
	}
	public void selectCategory()
	{
		gu.selectByIndexFromDropDown(category, 4);
	}
	public void enterPrice(String p)
	{
		gu.typeIntoAnElement(price,p);
	}
	public String readPrice(int row,int col) throws IOException
	{
		return(ExcelReadClass.readStringData(row, col));
	}
	public void clickAddproductSubmit()
	{
	gu.clickElement(addProductSubmit);
	}
	public void clickChooseFileToUploadImage(String path) throws InterruptedException
	{
		gu.scrollToElement(chooseFile, driver);
		gu.addThreadSleep();
		gu.typeIntoAnElement(chooseFile,path);
		gu.addThreadSleep();
		
	}
	public void enterSearchValue(String pnm)
	{
		gu.typeIntoAnElement(search,pnm);
	}
	public String searchByName()
	{
		//gu.pageRefresh(driver);
		return gu.getTextOfAnElement(searchNameText);
	}
	public String searchById()
	{
		//gu.pageRefresh(driver);
		return gu.getTextOfAnElement(searchIdText);
	}
	public void editoptionClick()
	{
		gu.clickElement(editOption);
	}
	public void enterTax(String t)
	{
		gu.typeIntoAnElement(taxField, t);
	}
	public void clearTax()
	{
		gu.clearElement(taxField);
	}
	public boolean isTaxDisplayed()
	{
		return gu.isDisplayedMethod(editedTax);
	}
	public void clickDelete() 
	{
		
		ew.elementToBeClickableWait(deleteOption, driver);
		gu.clickElement(deleteOption);
		gu.clickElement(deleteconfirmation);
	}
	
	public String confirmingDelete()
	{
		return gu.getTextOfAnElement(noMatchMsg);
	}
}
