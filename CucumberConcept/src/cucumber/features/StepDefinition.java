package cucumber.features;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition {
	
	WebDriver driver = null;

	
	@Given("^I am on halfEbay website$")
	public void shouldNavigateToHalEbaySite () throws Throwable {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.navigate().to("https://scgi.half.ebay.com/ws/ebayISAPI.dll?RegisterEnterInfo&usage=2943&ru");
	}
		

	@When("^I complete registration$")
	public void shouldBeOnRegitrationPage() throws Throwable {
		
		driver.findElement(By.name("firstname")).sendKeys("bzay");
		
		driver.findElement(By.name("lastname")).sendKeys("bzee");
		
		driver.findElement(By.name("address1")).sendKeys("12 Highstreet");
		
		driver.findElement(By.name("address2")).sendKeys("Downtown");
		
		driver.findElement(By.name("city")).sendKeys("Sunnyvale");
		
		Select select = new Select(driver.findElement(By.name("state")));
		select.selectByVisibleText("California");
		
		driver.findElement(By.name("dayphone1")).sendKeys("001");
		
		driver.findElement(By.name("dayphone2")).sendKeys("888");
		
		driver.findElement(By.name("dayphone3")).sendKeys("4321");
				
		driver.findElement(By.name("zip")).sendKeys("94085");
		
		driver.findElement(By.name("email")).sendKeys("bzaybee@yahoo.com");
		
		driver.findElement(By.name("retype_email")).sendKeys("bzaybee@yahoo.com");
		
		driver.findElement(By.name("userid")).sendKeys("bzeays2019");
		
		driver.findElement(By.id("PASSWORD")).sendKeys("H0ddesdon");
		
		driver.findElement(By.id("rpass")).sendKeys("H0ddesdon");
		
		Select select1 = new Select(driver.findElement(By.id("SECRET_QUESTION")));
		select1.selectByVisibleText("What is your pet's name?");
		
		driver.findElement(By.id("SECRET_ANSWER")).sendKeys("jenny");
		
		Select select2 = new Select(driver.findElement(By.name("birthdate2")));
		select2.selectByVisibleText("July");
		
		Select select3 = new Select(driver.findElement(By.name("birthdate1")));
		select3.selectByVisibleText("20");
		
		Select DOB3 = new Select(driver.findElement(By.name("birthdate3")));
		DOB3.selectByVisibleText("1978");
		
		driver.findElement(By.id("acceptq1")).click();
		
		driver.findElement(By.id("continue")).click();
	}

	@Then("^I check that registration is successful$")
	public void shouldConfirmRegistration() throws Throwable {
		Assert.assertTrue("Not onEbay HalfEbay Registration Page", driver.getTitle().contentEquals("Half.com: Registration Confirmation"));
		
		driver.close();
	}

}
