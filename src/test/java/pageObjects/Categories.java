package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//input[@id='SearchCategoryName']")
	WebElement categoryname;
	
	@FindBy(xpath="//table[@role='grid']")
	WebElement tblsearchresult;
	
	@FindBy(xpath="//table[@id='categories-grid']")
	WebElement table;

	@FindBy(xpath="//table[@id='categories-grid']//tbody//tr")
	List<WebElement> tablerows;
	
	@FindBy(xpath="//table[@id='categories-grid']//tbody//tr//td")
	List<WebElement> tablecolumns;
	
	@FindBy(xpath="//button[@id='search-categories']")
	WebElement Search;
	
	@FindBy(xpath="//button[@class='btn btn-success dropdown-toggle']")
	WebElement exportdropdown;
	
	@FindBy(xpath="//i[@class='far fa-file-excel']")
	WebElement exceloption;
	
	
	
	
	
	
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
	public void searching() {
		Search.click();
	}
	
	public void entercategoryname(String catnamedata) {
		categoryname.sendKeys(catnamedata);
	}
	public int getnoofrows() {
		return(tablerows.size());
	}
	public int getnofcolumns( ) {
		return(tablecolumns.size());
	}
	
	public boolean searchcategoriesbyname(String catnamedata)
	{
		boolean flag=false;
		
		for(int i=1;i<=getnoofrows();i++)
		{
			String Name=table.findElement(By.xpath("//table[@id='categories-grid]//tbody//tr["+i+"]//td[2]")).getText();
			System.out.println(Name);
			
			if(Name.equals(catnamedata))
			{
				flag=true;
			}
		}
		return flag;
	}
		public void clickonexportdropdown() {
			exportdropdown.click();
		}
		public void clickonexceloption() {
			exceloption.click();
}


	
	
	
	
}
