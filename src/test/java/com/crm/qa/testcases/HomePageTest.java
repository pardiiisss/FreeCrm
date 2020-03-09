package com.crm.qa.testcases;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	WebElement userNameLabel;
	ContactsPage contactsPage;

	public HomePageTest() throws FileNotFoundException {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		testUtil = new TestUtil();
//		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
//		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
//		testUtil.switchToFrame();
		driver.switchTo().frame("mainpanel");
		boolean userNameFlag = driver.findElement(By.xpath("//td[contains(@class,'headertext')]")).isDisplayed();
//		Assert.assertTrue(homePage.verifyCorrectUserName());
		System.out.println(userNameFlag);
		Assert.assertTrue(userNameFlag);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
//		testUtil.switchToFrame();
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
//		contactsPage = homePage.clickOnContactsLink();
//		homePage.clickOnContactsLink();
	}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}