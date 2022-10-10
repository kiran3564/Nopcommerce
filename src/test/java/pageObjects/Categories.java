package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Categories {

	public WebDriver ldriver;
	
	public Categories(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath="//p[normalize-space()='Catalog']//i[contains(@class,'right fas fa-angle-left')]")
	WebElement catalog;
	
	@FindBy(xpath="//p[normalize-space()='Categories']")
	WebElement categories;
	
	@FindBy(xpath="//i[@class='fas fa-plus-square']")
	WebElement Addnew;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\\\"ParentCategoryId\\\"]")
	WebElement dropdown;
	
	@FindBy(xpath="//button[@name='save']")
WebElement save;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Logoutbutton;
	
	public void catalogclick()
	{
		catalog.click();
	}
	
	public void categoriesclick()
	{
		categories.click();
	}
	
	public void addnewclick(){
	
		Addnew.click();
	}
	public void entername(String namedata) {
		name.sendKeys(namedata);
	}
	
	public void clickonsave() {
		save.click();
	}
	public void logout() {
		Logoutbutton.click();
	}
	
	
	
	
	
}
