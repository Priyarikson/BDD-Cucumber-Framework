package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
By search = By.xpath("//input[@type='search']");
By productName = By.cssSelector("h4.product-name");
By navigate = By.linkText("Top Deals");
By increment = By.cssSelector("a.increment");
By addToCart = By.cssSelector(".product-action button");

public void searchItem(String name) {
	driver.findElement(search).sendKeys(name);
	
}

public String getProductName() {
	
	return driver.findElement(productName).getText();
}
public void navigate() {
	
	driver.findElement(navigate).click();
	
}
public void incrementQuantity(int quantity) {
	
	int i = quantity - 1;
	while(i>0) {
		driver.findElement(increment).click();
		i--;
	}
	
}
public void addToCart() {
	driver.findElement(addToCart).click();
}

}
