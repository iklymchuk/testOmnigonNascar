package com.omnigon.nascar;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.omnigon.nascar.pages.NascarHomePage;
import com.omnigon.nascar.pages.NascarLoginPage;
import com.omnigon.nascar.pages.NascarProfilePage;
import com.omnigon.nascar.pages.NascarRegisterPage;
import com.omnigon.nascar.pages.NescarWelcomePage;
import com.omnigon.nascar.util.TestProperties;

public class NascarTest extends TestNgTestBase {

  private NascarHomePage homePage;
  private NascarRegisterPage registerPage;
  private NascarLoginPage loginPage;
  private NescarWelcomePage welcomePage;
  private NascarProfilePage profilePage;

  @BeforeMethod
  public void initPageObjects() {
    homePage = PageFactory.initElements(driver, NascarHomePage.class);
    driver.get(baseUrl);
  }

  @Test(priority = 1)
  public void testSuccessRegistry() {
    registerPage = homePage.goToRegisterPage();
    welcomePage = registerPage.registrationAs(TestProperties.getTestProperty("email"),
    										TestProperties.getTestProperty("password"),
    										TestProperties.getTestProperty("zip"));
	Assert.assertTrue(welcomePage.isWelcomePage(), "This isn't WelcomePage");
  }
  
  @Test(priority = 2, dependsOnMethods = "testSuccessRegistry")
  public void testSuccessLogin() {
	  login();
	  Assert.assertTrue(welcomePage.isWelcomePage(), "This isn't WelcomePage");
  }

  @Test(priority = 3, dependsOnMethods = "testSuccessLogin")
  public void testSuccessLogout() {
	  login();
	  profilePage = welcomePage.goToMyProfilePage();
	  loginPage = profilePage.logOut();
	  Assert.assertTrue(loginPage.isLoginPage(), "This isn't LoginPage");
  }
  
  private void login() {
	loginPage = homePage.goToLoginPage();
	welcomePage = loginPage.loginAs(TestProperties.getTestProperty("email"),
									TestProperties.getTestProperty("password"));
  	}
}
