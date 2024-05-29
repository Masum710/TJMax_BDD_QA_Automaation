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

public class DeleteItemTest {

	WebDriver driver;
	
	@Given("user is on the TJ Maxx homepage for delete item")
	public void user_is_on_the_tj_maxx_homepage() {
		//System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver (2).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
	    driver.get("https://tjmaxx.tjx.com/store/index.jsp");
	}

	@When("user searches for lamp")
	public void user_searches_for_lamp() {
		WebDriverWait wait=new WebDriverWait(driver, 60);  //60 sec
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-text-input")));
	    driver.findElement(By.id("search-text-input")).click();
	    try {
			driver.findElement(By.id("search-text-input")).sendKeys(FileUtil.getData3().getItem());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("user clicks on the search button")
	public void user_clicks_on_the_search_button() {
		driver.findElement(By.id("search-submit-button")).click();
	      
	}

	@When("user scrolls down by pixels")
	public void user_scrolls_down_by_pixels() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,400)", "");
	}

	@When("user selects the table lamp")
	public void user_selects_the_table_lamp() {
		driver.findElement(By.xpath("//img[@alt='Scalloped Table Lamp']")).click();
	}

	@When("user adds the item to the order")
	public void user_adds_the_item_to_the_order() {
		WebDriverWait wait1=new WebDriverWait(driver, 60);  //60 sec
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("addItemToOrder")));
	    driver.findElement(By.id("addItemToOrder")).click();
	}

	@Then("user should see the ViewBag link")
	public void user_should_see_the_ViewBag_link() {
		WebDriverWait wait2=new WebDriverWait(driver, 60);  //20 sec
	    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("VIEW BAG")));
	}

	@When("user clicks on the ViewBag link")
	public void user_clicks_on_the_ViewBag_link() {
		driver.findElement(By.linkText("VIEW BAG")).click();
	}
	
	@When("user clicks on the link to remove item")
	public void user_clicks_on_the_links_to_remove_item() throws IOException {
		
		WebDriverWait wait3=new WebDriverWait(driver, 60);  //20 sec
	    wait3.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Remove")));
	    
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File("./deleteitemimg1.png"));
		
	    driver.findElement(By.linkText("Remove")).click();
	}

	@Then("item should be removed from the shopping bag")
	public void item_should_be_removed_from_the_shopping_bag() {
	    driver.close();
	}


	
}
