package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
     // for edge browser
    //WebDriver driver;
    WebDriverWait wait;
    @SuppressWarnings("deprecation")
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // for edge browser
        // WebDriverManager.edgedriver().setup();
        // driver = new EdgeDriver();

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01 Verifying Make My Trip homepage URL contains makemytrip.");
        driver.get("https://www.makemytrip.com/");
        String url = driver.getCurrentUrl();
        if(url.contains("makemytrip")){
            System.out.println("The URL of the Make My Trip homepage contains makemytrip");
        }else{
            System.out.println("The URL of the Make My Trip homepage doesnot contains makemytrip");
        }
        System.out.println("end Test case: testCase01");
    }








    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02 Get flight details for a specific route and date");
        driver.get("https://www.makemytrip.com/");
        //Thread.sleep(2000);
        // WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='notification-frame-3176854a']"));
        // driver.switchTo().frame(frameElement);
        // WebElement closePopUp = driver.findElement(By.xpath("//a[contains(@id,'webklipper-publisher-')]"));
        // closePopUp.click();
        // driver.switchTo().parentFrame();

        WebElement departureTextBox = driver.findElement(By.xpath("//input[@id='fromCity']"));
        departureTextBox.sendKeys("blr");
        Thread.sleep(2000);
        WebElement departureCity = driver.findElement(By.xpath("(//p[text()='Bengaluru, India'])[1]"));
        departureCity.click();

        WebElement arrivalTextBox = driver.findElement(By.xpath("//input[@id='toCity']"));
        arrivalTextBox.sendKeys("del");
        Thread.sleep(2000);
        WebElement arivalCity = driver.findElement(By.xpath("//p[text()='New Delhi, India']"));
        arivalCity.click();

        driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Mon Apr 29 2024']")).click();

        Thread.sleep(1000);
        WebElement SearchButton = driver.findElement(By.xpath("//a[text()='Search']"));
        SearchButton.click();

        Thread.sleep(9000);

        WebElement priceLocator = driver.findElement(By.xpath("(//div[@class= 'listingCard  appendBottom5'])[1]//div[contains(@class,'clusterViewPrice')]"));
    
        // wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // wait.until(ExpectedConditions.elementToBeClickable(priceLocator));

        String departure = driver.findElement(By.xpath("(//div[@class= 'listingCard  appendBottom5'])[1]//div[contains(@class,'timeInfoLeft')]//p[@class='blackText']")).getText();
        System.out.println("Deparature City = " + departure);
        String arrival = driver.findElement(By.xpath("(//div[@class= 'listingCard  appendBottom5'])[1]//div[contains(@class,'timeInfoRight')]//p[@class='blackText']")).getText();
        System.out.println("Arrival City = " + arrival);
        String price = priceLocator.getText();
        System.out.println("Flight Price:" + price);

        System.out.println("end Test case: testCase02");
    }








    public  void testCase03() throws InterruptedException{

        System.out.println("Start Test case: testCase03 Get train details for a specific route and date.");
        driver.get("https://www.makemytrip.com/");
        //Thread.sleep(2000);
        // WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='notification-frame-3176854a']"));
        // driver.switchTo().frame(frameElement);
        // WebElement closePopUp = driver.findElement(By.xpath("//a[contains(@id,'webklipper-publisher-')]"));
        // closePopUp.click();
        // driver.switchTo().parentFrame();

        WebElement trainIcon = driver.findElement(By.xpath("//li[@data-cy='menu_Trains']"));
        trainIcon.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='fromCity']")).click();
        WebElement fromTextBox = driver.findElement(By.xpath("//input[@title='From']"));
        fromTextBox.sendKeys("ypr");
        Thread.sleep(2000);
        WebElement departureCity = driver.findElement(By.xpath("//span[text()='YPR']"));
        departureCity.click();

        WebElement arrivalTextBox = driver.findElement(By.xpath("//input[@id='toCity']"));
        arrivalTextBox.sendKeys("ndls");
        Thread.sleep(2000);
        WebElement arivalCity = driver.findElement(By.xpath("//span[text()='New Delhi Railway Station']"));
        arivalCity.click();

        WebElement calendar = driver.findElement(By.id("travelDate"));
        calendar.click();
        driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Mon Apr 29 2024']")).click();

        WebElement classLocator = driver.findElement(By.xpath("//label[@for='travelClass']"));
        classLocator.click();
        WebElement thirdAC = driver.findElement(By.xpath("//li[@data-cy='3A']"));
        thirdAC.click();

        Thread.sleep(1000);
        WebElement SearchButton = driver.findElement(By.xpath("//a[text()='Search']"));
        SearchButton.click();

        System.out.println("Train available for the given Rotes are : ");

        List<WebElement> trainsName = driver.findElements(By.className("train-name"));
        for(WebElement ele : trainsName){
            String s = ele.getText();
            System.out.println(s);
        }

        System.out.println("Prices of 3rd AC for the Repective Trains are: ");


        List<WebElement> thirdAcPrices = driver.findElements(By.xpath("//div[text()='3A']/parent::div/following-sibling::div"));
        for(WebElement ele : thirdAcPrices){
            String s = ele.getText();
            System.out.println("Train Price:"+s);
        }
        System.out.println("end Test case: testCase03");
    }


    




    public  void testCase04() throws InterruptedException{

        System.out.println("Start Test case: testCase04 there are no buses from Bangalore to Ranchi");
        driver.get("https://www.makemytrip.com/");
        //Thread.sleep(2000);
        // WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='notification-frame-3176854a']"));
        // driver.switchTo().frame(frameElement);
        // WebElement closePopUp = driver.findElement(By.xpath("//a[contains(@id,'webklipper-publisher-')]"));
        // closePopUp.click();
        // driver.switchTo().parentFrame();

        WebElement busesIcon = driver.findElement(By.xpath("//li[@data-cy='menu_Buses']"));
        busesIcon.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='fromCity']")).click();
        WebElement fromTextBox = driver.findElement(By.xpath("//input[@title='From']"));
        fromTextBox.sendKeys("bangl");
        Thread.sleep(2000);
        WebElement departureCity = driver.findElement(By.xpath("//div[@class='makeFlex column']//span[contains(text(),'Bangalore')]"));
        departureCity.click();

        // WebElement arrivalTextBox = driver.findElement(By.xpath("//input[@id='toCity']"));
        // arrivalTextBox.click();
        WebElement toTextBox = driver.findElement(By.xpath("//input[@placeholder='To']"));
        Thread.sleep(1000);
        toTextBox.sendKeys("ran");
        Thread.sleep(2000);
        WebElement arivalCity = driver.findElement(By.xpath("//div[@class='makeFlex column']//span[contains(text(),'Ranchi')]"));
        arivalCity.click();

        // WebElement calendar = driver.findElement(By.id("travelDate"));
        // calendar.click();
        driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Mon Apr 29 2024']")).click();

        Thread.sleep(1000);
        WebElement SearchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        SearchButton.click();

        Thread.sleep(4000);

        WebElement error = driver.findElement(By.className("error-title"));
        String expected = "No buses found for 29 Apr";
        if(error.getText().equals(expected)){
            System.out.println("No buses found for 29th of next Month");
        }
        System.out.println("end Test case: testCase04");
    }

    


}
