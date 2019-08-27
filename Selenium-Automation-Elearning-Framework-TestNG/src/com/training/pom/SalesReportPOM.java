package com.training.pom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalesReportPOM {
	private WebDriver driver; 
	public SalesReportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath = "//*[@class ='btn btn-primary']")
	private WebElement loginBtn; 
	
	
	@FindBy(xpath = "//*[@id = 'catalog']")
	private WebElement catalog;
	
	
	@FindBy(xpath = "//*[@id='catalog']/ul/li[2]/a")
	private WebElement Product;
	
	@FindBy(id = "input-name")
	private WebElement inputname;
	
	@FindBy(id = "catalog")
	private WebElement cataloglist;
	
	@FindBy(id = "button-filter")
	private WebElement filterbutton;
	
	@FindBy(xpath ="//*[@id='reports']/a/i" )
	private  WebElement reportsbutton;
	
	@FindBy(xpath = "//*[@id='reports']/ul/li[1]/a")
	private WebElement salesbutton;
	
	
	@FindBy(id = "input-date-start")
	private WebElement startdate;
	
	@FindBy(id = "input-date-end")
	private WebElement enddate;
	
	@FindBy(id = "input-group")
	private WebElement group;
	
	
	@FindBy(id = "input-status")
	private WebElement orderstatus;
	
	
	@FindBy(id = "button-filter")
	private WebElement filter;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
}
   
 public void clickoncatalog() {
	 this.cataloglist.click();; 
	 
 }
  
public void clickonproduct() {
	this.Product.click();
}

public void typeinput(String inputname)
{
	this.inputname.sendKeys(inputname);
}


public void clickonfilter() {
	this.filter.click();
}

public void clickonreports() {
	this.reportsbutton.click();
}



public void clickonsalesbutton() {
	this.salesbutton.click();
}

public void Enterstartdate(String startdate ) {
	this.startdate.clear();
	this.startdate.sendKeys(startdate);
	
}


public void Enterendtdate(String enddate ) {
	this.enddate.clear();
	this.enddate.sendKeys(enddate);
	
}


public void Selectgroupby(String grouptype ) {
	
	Select sel = new Select(this.group);
	sel.selectByVisibleText(grouptype);
}

public void Selectorderstatusby(String ordertype ) {
	
	Select sel = new Select(this.orderstatus);
	sel.selectByVisibleText(ordertype);
}

public void clickfilterorders() {
	this.filterbutton.click();
}



}

