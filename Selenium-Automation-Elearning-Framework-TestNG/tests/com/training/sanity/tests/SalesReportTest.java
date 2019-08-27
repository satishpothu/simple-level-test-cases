package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.training.generics.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SalesReportTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CatalogPOM CatalogPOM;
	private SalesReportPOM SalesReportPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebElement cataloglist;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);	
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		CatalogPOM =  new CatalogPOM(driver);
		SalesReportPOM = new SalesReportPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//ddriver.quit();
	}
	
	@Test()
	public void SalesReportTest() throws InterruptedException {
		
		//giving username
		loginPOM.sendUserName("admin");
		
		//giving passsword
		loginPOM.sendPassword("admin@123");
		
		//clicking on login button
		loginPOM.clickLoginBtn(); 
		
        //Clicking on  reports  	
		SalesReportPOM.clickonreports();
		
		//Click on sales button 
		SalesReportPOM.clickonsalesbutton();
		
         //Printing all the links under sales reports	
		 List<WebElement> salesreportlinks =driver.findElements(By.xpath("//ul[@class = 'collapse in']"));
	
			//Converting list of webelements to a string array
	      String []linkText =new String[salesreportlinks.size()];
	      
	      int i=0;
	      
	      
	      //Storing List elements text into String array
	      for(WebElement a:salesreportlinks )
	      {
	    	  linkText[i]=a.getText();
	          
	          System.out.println(linkText[i]);	
	             
	          i++;    
	      }
           
         //Importing actions 
	      Actions ac =  new Actions(driver);
           
        //Printing all the orders
        WebElement orders = driver.findElement(By.xpath("//*[@id = 'reports'] //*[contains(text(),'Orders')]")); 
           
        //Performing mouseover
       Action mouseover1 = ac.moveToElement(orders).click().build();
       
       mouseover1.perform();
       
       Thread.sleep(3000);
       
       //Giving startdate
       SalesReportPOM.Enterstartdate("20170803");
       
       //Giving enddate
       SalesReportPOM.Enterendtdate("20160119");
       
       //select group by
       SalesReportPOM.Selectgroupby("Days");
       
       //Selecting by orders status
       SalesReportPOM.Selectorderstatusby("Processing");
       
       //clicking on filter orders
       SalesReportPOM.clickfilterorders();
     
       
	}
       
	
	  
      
       
       

       
       
       
       
      
           
           
           
       
       
       
       
       
       
		
		
	
		
		
		
		
		
		
	      
}

