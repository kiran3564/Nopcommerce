package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class searchcustomerpage {
	
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	public searchcustomerpage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper =new WaitHelper(ldriver);
		}

@FindBy(how = How.XPATH, using = "//input[@id='SearchEmail']")
WebElement txtEmail;

@FindBy(how = How.XPATH, using = "//input[@id='SearchFirstName']")
WebElement txtFirstname;

@FindBy(how = How.XPATH, using = "//input[@id='SearchLastName']")
WebElement txtLastname;

@FindBy(how = How.XPATH, using = "//select[@id='SearchMonthOfBirth']")
WebElement drpdobmonth;

@FindBy(how = How.XPATH, using = "//select[@id='SearchDayOfBirth']")
WebElement drpdobday;

@FindBy(how = How.XPATH, using = "//input[@id='SearchCompany']")
WebElement txtsearchcompany;

@FindBy(how = How.XPATH, using = "//button[@id='search-customers']")
WebElement searchbutton;

@FindBy(how = How.XPATH, using = "//table[@role='grid']")
WebElement tblsearchresults;

@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
WebElement table;
@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
List<WebElement> tablerows;
@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
List<WebElement> tablecolumns;

public void setemail(String email) throws InterruptedException

{
	Thread.sleep(3000);
	txtEmail.clear();
	txtEmail.sendKeys(email);
	
}
public void setfirstname(String fname) throws InterruptedException
{
	Thread.sleep(3000);
	txtFirstname.clear();
	txtFirstname.sendKeys(fname);
	
}
public void setlastname(String lname) throws InterruptedException
{
	Thread.sleep(4000);
	txtLastname.clear();
	txtLastname.sendKeys(lname);
}
public void clickonsearch() throws InterruptedException {
	searchbutton.click();
	Thread.sleep(3000);
}
public int getnoofrows() {
	return(tablerows.size());
}
public int getnofcolumns( ) {
	return(tablecolumns.size());
}
public boolean searchcustomerbyemail(String email)
{
	boolean flag=false;
	
	for(int i=1;i<=getnoofrows();i++)
	{
		String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
		System.out.println(emailid);
		if(emailid.equals(email))
		{
			flag=true;
		}
	}
	return flag;
}
	public boolean searchcustomerbyname(String name)
	{
		boolean flag=false;
		
		for(int i=1;i<=getnoofrows();i++)
		{
			String Name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String Names []=Name.split(" ");
			
			if(Names[0].equals("sai") && Names[1].equals("venkata"))
			{
				flag=true;
			}
		}
		return flag;
}


}
