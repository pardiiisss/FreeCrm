package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {



	//Page Factory : OR : Object Repository
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[contains(text(),'submit')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement CrmLogo;
	
	public LoginPage() throws FileNotFoundException {
		

    //Initial page factory : Page Object ===> (this) means current class object(username,password,loginBtn,SignUpBtn,CrmLogo)
		PageFactory.initElements(driver, this);
	}
	

	//Actions : Features which available on login page
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}
	
	public boolean validateCrmImage() {
	return	CrmLogo.isDisplayed();
	}
	//void? HomePage
	public void login(String un, String pw) throws FindFailed, FileNotFoundException{
	
		username.sendKeys(un);
		password.sendKeys(pw);
//		loginBtn.click();
		
        Screen s = new Screen();
		Pattern settingImg = new Pattern("C:\\Users\\Asus\\eclipse-workspace\\FreeCrmTest\\crm_login.png");
		s.wait(settingImg,2000);
		s.click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		
//		return  new HomePage();
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
