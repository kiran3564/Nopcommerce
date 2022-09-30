package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddcustomerPage;
import pageObjects.Dashboardpage;
import pageObjects.Loginpage;
import pageObjects.searchcustomerpage;

public class steps extends Baseclass {
	
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 lp=new Loginpage(driver);
		 //Thread.sleep(5000);

	}

	@When("user opens url {string}")
	public void user_opens_url(String url) throws InterruptedException {
		driver.get(url);
	    driver.manage().window().maximize(); 
	    //Thread.sleep(5000);
	}

	@When("user enters email as  {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {

     lp.username(email);
	  lp.pwd(password);
	  //Thread.sleep(5000);
	}

	@When("click on login")
	public void click_on_login() throws InterruptedException {
	 
		lp.login();
		Thread.sleep(5000);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
	  
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		/*else {
			Assert.assertEquals(title, driver.getTitle());
		}*/
		Thread.sleep(5000);
	}

	@When("user click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	   lp.logout();
	   //Thread.sleep(5000);
	}

	@Then("close browser")
	public void close_browser() throws InterruptedException {
		Thread.sleep(5000);
	   driver.quit();
	   //Thread.sleep(5000);
	}

//Customer feature steps
	
	@Then("user can view dashboard")
	public void user_can_view_dashboard() {
	addcust=new AddcustomerPage(driver);
	Assert.assertEquals("Dashboard / nopCommerce administration" , addcust.getpagetitle());
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
	  Thread.sleep(3000);
	  addcust.clickoncustomermenu();
	}

	@When("click on the customers menu item")
	public void click_on_the_customers_menu_item() throws InterruptedException {
	    Thread.sleep(3000);
	    addcust.clickoncustomer();
	}

	@When("click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
	   Thread.sleep(3000);
	   addcust.clickonaddbutton();
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
	 Thread.sleep(3000);
	 Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getpagetitle());
	}

	@When("user enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		String email=randomestring() + "@gmail.com";
		addcust.setemail(email);
		//addcust.setcustomerroles("Guests");
		Thread.sleep(5000);
		addcust.setpassword("test@123");
		addcust.setfirstname("sai");
		addcust.setlastname("venkata");
		addcust.setGender("male");
		addcust.setdob("7/26/2000");
		addcust.setcompanyname("techtammina");
		
		
		addcust.setadmincomment("hello");
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    addcust.clickonsave();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().
			contains("The new customer has been added successfully"));
			
}
	
	@Then("enter customer email")
	public void enter_customer_email() throws InterruptedException {
		Thread.sleep(5000);
	searchcust = new searchcustomerpage(driver);
	searchcust.setemail("kiran3564@gmail.com");
	
	}

	@Then("click on the search button")
	public void click_on_the_search_button() throws InterruptedException {
	 searchcust.clickonsearch();
	 Thread.sleep(3000);
	}

	@Then("user should found email in search table")
	public void user_should_found_email_in_search_table() throws InterruptedException {
    boolean status	=searchcust.searchcustomerbyemail("kiran3564@gmail.com");
    Thread.sleep(5000);

     Assert.assertEquals(true, status);
	
	}
	@When("enter customer firstname")
	public void enter_customer_firstname() throws InterruptedException {
		Thread.sleep(5000);
		searchcust = new searchcustomerpage(driver);
		searchcust.setfirstname("sai");
	}

	@When("enter customer lastname")
	public void enter_customer_lastname() throws InterruptedException {
	searchcust.setlastname("venkata");
	}

	@Then("user should found name in search table")
	public void user_should_found_name_in_search_table() {
	  boolean status=searchcust.searchcustomerbyname("sai venkata");
	  Assert.assertEquals(true, status);
	  
	}
	
	//steps for clearing the cache in admin
	
	@Then("click on the settings")
	public void click_on_the_settings() {
		dbpage=new Dashboardpage(driver);
		dbpage.clicksettings();
	}

	@Then("click on the clear cache button")
	public void click_on_the_clear_cache_button() {
	  dbpage.clickclearcache();
	}

	@Then("user can alert message as {string}")
	public void user_can_alert_message_as(String string) throws InterruptedException {
		Thread.sleep(3000);
		if(driver.getPageSource().contains("For security purposes, the feature you have requested is not available on the demo site."))
		{
			driver.close();
			Assert.assertTrue(true);
		
	Thread.sleep(5000);
	}
	}
	
	//Steps for getting the nopcommerce content
	
	@Then("page source should contain {string}")
	public void page_source_should_contain(String string) throws InterruptedException {
		Thread.sleep(3000);
		if(driver.getPageSource().contains("NopCommerce News"))
		{
			driver.close();
			Assert.assertTrue(true);
	}
		
	}
		//steps for printing the nopcommerce content in console
		
		@When("print the content of nopcommerce news in console\\/")
		public void print_the_content_of_nopcommerce_news_in_console() throws InterruptedException {
			dbpage=new Dashboardpage(driver);
		   Thread.sleep(5000);
		  String newscontent= dbpage.NopcommerceNewscontent();
		  
		  
		  System.out.println(newscontent);
		}

		@Then("click on logout")
		public void click_on_logout() throws InterruptedException {
			Thread.sleep(5000);
		  dbpage.clickonthelogout();
		}

		//getting the data and saving in the text file
		
		@When("get the data and save it in the text file")
		public void get_the_data_and_save_it_in_the_text_file() throws InterruptedException, IOException {
			dbpage=new Dashboardpage(driver);
			   Thread.sleep(5000);
			  String newscontent= dbpage.NopcommerceNewscontent();
			  FileOutputStream fout=new FileOutputStream("C:\\Users\\TT-USER\\eclipse-workspace\\nopcommerce\\vc-01\\Exportdata\\testdata.txt");    
			     BufferedOutputStream bout=new BufferedOutputStream(fout); 
			     byte b[]=newscontent.getBytes();    
			     bout.write(b);    
			    bout.flush();    
			     bout.close();    
			     fout.close();  

		  
		}

//check wether order total is present in dashboard or not
		
		
		
		@Then("page source should contained the text {string}")
		public void page_source_should_contained_the_text(String string) throws InterruptedException {
			Thread.sleep(5000);
			dbpage=new Dashboardpage(driver);
			Thread.sleep(3000);
			if(driver.getPageSource().contains("Order totals"))
			{
				driver.close();
				Assert.assertTrue(true);
			
		}
}
}
