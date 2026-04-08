package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Attachment;

public class screenshot {

    @Attachment(value = "Screenshot", type = "image/png")
    public static void captureScreenshot() {
        TakesScreenshot ts = (TakesScreenshot)ThreadLocalManager.getDriver();
        ts.getScreenshotAs(OutputType.BYTES);
    }
}
