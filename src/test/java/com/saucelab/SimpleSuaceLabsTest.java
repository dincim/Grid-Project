package com.saucelab;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	 
	import java.net.URL;
	 
	public class SimpleSuaceLabsTest {
	 
	  public static final String USERNAME = "Qaaron";
	  public static final String ACCESS_KEY = "90444b18-7aa0-42bf-bdce-50bc6bbe9ec4";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	 
	  public static void main(String[] args) throws Exception {
	 
		  DesiredCapabilities caps = DesiredCapabilities.edge();
		  caps.setCapability("platform", "Windows 10");
		  caps.setCapability("version", "16.16299");
	 
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	 
	    /**
	     * Goes to Sauce Lab's guinea-pig page and prints title
	     */
	 
	    driver.get("https://www.etsy.com/");
	    System.out.println("title of page is: " + driver.getTitle());
	 
	    driver.quit();
	  }
	}


