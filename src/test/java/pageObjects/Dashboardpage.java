package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboardpage {
	
	
public WebDriver ldriver;
	
	public Dashboardpage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath="//i[@class='fas fa-cogs']")
	WebElement settingsbutton;
	
	@FindBy(xpath="//span[normalize-space()='Clear cache']")
	WebElement clearcachebutton;
	
	@FindBy(xpath="//div[@id='nopcommerce-news-box']")
WebElement NopCommerceNews;	
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Logout;
	
	


	public void clicksettings() {
		settingsbutton.click();
	}
	
	public void clickclearcache() {
		clearcachebutton.click();
	}
	public String NopcommerceNewscontent() {
		return NopCommerceNews.getText(); 
	}
	
	public void clickonthelogout() {
		Logout.click();
	}

}
