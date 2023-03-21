package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Add_RemovePage;
import utils.Log;
import utils.listener.ReportListener;

import static org.testng.Assert.assertEquals;

@Listeners(ReportListener.class)
public class AddRemoveTest extends BaseTest {

    Add_RemovePage add_removePage;
    @BeforeClass
    public void navigateToPage(){
        add_removePage = homePage.navigateToAddRemoveEle();
    }
    //fail
    @Test(priority = 1, description = "this is check title in Add and remove ele TestCase")
    @Step("Test verify title")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyTitleExist() {
        Log.info("Running testcase verify Title");
        String expTitle = "Add/Remove Elements1";
        assertEquals(add_removePage.verifyHeaderDisplay(),expTitle, "Header is not match!");
    }
    //success
    @Test(priority = 2, description = "Test function add and remove elements")
    @Step("Test verify button")
    public void verifyButtonDisplay() {
        Log.info("Running testcase verify button display");
        add_removePage.verifyClickAddRemoveBtn();
    }

}
