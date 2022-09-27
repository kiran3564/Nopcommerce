package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

	public WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	By lnkcustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkcustomers_customer=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By buttonaddnew = By.xpath("//a[@class='btn btn-primary']");
	By Emailid = By.xpath("//input[@id='Email']");
	By txtpassword = By.xpath("//input[@id='Password']");
	
	By txtfirstname = By.xpath("//input[@id='FirstName']");
	By txtlastname = By.xpath("//input[@id='LastName']");
	
	By rdmalegender =By.xpath("//input[@id='Gender_Male']");
	By rdfemalegender = By.xpath("//input[@id='Gender_Female']");
	By textdob        =By.xpath("//input[@id='DateOfBirth']");
	By txtcompanyname    =By.xpath("//input[@id='Company']");
	By txtnewsletter     = By.xpath("//input[@aria-expanded='true']");
	By listitemadmin  = By.xpath("//li[normalize-space()='Administrators']");
	By listitemforummoderators =By.xpath("//li[normalize-space()='Forum Moderators']");
	By listitemGuests =By.xpath("//li[normalize-space()='Guests']");
	By listitemRegistered=By.xpath("//li[@id='d119a7c9-1c17-446a-bbf0-d37809d9482f']");
	By listitemvendor = By.xpath("//li[contains(text(),'Vendors')]");
	By dropmgrvendor = By.xpath("//select[@id='VendorId']");
	By txtadmincomment = By.xpath("//textarea[@id='AdminComment']");
	By savebutton = By.xpath("//button[@name='save']//i[@class='far fa-save']");
	By txtcustomerroles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	public String getpagetitle() {
		return ldriver.getTitle();
	}
	
	
	public void clickoncustomermenu() throws InterruptedException {
		ldriver.findElement(lnkcustomers_menu).click();
		Thread.sleep(3000);
	}
	public void clickoncustomer() {
		ldriver.findElement(lnkcustomers_customer).click();
	}
	public void clickonaddbutton( ) throws InterruptedException {
		ldriver.findElement(buttonaddnew).click();
		Thread.sleep(3000);
	}
	public void setemail(String email) {
		ldriver.findElement(Emailid).sendKeys(email);
	}
	public void setpassword(String password) {
		ldriver.findElement(txtpassword).sendKeys(password);
	}
	public void setfirstname(String firstname) {
		ldriver.findElement(txtfirstname).sendKeys(firstname);
		
	}
	public void setlastname(String lastname) {
		ldriver.findElement(txtlastname).sendKeys(lastname);
	}
	public void setGender (String gender)
	{
	if(gender.equals("male"))
	{
	ldriver.findElement(rdmalegender).click();
	}
	else if(gender.equals("female"))
	{
	ldriver.findElement(rdfemalegender).click();
	}else
	{
	ldriver.findElement(rdmalegender).click();
	}
	}
	public void setdob(String dob) {
		ldriver.findElement(textdob).sendKeys(dob);
	}
	public void setcompanyname (String companyname ) {
		ldriver.findElement(txtcompanyname).sendKeys(companyname);
	}
	public void setnewsletter (String newsletter) {
		ldriver.findElement(txtnewsletter).sendKeys(newsletter);
	}
	public void setcustomerroles(String role) 
	{

		if (!role.equals("Vendors")) {
			ldriver.findElement(
					By.xpath("//div[@class='input-group']//div//select[@id='SelectedCustomerRoleIds']//option"));

		}
		ldriver.findElement(txtcustomerroles).click();
		
		WebElement listitem;
	
	 if(role.equals("administrators"))
	{
	listitem =ldriver.findElement(listitemadmin);
	}
	else if(role.equals("Guests"))
	{
	listitem=ldriver.findElement(listitemGuests);
	}
	else if(role.equals("registered"))
	{
	listitem=ldriver.findElement(listitemRegistered);
	} else if(role.equals("vendors"))
	{
	listitem=ldriver.findElement(listitemvendor);
	}
	else if(role.equals("forum moderators"))
	{
	listitem=ldriver.findElement(listitemforummoderators);
	}else
	{
		listitem=ldriver.findElement(listitemGuests);
	}
	listitem.click();

	JavascriptExecutor js = (JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].click();", listitem);
	}
	public void setmanagerofvendor(String value)
	{
	Select drp = new Select(ldriver.findElement(dropmgrvendor));
	drp.selectByVisibleText(value);
	}

public void setadmincomment(String admincomment) {
	ldriver.findElement(txtadmincomment).sendKeys(admincomment);
}
public void clickonsave() {
	ldriver.findElement(savebutton).click();
}
}

	
