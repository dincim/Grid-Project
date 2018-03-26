package com.saucelab;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.seleniumgrid.AmazonPage;
import com.seleniumgrid.EtsyPage;

public class WoodenSpoonSearch {
	WebDriver driver;
	  public static final String USERNAME = "Qaaron";
	  public static final String ACCESS_KEY = "90444b18-7aa0-42bf-bdce-50bc6bbe9ec4";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	  
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
//		 System.setProperty("webdriver.chrome.driver", 
//				  "/Users/muratdinc/Documents/Libraries/drivers/chromedriver");
//		  driver = new ChromeDriver();
		
		  DesiredCapabilities caps = DesiredCapabilities.chrome();
		  
		  caps.setCapability("platform", "Windows 10");
		  caps.setCapability("version", "65.0");
	 
	      driver = new RemoteWebDriver(new URL(URL), caps);
		
		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
		
  @Test
  public void EtsySearchTest() {
	 
	  EtsyPage etsy = new EtsyPage(driver);
	  etsy.goTo();
	  assertTrue(etsy.atEtsyPage());
	  
	  etsy.searchItem("Wooden Spoon");
	  
	  assertTrue(etsy.resultsAreDisplayed());
	    
  }
  @Test
  public void AmazonSearchTest() {
	  
	  AmazonPage amz = new AmazonPage(driver);
	  amz.goTo();
	  assertTrue(amz.atAmazonPage());
	  
	  amz.searchItem("Wooden Spoon");
	  
	  assertTrue(amz.resultsAreDisplayed());
  }
}
