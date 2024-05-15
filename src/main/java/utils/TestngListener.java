package utils;


import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.internal.IResultListener;

import static utils.Helper.attachScreenshotToAllureReport;
import static utils.Helper.takeScreenShot;


public class TestngListener implements ISuiteListener, ITestListener, IInvokedMethodListener, IResultListener {

    ////////////////////////////////////////////////////////////
    ////////////////////// ISuiteListener /////////////////////
    //////////////////////////////////////////////////////////
    @Override
    public void onStart(ISuite suite) {
        System.out.println("\n" + "=====================================");
        System.out.println("Starting Test Suite; By Amr Ali *");
        System.out.println("=====================================" + "\n");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("\n" + "=====================================");
        System.out.println("Finished Test Suite; By Amr Ali *");
        System.out.println("=====================================" + "\n");
    }

    ////////////////////////////////////////////////////////////
    ////////////////////// ITestListener //////////////////////
    //////////////////////////////////////////////////////////
    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n" + "=====================================" + "Test: ["
                + context.getName() + "] Started" + "=====================================" + "\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n" + "=====================================" + "Test: ["
                + context.getName() + "] Finished" + "=====================================" + "\n");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        attachScreenshotToAllureReport(driver);
//        takeScreenShot(driver, result);
    }



    ////////////////////////////////////////////////////////////
    ///////////////// IInvokedMethodListener //////////////////
    //////////////////////////////////////////////////////////
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("\n" + "============================================================================================");
        if (method.isConfigurationMethod()) {
            System.out.println("Starting Configuration Method (Setup or Teardown): [" + testResult.getName() + "]");
        } else {
            System.out.println("Starting Test Case: [" + testResult.getName() + "]");
        }
        System.out.println("============================================================================================" + "\n");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("\n" + "===========================================================================================");
        if (method.isConfigurationMethod()) {
            System.out.println("Finished Configuration Method (Setup or Teardown): [" + testResult.getName() + "]");
        } else {
            System.out.println("Finished Test Case: [" + testResult.getName() + "]");
        }
        System.out.println("===========================================================================================" + "\n");
    }
}

