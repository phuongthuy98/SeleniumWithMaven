package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.AlertFrameWindowPage;
import page.AlertsPage;
import page.HomePage;

import static org.testng.Assert.assertEquals;


public class AlertsTest extends TestCase{
    public By btnAlert = By.id("alertButton");
    public By btnTimerAlert = By.id("timerAlertButton");
    public By btnConfirm = By.id("confirmButton");
    public By btnPromt = By.id("promtButton");
    By txtConfirm = By.id("confirmResult");

    By txtPrompt = By.id("promptResult");

    public void goToAlertsPage() {
        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();
        AlertFrameWindowPage alertFrameWindowPage = homePage.clickAlertFrameWindow();
        alertFrameWindowPage.clickAlertsMenu();
        homePage.testBase.scrollToEndPage();
    }
    @Test
    public void verifyAlertButton() {
        goToAlertsPage();
        /*AlertsPage alertsPage = new AlertsPage(testBase.driver);
        alertsPage.goToAlertPages();*/
        testBase.clickByLocator(btnAlert);

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = testBase.driver.switchTo().alert();

        //Store the alert text in a variable
        String actualAlertText = alert.getText();
        String expectedAlertText = "You clicked a button";
        assertEquals(actualAlertText, expectedAlertText);

        //Press the OK button
        alert.accept();

    }
    @Test
    public void verifyTimerAlert() {
        goToAlertsPage();
        testBase.clickByLocator(btnTimerAlert);

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = testBase.driver.switchTo().alert();

        //Store the alert text in a variable
        String actualAlertText = alert.getText();
        String expectedAlertText = "This alert appeared after 5 seconds";
        assertEquals(actualAlertText, expectedAlertText);

        //Press the OK button
        alert.accept();
    }
    @Test
    public void verifyConfirmAlertCancel() {
        goToAlertsPage();
        testBase.clickByLocator(btnConfirm);

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = testBase.driver.switchTo().alert();
        //Store the alert text in a variable
        String actualAlertText = alert.getText();

        String expectedAlertText = "Do you confirm action?";
        assertEquals(actualAlertText, expectedAlertText);
        //Press the Cancel button
        alert.dismiss();

        String expectedOkConfirmAlert = "You selected Cancel";
        String actualOkConfirmAlert = testBase.getTextByLocator(txtConfirm);
        assertEquals(actualOkConfirmAlert, expectedOkConfirmAlert);
    }
    @Test
    public void verifyConfirmAlertOk() {
        goToAlertsPage();
        testBase.clickByLocator(btnConfirm);
        //Wait for the alert to be displayed and store it in a variable
        Alert alert = testBase.driver.switchTo().alert();

        //Store the alert text in a variable
        String actualAlertText = alert.getText();
        String expectedAlertText = "Do you confirm action?";
        assertEquals(actualAlertText, expectedAlertText);

        //Press the OK button
        alert.accept();

        String expectedOkConfirmAlert = "You selected Ok";
        String actualOkConfirmAlert = testBase.getTextByLocator(txtConfirm);
        assertEquals(actualOkConfirmAlert, expectedOkConfirmAlert);
    }
    @Test
    public void verifyPromtAlert() {
        goToAlertsPage();
        testBase.clickByLocator(btnPromt);

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = testBase.driver.switchTo().alert();
        String expectedPromptText = "Please enter your name";
        String actualPromptText = alert.getText();

        assertEquals(actualPromptText, expectedPromptText);
        //Type your message
        String inputPrompt = "Phuong Thuy";
        alert.sendKeys(inputPrompt);
        //Press the OK button
        alert.accept();

        String expectedPromtAlert = "You entered " + inputPrompt;
        String actualPromtAlert = testBase.getTextByLocator(txtPrompt);
        assertEquals(actualPromtAlert, expectedPromtAlert);
    }
}
