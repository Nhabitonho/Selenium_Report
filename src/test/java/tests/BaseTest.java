package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BaseSetup;
import pages.HomePage;
import utils.helpers.CaptureHelpers;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;

import static pages.BaseSetup.driver;

public class BaseTest {
    public static BaseSetup setup;
//    public static Method method;
    public static HomePage homePage;
    public WebDriver getDriver(){
        return driver;
    }
    @BeforeSuite
    public void beforeSuite() {
        setup = new BaseSetup();
    }

    @Parameters({"browser", "evn"})
    @BeforeTest
    public void initTestBaseSetup(@Optional("chrome") String browser,@Optional("dev") String environment) throws AWTException, IOException {
        setup.setupDriver(browser);
        homePage = setup.navigateToHomePage(environment);
    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws Exception {
        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
        // passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
                CaptureHelpers.captureScreenshot(driver, result.getName());
        }


    }
    @AfterClass
    public void endSession() {
        setup.gobacktoHomePage();
    }

    @AfterTest
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        setup.tearDownDriver();
    }
}
