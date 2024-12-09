package flipKart_Selenium_Automation_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilterProductsWithOverlay {

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

        // Wait for and click Samsung filter
        WebElement samsungFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='SAMSUNG']")));
        samsungFilter.click();

        // Wait for product results to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='KzDlHZ']")));

        int countBetween60kAnd90k = 0;
        int countBlackWhite = 0;

        // Fetch product details and process them
        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));

        int count = Math.min(productNames.size(), productPrices.size());
        System.out.println("Number of products found: " + count);

        for (int i = 0; i < count; i++) {
            // Re-locate product elements inside the loop
            WebElement product = driver.findElements(By.xpath("//div[@class='KzDlHZ']")).get(i);
            WebElement priceElement = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']")).get(i);

            String name = product.getText();
            String priceText = priceElement.getText().replace("₹", "").replace(",", "");
            int price = Integer.parseInt(priceText);

            // Check for price between ₹60,000 and ₹90,000
            if (price > 60000 && price < 90000) {
                System.out.println(name + " - ₹" + price);
                countBetween60kAnd90k++;
            }

            // Check for black and white products
            if (name.toLowerCase().contains("black") || name.toLowerCase().contains("white")) {
                System.out.println(name + " - ₹" + price);
                countBlackWhite++;
            }
        }

        System.out.println("Number of products with price between ₹60,000 and ₹90,000: " + countBetween60kAnd90k);
        System.out.println("Number of products with color 'Black' or 'White': " + countBlackWhite);

        driver.quit();
    }
}

