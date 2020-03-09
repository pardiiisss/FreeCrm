package com.crm.qa.testcases;

import java.io.FileNotFoundException;

import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.Assert;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws FileNotFoundException {
		super();
		}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
	 loginPage = new LoginPage();	
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
	String titleLoginPage =	loginPage.validateLoginPageTitle();
	System.out.println(titleLoginPage);
		Assert.assertEquals(titleLoginPage, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void crmLogoImageTest() {
	boolean flag =	loginPage.validateCrmImage();
	System.out.println(flag);
	Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() throws FindFailed, FileNotFoundException  {
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	
	
}
