package userStepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import utils.Dependency;

public class HomePageSteps {


	String topDealsProduct;
	Dependency dependencyInjection;
	HomePage homePage;

	public  HomePageSteps(Dependency dependencyInjection) {

		this.dependencyInjection = dependencyInjection;
	}


	@Given("User navigate to Green Cart Landing Page")
	public void user_navigate_to_green_cart_landing_page() throws Exception {

		WebDriverManager.chromedriver().setup();
		dependencyInjection.driver = new ChromeDriver();
		dependencyInjection.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(5000);
	}
	@When("^User enter (.+) on search field$")
	public void user_enter_on_search_field(String shortName) throws Exception {

		//xpath - By.xpath("//tagname[@attribute='value']")
		//dependencyInjection.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		 homePage = new HomePage(dependencyInjection.driver);
		 homePage.searchItem(shortName);
		Thread.sleep(5000);

	}
	@When("Extract actual name of the product")
	public void extract_actual_name_of_the_product() {

		//cssSelector - By.cssSelector("tagName.className")
		dependencyInjection.productName = homePage.getProductName()
				.split("-")[0].trim();
		System.out.println(dependencyInjection.productName);
	}
	
	@When("^Add (.+) Items of the selected product to cart$")
	public void add_items_of_the_selected_product_to_cart(String quantity) {
		homePage.incrementQuantity(Integer.parseInt(quantity));
	}



}
