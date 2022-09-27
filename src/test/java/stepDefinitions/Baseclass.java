package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.Loginpage;
import pageObjects.searchcustomerpage;

public class Baseclass {
	public WebDriver driver;
	public Loginpage lp;
	public AddcustomerPage addcust;
	public searchcustomerpage searchcust;
	
	//created for generating random string in the email for unique emailid
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		}
}
