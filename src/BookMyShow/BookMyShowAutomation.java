package BookMyShow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BookMyShowAutomation {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver","H:\\Testing\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(option);
        driver.manage().window().maximize();
        

        // Open BookMyShow website
        driver.get("https://in.bookmyshow.com/explore/home/"); 

        // Select Bangalore as the city
        
        driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();
        driver.findElement(By.xpath("//div[text()='Sign in']")).click();
        driver.findElement(By.xpath("//div[text()='Continue with Email']")).click();
        driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("seleniumauto@yopmail.com");
        //     Thread.sleep(2000);
             
             driver.findElement(By.xpath("//button[text()='Continue']")).click();
        // Open a new tab and navigate to yopmail.com
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        driver.get("http://www.yopmail.com");

        // Enter user email id
        WebElement emailInputYopMail = driver.findElement(By.xpath("//input[@title='Login']"));
        emailInputYopMail.sendKeys("seleniumauto@yopmail.com"); // Replace with your email
        emailInputYopMail.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
       // driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
        // Switch back to the previous tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        // Wait for the OTP enter page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement otpInput = driver.findElement(By.id("otp-input")); // Replace with the appropriate locator

        // Get the OTP code from the yopmail.com tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        WebElement otpCode = driver.findElement(By.cssSelector(".fz6 > span"));

        // Switch back to the OTP enter page and enter the OTP
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        otpInput.sendKeys(otpCode.getText());

        // Close the browser
        driver.quit();
    }
}
