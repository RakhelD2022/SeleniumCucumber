package PageObjects;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class AutomationPracticeObj {
    public WebDriver driver;
    String highestPrice;
    int index=1;

    public AutomationPracticeObj(WebDriver rdriver)
    {
        driver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement lnkDress;

    @FindBy(xpath = "//span[@class=\"price product-price\"]")
    private List<WebElement> priceElements;

    @FindBy(xpath = "//a[@title=\"Add to cart\"]")
    private WebElement btnAddToCart;

    public void clickDressButton() throws InterruptedException {
        lnkDress.click();
        Thread.sleep(10000);
        System.out.println("Test");
        Assert.assertEquals(driver.getTitle(),"Dresses - My Store");
    }

    public void selectHighestPriceProduct()
    {
        Map<WebElement,Integer> map = new HashMap<WebElement, Integer>();

        //Iterate all the price values in Find Elements list
        for(int i=0;i<priceElements.size();i++)
        {
            if((priceElements.get(i).getText()!="")) //Check for Null values in the elements
            {
                //Put all the prices in the hashmap
                map.put(priceElements.get(i),Integer.parseInt(priceElements.get(i).getText().replace("$","").replace(".","")));
            }
        }

        //Sort all the values
        List<Map.Entry<WebElement,Integer>> le = new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
        le.sort(Map.Entry.comparingByValue());

        //Click on Add to Cart Link
        Actions action = new Actions(driver);
        action.moveToElement(le.get(le.size()-1).getKey()).click().build().perform();
    }

    public void verifyProductAddedToTheCart() throws InterruptedException {
        String expectedMsg="Product successfully added";
        driver.getPageSource().contains(expectedMsg);
        Assert.assertTrue(driver.getPageSource().contains(expectedMsg)); //Verify successful message displays
        Thread.sleep(10000); //Wait for 10 seconds
    }

}
