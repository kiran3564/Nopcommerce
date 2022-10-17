package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manufacturerspage {
	public WebDriver ldriver;
	public Manufacturerspage(WebDriver rdriver) {
		
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	
}
	
	@FindBy(xpath="//p[normalize-space()='Catalog']//i[contains(@class,'right fas fa-angle-left')]")
	WebElement catalog;
	
	@FindBy(xpath="//p[normalize-space()='Manufacturers']")
	WebElement manfacturers;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement Addbutton;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement Namefield;
	
	@FindBy(xpath="//button[@name='save']//i[@class='far fa-save']")
	WebElement savebutton;
	
	public void catalogclick()
	{
		catalog.click();
	}
	
	public void manfacturersclick()
	{
		manfacturers.click();
		
	}
	
	public void addbuttonclick()
	{
		Addbutton.click();
	}
	
	public void savebuttonclick() {
		savebutton.click();
	}
	
	
}

