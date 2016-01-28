package com.omnigon.nascar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NascarHomePage extends Page {
 
	@FindBy(how = How.LINK_TEXT, using = "REGISTER")
	@CacheLookup
	public WebElement registerLink;
	
  @FindBy(how = How.LINK_TEXT, using = "LOGIN")
  @CacheLookup
  public WebElement loginLink;

  public NascarHomePage(WebDriver webDriver) {
    super(webDriver);
  }
  
  public NascarRegisterPage goToRegisterPage () {
	  waitElement(By.linkText("REGISTER"));
	  registerLink.click();
	  return new NascarRegisterPage(driver);
  }
  
  public NascarLoginPage goToLoginPage () {
	  waitElement(By.linkText("LOGIN"));
	  loginLink.click();
	  return new NascarLoginPage(driver);
  }
  
}
