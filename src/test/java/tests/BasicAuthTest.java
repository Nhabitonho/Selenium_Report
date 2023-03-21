package tests;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Basic_AuthPage;
import utils.listener.ReportListener;

import static org.testng.Assert.assertEquals;

@Listeners(ReportListener.class)
public class BasicAuthTest extends BaseTest {

    Basic_AuthPage basicAuthPage;
    @BeforeClass
    public void nevigateToPage() {
        basicAuthPage = homePage.navigateToBasicAuth();
    }

    @Test(priority = 1)
    @Step("Test verify send login")
    public void verifySendLogin(){
        basicAuthPage.verifySendLogin();}

    @Test(priority = 2)
    @Step("Test verify title")
    public void verifyTitleExist(){
        String expTitle = "Congratulations! You must have the proper credentials.";
        assertEquals(basicAuthPage.verifyHeaderDisplay(),expTitle, "Header is not match!");
    }

}
