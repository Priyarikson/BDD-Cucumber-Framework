package userStepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.TopDealsPage;
import utils.Dependency;

public class TopDealsPageSteps {


	String topDealsProduct;
	Dependency dependencyInjection;
	
	
	public TopDealsPageSteps(Dependency dependencyInjection) {
		this.dependencyInjection = dependencyInjection;
	}

	@When("User navigate to Top deals page")
	public void user_navigate_to_top_deals_page() {
		HomePage homePage = new HomePage(dependencyInjection.driver);
				homePage.navigate();
		Set<String> windows=dependencyInjection.driver.getWindowHandles();
		Iterator<String> windowSet=windows.iterator();
		String parentWindow = windowSet.next();
		String childWindow =windowSet.next();
		dependencyInjection.driver.switchTo().window(childWindow);


	}
	@When("^User enter (.+) on Top deals page search field and extract name of the product$")
	public void user_enter_on_top_deals_page_search_field_and_extract_name_of_the_product(String shortName) throws Exception {

		TopDealsPage topDealsPage = new TopDealsPage(dependencyInjection.driver);
		topDealsPage.searchItem(shortName);
		Thread.sleep(2000);
		topDealsProduct = topDealsPage.getProductName();

	}




	@Then("User validate the name of the product")
	public void user_validate_the_name_of_the_product() {

		Assert.assertEquals(topDealsProduct, dependencyInjection.productName);

	}}
