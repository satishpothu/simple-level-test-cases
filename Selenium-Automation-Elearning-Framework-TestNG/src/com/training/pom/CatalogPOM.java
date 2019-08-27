package com.training.pom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPOM {
	private WebDriver driver; 
	public CatalogPOM(WebDriver driver) {
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



}








