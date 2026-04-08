package Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class Listeners implements ITestListener{
    public void onTestStart(org.testng.ITestResult result) {
       Allure.addAttachment("Test Started" ,result.getName()); 
    }

    public void onTestSuccess(org.testng.ITestResult result) {
        Allure.addAttachment("Test Result", "Test passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        Allure.addAttachment("Failure Reason",result.getThrowable().getMessage()); // Attach failure reason to Allure report
        screenshot.captureScreenshot(); // Capture screenshot on failure
    }

    public void onTestSkipped(ITestResult result) {
        Allure.addAttachment("Test Result", "Test skipped: " + result.getName());
    }

    public void onTestFinish(ITestResult result) {
        Allure.addAttachment("Test Result", "Test finished: " + result.getName());
    }
}
