package userStepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckOut;
import pageObjects.HomePage;
import utils.Dependency;

public class CheckOutPageSteps {


	String topDealsProduct;
	Dependency dependencyInjection;
	HomePage homePage;
	CheckOut checkOut;

	public  CheckOutPageSteps(Dependency dependencyInjection) {

		this.dependencyInjection = dependencyInjection;
		 checkOut = new CheckOut(dependencyInjection.driver);
	}


	

	@When("User checkout the order")
	public void user_checkout_the_order() throws Exception {
		
		checkOut.checkOutItems(topDealsProduct);
		Thread.sleep(5000);
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
	    Assert.assertTrue(checkOut.verifyPromoBtn());
	    Assert.assertTrue(checkOut.placeButton());
	    
	}
	
	@Then("User place the order")
	public void User_place_the_order() {
		checkOut.placeOrder();
	    
	}
	


}
