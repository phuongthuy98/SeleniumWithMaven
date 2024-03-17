package test;

import org.testng.annotations.Test;
import page.*;

import static org.testng.Assert.assertEquals;

public class BrowserWindowsTest extends TestCase{
    //@Test
    //TC-01
    public void verifyNewTabSuccessfully(){
        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();
        AlertFrameWindowPage alertFrameWindowPage = homePage.clickAlertFrameWindow();
        BrowserWindowsPage browserWindowsPage = alertFrameWindowPage.clickBrowserWindowMenu();
        DemoSamplePage demoSamplePage = browserWindowsPage.clickNewTab();

        String actualHeading = testBase.getText(demoSamplePage.lbHeading, demoSamplePage.timeout_Short);
        assertEquals(actualHeading, "This is a sample page");

    }

    //@Test
    //TC-02
    public void verifyNewWindow() {
        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();
        AlertFrameWindowPage alertFrameWindowPage = homePage.clickAlertFrameWindow();
        BrowserWindowsPage browserWindowsPage = alertFrameWindowPage.clickBrowserWindowMenu();
        DemoSamplePage demoSamplePage = browserWindowsPage.clickNewWindow();

        String actualHeading = testBase.getText(demoSamplePage.lbHeading, demoSamplePage.timeout_Short);
        assertEquals(actualHeading, "This is a sample page");
    }

    @Test
    //TC-03
    public void verifyNewWindowMessage() {
        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();
        AlertFrameWindowPage alertFrameWindowPage = homePage.clickAlertFrameWindow();
        BrowserWindowsPage browserWindowsPage = alertFrameWindowPage.clickBrowserWindowMenu();
        homePage.testBase.scrollToEndPage();
        DemoWindowsAlertPage demoAlertPage = browserWindowsPage.clickNewWindowMessage();

        String actualText = demoAlertPage.testBase.getText(demoAlertPage.lbBody, demoAlertPage.timeout_Short);
        assertEquals(actualText, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
    }

}
