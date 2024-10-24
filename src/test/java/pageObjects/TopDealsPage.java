package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopDealsPage {
	
	public WebDriver driver;
	public TopDealsPage(WebDriver driver) {
		this.driver = driver;
	}



By search = By.xpath("//input[@type='search']");
By productName = By.cssSelector("tr td:nth-child(1)");



//dependencyInjection.driver.findElement(By.linkText("Top Deals")).click();

//dependencyInjection.driver.findElement(By.id("search-field")).sendKeys(shortName);

//dependencyInjection.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();



public void searchItem(String name) {
	driver.findElement(search).sendKeys(name);
	
}

public String getProductName() {
	
	return driver.findElement(productName).getText();
}
}
