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

public class SearchByCategoryTest {

	WebDriver driver;
	
	@Given("User is on the TJMaxx home page for categorysearch")
	public void the_user_goes_to_the_tj_maxx_home_page_for_categorysearch() {
		System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver (2).exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
	    driver.get("https://tjmaxx.tjx.com/store/index.jsp");
	}

	@When("User navigates to the women's category")
	public void the_user_navigates_to_the_women_s_category() {
		WebDriverWait wait=new WebDriverWait(driver, 20);  //20 sec
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usmm-tl-cat260062"))); 
		driver.findElement(By.id("usmm-tl-cat260062")).click();
        driver.get("https://tjmaxx.tjx.com/store/shop/women/_/N-2107733895?tn=2");
	}

	@When("User navigates to the women's perfume section")
	public void the_user_navigates_to_the_women_s_perfume_section() {
        driver.get("https://tjmaxx.tjx.com/store/shop/womens-perfume/_/N-944410246?ln=5:2");
	}

	@When("User selects the perfume item")
	public void the_user_selects_the_perfume_item() {
		WebDriverWait wait1=new WebDriverWait(driver, 20);  //20 sec
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='product-brand-1000891758']/span"))); 
		driver.findElement(By.xpath("//span[@id='product-brand-1000891758']/span")).click();
	    driver.findElement(By.xpath("//img[@alt='Made In France 6.7oz Aqua Allegoria Pera Granita Pear Eau De Toilette']")).click();
	}

	@When("User adds the item to the cart for categorysearch")
	public void the_user_adds_the_item_to_the_cart_for_categorysearch() throws IOException {
		WebDriverWait wait2=new WebDriverWait(driver, 20);  //20 sec
	    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("addItemToOrder"))); 
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,300)", "");

	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File("./searchbycategoryimg1.png"));
		
        driver.findElement(By.id("addItemToOrder")).click();
        
    }

	@Then("item should be in the cart")
	public void the_item_should_be_in_the_cart() {
		 driver.quit();
	}

}
