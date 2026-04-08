package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ThreadLocalManager;

public class BaseTest {
    
    WebDriver driver;

    public BaseTest() {
    }

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        
        // Block ads and popups
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
        
        // Block notifications
        options.addArguments("--disable-notifications");
        
        // Disable images (faster loading, fewer ads)
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("profile.managed_default_content_settings.images", 2); // 2 = block images
        }});
        
        // Additional useful options
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        
        driver = new ChromeDriver(options);
        ThreadLocalManager.setDriver(driver);

        ThreadLocalManager.getDriver().get("https://automationexercise.com/");
        ThreadLocalManager.getDriver().manage().window().maximize();
        ThreadLocalManager.getDriver().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (ThreadLocalManager.getDriver() != null) {
            ThreadLocalManager.getDriver().quit();  
        }
        ThreadLocalManager.removeDriver();
    }

}
