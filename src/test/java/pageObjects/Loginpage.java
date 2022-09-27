package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	public WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver) {
	
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Loginbutton;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Logoutbutton;
	
	public  void username(String uname) {
		Email.clear();
		Email.sendKeys(uname);
		
	}
	public void pwd(String pass) {
		Password.clear();
		Password.sendKeys(pass);
	}
	public void login(){
		Loginbutton.click();
		
	}
	public void logout() {
		Logoutbutton.click();
	}
}
