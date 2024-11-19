package flipKart_Selenium_Automation_testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search_for_a_Product {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		WebElement SearchBar = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
		SearchBar.sendKeys("Laptops");
		SearchBar.submit();		
		
		// Wait for search results to load
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_7dPnhA']")));
		//WebElement SearchBtn = driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']//*[name()='svg']"));
		//SearchBtn.click();
        
     // Verify that product results are displayed
        List<WebElement> productList = driver.findElements(By.className("tUxRFH"));
        if (productList.size() > 0) {
            System.out.println("Product results are displayed.");
            
            // Extract and print the names and prices of the first 5 products listed
            int count = 0;
            for (WebElement product : productList) {
                if (count >= 5) break; // Limit to 5 products
                try {
                    // Extract product name
                    WebElement productName = product.findElement(By.cssSelector("div.KzDlHZ")); //product name
                    WebElement productPrice = product.findElement(By.cssSelector("div.Nx9bqj._4b5DiR")); // Product price
                    
                    // Print product name and price
                    System.out.println("Product " + (count + 1) + ": " + productName.getText() + " - Price: " + productPrice.getText());
                    count++;
                    
                } catch (Exception e) {
                    // Skip products without proper details
                	System.out.println("Could not extract details for a product, skipping...");
                }
            }
        } else {
            System.out.println("No product results found.");
        }


        // Close the browser
        driver.quit();
	}
}
