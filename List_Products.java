package flipKart_Selenium_Automation_testing;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class List_Products {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        // Close login popup if present
        try {
            WebElement closePopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Login popup not displayed.");
        }

        // Search for "mobile"
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        searchBox.sendKeys("mobile");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

      
        // Initialize counters
        int countBelow60k = 0;
        int countBlackWhite = 0;

        // Get product count dynamically and iterate
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        int count = products.size();
        System.out.println("Number of products found: " + count);

        for (int i = 0; i < count; i++) {
            try {
                // Dynamically fetch product name and price for each iteration
                WebElement productNameElement = driver.findElements(By.xpath("//div[@class='KzDlHZ']")).get(i);
                WebElement productPriceElement = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']")).get(i);

                String name = productNameElement.getText();
                String priceText = productPriceElement.getText().replace("₹", "").replace(",", "");
                int price = Integer.parseInt(priceText);

                // Check for price less than ₹60,000
                if (price < 60000) {
                    System.out.println(name + " - ₹" + price);
                    countBelow60k++;
                }

                // Check if the product name contains "Black" or "White"
                if (name.toLowerCase().contains("black") || name.toLowerCase().contains("white")) {
                    System.out.println(name + " - ₹" + price);
                    countBlackWhite++;
                }
            } catch (Exception e) {
                System.out.println("Could not process product " + (i + 1));
            }
        }

        // Print counts
        System.out.println("Number of products with price less than ₹60,000: " + countBelow60k);
        System.out.println("Number of products with color 'Black' or 'White': " + countBlackWhite);

        // Close the browser
        driver.quit();
    }
}
