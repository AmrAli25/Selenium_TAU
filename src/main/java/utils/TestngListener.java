package utils;


import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.internal.IResultListener;

import static utils.Helper.attachScreenshotToAllureReport;


public class TestngListener implements ISuiteListener, ITestListener, IInvokedMethodListener, IResultListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("INFO: Starting test suite: <" + suite.getName() + ">");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("INFO: Finished test suite: <" + suite.getName() + ">");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++ " +
                "INFO: Running tests: <" + context.getName() + ">"
                + " +++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++ " +
                "INFO: Finished tests: <" + context.getName() + ">"
                + " +++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        attachScreenshotToAllureReport(driver);
    }


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if (method.isConfigurationMethod()) {
            System.out.println("INFO: Starting Configuration Method (Setup or TearDown): <" + testResult.getName() + ">");
        } else {
            System.out.println("INFO: Starting Test Case: <" + testResult.getName() + ">");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // Add this in here to attach the screenshot in the allure report
        ITestContext context = testResult.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        if (driver != null && testResult.getStatus() == ITestResult.FAILURE) {
            attachScreenshotToAllureReport(driver);
        }

        System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if (method.isConfigurationMethod()) {
            System.out.println("INFO: Finished Configuration Method (Setup or TearDown): <" + testResult.getName() + ">");
        } else {
            System.out.println("INFO: Finished Test Case: <" + testResult.getName() + ">");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
    }
}

