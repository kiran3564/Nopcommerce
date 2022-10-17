package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.Categories;
import pageObjects.Dashboardpage;
import pageObjects.Loginpage;
import pageObjects.Manufacturerspage;
import pageObjects.searchcustomerpage;

public class Baseclass {
	public WebDriver driver;
	public Loginpage lp;
	public AddcustomerPage addcust;
	public searchcustomerpage searchcust;
	public Dashboardpage dbpage;
	public Categories cgpage;
	public Manufacturerspage mfpage;
	
	//created for generating random string in the email for unique emailid
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		}
}
