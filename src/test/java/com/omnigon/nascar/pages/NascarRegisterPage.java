package com.omnigon.nascar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NascarRegisterPage extends Page {
	
	@FindBy(how = How.ID, using = ".//*[@name='email' and @data-screenset-roles='instance']")
	@CacheLookup
	public WebElement emailLink;
	
	public NascarRegisterPage(WebDriver driver) {
		super(driver);
	}

	public NescarWelcomePage registrationAs(String email, String pass, String zip) {
		waitElement(By.xpath(".//*[@name='email' and @data-screenset-roles='instance']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementsByName('email')[0].value='" + email + "';");
			js.executeScript("document.getElementsByName('password')[0].value='" + pass + "';");
			js.executeScript("document.getElementsByName('zip')[0].value='" + zip + "';");
			js.executeScript("document.getElementsByName('data.terms')[0].click();");
			js.executeScript("document.getElementsByClassName('gigya-input-submit')[0].click();");
		return new NescarWelcomePage(driver);
	}
}
