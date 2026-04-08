package Utilities;

import org.openqa.selenium.WebDriver;

public class ThreadLocalManager {
        private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();
    
        private ThreadLocalManager() {
        }
    
        public static void setDriver(WebDriver driver) {
            driverInstance.set(driver);  
        }

        public static WebDriver getDriver() {
            return driverInstance.get();
        }   

        public static void removeDriver() {
            driverInstance.remove();
        }
    
}
