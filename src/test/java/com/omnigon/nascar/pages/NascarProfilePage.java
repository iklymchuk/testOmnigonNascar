package com.omnigon.nascar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NascarProfilePage extends Page {
	
	  @FindBy(how = How.XPATH, using = ".//*[@value='Logout' and @data-screenset-roles='instance']")
	  @CacheLookup
	  public WebElement logoutLink;

	public NascarProfilePage(WebDriver driver) {
		super(driver);
	}

	public NascarLoginPage logOut () {
		waitElement(By.xpath(".//*[@value='Logout' and @data-screenset-roles='instance']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('gigya-input-submit logout')[0].click();");

		//logoutLink.click();
	  return new NascarLoginPage(driver);
}
}
