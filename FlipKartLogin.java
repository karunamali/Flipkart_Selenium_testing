package flipKart_Selenium_Automation_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartLogin {

    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the Flipkart website
            driver.get("https://www.flipkart.com/");

            // Maximize the browser window
            driver.manage().window().maximize();
            
            driver.findElement(By.cssSelector("a[title='Login'] span")).click();

            // Locate and interact with the login pop-up
            WebElement mobileNumberField = driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']"));
           // mobileNumberField.sendKeys("9960446738"); // you are not regesitered.please register!!!
            mobileNumberField.sendKeys("9028430080");//Otp send successfully....
            // Click on 'Request OTP' button
            WebElement requestOtpButton = driver.findElement(By.xpath("//button[normalize-space()='Request OTP']"));
            requestOtpButton.click();

            // Validate successful interaction
            System.out.println("OTP request initiated successfully.");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
