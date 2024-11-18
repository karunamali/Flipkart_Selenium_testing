package flipKart_Selenium_Automation_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FlipkartSignup {
    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Flipkart
        driver.get("https://www.flipkart.com/");

        // Maximize the window
        driver.manage().window().maximize();
        try {
        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
        Thread.sleep(2000);
        
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).perform();
        
        // Click on the "Sign Up" link
        WebElement signUpLink = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/a[1]/span[2]"));
        signUpLink.click();
        System.out.println("Navigated to sign up page successfully");
        
        }catch(Exception e) {
        	System.out.println("Error in locating or interacting with elements: " + e.getMessage());	
        }
        
        
       // driver.findElement(By.cssSelector("input[class='r4vIwl BV+Dqf']")).sendKeys("9028430080"); //"you are already registered please login"
        driver.findElement(By.cssSelector("input[class='r4vIwl BV+Dqf']")).sendKeys("9960446738"); //"otp sent to mobile enter otp"
        
        driver.findElement(By.cssSelector("button[class='QqFHMw twnTnD _7Pd1Fp']")).click();
        
        
        Thread.sleep(5000);
        
        
        // Close the browser
        driver.quit();
    }
}
