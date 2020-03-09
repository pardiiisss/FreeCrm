package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	//these are global variables that use throughout the program
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
public TestBase() throws FileNotFoundException{
		
	prop = new Properties();
	FileInputStream ip = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	try {
		prop.load(ip);
	} catch (IOException e) {
	
		e.printStackTrace();
	}
		
	}
	
public static void initialization() throws FileNotFoundException {
	String browserName = prop.getProperty("browser");
	
	
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Maven\\chromedriver.exe");
		driver = new ChromeDriver();

	}else 	if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Maven\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}
	
	
	
	
	
	

}
