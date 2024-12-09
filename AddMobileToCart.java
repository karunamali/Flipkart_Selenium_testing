package flipKart_Selenium_Automation_testing;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddMobileToCart {

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

        // Select product
        WebElement product = driver.findElement(By.xpath("//div[@class='KzDlHZ']"));
        product.click();
        
        
       
        // Switch to the newly opened tab
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Click on the desired element
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement svgElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='_1ri+WN'] li:nth-child(1),button[class='QqFHMw vslbG+ In9uk2']")));
            svgElement.click();
            System.out.println("Element clicked successfully!"
            		+ "Mobile added to cart");
        } catch (Exception e) {
            System.out.println("Failed to click the element: " + e.getMessage());
        }
        
        driver.navigate().to("https://www.flipkart.com/tecno-pova-6-neo-aurora-cloud-256-gb/p/itmc060ba768860b?pid=MOBH3WQG6PME22SD&lid=LSTMOBH3WQG6PME22SDFJN4EC&marketplace=FLIPKART&q=mobile&store=tyy%2F4io&srno=s_1_1&otracker=search&otracker1=search&fm=search-autosuggest&iid=en_eh9Lrjpi4J0BZ8EPZaEQ712K5FmVckte-DxQYxlzzYrTHWIUHAKaR6TSrk06Cj1YuSd9dYjnDcn-ma8R6kfyxPUFjCTyOHoHZs-Z5_PS_w0%3D&ppt=sp&ppn=sp&ssid=g4hrodvaio0000001732729096351&qH=532c28d5412dd75b");
        
        
        String originalWindow1 = driver.getWindowHandle();
        Set<String> allWindows1 = driver.getWindowHandles();
        for (String handle : allWindows1) {
            if (!handle.equals(originalWindow1)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        WebElement checkcart = driver.findElement(By.linkText("Cart"));
        checkcart.click();
        
      
        // Quit the browser
        driver.quit();
    }
}
