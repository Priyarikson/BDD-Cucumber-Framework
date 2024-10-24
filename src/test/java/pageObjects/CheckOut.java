package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {
	
	public WebDriver driver;
	public CheckOut(WebDriver driver) {
		this.driver = driver;
	}
By cartBag = By.cssSelector("[alt='Cart']");
By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
By promoBtn = By.cssSelector(".promoBtn");
By placeButton = By.xpath("//button[contains(text(),'Place Order')]");
By agree = By.cssSelector("input.chkAgree");
//dependencyInjection.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);

//dependencyInjection.productName = dependencyInjection.driver.findElement(By.cssSelector("h4.product-name")).getText()

public void checkOutItems(String name) {
	
	driver.findElement(cartBag).click();
	driver.findElement(checkOutButton).click();
}

public Boolean verifyPromoBtn() {
	return driver.findElement(promoBtn).isDisplayed();
	
	
}
public Boolean placeButton() {
	return driver.findElement(placeButton).isDisplayed();
	
	
}
public void placeOrder() {
	 driver.findElement(placeButton).click();
	
	
}
public void agree() {
	 driver.findElement(agree).click();
	
	
}

}
