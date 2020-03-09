package com.crm.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
//	@FindBy(xpath = "//a[text()='test2 test2']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']");
//	WebElement contactsLable;
	@FindBy(id="first_name")
    WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath= "//input[@class='button'and @type='submit' and @value='Save'])")
	WebElement saveBtn;
	
	public ContactsPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}

	
	public boolean contanctsLabel() {
		return contactsLable.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//"
				+ "parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String fName, String LtName, String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(LtName);
		companyName.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
}
