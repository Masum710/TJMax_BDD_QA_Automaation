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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreLocationTest {

	WebDriver driver;
	
	@Given("User is on the TJMaxx home page for store location")
	public void the_user_goes_to_the_tj_maxx_home_page_for_store_location() {
		//System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver (2).exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
	    driver.get("https://tjmaxx.tjx.com/store/index.jsp");
	}

	@When("User clicks on the store locator")
	public void the_user_clicks_on_the_store_locator() {
	    driver.findElement(By.linkText("Stores")).click();
        driver.get("https://tjmaxx.tjx.com/store/stores/storeLocator.jsp");
	}

	@When("User enters the zip code")
	public void the_user_enters_the_zip_code() throws Exception {
		WebDriverWait wait1=new WebDriverWait(driver, 20);  //20 sec
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("store-location-zip")));
		driver.findElement(By.id("store-location-zip")).click();
	    driver.findElement(By.id("store-location-zip")).clear();
	    
	    int zipCode = FileUtil.getData1().getZip();
		String zipCodeString = Integer.toString(zipCode);
		
	    driver.findElement(By.id("store-location-zip")).sendKeys(zipCodeString);
	}

	@When("User enters the city")
	public void the_user_enters_the_city() {
		driver.findElement(By.id("store-location-city")).click();
	    driver.findElement(By.id("store-location-city")).clear();
	    try {
			driver.findElement(By.id("store-location-city")).sendKeys(FileUtil.getData1().getCity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User selects the state")
	public void the_user_selects_the_state() {
		driver.findElement(By.id("store-location-state")).click();
	    new Select(driver.findElement(By.id("store-location-state"))).selectByVisibleText("Illinois");
	}

	@When("User clicks on the find store button")
	public void the_user_clicks_on_the_find_store_button() throws IOException {	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File("./storelocationimg.png"));
		WebDriverWait wait1=new WebDriverWait(driver, 20);  //20 sec
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
	    driver.findElement(By.name("submit")).click();

	}

	@Then("User should see the store locations")
	public void the_user_should_see_the_store_locations() throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,500)", "");
	     Thread.sleep(2000);
	     driver.close();
	}
	
	 @When("User clicks on the stores link")
	 public void the_User_clicks_on_the_stores_link() {
	     driver.findElement(By.linkText("Stores")).click();
	     driver.get("https://tjmaxx.tjx.com/store/stores/storeLocator.jsp");
	 }
	 
	 @When("User enters the city again")
	 public void the_User_enters_the_city_milford() {
		 driver.findElement(By.id("store-location-city")).click();
		 driver.findElement(By.id("store-location-city")).clear();
		 try {
			driver.findElement(By.id("store-location-city")).sendKeys(FileUtil.getData1().getCity1());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	 @When("User selects the state again")
	 public void the_User_selects_the_state_Arizona() {
		 driver.findElement(By.id("store-location-state")).click();
		 new Select(driver.findElement(By.id("store-location-state"))).selectByVisibleText("Arizona");
	 }
	 
	 @When("User clicks on the find a store button")
	 public void the_User_clicks_on_the_find_a_store_button() throws IOException, InterruptedException {

		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		 FileUtils.copyFile(scrFile, new File("./storelocationimg1.png"));
		 
		 WebDriverWait wait2=new WebDriverWait(driver, 20);  //20 sec
		 wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
		 
		 driver.findElement(By.name("submit")).click(); 
		 
	 }
	 
	@Then("User should see an error message or no store found")
	public void the_user_should_see_an_error_message_or_no_store_found() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)", "");
	    Thread.sleep(3000);
	    driver.quit();
	}


}
