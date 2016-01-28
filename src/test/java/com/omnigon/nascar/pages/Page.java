package com.omnigon.nascar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

  protected WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public boolean isElementVisible(WebElement locator) {
		try {
			locator.isDisplayed();
			return true;
		} catch (ElementNotVisibleException ignored) {
			return false;
		} catch (NoSuchElementException ignored) {
			return false;
		} catch (StaleElementReferenceException ignored) {
			return false;
		}
	}

  public boolean waitElement(By by) {
	  try {
		  (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(by));
		  return true;
	  } catch (TimeoutException ignored) {
		  return false;
	  } catch (Exception ignored) {
		  return false;
	}
  }
	  
}
