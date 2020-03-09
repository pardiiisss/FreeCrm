package com.crm.qa.testcases;

import java.io.FileNotFoundException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() throws FileNotFoundException {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		 testUtil = new TestUtil();
//		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.switchTo().frame("mainpanel");
//		homePage.clickOnContactsLink();

		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	}
	
	
	@Test(priority = 1)
	public void verifyContanctsLabel() {
//	 boolean contactsLabel =	contactsPage.contanctsLabel();
		boolean contactsLabel =	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).isDisplayed();
	 Assert.assertTrue("contact label is missing on the page", contactsLabel );
	
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest() {
//		contactsPage.selectContacts("niraj");
		//driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[text()='Boom Sharma']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	
	@Test(priority = 3)
	public void selectMultiplrContactsTest() {
//		contactsPage.selectContacts("niraj");
		//driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[text()='Hello Hi']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[text()='Boom Sharma']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[text()='Moto Yadav']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();

	}
	
	@DataProvider
	public Object[][] getCrmTestData() throws InvalidFormatException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
		
				
	}
	
	
	@Test(priority = 4, dataProvider = "getCrmTestData" )
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
//		public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
//		homePage.clickOnNewContactLink();
//		contactsPage.createNewContact("Mr.", "Yas", "Yasi", "Yas");
	//	contactsPage.createNewContact(title, firstName, lastName, company);
		Actions action = new Actions(driver);
  	    action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
  	    driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
  	    
  	  Select select = new Select(driver.findElement(By.name("title")));
//	  select.selectByVisibleText("Mr.");
	  select.selectByVisibleText(title);
	  
//	  driver.findElement(By.id("first_name")).sendKeys("Yas");
//	  driver.findElement(By.id("surname")).sendKeys("Yasi");
//	  driver.findElement(By.name("client_lookup")).sendKeys("YasComp");
	  
	  driver.findElement(By.id("first_name")).sendKeys(firstName);
	  driver.findElement(By.id("surname")).sendKeys(lastName);
	  driver.findElement(By.name("client_lookup")).sendKeys(company);
	  
	  driver.findElement(By.xpath("//input[@class='button'and @type='submit' and @value='Save']")).click();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
}
