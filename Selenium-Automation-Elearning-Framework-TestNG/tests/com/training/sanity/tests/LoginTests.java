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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CatalogPOM CatalogPOM;
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
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test()
	public void validLoginTest() {
		
		//giving username
		loginPOM.sendUserName("admin");
		
		//giving passsword
		loginPOM.sendPassword("admin@123");
		
		//clicking on login button
		loginPOM.clickLoginBtn(); 
		
		//clicking on catalog
		CatalogPOM.clickoncatalog();
		
		driver.getTitle();
		System.out.println(driver.getTitle());
		
	
	   //getting list of all the links from catalog
      List<WebElement> links =driver.findElements(By.id("catalog"));

      //Converting list of webelements to a string array
      String []linkText =new String[links.size()];
      
      int i=0;
      
      //Storing List elements text into String array
      for(WebElement a: links)
      {
    	  linkText[i]=a.getText();
          
    	  
    	  //Printing all the links under catalog tag
          System.out.println(linkText[i]);	
             
          i++;    
          
       Assert.assertEquals(linkText[0], "Categories");   
          
      }   
      
      
   //clicking on products link
    CatalogPOM.clickonproduct();
   
    List<WebElement> allproducts = driver.findElements(By.id("form-product"));
    
    String []totalproducts =new String[allproducts.size()];
    
    int k = 0;
   
    //Storing List elements text into String array
    for(WebElement b: allproducts)
    {
    	//Printing all the products under products list
    	totalproducts[k]=b.getText();
       
       System.out.println(totalproducts[k]);
          
       k++;
    }   
    
    
    //Entering Blazer in products box
    CatalogPOM.typeinput("Blazer");
    
    //clicking on filter
    CatalogPOM.clickonfilter();
    
  
    //Printint all the displayed products
    List<WebElement>prds = driver.findElements(By.xpath("//td[contains(text(),'Blazer')]"));
    
    System.out.println("The total no of blazer products available are"+prds.size());
    
    
    for(int j=0;j<prds.size();j++)
    {
    	
    String prdst = prds.get(j).getText();
    System.out.println(prdst);
    			
    }
    
    //getting the entered value in product search box
    WebElement enteredname = driver.findElement(By.name("filter_name"));
     
    enteredname.toString();
  
    //getting attribute
    enteredname.getAttribute("value");
    
    //Printing the attribute
    System.out.println("Value entered in the product text box is"+enteredname.getAttribute("value"));
    
    
    //Checking the entered name in GUI
    Assert.assertEquals(enteredname, "Blazer");
    
	}
	
	
	
  
			
	
			
				
		
	



}

