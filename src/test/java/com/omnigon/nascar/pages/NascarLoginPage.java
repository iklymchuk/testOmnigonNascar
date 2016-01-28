package com.omnigon.nascar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NascarLoginPage extends Page {
	
	@FindBy(how = How.LINK_TEXT, using = "LOGIN")
	@CacheLookup
	public WebElement loginLink;

	public NascarLoginPage(WebDriver driver) {
		super(driver);
	}

	public NescarWelcomePage loginAs(String email, String pass) {
		waitElement(By.xpath(".//*[@name='username' and @data-screenset-roles='instance']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementsByName('username')[0].value='" + email + "';");
			js.executeScript("document.getElementsByName('password')[0].value='" + pass + "';");
			js.executeScript("document.getElementsByClassName('gigya-input-submit')[0].click();");
		
		return new NescarWelcomePage(driver);	
	}

	public boolean isLoginPage() {
		return waitElement(By.linkText("LOGIN"));
	}
	
}
