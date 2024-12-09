package flipKart_Selenium_Automation_testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyOTP_Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		WebElement LoginBtn = driver.findElement(By.cssSelector("a[title='Login'] span"));
		LoginBtn.click();
		
		WebElement LoginNumber = driver.findElement(By.cssSelector("input[class='r4vIwl BV+Dqf']"));
		LoginNumber.sendKeys("9960446738");
		
		WebElement RequestOtpBtn = driver.findElement(By.cssSelector(".QqFHMw.twnTnD._7Pd1Fp"));
		RequestOtpBtn.click();
		
		WebElement VerifyBtn = driver.findElement(By.cssSelector("button[class='QqFHMw llMuju M5XAsp']"));
		VerifyBtn.click();
		
		WebElement SearchBox = driver.findElement(By.name("q"));
		SearchBox.sendKeys("mobile");
		SearchBox.submit();
		
		
	}

}
