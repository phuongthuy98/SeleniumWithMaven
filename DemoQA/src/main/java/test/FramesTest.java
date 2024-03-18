package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.AlertFrameWindowPage;
import page.FramesPage;
import page.HomePage;

import static org.testng.Assert.assertEquals;

public class FramesTest extends TestCase{
    By txtIframe = By.id("sampleHeading");

    @Test
    public void verifyDisplayFrames() {

        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();
        AlertFrameWindowPage alertFrameWindowPage = homePage.clickAlertFrameWindow();
        FramesPage framePage = alertFrameWindowPage.clickFramesMenu();

        testBase.driver.switchTo().frame("frame1");

        String actualFrameText = testBase.getTextByLocator(txtIframe);
        String expectedFrameText = "This is a sample page";

        assertEquals(actualFrameText, expectedFrameText);

        testBase.driver.switchTo().defaultContent();

        testBase.driver.switchTo().frame("frame2");

        String actualFrameText2 = testBase.getTextByLocator(txtIframe);
        String expectedFrameText2 = "This is a sample page";
        assertEquals(actualFrameText2, expectedFrameText2);
    }
}
