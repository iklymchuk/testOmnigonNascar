package com.omnigon.nascar;

import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import com.omnigon.nascar.util.PropertyLoader;

public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @BeforeMethod
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }
  
  @BeforeMethod
  public void initWebDriver() {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissAll();
  }
}
