package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchItemTest {

	WebDriver driver;
	
	@Given("User is on the TJMaxx home page for searchitem")
	public void the_user_goes_to_the_tj_maxx_home_page_for_searchitem() {
		//System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver (2).exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tjmaxx.tjx.com/store/index.jsp");
	}

	@When("User searches for an item")
	public void the_user_searches_for_an_item() {
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        try {
			driver.findElement(By.id("search-text-input")).sendKeys(FileUtil.getData2().getItem());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User clicks on the search button")
	public void the_user_clicks_on_the_search_button() {
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://tjmaxx.tjx.com/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=plants&qfh_sch=Search");
	}

	@When("User selects the item from the search results")
	public void the_user_selects_the_item_from_the_search_results() {
		WebDriverWait wait=new WebDriverWait(driver, 20);  //20 sec
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='24in Split Leaf Monstera Floor Plant In Grey Pot']"))); 
		driver.findElement(By.xpath("//img[@alt='24in Split Leaf Monstera Floor Plant In Grey Pot']")).click();
	    driver.get("https://tjmaxx.tjx.com/store/jump/product/24in-Split-Leaf-Monstera-Floor-Plant-In-Grey-Pot/1000790857?colorId=NS2614502&pos=1:10&Ntt=plants");
		
	}

	@When("User adds the item to the cart")
	public void the_user_adds_the_item_to_the_cart() throws IOException {
		 WebDriverWait wait1=new WebDriverWait(driver, 20);  //20 sec
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("addItemToOrder")));
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,300)", "");
		 
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		 FileUtils.copyFile(scrFile, new File("./image.png"));

         driver.findElement(By.id("addItemToOrder")).click();

	}

	@Then("item should be added to the cart successfully")
	public void the_item_should_be_added_to_the_cart_successfully(){
        driver.quit();
	}

}
