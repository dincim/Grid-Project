package com.seleniumgrid;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
private WebDriver driver;
	
	@FindBy(xpath = "//img[@class='s-access-image cfMarker']")
	List<WebElement> searchResulrItems;
	
	public void goTo() {
		driver.get("https://www.amazon.com/");
	}
	
	public AmazonPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(name = "search_query") !!! when we use id or name attribute name then no need to write @FindBy
	//We can use underscore, $ sign in variable name
	public WebElement twotabsearchtextbox;
	
	public void searchItem(String item) {
		twotabsearchtextbox.clear();
		twotabsearchtextbox.sendKeys(item,Keys.ENTER);
	}
	
	public boolean atAmazonPage() {
		
		return driver.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}
	public boolean resultsAreDisplayed() {
		return searchResulrItems != null && searchResulrItems.size() > 0;
	}
}
