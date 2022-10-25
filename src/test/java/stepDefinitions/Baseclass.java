package stepDefinitions;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

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
	;	//created for generating random string in the email for unique emailid
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		}
	
	public static ExtentReports getInstance() {
		Date date = new Date();
		String fileNameType = date.toString().replace(" ", "_").replace(":","_")+".html";
		String reportFilepath ="reports//"+fileNameType;
		ExtentReports eReport = new ExtentReports(reportFilepath,true,DisplayOrder.NEWEST_FIRST);;
        File reportConfigFile = new File("ReportsConfig.xml");
        eReport.loadConfig(reportConfigFile);
        
     eReport.addSystemInfo("maven","6.");
      eReport.addSystemInfo("webdriver v", "12.0");
      return eReport;
        
		}
	
        
		}

