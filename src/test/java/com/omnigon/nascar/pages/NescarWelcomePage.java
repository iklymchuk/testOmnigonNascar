package com.omnigon.nascar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NescarWelcomePage extends Page {

	@FindBy(how = How.ID, using = "myProfileLink")
	@CacheLookup
	public WebElement myProfile;
	
	public NescarWelcomePage(WebDriver driver) {
		super(driver);
	}
	
	public NascarProfilePage goToMyProfilePage () {
		waitElement(By.id("myProfileLink"));
		driver.get("http://www.nascar.com/en_us/ajax/dynamic/myNASCAR.html");
		return new NascarProfilePage(driver);
	}
	
	public boolean isWelcomePage() {
		return waitElement(By.linkText("MY PROFILE"));
	}

}
