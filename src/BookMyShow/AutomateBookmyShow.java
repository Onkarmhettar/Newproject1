package BookMyShow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateBookmyShow {
	
	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver","H:\\Testing\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://in.bookmyshow.com/explore/home/");
        
      //Store the ID of the original window
       
        driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();
        driver.findElement(By.xpath("//div[text()='Sign in']")).click();
        driver.findElement(By.xpath("//div[text()='Continue with Email']")).click();
        String originalWindow = driver.getWindowHandle();
        
        
        driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("seleniumauto@yopmail.com");
   //     Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
       
        
       // Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Opens a new window and switches to new window
       // driver.switchTo().newWindow(WindowType.WINDOW);
        
        // navigate to otp generation page
        driver.navigate().to("https://yopmail.com/");
     
     
       //locate the elements on yopmailpage
        driver.findElement(By.xpath("//input[@title='Login']")).sendKeys(" seleniumauto@yopmail.com");
	    driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
	    Thread.sleep(2000);
	    WebElement iframe=driver.findElement(By.xpath("//iframe[@id='ifmail']"));
        driver.switchTo().frame(iframe);//webelement of iframe
  //frame   
        Thread.sleep(1000);
        WebElement getOTP = driver.findElement(By.xpath("/html/body/main/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[4]/td/table/tbody/tr[2]/td/table/tbody/tr/td"));
        String otp = getOTP.getText();
        otp.toCharArray();
    
         System.out.println(otp);
       //  Thread.sleep(2000);
	    
	    //Close the tab or window
	   // driver.close();
	   // System.out.println("Close the browser");

	    //Switch back to the old tab or window
	    driver.switchTo().window(originalWindow);
	    System.out.println("switch to old window");
	  
	    driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/form/div[1]/div[3]/input[1]")).sendKeys(otp);
	    
	  //  Thread.sleep(1000);
	   
	    driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div/div[2]/form/div[2]/button")).click();
	  
	    
	  
	}
}

/*   ((JavascriptExecutor)driver).executeScript("window.open()");
ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(tabs.get(1));
driver.get("https://yopmail.com/");*/
//    Actions action = new Actions(driver);


// driver.get("https://yopmail.com/");
//char one= otp.charAt(0);
//int two=otp.charAt(1);
//int three=otp.charAt(2);
//int four=otp.charAt(3);
//int five=otp.charAt(4);
//int six=otp.charAt(5);

//char[] characters = otp.toCharArray();
//for (char c : characters) {
//  System.out.print(c);
//}  


//((JavascriptExecutor)driver).executeScript("window.open()");
//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//driver.switchTo().window(tabs.get(1));
////  driver.get("https://yopmail.com/");