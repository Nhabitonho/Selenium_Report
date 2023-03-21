package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ABPage;
import utils.Log;
import utils.listener.ReportListener;

import static org.testng.Assert.assertEquals;

@Listeners(ReportListener.class)
@Epic("Regression Test")
@Feature("Project Test")
public class ABTest extends BaseTest {
    ABPage abPage;

    @BeforeClass
    @Description("Check titile AB Testing")
    public void navigateToPage() {
        abPage = homePage.navigateToABTesting();
    }
    @Test(description = "this is check title in AB TestCase")
    @Step("Test verify title")
    public void verifyTitleExist(){
//        saveToReport(method.getName(), "report3");
        Log.error("Testcase Fail : check title");
        String expTitle = "A/B Test Variation 1";
        assertEquals(abPage.verifyHeaderDisplay(),expTitle, "Header is not match!");
    }
}
