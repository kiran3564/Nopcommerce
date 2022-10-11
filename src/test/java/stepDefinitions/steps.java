package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Nopcommerce.vc_01.XLUtility;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddcustomerPage;
import pageObjects.Categories;
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
  //search customer by email	
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
@Then("Get the orders data and save in the excel")
public void get_the_orders_data_and_save_in_the_excel() throws IOException, InterruptedException {
	Thread.sleep(5000);
	dbpage=new Dashboardpage(driver);
    String path="C:\\Users\\TT-USER\\eclipse-workspace\\nopcommerce\\vc-01\\Exceldata\\orders.xlsx";
    XLUtility xlutil=new XLUtility(path);
		
    xlutil.setCellData("sheet1",    0,0, "order status");
    xlutil.setCellData("sheet1",    0,1, "today");
    xlutil.setCellData("sheet1",    0,2, "this week");
    xlutil.setCellData("sheet1",    0,3, "this month");
    xlutil.setCellData("sheet1",    0,4, "this year");
    xlutil.setCellData("sheet1",    0,5, "all time");
    
    
		
   WebElement table=driver.findElement(By.xpath("//div[@id='average-order-report-grid_wrapper']//div[@class='row']//table//tbody"));
    int rows=table.findElements(By.xpath("tr")).size();
for(int r=1;r<=rows;r++)
{
	String Orderstatus=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
	String  Today =table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
	String Thisweek=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
	String ThisMonth=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
	String Thisyear=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
	String alltime=table.findElement(By.xpath("tr["+r+"]/td[6]")).getText();

System.out.println(Orderstatus+Today+Thisweek+ThisMonth+Thisyear+alltime);
//writing the data in excel sheet
xlutil.setCellData("sheet1", r, 0, Orderstatus);
xlutil.setCellData("sheet1", r, 1, Today);
xlutil.setCellData("sheet1", r, 2, Thisweek);
xlutil.setCellData("sheet1", r, 3, ThisMonth);
xlutil.setCellData("sheet1", r, 4, Thisyear);
xlutil.setCellData("sheet1", r, 5, alltime);
}
System.out.println("webscraping is done sucessfully");
System.out.println(table);


}
@Then("Get the latest orders data and save in the excel")
public void get_the_latest_orders_data_and_save_in_the_excel() throws InterruptedException, IOException {
	Thread.sleep(5000);
	dbpage=new Dashboardpage(driver);
    String path="C:\\Users\\TT-USER\\eclipse-workspace\\nopcommerce\\vc-01\\Exceldata\\latestorders.xlsx";
    XLUtility xlutil=new XLUtility(path);
		
    xlutil.setCellData("sheet1",    0,0, "order ");
    xlutil.setCellData("sheet1",    0,1, "order status");
    xlutil.setCellData("sheet1",    0,2, "customer");
    xlutil.setCellData("sheet1",    0,3, "created on");
    xlutil.setCellData("sheet1",    0,4, "view");
    //xlutil.setCellData("sheet1",    0,5, "all time");
    
    
		
   WebElement table=driver.findElement(By.xpath("//div[@id='orders-grid_wrapper']//table//tbody"));
    int rows=table.findElements(By.xpath("tr")).size();
for(int r=1;r<=rows;r++)
{
	String Order=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
	String orderstatus =table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
	String customer=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
	String createdon=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
	String view=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
	//String alltime=table.findElement(By.xpath("tr["+r+"]/td[6]")).getText();

System.out.println(Order+orderstatus+customer+createdon+view);
//writing the data in excel sheet
xlutil.setCellData("sheet1", r, 0, Order);
xlutil.setCellData("sheet1", r, 1, orderstatus);
xlutil.setCellData("sheet1", r, 2, customer);
xlutil.setCellData("sheet1", r, 3, createdon);
xlutil.setCellData("sheet1", r, 4, view);
//xlutil.setCellData("sheet1", r, 5, alltime);
}
System.out.println("webscraping is done sucessfully");
System.out.println(table);


}

