package StepDefinitions;

import PageObjects.AutomationPracticeObj;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPracticeSteps {
    public WebDriver driver;

    AutomationPracticeObj apObj;
    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        apObj = new AutomationPracticeObj(driver);
    }

    @Given("Opens URL {string}")
    public void opens_url(String url) {
        driver.navigate().to(url);
    }
    @Given("clicks on the Dresses Menu")
    public void clicks_on_the_dresses_menu() throws InterruptedException {
        apObj.clickDressButton();
    }
    @Then("User selects the highest priced item")
    public void user_selects_the_highest_priced_item() {
        apObj.selectHighestPriceProduct();
    }

    @Then("Verify that product is added to the cart and close the window")
    public void verify_that_product_is_added_to_the_cart_and_close_the_window() throws InterruptedException {
        apObj.verifyProductAddedToTheCart();
        driver.close();
        driver.quit();
    }
}
