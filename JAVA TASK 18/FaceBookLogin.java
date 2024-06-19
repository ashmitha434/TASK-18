package org.Maven.Automation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FaceBookLogin {
	public static void main(String[] args) {
		
		// Set the path to Firefoxdriver
	    System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver-v0.34.0-win64.exe");

	        // Initialize FirefoxDriver
	        WebDriver driver = new FirefoxDriver();
	     
	        // Maximize to browser window
	        driver.manage().window().maximize();
	        
	        // Navigate to Facebook website
	        driver.get("https://www.facebook.com/");
	        
	        // Verify redirection to FaceBook homepage
	        String currentUrl = driver.getCurrentUrl();
	        if (!currentUrl.equals("https://www.facebook.com/")) {
	        	System.out.println("Redirection to Facebook homepage failed.");
	        	driver.quit();
	        	return;
	        }
	        
	        // Click on "Create new account" Button
	        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
	        
	        // Fill Firstname on Input Field
	       // driver.findElement(By.name("firstname")).sendKeys("Test");
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	       
	       // Fill Lastname on Input Field
	        driver.findElement(By.name("lastname")).sendKeys("User");
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	        // Enter your email on input field
	        driver.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	        // Re-enter email on input field
	       driver.findElement(By.name("reg_email_confirmation__")).sendKeys("testuser@test.com");
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	       
	       // Enter Password on Input field
	        driver.findElement(By.name("reg_passwd__")).sendKeys("#123&785");
	  
	        // Select Day/Month/Year
	        Select selectDay = new Select(driver.findElement(By.id("day")));
	        selectDay.selectByVisibleText("11");
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	        Select selectMonth = new Select(driver.findElement(By.id("month")));
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        selectMonth.selectByVisibleText("May");
	        
	        Select selectYear = new Select(driver.findElement(By.id("year")));
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        selectYear.selectByVisibleText("1985");
	        
	        // Select Male or Female
	        driver.findElement(By.xpath("//input[@value='2']")).click();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	        // Submit the From By Click create account
	        driver.findElement(By.name("websubmit")).click();
	        
	        System.out.println("Your new FaceBook ID is Created");       

	}

}
