package org.Maven.Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropExample {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to GeckoDriver
    	  System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver-v0.34.0-win64.exe");


        // Initialize FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the jQueryUI website
        driver.get("https://jqueryui.com/droppable/");

        // Switch to iframe
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // Perform drag-and-drop action
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();

        // Retrieve the background color of the target element
        String targetElementColor = targetElement.getCssValue("background-color");

        if (targetElementColor.equals("rgba(255, 250, 144, 1)")) {
            System.out.println("Drag and drop operation successful. Target element color changed.");
        } else {
            System.out.println("Drag and drop operation failed. Target element color not changed.");
        }

        // Verify text change of the target element to "Dropped!"
        wait.until(ExpectedConditions.textToBePresentInElement(targetElement, "Dropped!"));
        String targetElementText = targetElement.getText();
        if (targetElementText.equals("Dropped!")) {
            System.out.println("Text of target element changed to 'Dropped!' after drop.");
        } else {
            System.out.println("Text of target element not changed to 'Dropped!' after drop.");
        }

        // Close the browser
        driver.close();
    }
}
