package tests;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Broken_ImgPage;
import utils.listener.ReportListener;

import static org.testng.Assert.assertEquals;
//import static pages.BaseSetup.baseUrl;

@Listeners(ReportListener.class)
public class Broken_ImgTest  extends BaseTest {

    Broken_ImgPage broken_imgPage;
    @BeforeClass
    public void setUp(){
        broken_imgPage = homePage.navigateToBrokenImg();
    }
    @Test(priority = 1)
    @Step("Test verify title")
    public void verifyTitleExist(){
        String expTitle = "Broken Images";
        assertEquals(broken_imgPage.verifyHeaderDisplay(),expTitle, "Header is not match!");
    }
    @Test(priority = 1)
    @Step("Test verify title broken Img")
    public void verifyBrokenImg(){
        broken_imgPage.checkImg();
    }

}
