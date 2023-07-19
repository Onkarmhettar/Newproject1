package BookMyShow;

public void bookMyShow() throws InterruptedException  {
	System.setProperty("webdriver.chrome.driver","H:\\Testing\\chromedriver.exe");
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
    WebDriver driver=new ChromeDriver(option);
    
//	ChromeOptions options = new ChromeOptions();
//	options.addArguments("--remote-allow-origins=*");
//	DesiredCapabilities cp = new DesiredCapabilities();
//	cp.setCapability(ChromeOptions.CAPABILITY, options);
//	options.merge(cp);
//	WebDriver driver = new ChromeDriver(options);
	System.out.println("browser is open");
    
    driver.manage().window().maximize();
    driver.get("https://in.bookmyshow.com/explore/home/");
    
  //Store the ID of the original window
    String originalWindow = driver.getWindowHandle();
   
    driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();
    driver.findElement(By.xpath("//div[text()='Sign in']")).click();
    driver.findElement(By.xpath("//div[text()='Continue with Email']")).click();
    
    
    driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("seleniumauto@yopmail.com");
    
    driver.findElement(By.xpath("//button[text()='Continue']")).click();
 
 // Opens a new tab and switches to new tab
    driver.switchTo().newWindow(WindowType.TAB);

    // Opens a new window and switches to new window
    driver.switchTo().newWindow(WindowType.WINDOW);
    
    
//    Actions action = new Actions(driver);
    driver.navigate().to("https://yopmail.com/");
    
   // driver.get("https://yopmail.com/");

   
    driver.findElement(By.xpath("//input[@title='Login']")).sendKeys(" seleniumauto@yopmail.com");
    driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
    Thread.sleep(2000);
    WebElement iframe=driver.findElement(By.xpath("//iframe[@id='ifmail']"));
    driver.switchTo().frame(iframe);//webelement of iframe
//frame    
    WebElement getOTP = driver.findElement(By.xpath("/html/body/main/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[4]/td/table/tbody/tr[2]/td/table/tbody/tr/td"));
   String otp = getOTP.getText();
    System.out.println(otp);
    Thread.sleep(2000);
    
  //Close the tab or window
    driver.close();
    System.out.println("Close the browser");

    //Switch back to the old tab or window
    driver.switchTo().window(originalWindow);
    System.out.println("switch to old window");
    
    driver.findElement(By.xpath("//div[@class='sc-gZMcBi sc-jzgbtB grnTcO']")).sendKeys(otp);
    System.out.println("enter the OTP");
    
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//button[@class='sc-eLExRp ctptQL']")).click();
    
}
}






driver.manage().window().maximize();
driver.get("https://in.bookmyshow.com/explore/home/");

//Store the ID of the original window
String originalWindow = driver.getWindowHandle();

driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();
driver.findElement(By.xpath("//div[text()='Sign in']")).click();
driver.findElement(By.xpath("//div[text()='Continue with Email']")).click();


driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("seleniumauto@yopmail.com");

driver.findElement(By.xpath("//button[text()='Continue']")).click();

// Opens a new tab and switches to new tab
driver.switchTo().newWindow(WindowType.TAB);

// Opens a new window and switches to new window
driver.switchTo().newWindow(WindowType.WINDOW);


//    Actions action = new Actions(driver);
driver.navigate().to("https://yopmail.com/");

// driver.get("https://yopmail.com/");


driver.findElement(By.xpath("//input[@title='Login']")).sendKeys(" seleniumauto@yopmail.com");
driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
Thread.sleep(2000);
WebElement iframe=driver.findElement(By.xpath("//iframe[@id='ifmail']"));
driver.switchTo().frame(iframe);//webelement of iframe
//frame    
WebElement getOTP = driver.findElement(By.xpath("/html/body/main/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[4]/td/table/tbody/tr[2]/td/table/tbody/tr/td"));
String otp = getOTP.getText();
	
System.out.println(otp);
Thread.sleep(2000);

//Close the tab or window
driver.close();
System.out.println("Close the browser");

//Switch back to the old tab or window
driver.switchTo().window(originalWindow);
System.out.println("switch to old window");

driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/form/div[1]/div[3]/input[1]")).sendKeys(otp);

System.out.println("enter the OTP");

Thread.sleep(2000);

driver.findElement(By.xpath("//button[@class='sc-eLExRp ctptQL']")).click();