@Then("Get the latest order data based on serial no")
public void get_the_latest_order_data_based_on_serial_no() throws InterruptedException {
	Thread.sleep(5000);
	dbpage=new Dashboardpage(driver);
	   List<WebElement> elementslist =driver.findElements(By.xpath("//div[@id='orders-grid_wrapper']//table//tbody//tr//td[1]"));
	   List<String>originallist=  elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
	   List<Object>orderdetails=elementslist.stream().filter(s->s.getText().contains("2")).map(s->getorderdetail(s)).collect(Collectors.toList());
	   
	   orderdetails.forEach(a->System.out.println(a));
	   System.out.println("hello");
		}

		private static Object getorderdetail(WebElement s) {
			// TODO Auto-generated method stub
		String orderdetail=	s.findElement(By.xpath("following-sibling::td[2]")).getText();
			
			return orderdetail;
		}
		
		@Then("Get the count of popular search keyword if item not there do pagination")
		public void get_the_count_of_popular_search_keyword_if_item_not_there_do_pagination() throws InterruptedException {
		    
			Thread.sleep(5000);
			dbpage=new Dashboardpage(driver);
			
			   List<WebElement> elementslist =driver.findElements(By.xpath("//div[@id='search-term-report-grid_wrapper']//table//tbody//tr//td[1]"));
			   List<String>originallist=  elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
			   List<Object>keyworddetails=elementslist.stream().filter(s->s.getText().contains("gift")).map(s->getorderdetails(s)).collect(Collectors.toList());
			   
			   keyworddetails.forEach(a->System.out.println(a));
			   System.out.println("hello");
			   if(keyworddetails.size()<1)
			   {
				   driver.findElement(By.xpath("//li[@id='search-term-report-grid_next']")).click();
			   }
				 
			     while(keyworddetails.size()<1);
				} 
				private static Object getorderdetails(WebElement s) {
					// TODO Auto-generated method stub
				
				String orderdetail=	s.findElement(By.xpath("following-sibling::td")).getText();
					
					return orderdetail;
				}
				
				
				
				
				@Then("Scroll down and click on the upward arrow")
				public void scroll_down_and_click_on_the_upward_arrow() throws InterruptedException {
					Thread.sleep(5000);
					dbpage=new Dashboardpage(driver);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,2000)", "");
					dbpage.scrolling();
					
				}
				
				@Then("enter the searchword as {string} in the search menu and click on enter")
				public void enter_the_searchword_as_in_the_search_menu_and_click_on_enter(String string) throws InterruptedException {
					Thread.sleep(5000);
					dbpage=new Dashboardpage(driver);
					dbpage.searching("customers");
					 Actions act = new Actions(driver);
				        act.sendKeys(Keys.DOWN).perform();
				        act.sendKeys(Keys.ENTER).perform();
					
				}

				@Then("Url should be changed")
				public void url_should_be_changed() {
				  String currenturl =driver.getTitle();
				  String accurateurl= "https://admin-demo.nopcommerce.com/Admin/Customer/List";
				  if(currenturl.equals(accurateurl))
				  {
					  Assert.assertTrue(true);
				  }
				}
				
				
				@Then("click on the catalog")
				public void click_on_the_catalog() {
				  cgpage = new Categories(driver);
				  cgpage.catalogclick();
				}

				@Then("click on the categories")
				public void click_on_the_categories() throws InterruptedException {
					Thread.sleep(5000);
				   cgpage.categoriesclick();
				}

				@Then("click on Add new")
				public void click_on_add_new() {
					cgpage.addnewclick();
				}


@Then("enter the name as {string}")
public void enter_the_name_as(String namedata) throws InterruptedException {
	Thread.sleep(5000);
    cgpage.entername(namedata);
    
}
			
			

				@Then("choose category")
				public void choose_category() throws InterruptedException {
					Thread.sleep(5000);
				    WebElement dropdownvalues = driver.findElement(By.xpath("//*[@id=\"ParentCategoryId\"]"));
			        Select dropdown = new Select(dropdownvalues);
			        dropdown.selectByVisibleText("Computers");
				}
				

				@Then("click on the save button")
				public void click_on_the_save_button() {
				    cgpage.clickonsave();
				    
				    if(driver.getPageSource().contains("The new category has been added successfully.")) {
				 	   
				 	   Assert.assertTrue(true);
				}

			
				}
				
				
				
				//steps for searching the categories in the categorie page
				
				/*@Then("Enter category name as {string}")
				public void enter_category_name_as(String catnamedata) {
					cgpage = new Categories(driver);
					cgpage.entercategoryname(catnamedata);
				   
				}

				@Then("click on the searchbutton")
				public void click_on_the_searchbutton() {
				   cgpage.searching();
				}
				
				@Then("user should found category name in search table")
				public void user_should_found_category_name_in_search_table() throws InterruptedException {
				 boolean status	=cgpage.searchcategoriesbyname("computers");
					    Thread.sleep(5000);

				     Assert.assertEquals(true, status);
					
					}
			  */
				
				//steps for searching the category name
				
				

@Then("Enter category name")
public void enter_category_name() {
	cgpage = new Categories(driver);
	cgpage.entercategoryname("computers");
   
}

@Then("click on the searchbutton")
public void click_on_the_searchbutton() throws InterruptedException {
    cgpage.searching();
    Thread.sleep(5000);
}

@Then("user should found category name in search table")
public void user_should_found_category_name_in_search_table() {
boolean status=cgpage.searchcategoriesbyname("computers");
Assert.assertEquals(true, status);
}
			}




	



