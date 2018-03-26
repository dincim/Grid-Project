package com.seleniumgrid;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyPage {
	
	private WebDriver driver;
	
	//Never put assertion in class!
	
	@FindBy(xpath = "//img[@class='width-full display-block position-absolute ']")
	List<WebElement> searchResulrItems;
	
	public void goTo() {
		driver.get("https://www.etsy.com/");
	}
	
	public EtsyPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(name = "search_query") !!! when we use id or name attribute name then no need to write @FindBy
	//We can use underscore, $ sign in variable name
	//@FindBy(id = "search-query")
	public WebElement search_query;
	
	public void searchItem(String item) {
		search_query.clear();
		search_query.sendKeys(item,Keys.ENTER);
	}
	
	public boolean atEtsyPage() {
		
		return driver.getTitle().equals("Etsy.com | Shop for anything from creative people everywhere");
	}
	public boolean resultsAreDisplayed() {
		return searchResulrItems != null && searchResulrItems.size() > 0;
	}

}
